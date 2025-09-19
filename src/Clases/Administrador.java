/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Interfaz.Menu;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Queue;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;

/**
 *
 * @author danie
 */
public class Administrador {
    private int ciclosDeRevision;
    private int ciclosDeRevisionTotales;

    public Administrador() {
        this.ciclosDeRevision = 0;
        this.ciclosDeRevisionTotales = 0;
    }
    
    
    
    //asignacion inical de cada personajes a su cola
    public void asignacion(ColasPrioridad cola){
        
        while(cola.colaRefuerzoStartrek.peek() != null && cola.colaRefuerzoStarwars.peek() != null){
          
            if(cola.colaRefuerzoStartrek.peek() != null){
                Personajes personaje1 = cola.colaRefuerzoStarwars.poll();
                
                switch (personaje1.getPrioridad()) {
                case 1 -> cola.cola1Starwars.add(personaje1);
                case 2 -> cola.cola2Starwars.add(personaje1);
                default -> cola.cola3Starwars.add(personaje1);
                }
            }else{}   
            
            if(cola.colaRefuerzoStartrek.peek() != null){
                Personajes personaje2 = cola.colaRefuerzoStartrek.poll();
                
                switch (personaje2.getPrioridad()) {
                case 1 -> cola.cola1Startrek.add(personaje2);
                case 2 -> cola.cola2Startrek.add(personaje2);
                default -> cola.cola3Startrek.add(personaje2);
                }
            }else{}
            
        }
        
        cola.printColas();
    }
   
    
    public void ejecucionPelea(ColasPrioridad cola, IA ia, Menu frame) throws InterruptedException, MalformedURLException{
        
        frame.getEstadoIA().setText("Esperando!");
        
        printCola(cola.cola1Startrek, "Cola 1 Star Trek", frame.getCola1Startrek());
        printCola(cola.cola1Starwars, "Cola 1 Star Wars", frame.getCola1Starwars());
        printCola(cola.cola2Startrek, "Cola 2 Star Trek", frame.getCola2Startrek());
        printCola(cola.cola2Starwars, "Cola 2 Star Wars", frame.getCola2Starwars());
        printCola(cola.cola3Startrek, "Cola 3 Star Trek", frame.getCola3Startrek());
        printCola(cola.cola3Starwars, "Cola 3 Star Wars", frame.getCola3Starwars());
        printCola(cola.colaRefuerzoStartrek, "Cola Refuerzos Star Trek", frame.getColaRefuerzosStartrek());
        printCola(cola.colaRefuerzoStarwars, "Cola Refuerzos Star Wars", frame.getColaRefuerzosStarwars());
        
        Personajes personaje1 = null;
        Personajes personaje2 = null;
        
        // Escoje peleador de Starwars
        if (cola.cola1Starwars.peek() != null) {
            personaje1 = cola.cola1Starwars.poll();
        } else if (cola.cola2Starwars.peek() != null) {
            personaje1 = cola.cola2Starwars.poll();
        } else if (cola.cola3Starwars.peek() != null) {
            personaje1 = cola.cola3Starwars.poll();
        }
        
       

        // Escoje peleador de Startrek
        if (cola.cola1Startrek.peek() != null) {
            personaje2 = cola.cola1Startrek.poll();
        } else if (cola.cola2Startrek.peek() != null) {
            personaje2 = cola.cola2Startrek.poll();
        } else if (cola.cola3Startrek.peek() != null) {
            personaje2 = cola.cola3Startrek.poll();
        }
        
            try {
         // Try to get the URLs for each character's image
         URL imageUrl1 = getClass().getResource("/Imágenes/" + personaje1.getNombre() + ".png");
         URL imageUrl2 = getClass().getResource("/Imágenes/" + personaje2.getNombre() + ".png");

         // Set the name labels
         frame.getNombreSW().setText(personaje1.getNombre());
         frame.getNombreST().setText(personaje2.getNombre());

         // Conditionally set icons only if the image URL exists
         if (imageUrl1 != null) {
             ImageIcon icon1 = new ImageIcon(imageUrl1);
             frame.getImagenSW().setIcon(icon1);
         } else {
             frame.getImagenSW().setIcon(null);  // No icon if image not found
         }

         if (imageUrl2 != null) {
             ImageIcon icon2 = new ImageIcon(imageUrl2);
             frame.getImagenST().setIcon(icon2);
         } else {
             frame.getImagenST().setIcon(null);  // No icon if image not found
         }

        } catch (Exception e) {
            System.out.println("Error: Unable to load character images. " + e.getMessage());
            // Optionally log the error or notify the user in the UI if needed
        }
            
       try {
            Thread.sleep(ia.getSegundosPorCombate()*1000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       
       frame.getEstadoIA().setText("Decidiendo!");
        
        printCola(cola.cola1Startrek, "Cola 1 Star Trek", frame.getCola1Startrek());
        printCola(cola.cola1Starwars, "Cola 1 Star Wars", frame.getCola1Starwars());
        printCola(cola.cola2Startrek, "Cola 2 Star Trek", frame.getCola2Startrek());
        printCola(cola.cola2Starwars, "Cola 2 Star Wars", frame.getCola2Starwars());
        printCola(cola.cola3Startrek, "Cola 3 Star Trek", frame.getCola3Startrek());
        printCola(cola.cola3Starwars, "Cola 3 Star Wars", frame.getCola3Starwars());
        printCola(cola.colaRefuerzoStartrek, "Cola Refuerzos Star Trek", frame.getColaRefuerzosStartrek());
        printCola(cola.colaRefuerzoStarwars, "Cola Refuerzos Star Wars", frame.getColaRefuerzosStarwars());
        
        ia.combate(cola, personaje1, personaje2, frame);
        
        frame.getEstadoIA().setText("Anunciando Resultado!");
        frame.getVictoriasSW().setText(String.valueOf(ia.victoriasStarwars));
        frame.getVictoriasST().setText(String.valueOf(ia.victoriasStartrek));
        
        try {
            Thread.sleep(ia.segundosPorCombate*1000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
         //Logica funcion para personajes en Reservas -> cola1
        int probabilidad1 = (int)(Math.random()* 100);
        if(cola.colaRefuerzoStarwars.peek() != null){
                if(probabilidad1 >= 40){
                    Personajes personajeCambio1 = cola.colaRefuerzoStarwars .poll();
                    cola.cola1Starwars.add(personajeCambio1);}
                else{
                    Personajes personajeCambio1 = cola.colaRefuerzoStarwars .poll();
                    cola.colaRefuerzoStarwars.add(personajeCambio1);}
            }else{}
        
        int probabilidad2 = (int)(Math.random()* 100);
        if(cola.colaRefuerzoStartrek.peek() != null){
                if(probabilidad2 >= 40){
                    Personajes personajeCambio2 = cola.colaRefuerzoStartrek .poll();
                    cola.cola1Startrek.add(personajeCambio2);}
                else{
                    Personajes personajeCambio2 = cola.colaRefuerzoStartrek .poll();
                    cola.colaRefuerzoStartrek.add(personajeCambio2);}
            }else{}
        
        cicloRevision( cola);
    }
    
    public void cicloRevision(ColasPrioridad cola){
        this.ciclosDeRevision ++;
        
        
        if(this.ciclosDeRevision >= 2){
            int probabilidad1 = (int)(Math.random()* 100);
            
             if(probabilidad1 <= 80){
                this.ciclosDeRevision = 0;
                this.ciclosDeRevisionTotales += 1;

                Personajes personaje1 = new Personajes(this.ciclosDeRevisionTotales + 80, "Han Solo", "/Imágenes/Han Solo.png");
                personaje1.evaluarPrioridad();
                cola.colaRefuerzoStarwars.add(personaje1);

                Personajes personaje2 = new Personajes(this.ciclosDeRevisionTotales + 80, "Spok", "/Imágenes/Spock.png");
                personaje1.evaluarPrioridad();
                cola.colaRefuerzoStartrek.add(personaje2);
             }
             else{
                this.ciclosDeRevision = 0;
                this.ciclosDeRevisionTotales += 1;
            }
        }else{}
        
    }
    
    // Método para imprimir una cola en un JTextArea específico
    public void printCola(Queue<Personajes> cola, String colaName, JTextArea textArea) {
        StringBuilder sb = new StringBuilder();
        sb.append("Printing ").append(colaName).append(":\n");

        // for-each para iterar por las colas y construir el texto para el JTextArea
        for (Personajes personaje : cola) {
            sb.append(personaje.toString()).append("\n"); // Agregar cada personaje al texto
        }

        textArea.setText(sb.toString()); // Mostrar el texto en el JTextArea
    }

    public int getCiclosDeRevision() {
        return ciclosDeRevision;
    }

    public void setCiclosDeRevision(int ciclosDeRevision) {
        this.ciclosDeRevision = ciclosDeRevision;
    }

    private void sleep(int par) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
