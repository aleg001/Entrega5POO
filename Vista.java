/*****************
Proyecto Semestral
Autor: Alejandro Gomez 20347, Marco Jurado 20308, Paola De Leon, Andres Osorio, Alejandra Guzman 20262
Fecha: 01/09/2020
Ultima modificacion: 11/09/2020
					
Driver program que desarrolla el simulador de 
Samaj-20
***************1**/

import java.util.Scanner;
import java.lang.Integer;
import java.util.ArrayList;
//import java.awt.Desktop; //Manejo de URL
//import java.net.URI; //Manejo de URL

public class Vista {


  public void Logo(){
    ArrayList<String> mensaje = new ArrayList<String>();

    mensaje.add( "                                             ____                             ,---._   \n");
    mensaje.add(  "  .--.--.          ,---,                  ,'  , `.      ,---,              .-- -.' `  \n");
    mensaje.add(  " /  /    '.       '  .' )              ,-+-,.' _ |     '  .' )             |    |   : \n");
    mensaje.add(  "|  :  /`. /      /  :    '.         ,-+-. ;   , ||   /  ;    '.'           :    ;   | \n");
    mensaje.add(  ";  |  |--`      :  :       )       ,--.'|'   |  ;|   :  :       )          :        | \n");
    mensaje.add(  "|  :  :_        :  |   /)   )     |   |  ,', |  ':   :  |   /;   )         |    :   : \n");
    mensaje.add(  " :      `.      |  :  ' ;.   :    |   | /  | |  ||   |    :  ' ;. :        :          \n");
    mensaje.add(  "  `----.   )    |  |  ;/  )   )   '   | :  | :  |,   |  |  ;/  :  :)       |    ;   | \n");
    mensaje.add(  "  __ )  )  |    '  :  | )  ) ,'   ;   . |  ; |--'    '  :  | )  ; ,'  ___ l          \n");
    mensaje.add(  " /  /`--'  /    |  |  '  '--'     |   : |  | ,       |  |  '  '--'   /    /`    J   : \n");
    mensaje.add(  "'--'.     /     |  :  :           |   : '  |/        |  :  :        /  ../  `..-    , \n");
    mensaje.add(  "  `--'---'      |  | ,'           ;   | |`-'         |  | ,'        (    ;         ;  \n");
    mensaje.add(  "                `--''             |   ;/             `--''           (    ;      ,'   \n");
    mensaje.add( "                                   '---'                               ---....--'     \n");
    mensaje.add( "                                       2 0 2 0                                        \n");
    
    int i;
    for(i = 0; i < mensaje.size(); i++){
        System.out.println(mensaje.get(i));
        try{
            Thread.sleep(150);
        }catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }
    }
    
  }
    
  // Propiedades
  Scanner scan = new Scanner(System.in);
  //Desktop d = new Desktop.getDesktop();
  String opc;

  /**
   * Metodo para que el usuario indique si tiene o no una cuenta
   * @return
   */
  
  public int ExisteUsuario () {
    int opc = 0;
    String opcS;
    boolean Valide = true;
    while ( Valide == true ) {
      
      System.out.println("\n\nYa cuenta con un usuario?" +
      "\n1) Si" +
      "\n2) No" );
      System.out.println ( "Ingrese el numero de opcion: " );
      opcS = scan.nextLine();
      opc = ValideNum( opcS );
      if ( opc != -1 ) {
        if(opc == 1){
          Valide = false;
        }
        else if(opc == 2){
          Valide = false;
        }  
        else { 
          System.out.println("Por favor ingrese una opcion valida. \nIntente Nuevamente");
        }
      }
    }
    
    return opc;
  }
    /**Metodo para mostrar el menu general
    * @param n/a
    * @return numero de opciones
    * @author Alejandra Guzman
    */

    public int MenuGeneral(){
      String opcS;
      int opc = 0;
      boolean Valide = true;
      System.out.println(
        "\n\nMENU PRINCIPAL:\n"+
        "1) Destinar uso de mi perfil\n" +
        "2) Crear trabajos temporales\n"+
        "3) Buscar trabajos temporales\n"+
        "4) Buscar trabajadores para mi empresa\n"+
        "5) Consejos\n"+
        "6) Salir\n"
      );
      while(Valide == true){
        System.out.println("Ingrese numero de opcion: ");
        opcS = scan.nextLine();
        opc = ValideNum( opcS );
        if( opc != -1 ){
          Valide = false;
 
        }
        else{}
      }
      return opc;

    }


  /**
  * Método para mostrar el menu para generar perfil y seleccionar una opción.
   * @param n/a
   * @return Numero de opción del menu ingresado por el usuario.
   * @author Alejandro y Paola
  */
  public int SubMenu () {
    int opc = 1;
    String opcS;
    boolean Valide = true;

    System.out.println( 
    "\n\n SUBMENU:"+
    "Crear perfil\n" +
    "1) Crear perfil para trabajo bajo contrato\n" +
    "2) Crear perfil para un trabajo temporal\n" +
    "3) Crear perfil para un empleador empresarial\n" +
    "4) Crear perfil para un empleador sin contrato\n"+
    "5) Regresar al menu principal\n"
    );
      
    while ( Valide == true ) {
      System.out.println ( "Ingrese el numero de opcion: " );
      opcS = scan.nextLine ();
      opc = ValideNum( opcS );
      if ( opc != -1 ) {
          Valide = false;
      }
      else { }
    }
    
    return opc;
  } 
  //

  /**
   * Método para indicar que no hay trabajos publicados aún.
   * @author Paola de Leon
  **/
  public void NullTrabajosTemp() {
    System.out.println("Aun no hay trabajos temporales publicados...\n");
  }

  
  /**
   * Método para validar cualquier número ingresado.
   * @param Num String de un número para verificar lo ingresado.
   * @return Número convertido en int.
   * @author Paola de Leon
  **/  
  public int ValideNum ( String Num ) {
    int newNum = -1;
    try {
       newNum = Integer.parseInt(Num);
    }
    catch ( NumberFormatException e )
    {
       System.out.println( "\nError! Ingrese un numero valido por favor" );
    }
    
    return newNum;
  }

  /**
  * Metodo para mostrar mensaje que ha ocurrido un error.
  * @author Paola de Leon
  */
  public void ErrorMns ( ) {
    System.out.println ( "Error! Vuelva a intentarlo..." );
  }

  /**
  *Mensaje de Bienvenida a Programa
  * @author Alejandro Gomez
   */
   public void MensajeBienvenida(){
     System.out.println( "\n \n \nBienvenido a Samaj-20 " +
     "\nEmpleo facil, rapido y seguro");
   }

   //**Metodo para ingresar al 
   //sub menu del prototipo */
   //@author Alejandra Guzman

   public int submenu2(){
     int opc = 2;
     String opcS = "";
     boolean valide = true; 

     System.out.println(
       "\n\n SUBMENU:\n" +
       "Opciones:\n"+
       "\n\nBuscar Trabajo\n \n"+
       "1) Buscar trabajos temporales\n"+
       "2) Regresar al menu principal\n"
     );
     while ( valide == true ) {
      System.out.println ( "Ingrese el numero de opcion: " );
      opcS = scan.nextLine ();
      opc = ValideNum( opcS );
      if ( opc != -1 ) {
          valide = false;
      }
      else { }
    }
    
    return opc;
  } 


