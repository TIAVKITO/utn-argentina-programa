package com.utn.app;

public class Equipo {
	private String id;
	private String nombre;
	private String descripcion;

	public Equipo(String id) {
		this.id = id;
	}

	public Equipo(String id, String nombre, String descripcion) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public String get_id() {
		return id;
	}

	public String get_nombre() {
		return nombre;
	}

	public String get_descripcion() {
		return descripcion;
	}

	public void set_descripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}