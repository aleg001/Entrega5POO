/*****************
Proyecto Semestral
Autor: Alejandro Gómez 20347, Marco Jurado 20308, Paola De Leon 20361, Andres Osorio, Alejandra Guzman 20262
Fecha: 01/09/2020
Ultima modificacion: 11/09/2020
					
Controlador del programa
Samaj-20
*****************/

import java.util.ArrayList;

public class Controlador {
  public static void main (String[] args) {

    //Propiedades
    //int opc;
    String NombreUsuario;
    String ApellidoUsuario;
    String CorreoUsuario;
    int TelefonoUsuario;
    int CodigoUsuario;

    int TrabajadorFormalEdad;
    int TrabajadorFormalEducacion;
    boolean TrabajdorFormalExpLaboral;
    int TrabajadorFormalIdioma;
    boolean TrabajadorFormalTransporte;
    boolean TrabajadorFormalHomeOffice;
    int TrabajadorFormalExpertise;

    String TrabajadorInformalArea;
  
    //Instanciar
    Documentos docs = new Documentos();
    Vista v = new Vista();
    usuarioSamaj user = null;
    boolean salir = false;
    Persistencia p = new Persistencia();

    //Logo realizado para el proyecto de Samaj
    v.Logo();

    v.MensajeBienvenida();

    //Bajar la base de datos para tener perfiles guardados del CSV
    ArrayList<ArrayList<String>> BaseDatos = p.obtenerDatos("TABLA1");
    Documentos.setInfoUsuarios(BaseDatos); //Guarada en la clase Documentos los datos de la base de datos.

    //------------------------------------------------------ D E S C A R G A R   B A S E   D A T O S   A   L O C A L -----------------------------------
    // Instaniar información de base de datos y agregarla a Documentos
    // Trabajadores Formales
    ArrayList<ArrayList<String>> BaseDatosUsuarios = p.obtenerDatos("TABLA1");
    ArrayList<ArrayList<String>> BaseDatosTrabajadores = p.obtenerDatos("TABLA2");
    ArrayList<ArrayList<String>> BaseDatosTrabajos = p.obtenerDatos("TABLA3");
    
    //Crear Trabajadores para que el programa lo lea.
    for(int i = 0; i < BaseDatosTrabajadores.size(); i++){  
      //Recuperando datos
      ArrayList<String> fila = BaseDatosTrabajadores.get(i);
      String nom = fila.get(1);
      String ape = fila.get(2);
      String corr = fila.get(3);
      
      int telefono = Integer.parseInt(fila.get(4));
      int cod = Integer.parseInt(fila.get(0));
      int edad = Integer.parseInt(fila.get(5));
      int nievleducacion = Integer.parseInt(fila.get(6));
      int idioma = Integer.parseInt(fila.get(7));
      int expert = Integer.parseInt(fila.get(11));
    
      String experiencialaboralS = fila.get(8);
      String transporteS = fila.get(9);
      String homeofficeS = fila.get(10);
      
      boolean experiencialaboral = Boolean.parseBoolean(experiencialaboralS);
      boolean transporte = Boolean.parseBoolean(transporteS);
      boolean homeoffice = Boolean.parseBoolean(homeofficeS);

      //Creando instancias con los datos recuperados
      usuarioSamaj User = new usuarioSamaj(nom,ape,corr, telefono, cod );
      TrabajadorFormal NewTF = new TrabajadorFormal(User, edad, nievleducacion, idioma, experiencialaboral,transporte, homeoffice, expert);
      if ( Documentos.BaseTF.contains(NewTF) ) {} 
      else {
        Documentos.AddTrabajadorFormal(NewTF);
      }
    }

    //Crear Usuarios para que el programa lo lea.
    for(int i = 0; i < BaseDatosUsuarios.size(); i++){
      ArrayList<String> fila = BaseDatosUsuarios.get(i);
      String nom = fila.get(1);
      String ape = fila.get(2);
      String corr = fila.get(4);
      int telefono = Integer.parseInt(fila.get(3));
      int cod = Integer.parseInt(fila.get(0));
      usuarioSamaj User = new usuarioSamaj(nom,ape,corr, telefono, cod );
      if (Documentos.Usuarios.contains(User)){}
      else {
        Documentos.AddUsuario(User);
      }
    }

    // Crear Trabajos para que el programa lo lea.
    for(int i = 0; i < BaseDatosTrabajos.size(); i++){
      ArrayList<String> fila = BaseDatosTrabajos.get(i);
      //Recuperando los datos
      
      int cod = Integer.parseInt(fila.get(0));
      int tel = Integer.parseInt(fila.get(3));
      String nombre = fila.get(1);
      String apellido = fila.get(2);
      String correo = fila.get(4);
      usuarioSamaj usertrabajito = new usuarioSamaj(nombre, apellido, correo, tel, cod); //Se crea instancia de usuario que va en trabajotemp

      String datopos7 = fila.get(7);
		  datopos7 = datopos7.replace(" ","");

      int sueldo = Integer.parseInt(datopos7);
      String categoria = fila.get(5);
      String descripcion = fila.get(6);
      

      TrabajoTemp trabajito = new TrabajoTemp(usertrabajito, categoria, descripcion, sueldo); //Se crea trabajo
      if(fila.size() >= 8){
        for(int l = 8; l < fila.size(); l++){
          //Recorre los aplicantes y obtiene el dato tipo string para añadirlos en dado caso tenga estos
          String x = fila.get(l); 
          trabajito.agregaraplicanteDato(x);
        }
      }

      if ( Documentos.TrabajoTemp.contains(trabajito) ) {}
      else {
        //Se sube la instancia de trabajito
        docs.AddTrabajoTemp(trabajito);
      }
      
    }

    //-------------------------------------------------------- C R E A R   U S U A R I O -----------------------------------------------------
    // Proceso de verificar existencia de perfil y/o creación de perfil
    int varTemporal = v.ExisteUsuario(); //Preguntar si tiene o no perfil. Devuelve 1 o 2 únicamente.
    if (varTemporal == 1) {
      //El usuario dice que tiene perfil
      CodigoUsuario = v.IngresoCodigo(docs);

		ArrayList<usuarioSamaj> usuariosbasedatos = new ArrayList<usuarioSamaj>();
		usuariosbasedatos = Documentos.getUsuarios();
		boolean encontrado = false;
		
		for(int k = 0; k < usuariosbasedatos.size(); k++){
			//Recorrer Base datos de usuarios
			usuarioSamaj usu = null;
			usu = usuariosbasedatos.get(k);
			
			int cod = usu.getCodigo();
			
			if(CodigoUsuario == cod){
				//Encontró el codigo en la base de datos.
				//Código si existe entonces se toman datos del ArrayList que tenga el código
				ArrayList<String> datosUsuario = docs.devolverDatos(CodigoUsuario);
				String NombreU = datosUsuario.get(1);
				String ApellidoU = datosUsuario.get(2);
				String CorreoU = datosUsuario.get(4);
				// TelefonoU
				String TelefonoU = datosUsuario.get(3); 
				// codigoU
				String CodigoU = datosUsuario.get(0); 
				int Telefono = Integer.parseInt(TelefonoU);
				int Codigo = Integer.parseInt(CodigoU);
				user = new usuarioSamaj(NombreU, ApellidoU, CorreoU, Telefono, Codigo);
				v.PerfilExito(); //Mensaje de creado con éxito. CHILERISIMO
				encontrado = true;
				
				
				
				//Imprime los trabajos que tenga el usuario
				
				//Se le muestra su trabajo temp publicado
				  for(int i = 0; i < BaseDatosTrabajos.size(); i++){
					ArrayList<String> filon = new ArrayList<String>();
					filon = BaseDatosTrabajos.get(i);
					int codigo = Integer.parseInt(filon.get(0));
					if(CodigoUsuario == codigo){
					  /* Se busca el codigo del usuario para mostrar su trabajo y se encuentra una similitud */
					  //Recuperando los datos
					  int tel = Integer.parseInt(filon.get(3));
					  String nombre = filon.get(1);
					  String apellido = filon.get(2);
					  String correo = filon.get(4);
					  usuarioSamaj usertrabajito = new usuarioSamaj(nombre, apellido, correo, tel, codigo); //Se crea instancia de usuario que va en trabajotemp
						
					String dato  = filon.get(7);
					dato = dato.replace(" ", "");
					  int sueldo = Integer.parseInt(dato);
					  String categoria = filon.get(5);
					  String descripcion = filon.get(6);
					  

					  TrabajoTemp tratra = new TrabajoTemp(usertrabajito, categoria, descripcion, sueldo); //Se crea trabajo
					  if (filon.size() >= 8) {
              for(int l = 8; l < filon.size(); l++){
                //Recorre los aplicantes y obtiene el dato tipo string para añadirlos en dado caso tenga estos
                String x = filon.get(l); 
                tratra.agregaraplicanteDato(x);
              }
					  }
					  v.imprimirTrabajo(tratra);

						}
					}
				
				
			}
		}if(encontrado == false){
			/* No encontro el codigo crea un usuario.*/
			v.IngresoInfo();
			NombreUsuario = v.ingresarNombre();
			ApellidoUsuario = v.ingresarApellido();
			CorreoUsuario = v.ingresarCorreo();
			TelefonoUsuario = v.ingresarTelefono();
			CodigoUsuario = v.IngresoCodigo(docs); 
			user = new usuarioSamaj(NombreUsuario, ApellidoUsuario, CorreoUsuario, TelefonoUsuario, CodigoUsuario );
			
			System.out.println("El usuario ---->" + user + "...\n\n");

			p.nuevoRegistro(user);
			v.PerfilExito(); //Mensaje de creado con éxito. CHILERISIMO
			}
      
      /*
      Se buscará el CodigoUsuario en el CSV
      para verificar que el código del 
      usuario en realidad existe.        */

    } else if (varTemporal == 2) {
      /* Se ejecuta en caso el usuario
        no posea un perfil creado en
        Samaj-2020          */ 
      v.IngresoInfo();
      NombreUsuario = v.ingresarNombre();
      ApellidoUsuario = v.ingresarApellido();
      CorreoUsuario = v.ingresarCorreo();
      TelefonoUsuario = v.ingresarTelefono();
      CodigoUsuario = v.IngresoCodigo(docs); 
      user = new usuarioSamaj(NombreUsuario, ApellidoUsuario, CorreoUsuario, TelefonoUsuario, CodigoUsuario );
      p.nuevoRegistro(user);
      v.PerfilExito(); //Mensaje de creado con éxito. CHILERISIMO
    }

	    v.mostrarinfoaUsuario(user);
    // C O M I E N Z A   M E N Ú   G E N E R A L
    while ( salir == false) {
      int opcion = v.MenuGeneral(); //Método de Menú de vista
      if(opcion == 1){

        //Sub Menú 
        boolean salirSub1 = false;
        while (salirSub1 == false) {
          int submenu1 = v.SubMenu();
          if (submenu1 == 1){
            /* Ingresar los datos para crear el perfil donde se obtienen los
               datos adicionales para crear el Trabajador Formal. */
            v.IngresoInfo();
            TrabajadorFormalEdad = v.ingresarEdad();
            TrabajadorFormalEducacion = v.ingresarEducacion();
            TrabajdorFormalExpLaboral = v.ingresarExperienciaLaboral(); 
            if(TrabajadorFormalEducacion == 3 || TrabajadorFormalEducacion == 4){
              TrabajadorFormalExpertise = v.ingresarExpertise();
            }else{
              TrabajadorFormalExpertise = 0;
            }
            TrabajadorFormalIdioma = v.ingresarIdioma();
            TrabajadorFormalTransporte = v.ingresarTransporte();
            TrabajadorFormalHomeOffice = v.ingresarHomeOffice();

            //Construir TrabajadorFormal y subir perfil a Documentos
            TrabajadorFormal entacuchado = new TrabajadorFormal(user, TrabajadorFormalEdad, TrabajadorFormalEducacion, TrabajadorFormalIdioma, TrabajdorFormalExpLaboral, TrabajadorFormalTransporte, TrabajadorFormalHomeOffice, TrabajadorFormalExpertise );
            Documentos.AddTrabajadorFormal( entacuchado );
            v.PerfilExito();
            v.MensajeTrabajadorFormalExito();
            p.NuevoRegistroTrabajadorFormal(entacuchado);
          }
          else if ( submenu1 == 2 ) {
            /* Ingresar los datos para crear el perfil donde se obtienen los
               datos adicionales para crear el Trabajador Informal. */
            v.IngresoInfo();
            TrabajadorInformalArea = v.ingresarConocimiento();

            //Construir TrabajadorInformal y subir perfil a Documentos
            TrabajadorInformal don = new TrabajadorInformal(user, TrabajadorInformalArea);
            Documentos.AddTrabajadorInformal( don );
            v.PerfilExito();
          }
          else if (submenu1 == 3) {
            //Construir EmpleadorFormal y subir perfil a Documentos
            EmpleadorFormal Jefe = new EmpleadorFormal(user);
            Documentos.AddEmpleadorFormal( Jefe );
            v.PerfilExito();
          }
          else if (submenu1 == 4) {
            //Construir EmpleadorTemporal y subir perfil a Documentos
            EmpleadorTemporal EmpleadorTemporal = new EmpleadorTemporal(user);
            Documentos.AddEmpleadorTemporal(EmpleadorTemporal);
            v.PerfilExito();
          }
          else if (submenu1 == 5) {
            v.MensajeRegresoMenuPrincipal();
            salirSub1 = true;
          }
          else {
            v.MensajeErrorMenu();
          }
        }
      }
      else if (opcion == 2) {
        // Crear Trabajos temporales
        v.CrearTemp();
        String CategoriaTrabajo = v.ingresarCategoriaTrabajo();
        String DescripcionTrabajo = v.ingresarDescripcion();

        int Sueldo = v.ingresarSueldo();
        TrabajoTemp TrabajosTempo = new TrabajoTemp( user, CategoriaTrabajo, DescripcionTrabajo, Sueldo );
        docs.AddTrabajoTemp(TrabajosTempo);
        p.NuevoRegistroTrabajoTemp(TrabajosTempo);
      }
      else if (opcion == 3) {
        //Buscar trabajos temporales
        boolean submenu2 = false;
        while (submenu2 == false) {
          int buscarTrabajos = v.submenu2();
          if(buscarTrabajos == 1){
            //Trabajo Temporal
            boolean correcto = false;
            int seleccion = 0;
			      while (correcto==false){
              seleccion = v.enlistarCategoriasTrabajo(docs);
              if (seleccion <= Documentos.getTrabajoTemp().size()) {
                correcto=true;
              }
              else {
                v.ErrorMns();
              }
            }
            ArrayList<TrabajoTemp> lista = Documentos.getTrabajoTemp();
            TrabajoTemp TrabajitoTemporal = lista.get(seleccion);
            TrabajitoTemporal.agregarAplicante(user);
            
            //Método que borra la linea en la base da datos
            String filaBuscar = p.FilaAEliminar(TrabajitoTemporal);
            p.eliminarRegistro(filaBuscar);

            //Agregan el trabajo modificado.
            docs.AddTrabajoTemp(TrabajitoTemporal);
            p.NuevoRegistroTrabajoTemp(TrabajitoTemporal);

          }
          else if (buscarTrabajos == 2) {
            //Salir al menú principal
            submenu2 = true;
          }
          else{
            v.MensajeErrorMenu();
          }
        }
        
      }
      else if (opcion == 4 ) {
        //Para buscar el trabajador formal indicado para la empresa.
        v.enlistarTrabajadoresFormales(docs);
      }
      else if (opcion == 5) {
        // Consejos
        boolean salirsub3 = false;
        while (salirsub3 == false) {
          int opc4 = v.ConsejosMenu(); //  
          if (opc4 == 1) {
            boolean subsubmenu = false;
            while(subsubmenu == false){
              int ConsejoPsic = v.SubConsejosPsic();
              if(ConsejoPsic ==1){
                v.ConsejosCrisis();
              }
              else if(ConsejoPsic == 2){
                v.ConsejosAntiS();
              }
              else if(ConsejoPsic ==3){
                v.ConsejosAyuda();
              }
              else if(ConsejoPsic == 4){
                subsubmenu = true;
              }
            }
          }
          else if (opc4 == 2) {
            boolean subsubmenu2 = false;
            while(subsubmenu2 == false){
              int ConsejoEcon = v.ConsejosSubEcon();
              if(ConsejoEcon ==1){
                v.ConsejoFinanciero1();
              }
              else if (ConsejoEcon == 2){
                v.ConsejoFinanciero2();
              }
              else if (ConsejoEcon ==3){
                v.ConsejoFinanciero3();
              }
              else if (ConsejoEcon ==4){
                v.ConsejoInfoFinan();
                subsubmenu2 = true;
              }
            }
          }
          else if (opc4 == 3) {
            salirsub3 = true;
          }
          else {
            v.MensajeErrorMenu();
          }
        }   
      }
      else if (opcion == 6) {
        //Salir
        v.MensajeDespedida();
        salir = true;
      }
      else {
        v.MensajeErrorMenu(); //Error de dato fuera de rango.
      }
    }
  }
}