/** Metodo para ingresar
 * al submenu 3
 * @author Alejandra Guzman
 */
    public int submenu3 (){
      int opc = 3;
      String opcS = "";
      boolean Valide = true;

      System.out.println(
        "\n\nSUBMENU\n"+
        "Opciones:\n"+
        "1) Publicar trabajo bajo contrato.\n"+
        "2) Publicar trabajo temporal.\n"
      );

      while ( Valide == true ) {
        System.out.println ( "Ingrese el numero de opcion: " );
        opcS = scan.nextLine ();
        opc = ValideNum( opcS );
        if ( opc != -1 ) {
            Valide = false;
        }
        else { }
      }
      
      return opc;
    } 
  /** Metodo para ingresar submenu 4
   * el cual accede a Manejo de crisis
   * @author Alejandra Guzman 
   */
  public int submenu4(){
    int opc = 4;
    String opcS = "";
    boolean Valide = true;

    System.out.println(
      "\n\n SUBMENU:\n"+
      "Opciones:\n"+
      "1) Manejo de crisis\n"+
      "2) Restructuracion de negocios\n"+
      "3) Linea anti suicidio\n"+
      "4) Regresar al menu principal"
    );
    while ( Valide == true ) {
      System.out.println ( "Ingrese el numero de opcion: " );
      opcS = scan.nextLine ();
      opc = ValideNum( opcS );
      if ( opc != -1 ) {
          Valide = false;
      }
      else { }
    }
    
    return opc;
  } 

  
   /** Metodo para preguntar el directorio
    * en el cual se almacenara el
    archivo csv de Samaj 2020 
    @author Alejandro Gomez */
    
    public String DirectorioCSV(){
      System.out.println("Ingrese su directorio completo para almacenar la base de datos: ");
      String csvPath = scan.nextLine();
      return csvPath;
    }


  
