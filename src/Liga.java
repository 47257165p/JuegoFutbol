import java.util.ArrayList;

/**
 * Created by 47257165p on 26/02/16.
 */
public class Liga {

    private String nombre;
    private String patrocinador;
    private byte categoria;
    private ArrayList<Equipo> equipos;

    public Liga(String nombre, String patrocinador, byte categoria) {
        this.nombre = nombre;
        this.patrocinador = patrocinador;
        this.categoria = categoria;
    }

    public Liga(){
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPatrocinador() {
        return patrocinador;
    }

    public void setPatrocinador(String patrocinador) {
        this.patrocinador = patrocinador;
    }


    public void setCategoria(byte categoria) {
        this.categoria = categoria;
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }

}
