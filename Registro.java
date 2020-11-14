/*****************
Proyecto Semestral
Autor: Alejandro Gómez 20347, Marco Jurado 20308, Paola De Leon 20361, Andres Osorio, Alejandra Guzman 20262
Fecha: 01/09/2020
Ultima modificacion: 11/09/2020
					
Interfaz para persistencia
Samaj-20
*****************/
import java.util.ArrayList;
import java.lang.Integer;

public interface Registro {


    // Tomar en cuenta los parámetros.
    // Parámetro "TABLA1" para recibir ArrayList de ArrayList de la clase usuarioSamaj
    // Parámetro "TABLA2" para recibir ArrayList de ArrayList de la clase TrabajadorFormal
    // Parámetro "TABLA3" para recibir ArrayList de ArrayList de la clase TrabajoTemp


    /**
   * Método que utilizará para crear registros de Usuarios en base de datos
   * @param user usuarioSamaj instancia del usuario
   * @return void.
   * @author Marco Jurado, Paola de Leon, Alejandro Gomez
   */
    abstract void nuevoRegistro( usuarioSamaj user );
    
     /**
   * Método para para Registrar la base de datos
   * @param tabla String del nombre de la tabla, dato String que es el dato a buscar
   * @return void.
   * @author Marco Jurado, Paola de Leon, Alejandro Gomez
   */
    abstract void registrarBD(String dato, String tabla);


     /**
   * Método que utilizará para obtener los datos de una tabla en sql y poder tener esta info en el programa en Java.
   * @param tabla String del nombre de la tabla
   * @return ArrayList<ArrayList<String>>.
   * @author Marco Jurado, Paola de Leon, Alejandro Gomez
   */
    abstract ArrayList<ArrayList<String>> obtenerDatos(String tabla);

    /**
   * Método que se utilizará para poder añadir nuevos registros a la base de datos en la tabla de Trabajos temporales
   * @param TrabajoTemp trabajito
   * @return void.
   * @author Marco Jurado, Paola de Leon, Alejandro Gomez
   */
    abstract void NuevoRegistroTrabajoTemp( TrabajoTemp trabajito);
    
    /**
   * Método que se utilizará para agregar un TRabajador Formal a la base de datos
   * @param x Trabajador formal por agregar.
   * @return void.
   * @author Marco Jurado, Paola de Leon, Alejandro Gomez
   */
    public void NuevoRegistroTrabajadorFormal(TrabajadorFormal x);
    
}
