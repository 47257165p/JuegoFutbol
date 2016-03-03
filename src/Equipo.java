import java.util.ArrayList;

/**
 * Created by 47257165p on 26/02/16.
 */
public class Equipo {

    private String nombre;
    private String estadio;
    private Entrenador entrenador;
    private ArrayList<Jugador> jugadores;
    private boolean enLiga;

    public Equipo(String nombre, String estadio) {
        this.nombre = nombre;
        this.estadio = estadio;
        this.enLiga=false;
    }

    public Equipo(){
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public boolean isEnLiga() {
        return enLiga;
    }

    public void setEnLiga(boolean enLiga) {
        this.enLiga = enLiga;
    }
    public void cambioLiga()
    {

    }
}
