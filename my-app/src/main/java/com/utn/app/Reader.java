/*
package com.utn.app;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {

	private Path pathResultados;
	private Path pathPronostico;

	public Reader(Path pathResultados, Path pathPronostico) {
		this.pathResultados = pathResultados;
		this.pathPronostico = pathPronostico;
	}

	public void parsearResultados(ArrayList<Partido> partidos) {
		List<String> lineasResultados = null;

		try {
			lineasResultados = Files.readAllLines(pathResultados);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}

		boolean primera = true;
		Integer id = 1; // y si agrego un columna en el archivo csv para determinar los IDs?
        for (String lineaResultado : lineasResultados) {
            if (primera) {
                primera = false;
            } else {
                String[] campos = lineaResultado.split(";");
                Equipo equipo1 = new Equipo(campos[2], campos[3], campos[4]);
                Equipo equipo2 = new Equipo(campos[7], campos[8], campos[9]);
                String ronda = campos[0];
                Partido partido = new Partido(ronda, id, equipo1, equipo2);
                partido.set_goles_equipo1(Integer.parseInt(campos[5]));
                partido.set_goles_equipo2(Integer.parseInt(campos[6]));
                id++;
                partidos.add(partido);
            }
		}
	}

	public void parsearPronostico(ArrayList<Partido> partidos, ArrayList<Pronostico> pronosticos) {
        List<String> lineasPronostico = null;

        try {
            lineasPronostico = Files.readAllLines(pathPronostico);
        } catch (IOException e) {
        	e.printStackTrace();
            System.exit(1);
        }

        boolean primera = true;
        Integer id = 1;
        for (String lineaPronostico : lineasPronostico) {
            if (primera) {
                primera = false;
            } else {
                String[] campos = lineaPronostico.split(";");
                Participante participante = new Participante(campos[1]);
                participante.set_id(Integer.parseInt(campos[0]));
                Equipo equipo1 = new Equipo(campos[2]);
                Equipo equipo2 = new Equipo(campos[6]);
                Partido partidoSeleccionado = null;

                for (Partido partido : partidos) {
                	if (partido.get_equipo1().get_id().equals(equipo1.get_id())
                		&& partido.get_equipo2().get_id().equals(equipo2.get_id())) {
                		partidoSeleccionado = partido;
                		equipo1 = partido.get_equipo1();
                		equipo2 = partido.get_equipo2();
                		break;
                	}
                }

				if("X".equals(campos[3])) {
					Pronostico pronostico1 = new Pronostico(id, participante, partidoSeleccionado, equipo1, EnumResultado.GANADOR);
					pronosticos.add(pronostico1);
					id++;
					//Pronostico pronostico2 = new Pronostico(id, participante, partidoSeleccionado, equipo2, EnumResultado.PERDEDOR);
					//pronosticos.add(pronostico2);
					//id++;					
				}

				if("X".equals(campos[4])) {
					Pronostico pronostico1 = new Pronostico(id, participante, partidoSeleccionado, equipo1, EnumResultado.EMPATE);
					pronosticos.add(pronostico1);
					id++;
					//Pronostico pronostico2 = new Pronostico(id, participante, partidoSeleccionado, equipo2, EnumResultado.EMPATE);
					//pronosticos.add(pronostico2);
					//id++;					
				}

				if("X".equals(campos[5])) {
					Pronostico pronostico1 = new Pronostico(id, participante, partidoSeleccionado, equipo1, EnumResultado.PERDEDOR);
					pronosticos.add(pronostico1);
					id++;
					//Pronostico pronostico2 = new Pronostico(id, participante, partidoSeleccionado, equipo2, EnumResultado.GANADOR);
					//pronosticos.add(pronostico2);
					//id++;					
				}
	        }
	    }           
    }
}
*/