package com.utn.app;

import java.util.*;
import java.sql.*;

public class Pronostico {
	private Participante participante;
	private Partido partido;
	private EnumResultado resultado;

	public Pronostico(Participante participante, Partido partido, EnumResultado resultado) {
		super();
		this.participante = participante;
		this.partido = partido;
		this.resultado = resultado;
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

	public int puntos() {
		EnumResultado resultadoReal = partido.resultado(partido.get_equipo1());
		if (this.resultado.equals(resultadoReal)) {
			return 1;
		} else {
			return 0;
		}
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
}