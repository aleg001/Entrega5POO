/*****************
Proyecto Semestral
Autor: Alejandro Gómez 20347, Marco Jurado 20308, Paola De Leon 20361, Andres Osorio, Alejandra Guzman 20262
Fecha: 01/09/2020
Ultima modificacion: 11/09/2020
					
Clase madre de usuarios de prgrama Samaj
Samaj-20
*****************/

//De esta clase madre de las cuales va a derivar el polimorfismo via herencia.
public class usuarioSamaj {

    protected String Nombre, Apellido, Correo;
    protected int Telefono, Codigo, Contacto;

    public usuarioSamaj(){}

    // Constructor
    public usuarioSamaj( String Nombre, String Apellido, String Correo, int Telefono, int Codigo ) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Correo = Correo;
        this.Telefono = Telefono;
        this.Codigo = Codigo;
    }

    // Getters 
    public String getNombre() { return Nombre; }
    public String getApellido() { return Apellido; }
    public String getCorreo() { return Correo; }
    public int getTelefono() { return Telefono; }
    public int getCodigo() { return Codigo; }


    // Setters 
    public void setNombre( String a ) { Nombre = a; } 
    public void setApellido( String a ) { Apellido = a; } 
    public void setCorreo( String a ) { Correo = a; } 
    public void setTelefono( int  a ) { Telefono = a; }
    public void setCodigo( int a ) { Codigo = a; }

    /**
     * Override toString
     * @return String Información básica de un usuario
     * @author Paola de León
     */
    public String toString() {
        String msj = "INFORMACION USUARIO:";
        msj += "\nNombre: " + Nombre;
        msj += "\nApellido: " + Apellido; 
        msj += "\nCorreo: " + Correo;
        msj += "\nTelefono: " + Telefono;
        msj += "\nCodigo: " + Codigo;

        return msj;
    }

}
