import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion{
	//Atributos
	private Connection cn;
	//Parámetros de la conexión con el servidor.
	private String SERVIDOR_IP = "remotemysql.com";
	private String PUERTO = "3306";
	private String BD = "cmMQ91ir0G";
	private String USUARIO = "cmMQ91ir0G";
	private String CONTRASENA ="fgWZ5wpBbg";

	public static void main(String[] args) {
		Conexion c = new Conexion();
	}
	
	//Constructor
	public Conexion(){
		try{
			cn = null;
			cn = DriverManager.getConnection("jdbc:mysql://"+SERVIDOR_IP+":"+PUERTO+"/"+BD, USUARIO, CONTRASENA);
			System.out.println("FUNCIONOOOOOO");
		}catch(SQLException sqle){
			System.out.println(sqle);
		}
	}
	//Metodo que devuelve la conexión con el servidor.
	public Connection getConn(){
		return cn;
	}
}