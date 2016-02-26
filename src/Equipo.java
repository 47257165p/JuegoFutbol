import java.util.ArrayList;

/**
 * Created by 47257165p on 26/02/16.
 */
public class Equipo {

    private String nombre = "Unnasigned";
    private String estadio = "Unnasigned";
    private Entrenador entrenador = new Entrenador();
    private ArrayList<Jugador> jugadores;

    public Equipo(String nombre, String estadio) {
        this.nombre = nombre;
        this.estadio = estadio;
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

    public void cambioLiga()
    {

    }
}
