package com.utn.app;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PronosticoTest {

	private Equipo equipo1;
	private Equipo equipo2;

	@Before
	public void setUp() {
		this.equipo1 = new Equipo("Argetina");
		this.equipo2 = new Equipo("Brasil");
	}
	
	@Test
	public void testControlarAciertos() {
		
		Partido partido = new Partido(this.equipo1, this.equipo2);
		partido.setGolesEq1(2);
		partido.setGolesEq2(1);
		Pronostico pronostico = new Pronostico(partido, this.equipo1, EnumResultado.GANADOR);
		
		int puntos = pronostico.puntos(partido.resultado());
		
		assertEquals(1, puntos);
		
		
	} 
	
	@Test
	public void testControlarDesaciertos() {
		
		Partido partido = new Partido(this.equipo1, this.equipo2);
		partido.setGolesEq1(2);
		partido.setGolesEq2(1);
		Pronostico pronostico = new Pronostico(partido, this.equipo1, EnumResultado.GANADOR);
		
		int puntos = pronostico.puntos(partido.resultado());

		assertEquals(0, puntos);
	} 
}