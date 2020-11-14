/*****************
Proyecto Semestral
Autor: Alejandro Gómez 20347, Marco Jurado 20308, Paola De Leon 20361, Andres Osorio, Alejandra Guzman 20262
Fecha: 01/09/2020
Ultima modificacion: 11/09/2020
					
Clase derivada de UsuarioSamaj.
Samaj-20
*****************/

public class EmpleadorFormal extends usuarioSamaj {
  
    // Constructor
    /**
     * Constructor de clase EmpleadorFormal.
     * @param user Usario existente de Empleador
     * @author Paola De León
    */
    public EmpleadorFormal( usuarioSamaj user) { 
      super( user.getNombre(), user.getApellido(), user.getCorreo(), user.getTelefono(), user.getCodigo() );
    }

    /**
     * Método para mostrar la información de un empleador.
     * @return String En el que se mostrará la información.
     * @author Paola De León
    */
    public String toString() {
      String mensaje = "";
      mensaje +=  "Informacion del empleador formal: ";
      mensaje += "- Nombre: " + this.Nombre;
      mensaje += "- Codigo: " + this.Codigo;
      mensaje += "- Contacto: " + this.Contacto;
    
      return mensaje;

    }

}