/* ------------------------------------------ S U B M E N U # 1 ------------------------------------------

*   Funcion:
*     Crear un nuevo Perfil para TrabajadorFormal
*     Metodos a utilizar descritos a continuacion. 
      Autores: Alejandro Gomez y Andres Osorio  */
  

  /**
   * Metodo para obtener el nombre y su respectivo mensaje al usuario.
   * @param N/A.
   * @return String.
   * @author Andrés y Alejandro
  */  
  
   public String ingresarNombre(){
     System.out.println("Ingrese su nombre: ");
     String nombre = scan.nextLine();
     return nombre;
   }

  /**
   * Metodo para obtener el apellido y su respectivo mensaje al usuario.
   * @param N/A.
   * @return String.
   * @author Andrésy Alejandro
  */   

   public String ingresarApellido(){
     System.out.println("\nIngrese su apellido: ");
     String apellido = scan.nextLine();
     return apellido;
   }

  /**
   * Metodo para obtener la edad y su respectivo mensaje al usuario.
   * @param N/A.
   * @return int.
   * @author Andrés
  */  

   public int ingresarEdad(){
     int valor = 0 ;
     boolean continuar = false;
     while(continuar==false){
       System.out.println("\nIngrese su edad: ");
       opc = scan.nextLine();
       int edad = ValideNum(opc);
       if(edad != -1){
         valor = edad;
         continuar = true;
       }else{
         // No hace falta agregar un mensaje de invalidacion, puesto que el metodo ValideNum ya lo tiene.
          continuar = false;
       }
     }

     return valor;
   }

  /**
   * Metodo para obtener el correo y su respectivo mensaje al usuario.
   * @param N/A.
   * @return int.
   * @author Andrés
  */  

   public String ingresarCorreo(){
     String valor = " ";
     boolean continuar = false;
     while(continuar==false){
       System.out.println("\nIngrese su correo electronico: ");
       opc = scan.nextLine();
       if(opc.contains("@")){
         valor = opc;
         continuar = true;
       }else{
         MensajeErrorCorreo();
         continuar = false;
       }
     }

     return valor;
   }

  /**
   * Metodo para obtener la educacion y su respectivo mensaje al usuario.
   * @param N/A.
   * @return int.
   * @author Andrés y Alejandra
  */  

    public int ingresarEducacion(){
      int valor = 0;
      boolean continuar = false;
      while(continuar==false){
        System.out.println("\nIngrese su nivel de educacion");
        System.out.println("1. Primaria \n2. Secundaria \n3. Universitaria \n4. Posgrado");
        opc = scan.nextLine();
        int opcion = ValideNum(opc);
        if(opcion==1 || opcion==2 || opcion==3 || opcion==4){
          valor = opcion;
          continuar = true;
        } else{
          // No hace falta agregar un mensaje de invalidación, puesto que el método ValideNum ya lo tiene.
          continuar = false;
        }
      }
      return valor;
    }


 /**
   * Método para obtener la experiencia laboral y su respectivo mensaje al usuario.
   * @param N/A.
   * @return boolean.
   * @author Andrés y Alejandro
  */ 
    public boolean ingresarExperienciaLaboral(){
      boolean expLab = false;
      boolean continuar = false;
      while(continuar==false){
        System.out.println("\nExperiencia laboral (SI/NO): ");
        opc = scan.nextLine();
        opc = opc.toLowerCase();
        if(opc.equals("si")){
          expLab = true;
          continuar = true;
        }else if(opc.equals("no")){
          expLab = false;
          continuar = true;
        }else{
          ErrorMns();
          continuar = false;
        }
      }
      return expLab;
    }

    //Termina revision de polimorfismo (borrar esto luego)

  /**
   * Método para obtener el idioma y respectivo mensaje al usuario.
   * @param N/A.
   * @return int.
   * @author Andrés
  */ 

    public int ingresarIdioma(){
      int valor = 0;
      boolean continuar = false;
      while(continuar==false){
        System.out.println("\nIngrese el idioma (1) de su dominio que desea mostrar en su perfil.\n");
        System.out.println(" 1. Espanol \n 2. Ingles \n 3. Aleman \n 4. Frances \n 5. Mandarin \n 6. Portugues \n 7. Otros\n");
        opc = scan.nextLine();
        int opcion = ValideNum(opc);
        if(opcion == 1 || opcion == 2 || opcion == 3 || opcion == 4 || opcion == 5 || opcion == 6 || opcion ==7){
          valor = opcion;
          continuar = true;
        }else{ 
          // No hace falta agregar un mensaje de invalidación, puesto que el método ValideNum ya lo tiene.
          continuar = false;
        }
      }

      return valor;
    }

  /**
   * Método para obtener el transporte y su respectivo mensaje al usuario.
   * @param N/A.
   * @return boolean.
   * @author Andrés
  */ 

    public boolean ingresarTransporte(){
      boolean valor = false;
      boolean continuar = false;
      while(continuar==false){
        System.out.println("\nTransporte (SI/NO)");
        opc = scan.nextLine();
        opc = opc.toLowerCase();
        if(opc.equals("si")){
          valor = true;
          continuar = true;
        }else if(opc.equals("no")){
          valor = false;
          continuar = true;
        }else{
          ErrorMns();
          continuar = false;
        }
      }
      return valor;
    }

     /**
   * Método para obtener el telefono y su respectivo mensaje.
   * @param N/A.
   * @return int.
   * @author Andrés y Alejandro
  */ 

    public int ingresarTelefono(){
      int valor = 0;
      boolean continuar = false;
      while(continuar==false){
        System.out.println("\nIngrese su numero de telefono: ");
        String opc = scan.nextLine();
        int tel = ValideNum(opc);
        if(tel != -1){
          valor = tel;
          continuar = true;
        } else {
          // No hace falta agregar un mensaje de invalidación, puesto que el método ValideNum ya lo tiene.
          continuar = false;
        }
      }

      return valor;
    }

  

   /**
   * Método para obtener la experiencia de HomeOffice y mostrar su respectivo mensaje.
   * @param N/A.
   * @return boolean.
   * @author Andrés
  */ 
  public boolean ingresarHomeOffice(){
    boolean valor = false ;
    boolean continuar = false;
    while(continuar==false){
      System.out.println("\nCuenta con herramientas de Homeoffice? (SI/NO): ");
      opc = scan.nextLine();
      opc = opc.toLowerCase();
      if(opc.equals("si")){
        valor = true;
        continuar = true;
      } else if(opc.equals("no")){
        valor = false;
        continuar = true;
      } else{
        ErrorMns();
        continuar = false;
      }
    }

    return valor;
  }

  /**
   * Método para obtener el conocimiento y mostrar su respectivo mensaje.
   * @param N/A.
   * @return boolean.
   * @author Andrés
  */ 

  public String ingresarConocimiento(){
    String valor = "";
    System.out.println("\nIngrese el area de cocimiento de interes a laborar ");
    System.out.println("(Ejemplos: Jardineria, educacion, construccion, carpinteria) :");
    opc = scan.nextLine();
    valor = opc;
    return valor;
  }

  /**
   * Método para obtener la categoria del trabajo y mostrar su respectivo mensaje.
   * @param N/A.
   * @return String Categoria del trabajo.
   * @author Andrés
  */ 

  public String ingresarCategoriaTrabajo(){
    System.out.println( "\n- Categoria (Ingrese solamente una palabra clave) : " );
    String valor = "";
    opc = scan.nextLine();
    valor = opc;

    return valor;
  }


  /**
   * Método para imprimir todas las categorias de trabajo.
   * @param N/A.
   * @return int del trabajo temporal elegido por el usuario (Buscar ya con get directamente)
   * @author Paola de León
  */ 

    public int enlistarCategoriasTrabajo( Documentos docs ) { 
      int cont = 0; 
      int contador;
      boolean continuar = false;
      System.out.println("\n\nBUSCAR TRABAJO");
      System.out.println("A continuacion se le presentaran la informacion de los trabajos: ");
      ArrayList<TrabajoTemp> TrabajosTemporales = Documentos.getTrabajoTemp();
      int size = TrabajosTemporales.size();
      if (TrabajosTemporales.size() == 0 ) {
        NullTrabajosTemp();
      }
      else {
        for ( int i = 0 ; i<TrabajosTemporales.size()  ; i++ ) {
          TrabajoTemp Tempo = TrabajosTemporales.get(i);
          contador = i+1;
          System.out.println(contador + ". " + Tempo.toString() + "\n");
        }
        while ( continuar== false ) {
          System.out.println("\n Ingrese el trabajo al que desea aplicar:  ");
          String opcS = scan.nextLine();
          cont = ValideNum(opcS); 
          if ( cont != -1 ) {
            cont = cont-1;
            continuar=true;
          }
        }
      }

        return cont;
    }

  /**
   * Método para imprimir todas las categorias de trabajo.
   * @param N/A.
   * @return int del trabajo temporal elegido por el usuario (Buscar ya con get directamente)
   * @author Paola de León
  */ 

  public int enlistarTrabajadoresFormales( Documentos docs ) { 
    int cont = 0; 
    int contador;
    boolean continuar = false;

    System.out.println("\n\nBUSCAR TRABAJORES BAJO CONTRATO:");
    System.out.println("Desea buscar por nivel de educacion?");
    System.out.println("    1.  Si\n    2.  No");
    String ingresousu = scan.nextLine();
    int ingresoniveledu = ValideNum(ingresousu);
    ArrayList<TrabajadorFormal> TrabajadoresFormales = Documentos.getTF();
    int size = TrabajadoresFormales.size();
    if (TrabajadoresFormales.size() == 0 ) {
      NullTrabajosTemp();
    }
    else {
      
      if( ingresoniveledu == 1) {
        //Si quiere por nivel
        System.out.println("\n\nBUSCAR TRABAJORES POR NIVEL DE EDUCACION:");
        System.out.println("    1.  Primaria\n    2.  Secundaria\n    3.  Universitaria\n    4.  Posgrados");
        //Ingresos de usuario
        String ingresEduS = scan.nextLine();
        int ingresoEdu = ValideNum(ingresEduS);  

        if( ingresoEdu == 1 ){
          System.out.println(" -------E S T U D I O S   D E   N I V E L   P R I M A R I O -------\n");
          for ( int i = 0 ; i< size ; i++ ) {
            //Recorre ArrayList de Trabajadores
            TrabajadorFormal Tempo = TrabajadoresFormales.get(i);
            if (Tempo.getNivelEducacion()==1 ) {
              System.out.println(Tempo.toString());
            }
          }
        } else if ( ingresoEdu == 2 ) {
          System.out.println(" -------E S T U D I O S   D E   N I V E L   S E C U N D A R I O -------\n");
          for ( int i = 0 ; i< size ; i++ ) {
            //Recorre ArrayList de Trabajadores
            TrabajadorFormal Tempo = TrabajadoresFormales.get(i);
            if (Tempo.getNivelEducacion()==2 ) {
              System.out.println(Tempo.toString());
            }
          }
        } else if(ingresoEdu == 3){
          System.out.println(" -------E S T U D I O S   D E   N I V E L   U N I V E R S I T A R I O S -------\n");
          //Si quiere por nivel
          System.out.println("\n\nBUSCAR TRABAJORES POR TITULO UNIVERSITARIO:");
          System.out.println("    1.  Ingenieria\n    2.  Marketing y Negocios\n    3.  Ciencias politicas\n    4.  Analitica\n    5.  Arquitectura\n    6.  Medicina\n    7.  Otros");
          //Ingresos de usuario
          String ingresUS = scan.nextLine();
          int ingresoU = ValideNum(ingresUS);  

          if(ingresoU == 1){
            System.out.println("\n-------I N G E N I E R O S -------\n");
            //Inge
            for ( int i = 0 ; i< size ; i++ ) {
              //Recorre ArrayList de Trabajadores
              TrabajadorFormal Tempo = TrabajadoresFormales.get(i);
              int Expertise = Tempo.getNivelExpertise();
              if (Tempo.getNivelEducacion()==3 && (Expertise>=1 && Expertise<=7)) {
                System.out.println(Tempo.toString());
              }
            }
          }else if(ingresoU == 2){
            System.out.println("\n-------M A R K E T I N G  Y    N E G O C I O S-------\n");
            //Marketing
            for ( int i = 0 ; i< size ; i++ ) {
              //Recorre ArrayList de Trabajadores
              TrabajadorFormal Tempo = TrabajadoresFormales.get(i);
              int Expertise = Tempo.getNivelExpertise();
              if (Tempo.getNivelEducacion()==3 && (Expertise>=8 && Expertise<=13)) {
                System.out.println(Tempo.toString());
              }
            }
          }else if(ingresoU == 3){
            System.out.println("\n-------C I E N C I A S    P O L I T I C A S-------\n");
            //Ciencias Politics
            for ( int i = 0 ; i< size ; i++ ) {
              //Recorre ArrayList de Trabajadores
              TrabajadorFormal Tempo = TrabajadoresFormales.get(i);
              int Expertise = Tempo.getNivelExpertise();
              if (Tempo.getNivelEducacion()==3 && (Expertise>=14 && Expertise<=17)) {
                System.out.println(Tempo.toString());
              }
            }
          }else if(ingresoU == 4){
            System.out.println("\n-------A N A L I T I C A-------\n");
            //Analitica
            for ( int i = 0 ; i< size ; i++ ) {
              //Recorre ArrayList de Trabajadores
              TrabajadorFormal Tempo = TrabajadoresFormales.get(i);
              int Expertise = Tempo.getNivelExpertise();
              if (Tempo.getNivelEducacion()==3 && (Expertise==18 || Expertise==19)) {
                System.out.println(Tempo.toString());
              }
            }
          }else if(ingresoU == 5){
            System.out.println("\n-------A R Q U I T E C T U R A -------\n");
            //Arqui
            for ( int i = 0 ; i< size ; i++ ) {
              //Recorre ArrayList de Trabajadores
              TrabajadorFormal Tempo = TrabajadoresFormales.get(i);
              int Expertise = Tempo.getNivelExpertise();
              if (Tempo.getNivelEducacion()==3 && Expertise==20) {
                System.out.println(Tempo.toString());
              }
            }
          }else if(ingresoU == 6){
            System.out.println("\n-------M E D I C O S-------\n");
            //Medicina
            for ( int i = 0 ; i< size ; i++ ) {
              //Recorre ArrayList de Trabajadores
              TrabajadorFormal Tempo = TrabajadoresFormales.get(i);
              int Expertise = Tempo.getNivelExpertise();
              if (Tempo.getNivelEducacion()==3 && Expertise==21) {
                System.out.println(Tempo.toString());
              }
            }
          }else if(ingresoU == 7){
            System.out.println("\n-------O T R O S-------\n");
            //Otros
            for ( int i = 0 ; i< size ; i++ ) {
              //Recorre ArrayList de Trabajadores
              TrabajadorFormal Tempo = TrabajadoresFormales.get(i);
              int Expertise = Tempo.getNivelExpertise();
              if (Tempo.getNivelEducacion()==3 && Expertise==22) {
                System.out.println(Tempo.toString());
              }
            }
          }
          
        } else if ( ingresoEdu == 4 ) {
          System.out.println(" -------E S T U D I O S   D E   N I V E L   P O S T G R A D O -------\n");
          for ( int i = 0 ; i< size ; i++ ) {
            //Recorre ArrayList de Trabajadores
            TrabajadorFormal Tempo = TrabajadoresFormales.get(i);
            if (Tempo.getNivelEducacion()==4 ) {
              System.out.println(Tempo.toString());
            }
          }
        }
        
      } else if(ingresoniveledu == 2){
        //No quiere por nivel de educ
        for ( int i = 0 ; i< size ; i++ ) {
          //Recorre ArrayList de Trabajadores
          TrabajadorFormal Tempo = TrabajadoresFormales.get(i);
          System.out.println("\n  "+ (i+1) + ". " + Tempo.toString() + "\n\n");
        }
      }
    }
      return cont;
  } 
  
  /**
   * Método para obtener el nivel de expertise
   * @param N/A.
   * @return int.
   * @author Alejandra y Marco 
  */ 

  public int ingresarExpertise(){

    /* El codigo que se usuara es: 
      1-7 ingenierias
      8-13 marketing y negocios
      14-16 ciencias politicas
      17-19 Analitca
      20 Arqui
      21 Medicina
      22 otros */

    int valor = 0;
    boolean continuar = false;
    while(continuar==false){
      System.out.println("\nIngrese el titulo que obtuvo en sus estudios universitarios.\n");
      System.out.println(" 1. Ingenieria \n 2. Marketing y negocios \n 3. Ciencias Politicas \n 4. Analitica \n 5. Arquitectura \n 6. Medicina \n 7. Otros\n");
      opc = scan.nextLine();
      int opcion = ValideNum(opc);
      if(opcion == 1){
        int OpcE1 = 0;
        //Ingenieria 
        System.out.println("\nIngrese la especializacion del area de ingenieria que obtuvo:\n");
        System.out.println(" 1. Ingenieria Industrial \n 2. Ingenieria Mecanica \n 3. Ingenieria Mecatronica \n 4. Ingenieria Quimica \n 5. Ingenieria Civil \n 6. Ingenieria en Sistemas \n 7. Ingenieria en alimentos\n");
        String opc1 = scan.nextLine();
        OpcE1 = ValideNum(opc1);

        //Verificar que ingreso.
        if(OpcE1 == 1){
          valor = 1;
          continuar = true;
        }
        else if(OpcE1 == 2){
          valor = 2;
          continuar = true;
        }
        else if(OpcE1 == 3){
          valor = 3;
          continuar = true;
        }
        else if(OpcE1 == 4){
          valor = 4;
          continuar = true;
        }
        else if(OpcE1 == 5){
          valor = 5;
          continuar = true;
        }
        else if(OpcE1 == 6){
          valor = 6;
          continuar = true;
        }
        else if(OpcE1 == 7){
          valor = 7;
          continuar = true;
        }
      
      
      }else if(opcion == 2){
        int OpcE2 = 0;
        //Marketing y negocios
        System.out.println("\nIngrese la especializacion del area de Marketing y negocios que obtuvo:\n");
        System.out.println(" 1. Mercadologo \n 2. Gestor de comunidades virtuales \n 3. Comercio internacional \n 4. Promotores comerciales \n 5. Especialista en SEO y Desarollo Web \n 6. Otros\n");

        String opc2 = scan.nextLine();
        OpcE2 = ValideNum(opc2);

        if(OpcE2 == 1){
          valor = 8;
          continuar = true;
        }
        else if(OpcE2 == 2){
          valor = 9;
          continuar = true;
        }
        else if(OpcE2 == 3){
          valor = 10;
          continuar = true;
        }
        else if(OpcE2 == 4){
          valor = 11;
          continuar = true;
        }
        else if(OpcE2 == 5){
          valor = 12;
          continuar = true;
        }
        else if(OpcE2 == 6){
          valor = 13;
          continuar = true;
        }

      } else if(opcion == 3){
        //Ciencias politicas
        int OpcE3 = 0;
        System.out.println("\nIngrese la especializacion en el area de ciencias politicas que obtuvo.\n");
        System.out.println(" 1.Abogacia rama civil \n 2. Abogacia con especializacion en penal \n 3. Abogacia en el area constitucional \n 4. Abogacia en el  area Comercial");
        String opc3 = scan.nextLine();
        OpcE3 = ValideNum(opc3);
         if(OpcE3 == 1){
          valor = 14;
          continuar = true;
        }
        else if(OpcE3 == 2){
          valor = 15;
          continuar = true;
        }
        else if(OpcE3 == 3){
          valor = 16;
          continuar = true;
        }
        else if(OpcE3== 4){
          valor= 17;
          continuar = true;
        }
        
      } else if(opcion == 4){
        // analitica
        int OpcE4 = 0;
        System.out.println("\nIngrese la especializacion en el area de Analitica que obtuvo.\n");
        System.out.println(" 1. Analitica de internet \n 2. Data Science");
        String opc4 = scan.nextLine();
        OpcE4 = ValideNum(opc4);
         if(OpcE4 == 1){
          valor = 18;
          continuar = true;
        }
        else if(OpcE4 == 2){
          valor = 19;
          continuar = true;
        }
      
        
      }else if(opcion == 5){
        //arquitectura
        valor = 20;
        continuar = true;
        
      }else if(opcion == 6){
        //Medicina
        valor = 21;
        continuar = true;
        
      }else if(opcion == 7){
        //Otros
        valor = 22;
        continuar = true;
      } else { 
        // No hace falta agregar un mensaje de invalidación, puesto que el método ValideNum ya lo tiene.
        continuar = false;
      }
    }

    return valor;
  }

  
  /**
   * Método para ingresar la opción del listado de las categorias de trabajo.
   * @param N/A.
   * @return boolean.
   * @author Andres y Alejandro
   
    private void ingresarOpcionTrabajo(ArrayList<String> categoriasTrabajo) {
      int valor = 0;
      boolean continuar = false;
      while(continuar==false) {
        opc = scan.next();
        scan.next();
        int opcion = ValideNum(opc);
        if (opcion != -1 && (categoriasTrabajo.size() < opcion || opcion > 0) ) {
          valor = opcion;
          continuar = true;
        } else{
          // No hace falta agregar un mensaje de invalidación, puesto que el método ValideNum ya lo tiene.
          continuar = false;
        }
      }

      enlistarTrabajos(valor, categoriasTrabajo);
    }

  /**
   * Método para enlistar los trabajos en los que el usuario estaba interesado.
   * @param opcion(valor) y enlistar.
   * @return boolean.
   * @author Andrés
   
    private void enlistarTrabajos(int valor, ArrayList<String> categoriasTrabajo){
      String palabraClaveSeleccionada =  categoriasTrabajo.get(valor);
      System.out.println("Los trabajos de su interes son los siguientes: ");
        for(int i = 0 ; i<(Documentos.getET()).size() ; i++){
          for(int h = 0 ; h<((Documentos.getET()).get(i)).getTrabajoTemporal().size() ; h++){
            if(((Documentos.getET()).get(i)).getTrabajoTemporal().get(h).getCategoriaTrabajo().equals(palabraClaveSeleccionada)){
              System.out.println("- "+((Documentos.getET()).get(i)).getTrabajoTemporal().get(h).getCategoriaTrabajo().toString());
            }
          }
        }
    }*/

