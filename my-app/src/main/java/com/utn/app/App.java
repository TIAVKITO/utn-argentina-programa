package com.utn.app;

import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class App 
{
    public static void main(String[] args) {

    /*
        // check si la ruta es valida
        if(args.length == 0){
            System.out.println("No ingreso ningun archivo como argumento.");
            System.exit(1);
        }

        // paso la ruta 
        Path pathResultados = Paths.get(args[0]);
        Path pathPronostico = Paths.get(args[1]);
    */

        Path pathResultados = Paths.get("C:\\Users\\nicol\\Desktop\\utn-tp-pronostico\\src\\test\\resources\\resultados2.csv");
        Path pathPronostico = Paths.get("C:\\Users\\nicol\\Desktop\\utn-tp-pronostico\\src\\test\\resources\\pronostico2.csv");

        Reader lectorArchivos = new Reader(pathResultados, pathPronostico);

        ArrayList<Partido> partidos = new ArrayList<Partido>();
        lectorArchivos.parsearResultados(partidos);
   
        ArrayList<Pronostico> pronosticos = new ArrayList<Pronostico>();
        lectorArchivos.parsearPronostico(partidos, pronosticos);

        ArrayList<Participante> participantes = new ArrayList<Participante>();
        for (Pronostico pronostico : pronosticos) {
            if (participantes.isEmpty()) {
                participantes.add(pronostico.get_participante());
            } 
            Participante ultimoParticipante = participantes.get(participantes.size()-1);
            if (ultimoParticipante.get_id() != pronostico.get_participante().get_id()) {
                participantes.add(pronostico.get_participante());
            }
        }

        int puntos = 0;

        for (Participante participante : participantes) {
            for (Partido partido : partidos ) {
                for (Pronostico pronostico : pronosticos) {
                    if (partido.get_id().equals(pronostico.get_partido().get_id())
                        && pronostico.get_participante().get_id().equals(participante.get_id())) {
                        puntos += pronostico.puntos(partido.resultado(pronostico.get_equipo()));  
                    }
                }
            }
            participante.set_puntos(puntos);
            puntos = 0;  
        }

        for (Participante participante : participantes) {
            System.out.println("Los puntos obtenidos por " + participante.get_nombre() + " son: ");
            System.out.println(participante.get_puntos());             
        }

    }
}
