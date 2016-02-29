
/**
 * Created by 47257165p on 26/02/16.
 */
public class Jugador {

    private String dni = "00000000A";
    private String nombre = "Unnasigned";
    private String apellido = "Unnasigned";
    private double altura = -1;
    private Caracteristicas caracteristicas = new Caracteristicas();

    public Jugador(String dni, String nombre, String apellido, double altura) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.altura = altura;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getAltura() {
        return altura;
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

    public void seRetira()
    {

    }

    public void seTraspasa()
    {

    }

    public String toString()
    {
        return "Jugador:\nDNI = "+dni+"\nNombre = "+nombre+"\nApellido = "+apellido+"\nAltura = "+altura+"\n"+caracteristicas.toString();
    }
}
