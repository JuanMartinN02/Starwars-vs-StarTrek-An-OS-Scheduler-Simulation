/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto.so2;

import Clases.Administrador;
import Clases.ColasPrioridad;
import Clases.IA;
import Interfaz.Menu;
import java.net.MalformedURLException;

/**
 *
 * @author danie
 */
public class ProyectoSO2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        
        ColasPrioridad colas = new ColasPrioridad();
        IA ia = new IA();
        Administrador admin = new Administrador();

        colas.personajesStartrek();
        colas.personajesStarwars();
        
        Menu frame = new Menu(ia);
        frame.setVisible(true);
        
        admin.asignacion(colas);
        
        
        
        
        while((colas.getCola1Startrek().peek() != null || colas.getCola2Startrek().peek() != null || colas.getCola3Startrek().peek() != null || colas.getColaRefuerzoStartrek().peek() != null ) 
                &&  (colas.getCola1Starwars().peek() != null || colas.getCola2Starwars().peek() != null || colas.getCola3Starwars().peek() != null || colas.getColaRefuerzoStarwars().peek() != null)){
            admin.ejecucionPelea(colas, ia, frame);
        
            colas.printColas();
        
        }
    
    }
    
}
