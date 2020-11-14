
//import java.nio.charset.Charset;
import java.util.ArrayList;
import java.lang.Integer;
//Nuevos imports
//import java.util.Arrays;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.lang.Boolean;

 public class Persistencia implements Registro{

   //Propiedades
   private Connection conn;

   //Constructor, el cual confirma la conexión con el servidor.
   public Persistencia(){
      conn = null;
      Conexion cn = new Conexion();
      conn = cn.getConn();
      if(conn==null){
         System.out.println("ERROR: La conexión al servidor no existe.");
      }
   }

   //Registro de un string anidado con todos los datos (atributos de demás clases)
	public void registrarBD(String dato, String tabla){
		try{  
			PreparedStatement pst = conn.prepareStatement("INSERT INTO "+tabla+" VALUES(?)");
			pst.setString(1, dato);
			int i = pst.executeUpdate();
			System.out.println("Se ha actualizado "+Integer.toString(i)+" cantidad de filas en la base de datos.");
		}catch(Exception sqle){
			System.out.println("Error: "+sqle);
		}

	}

   //Metodo que añade un nuevo registro . Recibe una instancia del objeto
   public void nuevoRegistro( usuarioSamaj user ){

         String cod = Integer.toString(user.getCodigo());
         String nombre = user.getNombre();
         String apellido = user.getApellido();
         String tel = Integer.toString(user.getTelefono());
         String correo = user.getCorreo();
         String fila = cod+","+nombre+","+apellido+","+tel+","+correo;

         registrarBD(fila, "TABLA1");
   }
   // Tomar en cuenta los parámetros.
   // Parámetro "TABLA1" para recibir ArrayList de ArrayList de la clase usuarioSamaj
   // Parámetro "TABLA2" para recibir ArrayList de ArrayList de la clase TrabajadorFormal
   // Parámetro "TABLA3" para recibir ArrayList de ArrayList de la clase TrabajoTemp
   
   // Metodo que devuelve un ArrayList de ArrayList de toda la info solo de una tabla en la bd en específico
  public ArrayList<ArrayList<String>> obtenerDatos(String tabla){
		ArrayList<ArrayList<String>> datos = new ArrayList<ArrayList<String>>();
		try{
			Statement st = conn.createStatement();
			ResultSet rs =  st.executeQuery("SELECT * FROM "+tabla);
			while(rs.next() != false){
				ArrayList<String> fila = new ArrayList<String>();
				String[] lista = (rs.getString("Registro")).split(",");
				for(int i = 0; i < lista.length; i++){
					fila.add(lista[i]);
				}
				datos.add(fila);
			}
		}catch(Exception sqle){
			System.out.println("Error: "+sqle );
		}

		return datos;
   }
   
   // Metodo para agregar al csv 
   public void NuevoRegistroTrabajoTemp( TrabajoTemp trabajito) {
      usuarioSamaj user = trabajito.getUser();
      String cod = Integer.toString(user.getCodigo());
      String nombre = user.getNombre();
      String apellido = user.getApellido();
      String tel = Integer.toString(user.getTelefono());
      String correo = user.getCorreo();

      String categoria = trabajito.getCategoriaTrabajo();
      String descripcion = trabajito.getDescripcionTrabajo();
      String sueldo = Integer.toString(trabajito.getSueldo());
      String fila = cod+","+nombre+","+apellido+","+tel+","+correo + ", " + categoria + ", " + descripcion + ", " + sueldo;

      /*Tomar el ArrayList de aplicantes del objeto TrabajoTemp
         y extraer el nombre y número de telefono de cada uno de
         estos para que sean almacenados en el registro.  Estos
         serán añadidos fila para ser metidos al registro.   */

      ArrayList<usuarioSamaj> aplicantes = trabajito.getAplicantes();
      if (aplicantes.size()!=0){
         for (int i = 0; i < aplicantes.size(); i++) {
            usuarioSamaj h = aplicantes.get(i);
            String nom = h.getNombre();
            String telef = Integer.toString(h.getTelefono());
            fila += ", " + nom + ", " + telef;
         }
      }
      // LLamar método con dos parámetros: el String anidado y el nombre de la tabla en la base de datos.
      registrarBD(fila, "TABLA3");
   }

   //Metodo para agregar TrabajadorFormal a la BaseDatos
   public void NuevoRegistroTrabajadorFormal(TrabajadorFormal x){
         //Datos usuario
         String cod = Integer.toString(x.getCodigo());
         String nombre = x.getNombre();
         String apellido = x.getApellido();
         String tel = Integer.toString(x.getTelefono());
         String correo = x.getCorreo();
         
         //Datos TrabajadorFormal
         String edad = Integer.toString(x.getEdad());
         String educacion = Integer.toString(x.getNivelEducacion());
         String idioma = Integer.toString(x.getIdiomas());
         String exp = String.valueOf(x.getExperiencia());
         String trans = String.valueOf(x.getTransporte());
         String home = String.valueOf(x.getHomeOffice());
         String expertise = Integer.toString(x.getNivelExpertise());
         String fila = cod+","+nombre+","+apellido+","+correo+","+tel+","+edad+","+educacion+","+idioma+","+exp+","+trans+","+home+","+expertise;
         registrarBD(fila, "TABLA2");
   }

   public String FilaAEliminar( TrabajoTemp trabajito) {
      String retorno = "";
      usuarioSamaj user = trabajito.getUser();
      String cod = Integer.toString(user.getCodigo());
      String nombre = user.getNombre();
      String apellido = user.getApellido();
      String tel = Integer.toString(user.getTelefono());
      String correo = user.getCorreo();

      String categoria = trabajito.getCategoriaTrabajo();
      String descripcion = trabajito.getDescripcionTrabajo();
      String sueldo = Integer.toString(trabajito.getSueldo());
      String fila = cod+","+nombre+","+apellido+","+tel+","+correo + ", " + categoria + ", " + descripcion + ", " + sueldo;
      retorno = fila;
      return retorno;
   }
   //Metodo para eliminar 
   public void eliminarRegistro(String dato){
      try{
         PreparedStatement pst = conn.prepareStatement("DELETE FROM TABLA3 WHERE Registro = ? ");
         pst.setString(1,dato);
         int i = pst.executeUpdate();
         System.out.println("Se ha eliminado"+Integer.toString(i)+" registro de la base de datos.");
      }catch(SQLException sqle){
         System.out.println(sqle);
      }
   }

   
}