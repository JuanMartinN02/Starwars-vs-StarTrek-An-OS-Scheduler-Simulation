/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Clases.ColasPrioridad;
import Interfaz.Menu;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 *
 * @author danie
 */
public class IA {
    int victoriasStarwars;
    int victoriasStartrek;
    int segundosPorCombate;
    LinkedList<Personajes> ganadoresStarwars = new LinkedList<>();
    LinkedList<Personajes> ganadoresStartrek = new LinkedList<>();
    
    public IA() {
        this.victoriasStarwars = 0;
        this.victoriasStartrek = 0;
        this.segundosPorCombate = 3;
    }
    
    
    /*
    Funcion que saca a un personaje de cada lista, los hace pelear y determina un ganador.
    Una manera posbile de decidir un ganador es tirar dados (Dungeons and Dragons) por cada habilidad,
    si la habilidad es de calidad se le da un dado extra con maximo x puntos.
    
    tener un random para desempate!
    */
    public void combate(ColasPrioridad cola, Personajes personaje1, Personajes personaje2, Menu frame) throws InterruptedException{
        
        frame.getDesicionCombate().setText("...");
        
        aumentarInanicion(cola);
        
        personaje1.setContadorinanicion(0);
        personaje2.setContadorinanicion(0);
        
        sleep(segundosPorCombate * 1000);
        
        int puntosDados1 = 0;
        int puntosDados2 = 0;
        
        int probabilidad = (int)(Math.random()* 100);
        
        //existe un ganador
        if (probabilidad <= 40){
            System.out.println("");
            System.out.println("Van a pelear!");
            
            //roll para fuerza
            if(personaje1.isFuerza() == true && personaje2.isFuerza() == true){
                //dados normales
                puntosDados1 += (int)(Math.random()*6+1);
                puntosDados2 += (int)(Math.random()*6+1);
                
                //dados bono de calidad
                puntosDados1 += (int)(Math.random()*3+1);
                puntosDados2 += (int)(Math.random()*3+1);
                
            }else if(personaje1.isFuerza() == true && personaje2.isFuerza() == false){
                 //dados normales
                puntosDados1 += (int)(Math.random()*6+1);
                puntosDados2 += (int)(Math.random()*6+1);
                
                //dados bono de calidad
                puntosDados1 += (int)(Math.random()*3+1);
            
            }else if(personaje1.isFuerza() == false && personaje2.isFuerza() == true){
                 //dados normales
                puntosDados1 += (int)(Math.random()*6+1);
                puntosDados2 += (int)(Math.random()*6+1);
                
                //dados bono de calidad
                puntosDados2 += (int)(Math.random()*3+1);
            
            }else{
                 //dados normales
                puntosDados1 += (int)(Math.random()*6+1);
                puntosDados2 += (int)(Math.random()*6+1);
                
            }
            
             //roll para puntos de vida
            if(personaje1.isPuntosVida() == true && personaje2.isPuntosVida() == true){
                //dados normales
                puntosDados1 += (int)(Math.random()*6+1);
                puntosDados2 += (int)(Math.random()*6+1);
                
                //dados bono de calidad
                puntosDados1 += (int)(Math.random()*3+1);
                puntosDados2 += (int)(Math.random()*3+1);
                
            }else if(personaje1.isPuntosVida() == true && personaje2.isPuntosVida() == false){
                 //dados normales
                puntosDados1 += (int)(Math.random()*6+1);
                puntosDados2 += (int)(Math.random()*6+1);
                
                //dados bono de calidad
                puntosDados1 += (int)(Math.random()*3+1);
            
            }else if(personaje1.isPuntosVida() == false && personaje2.isPuntosVida() == true){
                 //dados normales
                puntosDados1 += (int)(Math.random()*6+1);
                puntosDados2 += (int)(Math.random()*6+1);
                
                //dados bono de calidad
                puntosDados2 += (int)(Math.random()*3+1);
            
            }else{
                 //dados normales
                puntosDados1 += (int)(Math.random()*6+1);
                puntosDados2 += (int)(Math.random()*6+1);
                
            }
            
            
             //roll para agilidad
            if(personaje1.isAgilidad()  == true && personaje2.isAgilidad()  == true){
                //dados normales
                puntosDados1 += (int)(Math.random()*6+1);
                puntosDados2 += (int)(Math.random()*6+1);
                
                //dados bono de calidad
                puntosDados1 += (int)(Math.random()*3+1);
                puntosDados2 += (int)(Math.random()*3+1);
                
            }else if(personaje1.isAgilidad()  == true && personaje2.isAgilidad()  == false){
                 //dados normales
                puntosDados1 += (int)(Math.random()*6+1);
                puntosDados2 += (int)(Math.random()*6+1);
                
                //dados bono de calidad
                puntosDados1 += (int)(Math.random()*3+1);
            
            }else if(personaje1.isAgilidad() == false && personaje2.isAgilidad() == true){
                 //dados normales
                puntosDados1 += (int)(Math.random()*6+1);
                puntosDados2 += (int)(Math.random()*6+1);
                
                //dados bono de calidad
                puntosDados2 += (int)(Math.random()*3+1);
            
            }else{
                 //dados normales
                puntosDados1 += (int)(Math.random()*6+1);
                puntosDados2 += (int)(Math.random()*6+1);
                
            }
            
            
             //roll para 
            if(personaje1.isHabilidades() == true && personaje2.isHabilidades() == true){
                //dados normales
                puntosDados1 += (int)(Math.random()*6+1);
                puntosDados2 += (int)(Math.random()*6+1);
                
                //dados bono de calidad
                puntosDados1 += (int)(Math.random()*3+1);
                puntosDados2 += (int)(Math.random()*3+1);
                
            }else if(personaje1.isHabilidades() == true && personaje2.isHabilidades()== false){
                 //dados normales
                puntosDados1 += (int)(Math.random()*6+1);
                puntosDados2 += (int)(Math.random()*6+1);
                
                //dados bono de calidad
                puntosDados1 += (int)(Math.random()*3+1);
            
            }else if(personaje1.isHabilidades() == false && personaje2.isHabilidades() == true){
                 //dados normales
                puntosDados1 += (int)(Math.random()*6+1);
                puntosDados2 += (int)(Math.random()*6+1);
                
                //dados bono de calidad
                puntosDados2 += (int)(Math.random()*3+1);
            
            }else{
                 //dados normales
                puntosDados1 += (int)(Math.random()*6+1);
                puntosDados2 += (int)(Math.random()*6+1);
                
            }
            
            //Decidir ganador a partir de puntos 
            if(puntosDados1 > puntosDados2){ //gano starwars
                this.victoriasStarwars ++;
                System.out.println("");
                System.out.println(personaje1.getNombre()+ " vs " + personaje2.getNombre());
                System.out.println(personaje1.getNombre()+ " Obtuvo: "+puntosDados1+" y " + personaje2.getNombre()+ " Obtuvo: "+puntosDados2);
                System.out.println(personaje1.getNombre()+ " GANO LA BATALLA!");
                
                //anade a la cola de ganador
                this.ganadoresStarwars.add(personaje1);
                frame.getDesicionCombate().setText("Gana: "+personaje1.getNombre()+"!");
            }
            
            else if(puntosDados1 < puntosDados2){ //gano startrek
                this.victoriasStartrek ++;
                System.out.println("");
                System.out.println(personaje1.getNombre()+ " vs " + personaje2.getNombre());
                System.out.println(personaje1.getNombre()+ " Obtuvo: "+puntosDados1+" y " + personaje2.getNombre()+ " Obtuvo: "+puntosDados2);
                System.out.println(personaje2.getNombre()+ " GANO LA BATALLA!");
                
                //anade a la cola de ganador
                this.ganadoresStartrek.add(personaje2);
                frame.getDesicionCombate().setText("Gana: "+personaje2.getNombre()+"!");
                
            }else{//Empataron el combate!! casi imposible
                int dadoFinal = (int)(Math.random()*2+1);
                System.out.println("");
                System.out.println(personaje1.getNombre()+ " vs " + personaje2.getNombre());
                System.out.println("EMPATARON EL COMBATE!!!");
                System.out.println("PASAMOS AL DADO DE LA MUERTE!!!!");
                
                
                if(dadoFinal == 1){ //gano starwars
                    this.victoriasStarwars ++;
                    System.out.println("");
                    System.out.println(personaje1.getNombre()+ " vs " + personaje2.getNombre());
                    System.out.println(personaje1.getNombre()+ " Obtuvo: "+puntosDados1+" y " + personaje2.getNombre()+ " Obtuvo: "+puntosDados2);
                    System.out.println(personaje1.getNombre()+ " GANO LA BATALLA!");
                    
                    //anade a la cola de ganador
                    this.ganadoresStarwars.add(personaje1);
                    frame.getDesicionCombate().setText("Gana: "+personaje1.getNombre()+"!");
                    
                }else{//gano startrek
                    this.victoriasStartrek ++;
                    System.out.println("");
                    System.out.println(personaje1.getNombre()+ " vs " + personaje2.getNombre());
                    System.out.println(personaje1.getNombre()+ " Obtuvo: "+puntosDados1+" y " + personaje2.getNombre()+ " Obtuvo: "+puntosDados2);
                    System.out.println(personaje2.getNombre()+ " GANO LA BATALLA!");
            
                    //anade a la cola de ganador
                    this.ganadoresStartrek.add(personaje2);
                    frame.getDesicionCombate().setText("Gana: "+personaje2.getNombre()+"!");
                }
            }
            
            
            System.out.println("");
            System.out.println("Scoreboard:");
            System.out.println("Victorias de Starwars: "+this.victoriasStarwars);
            System.out.println("Victorias de Startrek: "+this.victoriasStartrek);
        }
        
        
        //empate
        else if(probabilidad <= 67){ 
            System.out.println("");
            System.out.println(personaje1.getNombre()+ " vs " + personaje2.getNombre());
            System.out.println("Empataron, no hay combate!");
            //Se colocan al final de la cola de prioridad 1 para que vuelvan a pelear!
            cola.cola1Starwars.add(personaje1);
            cola.cola1Startrek.add(personaje2); 
            frame.getDesicionCombate().setText("Empate!");
        }
        
        
         //se anula el combate
        else{
            System.out.println("");
            System.out.println(personaje1.getNombre()+ " vs " + personaje2.getNombre());
            System.out.println("Se anula el combate!");
            //Se encolan en la cola de refuerzos porque no estan listos para el combate!
            cola.colaRefuerzoStarwars.add(personaje1);
            cola.colaRefuerzoStartrek.add(personaje2); 
            frame.getDesicionCombate().setText("Se anula el combate!");
        }
        
        
    }
    
    
    public void aumentarInanicion(ColasPrioridad cola) {
    // Lista temporal para guardar personajes que van a subir de prioridad
    List<Personajes> toMoveFrom2to1 = new ArrayList<>();
    List<Personajes> toMoveFrom3to2 = new ArrayList<>();
    List<Personajes> toMoveFromRefuerzoTo3 = new ArrayList<>();

    //proceso cola1Starwars
    for (Personajes personaje : cola.cola1Starwars) {
        personaje.setContadorinanicion(personaje.getContadorinanicion() + 1);
        if (personaje.getContadorinanicion() >= 8) {
            personaje.setContadorinanicion(0);
        }
    }

    //proceso cola2Starwars
    for (Personajes personaje : cola.cola2Starwars) {
        personaje.setContadorinanicion(personaje.getContadorinanicion() + 1);
        if (personaje.getContadorinanicion() >= 8) {
            personaje.setContadorinanicion(0);
            toMoveFrom2to1.add(personaje);  // Store character to move later
        }
    }

    //proceso cola3Starwars
    for (Personajes personaje : cola.cola3Starwars) {
        personaje.setContadorinanicion(personaje.getContadorinanicion() + 1);
        if (personaje.getContadorinanicion() >= 8) {
            personaje.setContadorinanicion(0);
            toMoveFrom3to2.add(personaje);  // Store character to move later
        }
    }

    //proceso colaRefuerzosStarwars
    for (Personajes personaje : cola.colaRefuerzoStarwars) {
        personaje.setContadorinanicion(personaje.getContadorinanicion() + 1);
        if (personaje.getContadorinanicion() >= 8) {
            personaje.setContadorinanicion(0);
            toMoveFromRefuerzoTo3.add(personaje);  // Store character to move later
        }
    }

    // Mover personajes de prioridad si aplica
    cola.cola2Starwars.removeAll(toMoveFrom2to1);
    cola.cola1Starwars.addAll(toMoveFrom2to1);

    cola.cola3Starwars.removeAll(toMoveFrom3to2);
    cola.cola2Starwars.addAll(toMoveFrom3to2);

    cola.colaRefuerzoStarwars.removeAll(toMoveFromRefuerzoTo3);
    cola.cola3Starwars.addAll(toMoveFromRefuerzoTo3);

    
    // Proceso cola1Startrek
    for (Personajes personaje : cola.cola1Startrek) {
        personaje.setContadorinanicion(personaje.getContadorinanicion() + 1);
        if (personaje.getContadorinanicion() >= 8) {
            personaje.setContadorinanicion(0);
        }
    }

    // Proceso cola2Startrek
    List<Personajes> toMoveFrom2to1Startrek = new ArrayList<>();
    for (Personajes personaje : cola.cola2Startrek) {
        personaje.setContadorinanicion(personaje.getContadorinanicion() + 1);
        if (personaje.getContadorinanicion() >= 8) {
            personaje.setContadorinanicion(0);
            toMoveFrom2to1Startrek.add(personaje);  // Store character to move later
        }
    }
    
    // Mover personajes de prioridad si aplica
    cola.cola2Startrek.removeAll(toMoveFrom2to1Startrek);
    cola.cola1Startrek.addAll(toMoveFrom2to1Startrek);

    // Proceso cola3Startrek
    List<Personajes> toMoveFrom3to2Startrek = new ArrayList<>();
    for (Personajes personaje : cola.cola3Startrek) {
        personaje.setContadorinanicion(personaje.getContadorinanicion() + 1);
        if (personaje.getContadorinanicion() >= 8) {
            personaje.setContadorinanicion(0);
            toMoveFrom3to2Startrek.add(personaje);  // Store character to move later
        }
    }
    
    // Mover personajes de prioridad si aplica
    cola.cola3Startrek.removeAll(toMoveFrom3to2Startrek);
    cola.cola2Startrek.addAll(toMoveFrom3to2Startrek);

    // Proceso colaRefuerzoStartrek
    List<Personajes> toMoveFromRefuerzoTo3Startrek = new ArrayList<>();
    for (Personajes personaje : cola.colaRefuerzoStartrek) {
        personaje.setContadorinanicion(personaje.getContadorinanicion() + 1);
        if (personaje.getContadorinanicion() >= 8) {
            personaje.setContadorinanicion(0);
            toMoveFromRefuerzoTo3Startrek.add(personaje);  // Store character to move later
        }
    }
    
    // Mover personajes de prioridad si aplica
    cola.colaRefuerzoStartrek.removeAll(toMoveFromRefuerzoTo3Startrek);
    cola.cola3Startrek.addAll(toMoveFromRefuerzoTo3Startrek);
}
    

