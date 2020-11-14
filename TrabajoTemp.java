/*****************
Proyecto Semestral
Autor: Alejandro Gómez 20347, Marco Jurado 20308, Paola De Leon 20361, Andres Osorio, Alejandra Guzman 20262
Fecha: 01/09/2020
Ultima modificacion: 11/09/2020
					
Clase que simulará un trabajo temporal en el proyecto semestral:
Samaj-20
*****************/
import java.util.ArrayList;
public class TrabajoTemp {

  //Propiedades
  private String Nombre; // Nombre del empleador que publicará el trabajo
  private int Telefono; // Contacto del empleador
  private String CategoriaTrabajo; // Palabra clave que representará el tipo de trabajo
  private String DescripcionTrabajo; // Breve descripción del trabajo
  private int Sueldo; // Pago que se ofrecerá por realizar el trabajo
  private ArrayList<usuarioSamaj> Aplicantes;
  private ArrayList<String> aplicantesDatos;
  private usuarioSamaj user;

  // Cosntructor general
  public TrabajoTemp ( ) { }

  // Constructor que creará objetos del Trabajo temporal
  public TrabajoTemp ( usuarioSamaj usu, String CategoriaTrabajo, String DescripcionTrabajo, int Sueldo ) {
    this.Nombre = usu.getNombre();
    this.Telefono = usu.getTelefono();
    this.CategoriaTrabajo = CategoriaTrabajo;
    this.DescripcionTrabajo = DescripcionTrabajo;
    this.Sueldo = Sueldo;
    Aplicantes = new ArrayList<usuarioSamaj>(); 
    this.user = usu;
    aplicantesDatos = new ArrayList<String>();
  }

  // Getters
  public String getNombre () { return Nombre; }
  public String getCategoriaTrabajo () { return CategoriaTrabajo; }
  public String getDescripcionTrabajo () { return DescripcionTrabajo; }
  public int getTelefono () { return Telefono; }
  public int getSueldo () { return Sueldo; }
  public ArrayList<usuarioSamaj>  getAplicantes() {return Aplicantes;}
  public usuarioSamaj getUser(){return user;}
  public ArrayList<String> getaplicantesDatos(){return aplicantesDatos;}
  
  // Setters
  public void setNombre ( String a ) { Nombre = a; }
  public void setCategoriaTrabajo ( String a ) { CategoriaTrabajo = a; }
  public void setDescripcionTrabajo ( String a ) { DescripcionTrabajo = a; }
  public void setTelefono ( int a ) { Telefono = a; }
  public void setSueldo ( int a ) { Sueldo = a; }
  public void setAplicantes(ArrayList<usuarioSamaj> ap) {Aplicantes = ap;}
  public void setUser(usuarioSamaj u){user = u;}
  public void setAplicantesDatos(ArrayList<String> x){ aplicantesDatos = x;}
  
  /**
   * Método para modificar un elemento del trabajado temporal de tipo int.
   * @param temp el trabajo temporal que se quiere cambiar.
   * @param opc el número de opción que se cambiará.
   * @param CambioN el cambio a realizar.
   * @return boolean Indicará si se realizó el cambio o no.
   * @author Paola De León
   */
  public boolean ModificarTrabajo( TrabajoTemp temp, int opc, int CambioN ) {
    boolean Exito = false;
    // Si la opción que eligió el usuario es 1: Se cambiará el contacto del trabajo.
    if ( opc == 1 ) {
        temp.setTelefono( CambioN );
        Exito = true;
    }
    // Si la opción que eligió el usuario es 2: Se cambiará el salario del trabajo.
    if ( opc == 2 ) {
        temp.setSueldo( CambioN );
        Exito = true;
    }
    // Si la opción que eligió el usuario es > 2: El booleano permanecerá false.
    else {}
    return Exito;
  }

  
  /**
   * Sobrecarga de método para modificar un elemento del trabajo temporal de tipo String.
   * @param temp Trabajo temporal a modificar.
   * @param opc Número de opción elegida.
   * @param CambioN String del cambio a realizar.
   * @return boolean Que indicará si se realizó el cambio.
   * @author Paola De León
   */
  public boolean ModificarTrabajo( TrabajoTemp temp, int opc, String CambioN ) {
    boolean Exito = false;
    // Si la opción que eligió el usuario es 1: Se cambiará el nombre del empleador que publicará el trabajo.
    if ( opc == 1 ) {
        temp.setNombre( CambioN );
        Exito = true;
    }
    // Si la opción que eligió el usuario es 2: Se cambiará la categoría del trabajo.
    if ( opc == 2 ) {
        temp.setCategoriaTrabajo( CambioN );
        Exito = true;
    }
    // Si la opción que eligió el usuario es 3: Se cambiará la descripción del trabajo.
    if ( opc == 3 ) {
        temp.setDescripcionTrabajo( CambioN );
        Exito = true;
    }
    // Si la opción que eligió el usuario es > 3: El booleano permanecerá false.
    else {}
    return Exito;
  }
  
