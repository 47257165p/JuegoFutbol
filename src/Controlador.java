import java.util.ArrayList;
import java.util.InputMismatchException;
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
        boolean keep = true;
        while (keep)
        {
            System.out.println("-MENÚ PRINCIPAL-");
            System.out.println("1. Jugadores");
            System.out.println("2. Equipos");
            System.out.println("3. Entrenadores");
            System.out.println("4. Ligas");
            System.out.println("5. Salir");
            System.out.println("----------------");

            try
            {
                switch (in.nextInt())
                {
                    case 1:
                        menuJugadores();
                        break;
                    case 2:
                        menuEquipos();
                        break;
                    case 3:
                        menuEntrenadores();
                        break;
                    case 4:
                        menuLigas();
                        break;
                    case 5:
                        System.out.println("Aplicación finalizada, muchas gracias.");
                        keep = false;
                        break;

                    default:
                        System.out.println("La opción introducida no existe. Intenta de nuevo.");
                        break;
                }
            }
            catch (Exception e)
            {
                System.out.println("Has introducido un caracter inválido. Intenta de nuevo.");
                in.reset();
            }
        }
    }

    public static void menuJugadores()
    {
        System.out.println("-MENÚ JUGADOR-");
        System.out.println("1. Crear");
        System.out.println("2. Modificar");
        System.out.println("3. Borrar");
        System.out.println("4. Buscar");
        System.out.println("5. Mostrar todos");
        System.out.println("6. Salir");
        System.out.println("--------------");

        int posicion;
        switch (in.nextInt())
        {
            case 1:
                jugadores.add(crearJugador(new Jugador()));
                break;
            case 2:
                posicion = buscarJugador();
                if (posicion!=-1)
                {
                    System.out.println("Se va a modificar el jugador " + jugadores.get(posicion).getNombre() + ". Todos los datos que se introduzcan a continuación modificarán los ya existentes.");
                    crearJugador(jugadores.get(posicion));
                }
                break;
            case 3:
                posicion = buscarJugador();
                if (posicion!=-1)
                {
                    jugadores.remove(posicion);
                    System.out.println("Se ha eliminado el jugador.");
                }

                break;
            case 4:
                break;
            default:
                break;
        }
        menu();
    }

    public static Jugador crearJugador(Jugador jugador)
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
        return jugador;
    }

    public static int buscarJugador()
    {
        System.out.println("Introduce el DNI del jugador:");
        String dni = in.next();
        int position = -1;
        try
        {
            for (int i = 0; i < jugadores.size(); i++) {
                if (jugadores.get(i).getDNI().equals(dni)) {
                    position = i;
                }
            }
            System.out.println("No se ha encontrado el jugador con DNI: "+dni);
        }
        catch (NullPointerException e)
        {
            System.out.println("No hay ningún jugador registrado en la base de datos.");
        }
        finally {
            return position;
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