    //Cambia tiempo de combate (tiempo es en segundos)
    public void cambiarTiempoCombate(int tiempo){
        this.setSegundosPorCombate(tiempo);
    }

    public int getSegundosPorCombate() {
        return segundosPorCombate;
    }

    public void setSegundosPorCombate(int segundosPorCombate) {
        this.segundosPorCombate = segundosPorCombate;
    }
    
    
    
    public int getVictoriasStarwars() {
        return victoriasStarwars;
    }

    public void setVictoriasStarwars(int victoriasStarwars) {
        this.victoriasStarwars = victoriasStarwars;
    }

    public int getVictoriasStartrek() {
        return victoriasStartrek;
    }

    public void setVictoriasStartrek(int victoriasStartrek) {
        this.victoriasStartrek = victoriasStartrek;
    }

    public LinkedList<Personajes> getGanadoresStarwars() {
        return ganadoresStarwars;
    }

    public void setGanadoresStarwars(LinkedList<Personajes> ganadoresStarwars) {
        this.ganadoresStarwars = ganadoresStarwars;
    }

    public LinkedList<Personajes> getGanadoresStartrek() {
        return ganadoresStartrek;
    }

    public void setGanadoresStartrek(LinkedList<Personajes> ganadoresStartrek) {
        this.ganadoresStartrek = ganadoresStartrek;
    }
    
    
    
}
