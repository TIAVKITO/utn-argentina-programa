package com.utn.app;

import java.util.*;
import java.sql.*;

public class App {
    public static void main(String[] args) {

        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/utn_argentina_programa", "root", "root");
            
            List<Partido> partidos = Partido.fetchFromDatabase(conexion);
            List<Pronostico> pronosticos = Pronostico.fetchFromDatabase(conexion, partidos);
            List<Participante> participantes = null; 

            for (Pronostico pronostico : pronosticos) {
                if (participantes.isEmpty()) {
                    participantes.add(pronostico.get_participante());
                } 
                Participante ultimoParticipante = participantes.get(participantes.size()-1);
                if (ultimoParticipante.get_id() != pronostico.get_participante().get_id()) {
                    participantes.add(pronostico.get_participante());
                }
            }

            for (Participante participante : participantes) {
                int puntos = 0;
                for (Pronostico pronostico : pronosticos) {
                    if (participante.get_id() == pronostico.get_participante().get_id()) {
                        puntos += pronostico.puntos();  
                    }
                }
                participante.set_puntos(puntos); 
            }   

            for (Participante participante : participantes) {
                System.out.println("Los puntos obtenidos por " + participante.get_nombre() + " son: ");
                System.out.println(participante.get_puntos()); 
            }

        } catch (SQLException e) {
            System.err.println("Error al conectarse a la base de datos.");
            e.printStackTrace();
        }
    }
}
