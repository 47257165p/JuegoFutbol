import com.sun.org.apache.xml.internal.security.signature.ObjectContainer;

/**
 * Created by 47257165p on 26/02/16.
 */
public class Jugador {

    private String dni;
    private String nombre;
    private String apellido;
    private double altura;
    private Caracteristicas caracteristicas;
    private boolean enEquipo;

    public Jugador(String dni, String nombre, String apellido, double altura) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.altura = altura;
        this.enEquipo = false;
    }
    public Jugador(){
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    public void setAltura(double altura) {
        this.altura = altura;
    }

    public Caracteristicas getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(Caracteristicas caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public boolean isEnEquipo() {
        return enEquipo;
    }

    public void setEnEquipo(boolean enEquipo) {
        this.enEquipo = enEquipo;
    }

    public String toString()
    {
        return "Jugador:\nDNI = "+dni+"\nNombre = "+nombre+"\nApellido = "+apellido+"\nAltura = "+altura+"\n"+caracteristicas.toString();
    }
}
