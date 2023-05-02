package com.utn.app;

public class Equipo {
	private int id;
	private String nombre;

	public Equipo(int id, String nombre) {
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
}