/* ------------------------------------------ C R E A R   U S U A R I O  ------------------------------------------

*  Funcion:
*    Crear un nuevo Usuario.
*    Metodos a utilizar descritos a continuacion. 
*  Autores: Marco Jurado  */

  /**
   * Método para preguntar a usuario si tiene un perfil creado anteriormente en Samaj 2020.
   * @param n/a.
   * @return int.
   * @author Marco Jurado
  */

    public int MensajeTieneUsuario(){
      System.out.println("\n Posee codigo ID en Samaj 2020? \nIngrese Si / No segun su respuesta.");
      int devolucion = 0;
      String ingreso = "";
      boolean correct = false;
      while(correct == false){
        ingreso = scan.nextLine();
        ingreso = ingreso.toLowerCase();
        if (ingreso == "si" || ingreso =="si" ){
          devolucion = 1;
          correct = true;
        } else if(ingreso == "no"){
          devolucion = -1;
          correct = true;
        } else{
          System.out.println("Por favor ingrese unicamente si o no. Por favor intente nuevamente.");
        }
      }
      return devolucion;
    }

  
  /**
   * Método para ingresar el código del usuario.
   * @param docs. Esta es la instancia de Documentos en controlador.
   * @return int.
   * @author Marco Jurado
  */
  public int IngresoCodigo(Documentos docs){
    int numeritoCOD = 0;
    String num = "";
    boolean Valide = false;
    while ( Valide == false ) {
      System.out.println ( "\nIngrese el codigo que desea para ingresar a su perfil: " );
      num = scan.nextLine();
      numeritoCOD = ValideNum( num );
      if ( numeritoCOD != -1 ) {
        boolean ExisteCod = docs.verificarCodigo(numeritoCOD);//Método para verificar que sea único.
        if (ExisteCod == false){ //Codigo no existe
          System.out.println("El codigo NO existe en la base de datos. \n");
          Valide = true;
        }
        else{
          System.out.println("El codigo ya existe en la base de datos. \n");
          Valide = true;
        }
      }
    }
    return numeritoCOD;
  }

  public void MensajeErrorMenu(){
    System.out.println("Ha ingresado un numero invalido. Por favor intente nuevamente");
  }
  public void MensajeDespedida(){
    System.out.println("\n\n\nUsted ha salido del programa. \nCreditos: Alejandro Gomez, Alejandra Guzman, Paola de Leon Molina, Marco Jurado, Andres Osorio. ");
    System.out.println("Esperamos que vuelva pronto!");
  }
  public void MensajeRegresoMenuPrincipal(){
    System.out.println("Regresando a menu principal... \n \n \n \n");
  }
  public void mostrarinfoaUsuario(usuarioSamaj x){
    System.out.println("Tu informacion es:  ");
    System.out.println(x);
  }
   

