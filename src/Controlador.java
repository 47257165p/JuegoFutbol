import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
/**
 * Created by 47257165p on 26/02/16.
 */
public class Controlador {

    private static ObjectContainer database;
    private static Scanner in = new Scanner(System.in);
    private static String basura;

    public static void main(String[] args) {

        createDB();
        menu();
    }

    public List getChildren() {

        ArrayList<String> childrenList = new ArrayList();

        childrenList.add("a");
        childrenList.add("a");
        childrenList.add("a");


        return childrenList;
    }

    public static void createDB()
    {
        File db = new File("/database.data");
        if (!db.exists())
        {
            try
            {
                db.createNewFile();
            }
            catch (IOException e)
            {
                System.out.println("Error al crear la base de datos.");
            }
        }
    }

    public static void openDB()
    {
        try
        {
            database = Db4o.openFile("database.data");
        }
        catch (Exception e)
        {
            System.out.println("Error al abrir la base de datos. Cerrando...");
            database.close();
        }
    }

    public static void saveAndCloseDB()
    {
        database.commit();
        database.close();
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

            in = new Scanner(System.in);

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
                        System.out.println("La opción introducida no existe. Intenta de nuevo.\n");
                        break;
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println("Has introducido un caracter inválido. Intenta de nuevo.\n");
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

        Jugador jugador;
        switch (in.nextInt())
        {
            case 1:
                openDB();
                database.store(crearJugador(new Jugador()));
                saveAndCloseDB();
                break;
            case 2:
                openDB();
                jugador = buscarJugador();
                if (jugador!=null)
                {
                    System.out.println("Se va a modificar el jugador " + jugador.getNombre() + ". Todos los datos que se introduzcan a continuación modificarán los ya existentes.");
                    jugador = crearJugador(jugador);
                    database.store(jugador);
                }
                saveAndCloseDB();
                break;
            case 3:
                openDB();
                jugador = buscarJugador();
                if (jugador!=null)
                {
                    database.delete(jugador);
                    System.out.println("Se ha eliminado el jugador.");
                }
                saveAndCloseDB();
                break;
            case 4:
                openDB();
                jugador = buscarJugador();
                if (jugador!=null)
                {
                    System.out.println(jugador.toString());
                }
                database.close();
                break;
            case 5:
                openDB();
                database.close();
            default:
                break;
        }
        menu();
    }

    public static Jugador crearJugador(Jugador jugador)
    {
        System.out.println("Introduce el nombre del jugador:");
        String nombre = in.nextLine();
        basura = in.next();
        System.out.println("Introduce el apellido del jugador:");
        String apellido = in.nextLine();
        System.out.println("Introduce el DNI del jugador:");
        String dni = in.nextLine();
        System.out.println("Introduce la altura del jugador:");
        double altura = in.nextDouble();

        jugador.setNombre(nombre);
        jugador.setApellido(apellido);
        jugador.setDni(dni);
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
                System.out.println("Se ha creado el jugador correctamente.\n");
                break;
        }
        return jugador;
    }

    public static Jugador buscarJugador()
    {
        System.out.println("Introduce el DNI del jugador:");
        String dni = in.next();
        Jugador jugador = null;
        try
        {
            ObjectSet<Jugador> jugadores = database.queryByExample(new Jugador());

            for (int i = 0; i < jugadores.size(); i++) {
                if (jugadores.get(i).getDni().equals(dni)) {
                    jugador = jugadores.get(i);
                    return jugador;
                }
            }
            System.out.println("No se ha encontrado el jugador con DNI: "+dni);
        }
        catch (NullPointerException e)
        {
            System.out.println("No hay ningún jugador registrado en la base de datos.");
        }
        finally {
            return jugador;
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
