package com.utn.app;

import java.util.*;
import java.sql.*;

public class Partido {
	private int id;
	private int ronda;
	private Equipo equipo1;
	private Equipo equipo2;
	private int golesEquipo1;
	private int golesEquipo2;
		
	public Partido(int ronda, int id, Equipo equipo1, Equipo equipo2, int golesEquipo1, int golesEquipo2) {
		super();
		this.ronda = ronda;
		this.id = id;
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.golesEquipo1 = golesEquipo1;
		this.golesEquipo2 = golesEquipo2;
	}

	public int get_id() {
		return id;
	}

	public int get_ronda() {
		return ronda;
	}

	public Equipo get_equipo1() {
		return equipo1;
	}

	public Equipo get_equipo2() {
		return equipo2;
	}

	public int get_goles_equipo1() {
		return golesEquipo1;
	}

	public void set_goles_equipo1(int golesEquipo1) {
		this.golesEquipo1 = golesEquipo1;
	}

	public int get_goles_equipo2() {
		return golesEquipo2;
	}

	public void set_goles_equipo2(int golesEquipo2) {
		this.golesEquipo2 = golesEquipo2;
	}
	
	public EnumResultado resultado(Equipo equipo) {
		if (golesEquipo1 == golesEquipo2) {
			return EnumResultado.EMPATE;
		} else if (equipo.equals(equipo1)) {
			return golesEquipo1 < golesEquipo2 ? EnumResultado.PERDEDOR : EnumResultado.GANADOR;
		} else {
			return golesEquipo2 < golesEquipo1 ? EnumResultado.PERDEDOR : EnumResultado.GANADOR;
		}
	}	

	public static List<Partido> fetchFromDatabase(Connection conexion) throws SQLException {
    	
    	List<Partido> partidos = new ArrayList<>();

    	Statement consulta = conexion.createStatement();
    	String query = "SELECT * FROM utn_argentina_programa.resultados";
    	ResultSet resultado = consulta.executeQuery(query);
                   
        while (resultado.next()) { //it returns false when there are no more rows in the ResultSet object
            int ronda = resultado.getInt("ronda");            
            int id = resultado.getInt("partido_id");
            Equipo equipo1 = new Equipo(resultado.getInt("equipo1_id"), resultado.getString("equipo1_nombre"));
			Equipo equipo2 = new Equipo(resultado.getInt("equipo2_id"), resultado.getString("equipo2_nombre"));
            int golesEquipo1 = resultado.getInt("equipo1_goles");
            int golesEquipo2 = resultado.getInt("equipo2_goles");
            partidos.add(new Partido(ronda, id, equipo1, equipo2, golesEquipo1, golesEquipo2));
        } 
        consulta.close();
        resultado.close();
        return partidos;
	}
}