//--------------------------P U B L I C A R   T R A B A J O   T E M P O R A L --------------------

    public void encabezadoPublicarTrabajo(){
      System.out.println( "PUBLICAR TRABAJO TEMPORAL");
      System.out.println( "Ingrese los siguientes datos: " );
    }
 

    public String ingresarDescripcion(){
      System.out.println("\nIngrese descripcion: ");
      opc = scan.nextLine();
      return opc;
    }

    public int ingresarSueldo(){
      int valor = 0 ;
      boolean continuar = false;
      while(continuar==false){
        System.out.println("\nIngrese sueldo: ");
        opc = scan.nextLine();
        int sueldo = ValideNum(opc);
        if(sueldo != -1){
          valor = sueldo;
          continuar = true;
        } else{
          // No hace falta agregar un mensaje de invalidación, puesto que el método ValideNum ya lo tiene.
          continuar = false;
        }
      }

      return valor;
    }

    public void imprimirTrabajo(TrabajoTemp xx){
      ArrayList<String> aplicantes = xx.getaplicantesDatos();
      System.out.println("\n\nSu trabajo: \n" + xx + "\n");
      int num = 1;
      if(aplicantes != null){
        if(aplicantes.size() != 0){
          for(int i = 0; i < aplicantes.size(); i++) {
          //Recorre el listado de aplicantes
          if(num == 2) {
            num = 1;
            String data = aplicantes.get(i);
            System.out.println("      -" + data + "\n\n");
          } else if(num == 1) {
            num++;
            String data = aplicantes.get(i);
            System.out.println("El trabajador que ha aplicado es: \n" + "      -" + data);
            }
          } 
        } 
      }  
    }

