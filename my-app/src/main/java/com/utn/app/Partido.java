package com.utn.app;

public class Partido {
	private String rondaId;
	private Integer id;
	private Equipo equipo1;
	private Equipo equipo2;
	private int golesEq1;
	private int golesEq2;
		
	public Partido(String rondaId, Integer id, Equipo equipo1, Equipo equipo2) {
		super();
		this.rondaId = rondaId;
		this.id = id;
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
	}

	public Integer get_id() {
		return id;
	}

	public Equipo get_equipo1() {
		return equipo1;
	}

	public Equipo get_equipo2() {
		return equipo2;
	}

	public int get_goles_equipo1() {
		return golesEq1;
	}

	public void set_goles_equipo1(int golesEq1) {
		this.golesEq1 = golesEq1;
	}

	public int get_goles_equipo2() {
		return golesEq2;
	}

	public void set_goles_equipo2(int golesEq2) {
		this.golesEq2 = golesEq2;
	}
	
	public EnumResultado resultado(Equipo equipo) {
		if(golesEq1 == golesEq2) {
			return EnumResultado.EMPATE;
		}
		if(equipo.get_nombre().equals(equipo1.get_nombre())) {
			if(golesEq1>golesEq2) {
				return EnumResultado.GANADOR;	
			}	else {
				return EnumResultado.PERDEDOR;
			}			
		} else {
			if(golesEq2>golesEq1) {
				return EnumResultado.GANADOR;	
			}	else {
				return EnumResultado.PERDEDOR;
			}	
		}	
	}
}