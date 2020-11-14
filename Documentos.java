/*****************
Proyecto Semestral
Autor: Alejandro Gómez 20347, Marco Jurado 20308, Paola De Leon, Andres Osorio, Alejandra Guzman 20262
Fecha: 01/09/2020
Ultima modificacion: 11/09/2020 
					
Clase que se encarga de tener todo lo relacionado
con los metodos para documentos
*****************/

import java.util.ArrayList;
import java.util.Random;

public class Documentos {

	//Propiedades de clase
	public static ArrayList<TrabajadorFormal> BaseTF; // ArrayList de trabajadores formales
	public static ArrayList<TrabajadorInformal> BaseTT; // ArrayList de trabajadores informales
	public static ArrayList<EmpleadorFormal> BaseEF; // ArrayList de empleadores formales.
  public static ArrayList<EmpleadorTemporal> BaseET; // ArrayList de empleadores informales
  public static ArrayList<usuarioSamaj> Usuarios; // ArrayList de usarios de Samaj
  public static ArrayList<TrabajoTemp> TrabajoTemp; // ArrayList de trabajos temporales generales
  public static ArrayList<ArrayList<String>> InfoUsuarios; // ArrayList de info

	// Constructor que instancia las listas en las que se almacenará la infromación.
  public Documentos ( ) {
    BaseTF = new ArrayList<TrabajadorFormal>();
    BaseTT = new ArrayList<TrabajadorInformal>();
    BaseEF = new ArrayList<EmpleadorFormal>();
    BaseET = new ArrayList<EmpleadorTemporal>();
    Usuarios = new ArrayList<usuarioSamaj>();
    TrabajoTemp = new ArrayList<TrabajoTemp>();
    InfoUsuarios = new ArrayList<ArrayList<String>>();
  }

  // Getters
  public static ArrayList<EmpleadorTemporal> getET ( ) { return BaseET; }
  public static ArrayList<EmpleadorFormal> getEF ( ) { return BaseEF; }
  public static ArrayList<TrabajadorInformal> getTT ( ) { return BaseTT; }
  public static ArrayList<TrabajadorFormal> getTF ( ) { return BaseTF; }
  public static ArrayList<usuarioSamaj> getUsuarios ( ) { return Usuarios; }
  public static ArrayList<TrabajoTemp> getTrabajoTemp ( ) { return TrabajoTemp; }
  public static ArrayList<ArrayList<String>> getInfoUsuarios ( ) { return InfoUsuarios; }

  // Setter
  public static void setInfoUsuarios ( ArrayList<ArrayList<String>> a ) { InfoUsuarios = a; }

  /**
   * Método para buscar un trabajador formal en ArrayList.
   * @param codigo Código el trabajador formal.
   * @return boolean Será true si se encontró el objeto en el ArrayList.
   * @author 
   */
	public boolean BuscarTrabajadorFormal( int codigo ) { 

    boolean exists = false;
    //Se recorre el listado y se busca el código igual.
		for ( int i = 0; i< BaseTF.size(); i++ ) {
			TrabajadorFormal entacuchado = BaseTF.get(i);
			if (codigo == entacuchado.getCodigo()) {
				exists = true;
      } 
      else {}
    }
    
    return exists;
	}

  public void AddTrabajoTemp ( TrabajoTemp a ) {
    TrabajoTemp.add ( a );
  }

  /** 
   * Método para buscar un trabajador temporal en ArrayList.
   * @param Codigo Código del trabajador temporal.
   * @return boolean Será true si se encontró el objeto en el ArrayList.
   */
	public boolean BuscarTrabajadorTemporal( int Codigo ) {

    //Se recorre el listado y se busca el código igual.
    boolean exists = false;
		for ( int i = 0; i< BaseTT.size(); i++ ) {
			TrabajadorInformal TInformal = BaseTT.get ( i );
			if ( Codigo == TInformal.getCodigo() ) {
        exists = true;
      }
      else {}
    }
    
    return exists;
	}


  /**
   * Método para buscar un Empleador Formal en ArrayList.
   * @param Codigo Código del empleador formal.
   * @return boolean Será true si se encontró el objeto en el ArrayList.
   * @author 
   */
	public boolean BuscarEmpleadorFormal ( int Codigo ) {
    boolean exists = false;
    //Se recorre el listado y se busca el código igual. 
		for ( int i = 0; i< BaseEF.size(); i++ ) {
			EmpleadorFormal Jefe = BaseEF.get(i);
			if (Codigo == Jefe.getCodigo()){
				exists = true;
      }
      else{}
    }
    
    return exists;
  }
  