//-------------------------C O N E X I O N ----------------------------------------------

public void conexionBaseDeDatos(){
  System.out.println("ERROR: No se puede conectar con la base de datos.");
}

//------------------------- Opcion de Consejos ------------------------------------------
/**
 * Método que muestra opciones de consejos 
 * y abre paginas web.
 * @param N/A
 * @return N/A
 * @author Alejandro Gómez
*/
public int ConsejosMenu(){
  boolean Validar = true;
  int opcConsejos = 0;
  System.out.println("\nAPARTADO DE CONSEJOS:\n");
  System.out.println(" 1. Consejos Psicologicos \n 2. Consejos Financieros \n 3. Regresar a menu \n Ingrese el numero de opcion: ");
  while (Validar==true) {
    String cons = scan.nextLine();
    opcConsejos = ValideNum(cons);
    if (opcConsejos != -1) {
      Validar = false;
    }
    else{ }
  }
  
  return opcConsejos;
}
/* @author Alejandro Gomez */

  public int SubConsejosPsic(){
    boolean Validar = true;
    int opcConsejos = 0;
    System.out.println("\nConsejos Psicologicos:\n");
    System.out.println(" 1. Manejo de crisis \n 2. Linea antisuicidio \n 3. Contacto de ayuda \n 4. Regresar a menu \n Ingrese el numero de opcion: ");
    while (Validar==true) {
      String cons = scan.nextLine();
      opcConsejos = ValideNum(cons);
      if (opcConsejos != -1) {
        Validar = false;
      }
      else{ }
    }
    
    return opcConsejos;
  }
