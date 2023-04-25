package com.utn.app;

public class Pronostico {
	private int id;
	private Participante participante;
	private Partido partido;
	private Equipo equipo;
	private EnumResultado resultado;

	public Pronostico(int id, Participante participante, Partido partido, Equipo equipo, EnumResultado resultado) {
		super();
		this.id = id;
		this.participante = participante;
		this.partido = partido;
		this.equipo = equipo;
		this.resultado = resultado;
	}

	public int get_id() {
		return id;
	}

	public Participante get_participante() {
		return participante;
	}

	public Partido get_partido() {
		return partido;
	}

	public Equipo get_equipo() {
		return equipo;
	}

	public EnumResultado get_resultado() {
		return resultado;
	}

	public int puntos(EnumResultado resultadoReal) {
		if (this.resultado.equals(resultadoReal)) {
			return 1;
		} else {
			return 0;
		}
	}
}