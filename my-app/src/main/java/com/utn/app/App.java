package com.utn.app;

import java.util.*;
import java.sql.*;

public class App {
    public static void main(String[] args) {

        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/utn_argentina_programa", "root", "root");
            
            List<Partido> partidos = Partido.fetchFromDatabase(conexion);
            List<Pronostico> pronosticos = Pronostico.fetchFromDatabase(conexion, partidos);

            List<Participante> participantes = new ArrayList<>();
 /*           
            participantes.add(pronosticos.get(0).get_participante());
            for (Pronostico pronostico : pronosticos) {
                if (!participantes.get(participantes.size()-1).equals(pronostico.get_participante())) {
                    participantes.add(pronostico.get_participante());
                }
                //debo soobrescribir .equals? pensar q es lo q deberia cambiar
             } 
*/
            participantes.add(pronosticos.get(0).get_participante());
            participantes.add(pronosticos.get(8).get_participante());

            for (Participante participante : participantes) {
                int puntos = 0;
                int aciertosRonda = 0;
                int recompensa = 0;

                int recompensaRonda = 0;
                int recompensaFase = 0;

                for (Pronostico pronostico : pronosticos) {
                    if (participante.get_id() == pronostico.get_participante().get_id()) { 
                        puntos += pronostico.puntos(aciertosRonda, recompensa);
                    }
                    pronostico.recompensas(recompensaRonda, recompensaFase);
                }
                if (recompensa!=0) {
                    puntos += (recompensaRonda*recompensa);
                    if (recompensa>1) {
                        puntos += recompensaFase;
                    }
                }

                participante.set_puntos(puntos); 
            }   

            for (Participante participante : participantes) {
                System.out.println(participante.get_nombre() + ": " + participante.get_puntos()); 
            }

        } catch (SQLException e) {
            System.err.println("Error al conectarse a la base de datos.");
            e.printStackTrace();
        }
    }
}