/* @author Alejandro Gomez */

public int ConsejosSubEcon(){
  boolean Validar = true;
  int opcConsejos = 0;
  System.out.println("\nConsejos Financieros:\n");
  System.out.println(" 1. Presupuesto \n 2. Plan de Emergencia  \n 3. Prioridades financieras  \n 4. Regresar a menu \n Ingrese el numero de opcion: ");
  while (Validar==true) {
    String cons = scan.nextLine();
    opcConsejos = ValideNum(cons);
    if (opcConsejos != -1) {
      Validar = false;
    }
    else{ }
  }
  
  return opcConsejos;
}
/* @author Alejandro Gomez */

  public void ConsejosCrisis(){ 
      //Opcion 1: Manejo de Crisis
      System.out.println("\n\n1. Manejo de Crisis\n");
      System.out.println("Mantenga la calma en todo momento");
      System.out.println("Todo mejorara, el sol vuelve a salir.");
      System.out.println("Los siguientes links le seran de mucha ayuda:");
      System.out.println("https://www.elempleo.com/co/noticias/consejos-profesionales/claves-para-el-manejo-de-crisis-en-las-organizaciones-5608");
      System.out.println("https://emprendedoresynegocios.com/manejo-de-crisis-empresarial/");
    }
/* @author Alejandro Gomez */
public void ConsejoFinanciero1(){ 
  //Opcion 1: Manejo de Crisis
  System.out.println("\n\n1. Haga un presupuesto\n");
  System.out.println("Debe priorizar las necesidades de su familia");
  System.out.println("Registre sus gastos usuales y lleve conteo del mismo.");

}
/* @author Alejandro Gomez */
public void ConsejoFinanciero2(){ 
  //Opcion 1: Manejo de Crisis
  System.out.println("\n\n2. Desarolle un plan de emergencia\n");
  System.out.println("Prevenga las dificultades financieras que su familia puede enfrentar");
  System.out.println("Concentrese en lo importante y mantenga una lista");
  System.out.println("Recuerde que es mejor prevenir que lamentar.");
}
/* @author Alejandro Gomez */
public void ConsejoFinanciero3(){ 
  //Opcion 1: Manejo de Crisis
  System.out.println("\n\n3. Prioridades financieras\n");
  System.out.println("Reconozca aquellas compras no necesarias y evitelas por un tiempo");
  System.out.println("Aproveche las ofertas y saquele provecho a lo que tenga");
}
public void ConsejoInfoFinan(){
  System.out.println("\nPara mas informacion, revise los siguientes links\n");
  System.out.println("https://qualitasoflife.org/wp-content/uploads/2020/03/Tips-Financieros-en-Tiempos-de-COVID-19-1.pdf");
  System.out.println("https://www.bbva.com/es/pe/cuatro-consejos-para-ahorrar-en-tiempos-de-coronavirus/");
}
/* @author Alejandro Gomez */
 public void ConsejosRestruc(){ 
      //Opcion 2: Reestructuracion de negocios
      System.out.println("\n\n2. Reestructuracion de negocios");
      System.out.println("Los siguientes links le seran de mucha ayuda:");
      System.out.println("https://www.emprendepyme.net/como-reestructurar-una-empresa-de-forma-exitosa.html");
      System.out.println("https://www.emprendepyme.net/reestructuracion-empresarial");
    }