  /**
   * Método para buscar un Empleador Temporal en ArrayList.
   * @param Codigo Código del empleador temporal.
   * @return boolean Será true si se encontró el objeto en el ArrayList.
   * @author 
   */
	public boolean BuscarEmpleadorTemporal ( int Codigo ) {
    boolean exists = false;
		for ( int i = 0; i< BaseET.size(); i++ ) {
			EmpleadorTemporal Senito = BaseET.get(i);
			if ( Codigo == Senito.getCodigo() ) {
				exists = true;
      } 
      else {}
    }
    
    return exists;
	}
	

  /**
   * Método para devolver el objeto que tenga el mismo código.
   * Se debe validar el codigo para usar este método.
   * @param Codigo Código del empleador formal.
   * @return TrabajadorFormal El trabajador formal que corresponde al código ingresado.
   * @author 
   */
	public TrabajadorFormal ObtenerTF ( int Codigo ) {
    TrabajadorFormal Worker = null;
		for ( int i = 0; i< BaseTF.size(); i++ ) {
			TrabajadorFormal entacuchado = BaseTF.get(i);
			if ( Codigo == entacuchado.getCodigo( ) ) {
				Worker = entacuchado;
			}
		}

    return Worker;
	}
  

  /**
   * Método para devolver el objeto que tenga el mismo código.
   * Se debe validar el codigo para usar este método.
   * @param Codigo Código del trabajador informal.
   * @return TrabajadorInformal Trabajador informal que corresponde al código ingresado.
   * @author 
   */
	public TrabajadorInformal ObtenerTT ( int Codigo ) {
    TrabajadorInformal Worker = null; 
		for ( int i = 0; i< BaseTT.size(); i++ ) {
			TrabajadorInformal don = BaseTT.get( i );
			if ( Codigo == don.getCodigo() ) {
				Worker = don;//Devuelve el objeto si lo encontró
			}
		}
    
    return Worker;
	}


  /**
   * Método para obtener un empleador del ArrayList.
   * Se debe validar el codigo para usar este método.
   * @param Codigo Código del empleador formal.
   * @return EmpleadorFormal Empleador formal que corresponde al código ingresado.
   * @author 
   */
	public EmpleadorFormal ObtenerEF ( int Codigo ) {
    EmpleadorFormal Boss = null;
		for ( int i = 0; i< BaseEF.size(); i++ ) {
			EmpleadorFormal Jefe = BaseEF.get(i);
			if (Codigo == Jefe.getCodigo() ) {
				Boss = Jefe;
      }
      else {}
		}

    return Boss;
	}


  /**
   * Método para devolver el objeto que tenga el mismo código.
   * Se debe validar el codigo para usar este método.
   * @param Codigo Código del empleador temporal.
   * @return EmpleadorTemporal Empleador temporal que corresponde al código ingresado.
   * @author 
   */
	public EmpleadorTemporal ObtenerET ( int Codigo ) {
    EmpleadorTemporal Mister = null;
		for ( int i = 0; i< BaseET.size(); i++ ) {
			EmpleadorTemporal Senito = BaseET.get(i);
			if ( Codigo == Senito.getCodigo() ) {
				Mister = Senito;
			}
		}

    return Mister;
	}

  
  /**
   * Método para generar un código aleatorio.
   * @param docs Objeto de documentos.
   * @return int Código generado.
   * @author Paola de León
   */
  public static int generarCod ( Documentos docs ) {
    boolean codCorrecto = false; 
    int Codigo = 0;
    //Verifica si este ya existe en las bases de datos.
    while ( codCorrecto == false ) { 
      Random rand = new Random();
      int cod = rand.nextInt(899) + 100;
      int contador = 0;
  
      //For que recorre la base de datos de trabajadores formales
      for ( int i = 0; i < BaseTF.size(); i++ ) {
        TrabajadorFormal entacuchado = BaseTF.get(i);
        int numerito = entacuchado.getCodigo();
        if( cod == numerito ) {
          contador += 1;
        }
      }
      //For para recorrer la base de datos de trabajadores temporales
      for ( int j = 0; j < BaseTT.size(); j++ ) {
        TrabajadorInformal don = BaseTT.get(j);
        int numerazo = don.getCodigo();
        if( cod == numerazo ) {
          contador += 1;
        }
      }
      
      //For que recorre la base de datos de empleador formal
      for ( int k = 0; k < BaseEF.size(); k++ ) {
        EmpleadorFormal Jefe = BaseEF.get(k);
        int Num = Jefe.getCodigo();
        if ( cod == Num ) {
          contador += 1;
        }
      }
      
      //For que recorre base de datos de empleador de empleador temporales.
      for ( int l = 0; l < BaseET.size(); l++ ) {
        EmpleadorTemporal Senito = BaseET.get(l);
        int numerito = Senito.getCodigo();
        if ( cod == numerito ) {
          contador += 1;
        }
      }
      
      if ( contador == 0 ) {
        Codigo = cod;
        codCorrecto = true;
      }
    }
    
    return Codigo;
    
  }

