package com.utn.app;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PartidoTest {

	private Equipo equipo1;
	private Equipo equipo2;
	private Partido partido;

	@Before
	public void setUp() {
		this.equipo1 = new Equipo("Argentina");
		this.equipo2 = new Equipo("Brasil");
		this.partido = new Partido(this.equipo1, this.equipo2,);
	}

	@Test
	public void testPartidoGanadorPerdedor() {

		this.partido.setGolesEq1(2);
		this.partido.setGolesEq2(1);

		EnumResultado resultadoObtenido1 = partido.resultado(this.equipo1);
		EnumResultado resultadoObtenido2 = partido.resultado(this.equipo2);

		assertEquals(EnumResultado.GANADOR, resultadoObtenido1);
		assertEquals(EnumResultado.PERDEDOR, resultadoObtenido2);

	}
	
	@Test
	public void testPartidoEmpatado() {

		this.partido.setGolesEq1(2);
		this.partido.setGolesEq2(2);

		EnumResultado resultadoObtenido = partido.resultado(equipo1);
		
		assertEquals(EnumResultado.EMPATE, resultadoObtenido);

	}

}