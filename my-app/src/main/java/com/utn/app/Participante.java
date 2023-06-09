package com.utn.app;

public class Participante {
	private int id;
	private String nombre;
	private int puntos;
	private int totalAciertosRonda = 0;
	private int totalAciertosFase = 0; 

	public Participante(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public int get_id() {
		return id;
	}

	public String get_nombre() {
		return nombre;
	}

	public void set_nombre(String nombre) {
		this.nombre = nombre;
	}

	public int get_puntos() {
		return puntos;
	}

	public void set_puntos(int puntos) {
		this.puntos = puntos;
	}

	public int get_total_aciertos_ronda() {
		return totalAciertosRonda;
	}

	public int get_total_aciertos_fase() {
		return totalAciertosFase;
	}

}