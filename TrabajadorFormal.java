/*****************
Proyecto Semestral
Autor: Alejandro Gómez 20347, Marco Jurado 20308, Paola De Leon 20361, Andres Osorio, Alejandra Guzman 20262
Fecha: 01/09/2020
Ultima modificacion: 11/09/2020
					
Clase que trabaja con el perfil del trabajador formal
Samaj-20
*****************/

public class TrabajadorFormal extends usuarioSamaj {

  //Atributos
  private int Edad;
  private int NivelEducacion;
  private int NivelExpertise;
  private int Idiomas;
  private boolean Experiencia;
  private boolean Transporte;
  private boolean HomeOffice;
  
  
  // Constructor
  public TrabajadorFormal( usuarioSamaj user, int eda, int nivelEd, int idioma, boolean exp, boolean trans, boolean homeof, int nivelex ) {
    super( user.getNombre(), user.getApellido(), user.getCorreo(), user.getTelefono(), user.getCodigo() );
    Edad = eda;
    NivelEducacion = nivelEd;
    NivelExpertise = nivelex;
    Idiomas = idioma;
    Experiencia = exp;
    Transporte = trans;
    HomeOffice = homeof;
    
  }

  
  //Getters
  public int getEdad ( ) { return Edad; }
  public boolean getExperiencia ( ) { return Experiencia; }
  public int getNivelEducacion ( ) { return NivelEducacion; }
  public int getNivelExpertise ( ) { return NivelExpertise; }
  public int getIdiomas ( ) { return Idiomas; }
  public boolean getTransporte ( ) { return Transporte; }
  public boolean getHomeOffice ( ) { return HomeOffice; }
  
  //Setters
  public void setNivelEducacion ( int NivelEducacion ) { this.NivelEducacion = NivelEducacion; }
  public void setNivelExpertise (int NivelExpertise){this.NivelExpertise = NivelExpertise;}
  public void setIdiomas ( int Idiomas ) { this.Idiomas = Idiomas; }
  public void setExperiencia ( boolean Experiencia ) { this.Experiencia = Experiencia; }
  public void setTransporte ( boolean Transporte ) { this.Transporte = Transporte; }
  public void setHomeOffice ( boolean HomeOffice ){ this.HomeOffice = HomeOffice; }


  /**
   * Método para mostrar la información de un trabajador informal.
   * @return String Con la información.
   * @author Paola De León
   */
  public String toString ( ) {

    String mensaje = " Informacion de trabajador formal: \n";
    mensaje += "\n          - Nombre y apellido: " + this.Nombre + " " + this.Apellido;
    mensaje += "\n          - Edad: " + this.Edad;
    mensaje += "\n          - Telefono: " + this.Telefono;
    mensaje += "\n          - Correo: " + this.Correo;
    
    //Se utiliza la informacion relevante al nivel de educacion
    int NivelEducacion = this.NivelEducacion;
    switch ( NivelEducacion ) {
      case 1:
        mensaje += "\n          - Nivel de educacion: Primaria";
        break;
      case 2:
        mensaje += "\n          - Nivel de educacion: Secundaria";
        break;
      case 3:
        mensaje += "\n          - Nivel de educacion: Universitaria";
        break;
      case 4:
        mensaje += "\n          - Nivel de educacion: Postgrado";
        break;
      default:
        break;
    }

    //Se utiliza la informaion relevante al nivel de expertise
    int NivelExpertise = this.NivelExpertise;
    //Preguntar al buki
    switch (NivelExpertise){
      case 0:
        break;
      case 1:
      mensaje += "\n          - Titulo universitario: Ing. Industrial ";
        break;
      case 2:
      mensaje += "\n          - Titulo universitario: Ing. Mecanico";
        break;
      case 3: 
      mensaje += "\n          - Titulo universitario: Ing. Mecatronico";
        break;
      case 4:
      mensaje += "\n          - Titulo universitario: Ing. Quimico";
        break;
      case 5:
      mensaje += "\n          - Titulo universitario: Ing. Civil";
        break;
      case 6: 
      mensaje += "\n          - Titulo universitario: Ing. Sistemas";
        break;
      case 7:
      mensaje += "\n          - Titulo universitario: Ing. Alimentos ";
        break;
      case 8:
      mensaje += "\n          - Titulo universitario: Mercadologo";
        break;
      case 9:
      mensaje += "\n          - Titulo universitario: Mercadologo especializado en gestion de comunidades virtuales";
        break;
      case 10:
      mensaje += "\n          - Titulo universitario: Mercadologo especializado en Comercios internacionales";
        break;
      case 11:
      mensaje += "\n          - Titulo universitario: Mercadologo especializado en Promotores comerciales";
        break;
      case 12:
      mensaje += "\n          - Titulo universitario: Mercadologo Especialista en SEO y Desarollo Web";
        break;
      case 13:
      mensaje += "\n          - Titulo universitario: Mercadologo especializado";
        break;
      case 14:
      mensaje += "\n          - Titulo universitario: Ciencias politicas especializada en Abogacia rama civil";
        break;
      case 15:
      mensaje += "\n          - Titulo universitario: ciencias politicas especializada en Abogacia con especialización en penal";
        break;
      case 16:
      mensaje += "\n          - Titulo universitario: ciencias politicas especializada en Abogacia en el area constitucional";
        break;
      case 17:
      mensaje += "\n          - Titulo universitario: ciencias politicas especializada en Abogacia en el  area Comercial";
        break;
      case 18:
      mensaje += "\n          - Titulo universitario: Analista especializada de internet";
        break;
      case 19:
      mensaje += "\n          - Titulo universitario: Analista especializado en data science";
        break;
      case 20:
      mensaje += "\n          - Titulo universitario: Arquitecto ";
        break;
      case 21:
      mensaje += "\n          - Titulo universitario: Medicina";
        break;
      case 22:
      mensaje += "\n          - Se registro como: Otros";
        break;

      default:
        break;
    }

    //Se utiliza la informacion relevante al idioma de conocimiento
    int Idiomas = this.Idiomas;
    switch ( Idiomas ) {
      case 1:
        mensaje += "\n          - Idioma de conocimiento: Espanol";
        break;
      case 2:
        mensaje += "\n          - Idiomas de conocimiento: Ingles";
        break;
      case 3:
        mensaje += "\n          - Idiomas de conocimiento: Aleman";
        break;
      case 4:
        mensaje += "\n          - Idiomas de conocimiento: Frances";
        break;
      case 5:
        mensaje += "\n          - Idiomas de conocimiento: Mandarin";
        break;
      case 6:
        mensaje += "\n          - Idiomas de conocimiento: Portugues";
        break;
      case 7:
        mensaje += "\n          - Idiomas de conocimiento: Otros";
        break;

      default:
        break;
    }

    boolean Experiencia = this.Experiencia;
    if ( Experiencia == true ) {
      mensaje += "\n          - Experiencia: Si";
    }
    else {
      mensaje += "\n          - Experiencia: No";
    }

    Boolean Transporte = this.Transporte;
    if ( Transporte == true ) {
      mensaje += "\n          - Transporte: Si";
    }
    else {
      mensaje += "\n          - Transporte: No";
    }

    boolean HomeOffice = this.HomeOffice;
    if ( HomeOffice == true ) {
      mensaje += "\n          - Cuenta con herramientas para home office:: Si";
    }
    else {
      mensaje += "\n          - Cuenta con herramientas para home office: No";
    }

    mensaje += "\n          - Codigo: " + this.Codigo;


    return mensaje;
  }

}