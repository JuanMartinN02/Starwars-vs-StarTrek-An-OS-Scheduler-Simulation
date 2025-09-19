/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.Random;

/**
 *
 * @author danie
 */
public class Personajes {
    
    private int id;
    private String nombre;
    private String imagen;
    private boolean puntosVida;
    private boolean fuerza;
    private boolean habilidades;
    private boolean agilidad;
    private int puntos;
    private int prioridad;
    private int contadorinanicion;
    
    public Personajes(int id, String nombre, String imagen){
        this.id = id;
        this.nombre = nombre;
        this.imagen = imagen;
        this.puntosVida = false;
        this.fuerza = false;
        this.habilidades = false;
        this.agilidad = false;
        this.puntos = 0;
        
        this.prioridad = 3;
        this.contadorinanicion = 0;
    }
    
    public void evaluarPrioridad(){
        /*
        La prioridad se evaluara calculando los puntos de un personaje, cada razgo de calidad que tenga el personaje le sumaran 25 puntos.
        La distribucion sera la siguientes:
        0 o 25 puntos: nivel 3
        50 o 75 puntos: nivel 2
        100 puntos: nivel 1
        */
        Random random = new Random();

        // Generar variables con las probabilidades indicadas
        int puntosVida = (random.nextDouble() < 0.60) ? 25 : 0;  // 60% de probabilidad de ser 25
        int fuerza = (random.nextDouble() < 0.70) ? 25 : 0;  // 70% de probabilidad de ser 25
        int habilidades = (random.nextDouble() < 0.50) ? 25 : 0;  // 50% de probabilidad de ser 25
        int agilidad = (random.nextDouble() < 0.40) ? 25 : 0;  // 40% de probabilidad de ser 25
        
        this.puntos += puntosVida + fuerza + habilidades + agilidad;

        if(puntosVida == 25){
            this.puntosVida = true;
        }else{}
        
        if(fuerza == 25){
            this.fuerza = true;
        }else{}
        
        if(habilidades == 25){
            this.habilidades = true;
        }else{}
        
        if(agilidad == 25){
            this.agilidad = true;
        }else{}
        
        
        if(puntos <= 0){
            this.prioridad = 3;
        }
        else if(puntos <= 50){
            this.prioridad = 2;
        }
        else if(puntos <= 100){
            this.prioridad = 1;
        }
        
        //prints de prueba
        System.out.println("");
        System.out.println("ID: "+ this.id);
        System.out.println("Estadisticas de: "+ this.nombre);
        System.out.println("Fueza de calidad: " + this.fuerza);
        System.out.println("Puntos de vida de calidad: " + this.puntosVida);
        System.out.println("habilidades de calidad: " + this.habilidades);
        System.out.println("Agilidad de calidad: " + this.agilidad);
        System.out.println("PUNTOS TOTALES: " + this.puntos);
        System.out.println("PRIORIDAD: " + this.prioridad);
        System.out.println("Imagen: " + this.imagen);
    }
    
    @Override
    public String toString() {
        return "ID=" + this.id +", "+ this.nombre + ",  Inanicion=" + this.contadorinanicion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public boolean isPuntosVida() {
        return puntosVida;
    }

    public void setPuntosVida(boolean puntosVida) {
        this.puntosVida = puntosVida;
    }

    public boolean isFuerza() {
        return fuerza;
    }

    public void setFuerza(boolean fuerza) {
        this.fuerza = fuerza;
    }

    public boolean isHabilidades() {
        return habilidades;
    }

    public void setHabilidades(boolean habilidades) {
        this.habilidades = habilidades;
    }

    public boolean isAgilidad() {
        return agilidad;
    }

    public void setAgilidad(boolean agilidad) {
        this.agilidad = agilidad;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public int getContadorinanicion() {
        return contadorinanicion;
    }

    public void setContadorinanicion(int contadorinanicion) {
        this.contadorinanicion = contadorinanicion;
    }
    

   
    
}
