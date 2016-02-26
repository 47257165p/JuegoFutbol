import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by 47257165p on 26/02/16.
 */
public class Controlador {

    private static ArrayList<Liga> ligas = new ArrayList<>();
    private static ArrayList<Equipo> equipos = new ArrayList<>();
    private static ArrayList<Jugador> jugadores = new ArrayList<>();
    private static ArrayList<Entrenador> entrenadores = new ArrayList<>();

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        menu();
    }

    public static void menu()
    {
        System.out.println("-MENÚ PRINCIPAL-");
        System.out.println("1. Jugadores");
        System.out.println("2. Equipos");
        System.out.println("3. Entrenadores");
        System.out.println("4. Ligas");
        System.out.println("5. Salir");
        System.out.println("----------------");

        switch (in.nextInt())
        {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5: break;

            default: break;
        }
    }

    public static void menuJugadores()
    {
        System.out.println("-MENÚ JUGADOR-");
        System.out.println("1. Crear");
        System.out.println("2. Modificar");
        System.out.println("3. Borrar");
        System.out.println("5. Salir");
        System.out.println("--------------");

        Jugador jugador = new Jugador();

        switch (in.nextInt())
        {
            case 1:
                crearJugador(jugador);
                break;
            case 2:
                jugador = buscarJugador();
                System.out.println("Se va a modificar el jugador " + jugadore.getNombre() + ". Todos los datos que se introduzcan a continuación modificarán los ya existentes.");
                crearJugador(jugador);
                break;
            case 3:

                break;
            case 4:
                break;
            case 5:
                break;
            default:
                break;
        }
        menu();
    }

    public static void crearJugador(Jugador jugador)
    {
        System.out.println("Introduce el nombre del jugador:");
        String nombre = in.nextLine();
        System.out.println("Introduce el apellido del jugador:");
        String apellido = in.nextLine();
        System.out.println("Introduce el DNI del jugador:");
        String dni = in.nextLine();
        System.out.println("Introduce la altura del jugador:");
        double altura = in.nextDouble();

        jugador.setNombre(nombre);
        jugador.setApellido(apellido);
        jugador.setDNI(dni);
        jugador.setAltura(altura);

        System.out.println("¿Quieres asignarle características? 1 = SÍ. 2 = NO.");

        switch (in.nextInt())
        {
            case 1:
                System.out.println("Agilidad actual = "+jugador.getCaracteristicas().getAgilidad()+"\nIntroduzca la agilidad deseada:");
                byte agilidad = in.nextByte();
                System.out.println("Fuerza actual = "+jugador.getCaracteristicas().getFuerza()+"\nIntroduzca la fuerza deseada:");
                byte fuerza = in.nextByte();
                System.out.println("Velocidad actual = "+jugador.getCaracteristicas().getVelocidad()+"\nIntroduzca la velocidad deseada:");
                byte velocidad = in.nextByte();
                System.out.println("Resistencia actual = "+jugador.getCaracteristicas().getResistencia()+"\nIntroduzca la resistencia deseada:");
                byte resistencia = in.nextByte();
                System.out.println("Tiro actual = "+jugador.getCaracteristicas().getTiro()+"\nIntroduzca el tiro deseado:");
                byte tiro = in.nextByte();
                jugador.getCaracteristicas().modificarCaracteristicas(agilidad, fuerza, velocidad, resistencia, tiro);

                System.out.println("Se ha creado el jugador correctamente.");
                break;

            case 2:
                System.out.println("Se ha creado el jugador correctamente.");
                break;
        }
        jugadores.add(jugador);
    }

    public static Jugador buscarJugador()
    {
        System.out.println("Introduce el DNI del jugador:");
        String dni = in.next();
        try
        {
            for (Jugador jugadore : jugadores) {
                if (jugadore.getDNI().equals(dni)) {
                    return jugadore;
                }
            }
            System.out.println("No se ha encontrado el jugador con DNI: "+dni);
        }
        catch (NullPointerException e)
        {
            System.out.println("No hay ningún jugador registrado en la base de datos.");
        }
    }
    public static void menuEquipos()
    {

    }
    public static void menuEntrenadores()
    {

    }
    public static void menuLigas()
    {

    }
}
