package com.utn.app;

public class Ronda {
	private String id;
	private String numero;
	// aca hay una cuestion con el array y la coleccion, cual uso?
	//private Partido partidos[] = null;

	public Ronda(String numero) {
		this.numero = numero;
		//this.partidos = partido;
	}

	public String get_numero() {
		return numero;
	}
/*
	public Partido get_partidos() {
		return partidos;
	}

	public void set_partidos(Partido partidos) {
		this.partidos = partidos;
	}

	public Integer puntos() {

	}
*/
}