package com.utn.app;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PronosticoTest {

	private Equipo equipo1;
	private Equipo equipo2;

	@Before
	public void setUp() {
		this.equipo1 = new Equipo("1");
		this.equipo2 = new Equipo("2");
		equipo1.set_nombre("Argentina");
		equipo2.set_nombre("Brasil");
	}
	
	@Test
	public void testControlarAciertos() {
		
		Participante participante = new Participante("Thiago");
		Partido partido = new Partido(this.equipo1, this.equipo2);
		partido.set_goles_equipo1(2);
		partido.set_goles_equipo2(1);
		Pronostico pronostico = new Pronostico(1, participante, partido, this.equipo1, EnumResultado.GANADOR);
		
		int puntos = pronostico.puntos(partido.resultado(this.equipo1));
		
		assertEquals(1, puntos);
		
		
	} 
	
	@Test
	public void testControlarDesaciertos() {
		
		Participante participante = new Participante("Thiago");
		Partido partido = new Partido(this.equipo1, this.equipo2);
		partido.set_goles_equipo1(2);
		partido.set_goles_equipo2(1);
		Pronostico pronostico = new Pronostico(2, participante, partido, this.equipo1, EnumResultado.PERDEDOR);
		
		int puntos = pronostico.puntos(partido.resultado(this.equipo1));

		assertEquals(0, puntos);
	} 
}