  /**
   * Método para obtener la información de un trabajo temporal
   * @param a Trabajo temporal del cuál se quiere saber la info.
   * @return String De la info.
   * @author Alejandro Gomez
   */
  public String toString( ) {
    String mensaje = "";
    mensaje += "          - Nombre del empleador: " + this.Nombre + "\n";
    mensaje += "          - Telefono del empleador: " + this.Telefono+ "\n";
    mensaje += "          - Categoría del trabajo temporal: " + this.CategoriaTrabajo+ "\n";
    mensaje += "          - Descripción del trabajo temporal: " + this.DescripcionTrabajo+ "\n";
    mensaje += "          - Sueldo del trabajo temporal: " + this.Sueldo+ "\n";
    
    return mensaje;
  }


  /**
   * Método para agregar un nuevo Trabajador Informal a el ArrayList aplicantes dentro del trabajo 
   * @param trainf usuarioSamaj a añadir.
   * @return void.
   * @author Marco Jurado 
   */
  public void agregarAplicante(usuarioSamaj trainf){
    Aplicantes.add(trainf);
  }

  /**
   * Método para buscar un Trabajador Informal en el ArrayList aplicantes dentro del trabajo 
   * @param trainf usuarioSamaj a buscar.
   * @return usuarioSamaj
   * @author Marco Jurado 
   */
  public usuarioSamaj buscarAplicante(usuarioSamaj trainf){
    usuarioSamaj retorno = null;
    int codigoOriginal = trainf.getCodigo();
    int tamano = Aplicantes.size();
    if(tamano == 0){
      System.out.println("NO HAY");
    }else{
        for( int i = 0; i < tamano; i++){
          usuarioSamaj busqueda = Aplicantes.get(i);
          int codigoBuscado = busqueda.getCodigo();
          if(codigoOriginal == codigoBuscado){
            retorno = busqueda; // Se devuelve el trabajador que coincide con la información 
          }
        }
    }
    return retorno;
  }

  /**
   * Método para buscar un Trabajador Informal en el ArrayList aplicantes dentro del trabajo SOBRECARGA por codigo de user 
   * @param cod Codigo del Trabajador Informal a buscar.
   * @return Trabajador Informal.
   * @author Marco Jurado 
   */
  public usuarioSamaj buscarAplicante(int cod){
    usuarioSamaj retorno = null;
    int codigoOriginal = cod;
    int tamano = Aplicantes.size();
    if(tamano == 0){
      System.out.println("NO HAY");
    }else{
        for( int i = 0; i < tamano; i++){
          usuarioSamaj busqueda = Aplicantes.get(i);
          int codigoBuscado = busqueda.getCodigo();
          if(codigoOriginal == codigoBuscado){
            retorno = busqueda; // Se devuelve el trabajador que coincide con la información 
          }
        }
    }
    return retorno;
  }

  public void agregaraplicanteDato(String x){
    aplicantesDatos.add(x);
  }

}