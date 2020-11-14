/*****************
Proyecto Semestral
Autor: Alejandro Gómez 20347, Marco Jurado 20308, Paola De Leon 20361, Andres Osorio, Alejandra Guzman 20262
Fecha: 01/09/2020
Ultima modificacion: 11/09/2020
					
Clase que trabaja con el perfil del trabajador informal
Samaj-20
*****************/

public class TrabajadorInformal extends usuarioSamaj {

  //Variables de instancia
  private String AreaConocimiento;
  
  //Constructor
  public TrabajadorInformal ( usuarioSamaj user, String Area ) {
    super( user.getNombre(), user.getApellido(), user.getCorreo(), user.getTelefono(), user.getCodigo() );
    this.AreaConocimiento = Area;
  }

  // Getters
  public String getAreaConocimiento () { return AreaConocimiento; }

  // Setters
  public void setAreaConocimiento ( String a ) { AreaConocimiento =  a; }

  /**
   * Método para mostrar la infromación de un trabajador informal.
   * @param a Trabajador informal del cuál se mostrará la información.
   * @return String Con la info del trabajador.
   * @author Paola De León
  */
  public String toString() {
    String result = "";
    result = "\n Codigo ID:" + this.Codigo + "\n Nombre: " + this.Nombre + "\n Apellido: " + this.Apellido + "\n Areadeconocimiento" + this.AreaConocimiento + "\n Telefono:" + this.Telefono;
    
    return result;
  }

}