/*****************
Proyecto Semestral
Autor: Alejandro Gómez 20347, Marco Jurado 20308, Paola De Leon 20361, Andres Osorio, Alejandra Guzman 20262
Fecha: 01/09/2020
Ultima modificacion: 11/09/2020
					
Clase derivada de EmpleadorFormal.
Samaj-20
*****************/

import java.util.ArrayList;

public class EmpleadorTemporal extends EmpleadorFormal {
    
    // Propiedades
    private ArrayList<TrabajoTemp> TrabajoTemporal; // Lista que almacenará los trabajos informales creados por el empleador.

    //Constructor
    public EmpleadorTemporal( usuarioSamaj user ) {
        // Llamar a constructor de EmpleadorFormal
        super( user );
        TrabajoTemporal = new ArrayList<TrabajoTemp>(); 
    }

    // Getters
    public ArrayList<TrabajoTemp> getTrabajoTemporal() { return TrabajoTemporal; }

    // Setters
    public ArrayList<TrabajoTemp> setTrabajoTemporal ( ArrayList<TrabajoTemp> a ) { TrabajoTemporal = a; return TrabajoTemporal; }

    /**
     * Método para agregar un trabajo a la lista de trabajos temporales.
     * @param a Trabajo temporal que se agregará.
     * @return void
     * @author Paola De León
    */
    public void AddTrabajoTemp ( TrabajoTemp a ) {
        ArrayList<TrabajoTemp> ListaTrabajos = this.TrabajoTemporal;
        ListaTrabajos.add ( a );
    }


    /**
      * Método para mostrar la información de un empleador.
      * @param a Empleador del cual se mostrará la información.
      * @return String En el que se mostrará la infor.
      * @author Paola De León
    */
    public String toString ( ) {
        String mensaje = "";    
        mensaje += "Informacion del empleador informal: ";  
        mensaje += "- Nombre: " + this.Nombre;
        mensaje += "- Codigo: " + this.Codigo;
        mensaje += "- Contacto: " + this.Contacto;
        
        return mensaje;
    }

}
