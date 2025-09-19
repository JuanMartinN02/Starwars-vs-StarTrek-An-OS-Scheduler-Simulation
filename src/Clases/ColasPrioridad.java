/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Windows 10
 */
public class ColasPrioridad {
    Queue<Personajes> cola1Starwars = new LinkedList<>();
    Queue<Personajes> cola2Starwars = new LinkedList<>();
    Queue<Personajes> cola3Starwars = new LinkedList<>();
    Queue<Personajes> colaRefuerzoStarwars = new LinkedList<>();
     
    Queue<Personajes> cola1Startrek = new LinkedList<>();
    Queue<Personajes> cola2Startrek = new LinkedList<>();;
    Queue<Personajes> cola3Startrek = new LinkedList<>();;
    Queue<Personajes> colaRefuerzoStartrek = new LinkedList<>();;
  
    //Crea los personajes y los mete a la cola de refuerzo
    
    public static String[] cargarPersonajes(String nombreArchivo, int numPersonajes) {
        String[] personajes = new String[numPersonajes];
        try {
            BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo));
            String line;
            int i = 0;
            while ((line = reader.readLine()) != null && i < numPersonajes) {
                personajes[i] = line;
                i++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return personajes;
    }
    
    public void personajesStarwars(){
        int nmrpersonajes1 = 20;
        String[] personajesArray = cargarPersonajes("Personajes Star Wars.txt", nmrpersonajes1);
        
        for (int i = 0; i < nmrpersonajes1; i++) {
            String[] partes = personajesArray[i].split(", ");
            int id = Integer.parseInt(partes[0]);
            String nombre = partes[1];
            String imagen = partes[2];
            Personajes personaje1 = new Personajes(id, nombre, imagen);
            personaje1.evaluarPrioridad();
            colaRefuerzoStarwars.add(personaje1);
        }
        System.out.println("******************************************");
        System.out.println("Se han cargado todos los personajes de SW");
        System.out.println("******************************************");
    }
    
     //Crea los personajes y los mete a la cola de refuerzo
     public void personajesStartrek(){
        int nmrpersonajes2 = 20;
        String[] personajesArray = cargarPersonajes("Personajes Star Trek.txt", nmrpersonajes2);
        
        for (int i = 0; i < nmrpersonajes2; i++) {
            String[] partes = personajesArray[i].split(", ");
            int id = Integer.parseInt(partes[0]);
            String nombre = partes[1];
            String imagen = partes[2];
            Personajes personaje2 = new Personajes(id, nombre, imagen);
            personaje2.evaluarPrioridad();
            colaRefuerzoStartrek.add(personaje2);
        }
        System.out.println("******************************************");
        System.out.println("Se han cargado todos los personajes de ST");
        System.out.println("******************************************");
    }
     
   // Hace print a la cola que pases por argumento
    public void printCola(Queue<Personajes> cola, String colaName) {
        System.out.println("Printing " + colaName + ":");
        
        // for-each para iterar por las colas
        for (Personajes personaje : cola) {
            System.out.println(personaje.toString());  // Print para cada personaje
        }
    }

    // Hace print a todas las colas
    public void printColas() {
        System.out.println("");
        System.out.println("*********************************");
        printCola(cola1Starwars, "Cola 1 Starwars");
        System.out.println("");
        printCola(cola2Starwars, "Cola 2 Starwars");
        System.out.println("");
        printCola(cola3Starwars, "Cola 3 Starwars");
        System.out.println("");
        printCola(colaRefuerzoStarwars, "Cola Refuerzo Starwars");
        System.out.println("");
        printCola(cola1Startrek, "Cola 1 Startrek");
        System.out.println("");
        printCola(cola2Startrek, "Cola 2 Startrek");
        System.out.println("");
        printCola(cola3Startrek, "Cola 3 Startrek");
        System.out.println("");
        printCola(colaRefuerzoStartrek, "Cola Refuerzo Startrek");
        System.out.println("*********************************");
        System.out.println("");
    }

    public Queue<Personajes> getCola1Starwars() {
        return cola1Starwars;
    }

    public void setCola1Starwars(Queue<Personajes> cola1Starwars) {
        this.cola1Starwars = cola1Starwars;
    }

    public Queue<Personajes> getCola2Starwars() {
        return cola2Starwars;
    }

    public void setCola2Starwars(Queue<Personajes> cola2Starwars) {
        this.cola2Starwars = cola2Starwars;
    }

    public Queue<Personajes> getCola3Starwars() {
        return cola3Starwars;
    }

    public void setCola3Starwars(Queue<Personajes> cola3Starwars) {
        this.cola3Starwars = cola3Starwars;
    }

    public Queue<Personajes> getColaRefuerzoStarwars() {
        return colaRefuerzoStarwars;
    }

    public void setColaRefuerzoStarwars(Queue<Personajes> colaRefuerzoStarwars) {
        this.colaRefuerzoStarwars = colaRefuerzoStarwars;
    }

    public Queue<Personajes> getCola1Startrek() {
        return cola1Startrek;
    }

    public void setCola1Startrek(Queue<Personajes> cola1Startrek) {
        this.cola1Startrek = cola1Startrek;
    }

    public Queue<Personajes> getCola2Startrek() {
        return cola2Startrek;
    }

    public void setCola2Startrek(Queue<Personajes> cola2Startrek) {
        this.cola2Startrek = cola2Startrek;
    }

    public Queue<Personajes> getCola3Startrek() {
        return cola3Startrek;
    }

    public void setCola3Startrek(Queue<Personajes> cola3Startrek) {
        this.cola3Startrek = cola3Startrek;
    }

    public Queue<Personajes> getColaRefuerzoStartrek() {
        return colaRefuerzoStartrek;
    }

    public void setColaRefuerzoStartrek(Queue<Personajes> colaRefuerzoStartrek) {
        this.colaRefuerzoStartrek = colaRefuerzoStartrek;
    }

  
     
     
}