  /**
   * Método que verifica si el código ingresado existe en las bases de datos.
   * @param cod Código que se verificará.
   * @return boolean Indicará si existe el código.
   * @author Paola de León
  */

  public static boolean verificarEx( int cod ) {
    boolean Existe = false;
    // Buscar en base de trabajadores formales
    for (int i = 0; i < BaseTF.size(); i++ ){
      TrabajadorFormal entacuchado = BaseTF.get(i);
      int numerito = entacuchado.getCodigo();
      if (cod == numerito) {
      Existe = true; //Torna true si encuentra una similitud.
      }
    }
    // Buscar en base de trabajadores temporales
    for (int j = 0; j < BaseTT.size(); j++ ){
      TrabajadorInformal don = BaseTT.get(j);
      int numerazo = don.getCodigo();
      if(cod == numerazo) {
        Existe = true;//Torna true si encuentra una similitud.
      }
    }
    // Buscar en base de empleadores formales
    for (int k = 0; k < BaseEF.size(); k++ ){
      EmpleadorFormal Jefe = BaseEF.get(k);
      int Num = Jefe.getCodigo();
      if(cod == Num){
        Existe = true;//Torna true si encuentra una similitud.
      }
    }
    // Buscar en base de empleadores temporales
    for (int l = 0; l<BaseET.size(); l++ ){
      EmpleadorTemporal Senito = BaseET.get(l);
      int numerito = Senito.getCodigo();
      if(cod == numerito) {
        Existe = true;//Torna true si encuentra una similitud.
      }
    }
    
    return Existe;
  }
  

  /**
   * Método para agregar un perfil a la lista de trabajadores formales.
   * @param TF Trabajador formal por agregar.
   * @author Paola de Leon
   */
  public static void AddTrabajadorFormal( TrabajadorFormal TF ) {
    BaseTF.add(TF);
    Usuarios.add(TF);
  }

  /**
   * Método para agregar un perfil a la lista de trabajadores informales.
   * @param TI Trabajador informal por agregar.
   * @author Paola de Leon
   */
  public static void AddTrabajadorInformal( TrabajadorInformal TI ) {
    BaseTT.add(TI);
    Usuarios.add(TI);
  }

  /**
   * Método para agregar un perfil a la lista de trabajadores formales.
   * @param EF Empleador formal por agregar.
   * @author Andrés Osorio
   */

  public static void AddEmpleadorFormal( EmpleadorFormal EF ){
    BaseEF.add(EF);
    Usuarios.add(EF);
  }

  /**
   * Método para agregar un perfil a la lista de usuarios
   * @param User Usuario por agregar.
   * @author Paola De Léon
   */

  public static void AddUsuario( usuarioSamaj User ){
    Usuarios.add(User);
  }

  /**
   * Método para agregar un perfil a la lista de empleadores temporales
   * @param ET Empleador temporal por agregar.
   * @author Paola De León
  */
  public static void AddEmpleadorTemporal( EmpleadorTemporal ET ){
    BaseET.add(ET);
    Usuarios.add(ET);
  }
  /**
   * Método para comparar el codigo ingresado en parámetros con el de los del ArrayList
   * @param int Código ingresado por el usuario
   * @author Marco Jurado 
  */
  public boolean verificarCodigo(int numeroEntrada){
      boolean  unico = false; //No hay código similar dentro de la base.
      String num = Integer.toString(numeroEntrada);
      if(InfoUsuarios.size() == 0){ 
        unico = false; 
      }
      else{
        for(int i = 0; i < InfoUsuarios.size(); i++){ //Recorre filas 
          ArrayList<String> lista = InfoUsuarios.get(i);
          String codigoenbase = lista.get(0);
          if(num.equals(codigoenbase)) {
            unico = true;
          }
        }
      }

      return unico;
  } 

  /**
   * Método para devolver el ArrayList con los datos
   * @param int Código ingresado por el usuario
   * @author Marco Jurado 
  */
  public ArrayList<String> devolverDatos(int numeroEntrada){
    ArrayList<String> devolver = new ArrayList<String>(); //No hay código similar dentro de la base.
    String num = Integer.toString(numeroEntrada);
    for(int i = 0; i < InfoUsuarios.size(); i++){ //Recorre filas 
        ArrayList<String> lista = InfoUsuarios.get(i);
        String temp = lista.get(0); //Códigos 
        if(num.equals(temp)){
          devolver = lista;
        }
        else{ }
    }
    return devolver;
  } 
}