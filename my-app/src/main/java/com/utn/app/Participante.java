package com.utn.app;

public class Participante {
	private Integer id;
	private String nombre;
	private int puntos;

	public Participante(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Integer get_id() {
		return id;
	}

	public void set_id(Integer id) {
		this.id = id;
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