package com.utn.app;

import java.util.*;
import java.sql.*;
import java.io.FileInputStream;
import java.io.IOException;

public class Pronostico {
	private Participante participante;
	private Partido partido;
	private EnumResultado resultado;
    private static int acierto;
    private static int recompensaRonda;
    private static int recompensaFase;
    private static int rondaActual = 0;

	public Pronostico(Participante participante, Partido partido, EnumResultado resultado) {
		super();
		this.participante = participante;
		this.partido = partido;
		this.resultado = resultado;
	}

	static {
		loadConfig();
	}

	public Participante get_participante() {
		return participante;
	}

	public Partido get_partido() {
		return partido;
	}

	public EnumResultado get_resultado() {
		return resultado;
	}

	public int get_recompensa_ronda() {
		return recompensaRonda;
	}

	public int get_recompensa_fase() {
		return recompensaFase;
	}

	public void recompensas (int recompensaRonda, int recompensaFase) {
		recompensaRonda = this.recompensaRonda;
		recompensaFase = this.recompensaFase;
	}

	public int puntos(int aciertosRonda, int recompensa) {

		if (rondaActual != partido.get_ronda()){
			rondaActual = partido.get_ronda();
			aciertosRonda = 0;
		}

		//si la ronda cambiar restablecer variables

		EnumResultado resultadoReal = partido.resultado(partido.get_equipo1());
        if (this.resultado.equals(resultadoReal)) {
        	aciertosRonda++;
        	if (aciertosRonda == 4) {
        		recompensa++;
        	}
            return acierto;
        }
        return 0;
	}

	public static List<Pronostico> fetchFromDatabase(Connection conexion, List<Partido> partidos) throws SQLException {
        
        List<Pronostico> pronosticos = new ArrayList<>();

        Statement consulta = conexion.createStatement();
        String query = "SELECT * FROM utn_argentina_programa.pronosticos";
        ResultSet resultado = consulta.executeQuery(query);

        while (resultado.next()) {
            Participante participante = new Participante(resultado.getInt("participante_id"), resultado.getString("participante_nombre"));
            int partido_id = resultado.getInt("partido_id");
            Partido partido = null;
            for (Partido p : partidos) {
            	if (p.get_id() == partido_id) {partido = p;}
            }
            String gana1 = resultado.getString("gana1");
            String empate = resultado.getString("empate");
            String gana2 = resultado.getString("gana2");

            EnumResultado resultadoFinal = EnumResultado.resultadoFinal(gana1, empate, gana2);

            pronosticos.add(new Pronostico(participante, partido, resultadoFinal));
        }
        consulta.close();
        resultado.close();
        return pronosticos;
    }

	public static void loadConfig() { //sera mejor hacer esto en Participante.java?
    	Properties properties = new Properties();
       	try (FileInputStream fileInputStream = new FileInputStream("config.properties")) {
        	properties.load(fileInputStream);
           	acierto = Integer.parseInt(properties.getProperty("acierto"));
           	recompensaRonda = Integer.parseInt(properties.getProperty("recompensaRonda"));
           	recompensaFase = Integer.parseInt(properties.getProperty("recompensaFase"));
       	} catch (IOException e) {
       		System.err.println("Error al cargar el archivo de configuración.");
       	}
    }
}