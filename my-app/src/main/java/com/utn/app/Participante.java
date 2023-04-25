package com.utn.app;

public class Participante {
	private String id;
	private String nombre;
	private int puntos;

	public Participante(String id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public String get_id() {
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
}