/* @author Alejandro Gomez */
  public void ConsejosAntiS(){ 
      //Opcion 3: Linea antisuicidio
      System.out.println("\n\n3. Linea antisuicidio\n");
      System.out.println("En caso necesite ayuda, recuerde que siempre hay alguien dispuesto a escucharlo");
      System.out.println("Linea de apoyo para Guatemala: 2232-6269 o 2238-3739");
      System.out.println("Direccion de linea de apoyo:  12 calle A 0-27, zona 1");
    }
/* @author Alejandro Gomez */
  public void ConsejosAyuda(){ 
      //Opcion 4: Contacto de ayuda
      System.out.println("\n\n4. Contacto de ayuda\n");
      System.out.println("No tome medidas drasticas si no se siente bien");
      System.out.println("Hemos habilitado una pagina para que pueda acudir en caso tenga cualquier duda");
      System.out.println("https://www.facebook.com/Samaj-2020-107001737815812");
    }

    public void MensajeErrorCorreo(){
      System.out.println("Error! Por favor asegurese de ingresar un correo valido. \nUtilice el caracter -@-.\n \nIntente Nuevamente...\n");
    }

    public void CrearTemp(){
      System.out.println("Crear trabajo temporal:\n");
    }
    public void CrearCon(){
      System.out.println("Crear trabajo bajo contrato:\n");
    }
    
  public void PerfilExito(){
    System.out.println("\nChilerisimo. Ha creado un perfil con exito\n");
  }
    public void IngresoInfo(){
      System.out.println("\n\nIngrese los datos que se le solicitan");
    }

  public void MensajeTrabajadorFormalExito(){
    System.out.println("\n \nSu perfil se ha agregado a la base de datos. \nEsperamos lo contacten pronto!\n \n");
  }
    
}

