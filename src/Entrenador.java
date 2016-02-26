/**
 * Created by 47257165p on 26/02/16.
 */
public class Entrenador {

    private String nombre = "Unnasigned";
    private byte añosExperiencia = -1;

    public Entrenador(String nombre, byte añosExperiencia) {
        this.nombre = nombre;
        this.añosExperiencia = añosExperiencia;
    }

    public Entrenador (){
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte getAñosExperiencia() {
        return añosExperiencia;
    }

    public void setAñosExperiencia(byte añosExperiencia) {
        this.añosExperiencia = añosExperiencia;
    }

    public void cambioEquipo()
    {

    }
}
