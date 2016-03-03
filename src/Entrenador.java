/**
 * Created by 47257165p on 26/02/16.
 */
public class Entrenador {

    private String nombre;
    private byte añosExperiencia;
    private boolean tieneEquipo;

    public Entrenador(String nombre, byte añosExperiencia) {
        this.nombre = nombre;
        this.añosExperiencia = añosExperiencia;
        this.tieneEquipo = false;
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

    public boolean isTieneEquipo() {return tieneEquipo;}

    public void setTieneEquipo(boolean tieneEquipo) {this.tieneEquipo = tieneEquipo;}

    public void cambioEquipo()
    {

    }
}
