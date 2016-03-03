import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.ext.DatabaseClosedException;
import com.db4o.ext.Db4oIOException;
import com.db4o.query.Query;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Created by 47257165p on 26/02/16.
 */
public class Controlador {

    private static ObjectContainer database;
    private static Scanner in = new Scanner(System.in);
    private static Jugador jugador;
    private static Entrenador entrenador;
    private static Equipo equipo;
    private static Liga liga;

    public static void main(String[] args) {

        createDB();
        menu();
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
            EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
            database = Db4oEmbedded.openFile(config, "database.data");
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
            System.out.println("1. Creación");
            System.out.println("2. Eliminación");
            System.out.println("3. Visualización");
            System.out.println("4. Otras opciones");
            System.out.println("5. Salir");
            System.out.println("----------------");

            in = new Scanner(System.in);

            try
            {
                switch (in.nextLine())
                {
                    case "1":
                        menuCrear();
                        break;
                    case "2":
                        menuBorrar();
                        break;
                    case "3":
                        menuMostrar();
                        break;
                    case "4":
                        menuOtrasOpciones();
                        break;
                    case "5":
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

    public static void menuCrear()
    {
        System.out.println("-MENÚ CREACIÓN-");
        System.out.println("1. Crear jugador");
        System.out.println("2. Crear equipo");
        System.out.println("3. Crear entrenador");
        System.out.println("4. Crear liga");
        System.out.println("5. Salir");
        System.out.println("---------------");

        switch (in.nextLine())
        {
            case "1":
                openDB();
                database.store(crearJugador(new Jugador()));
                saveAndCloseDB();
                break;
            case "2":
                openDB();
                database.store(crearEquipo(new Equipo()));
                saveAndCloseDB();
                break;
            case "3":
                openDB();
                database.store(crearEntrenador(new Entrenador()));
                saveAndCloseDB();
                break;
            case "4":
                openDB();
                database.store(crearLiga(new Liga()));
                database.close();
                break;
            case "5":
                break;
            default:
                System.out.println("Tu opción no coincide con ninguna opción del menú.");
                break;
        }
        menu();
    }

    public static void menuBorrar()
    {
        System.out.println("-MENÚ ELIMINACIÓN-");
        System.out.println("1. Eliminar jugador");
        System.out.println("2. Eliminar equipo");
        System.out.println("3. Eliminar entrenador");
        System.out.println("4. Eliminar liga");
        System.out.println("5. Salir");
        System.out.println("------------------");

        switch (in.next())
        {
            case "1":
                openDB();
                jugador = buscarJugador();
                if (jugador!=null)
                {
                    database.delete(jugador);
                    System.out.println("Se ha eliminado el jugador.");
                    jugador = null;
                }
                saveAndCloseDB();
                break;
            case "2":
                openDB();
                equipo = buscarEquipo();
                if (entrenador!=null)
                {
                    database.delete(equipo);
                    System.out.println("Se ha eliminado el equipo.");
                    equipo = null;
                }
                saveAndCloseDB();
                break;
            case "3":
                openDB();
                entrenador = buscarEntrenador();
                if (entrenador!=null)
                {
                    database.delete(entrenador);
                    System.out.println("Se ha eliminado el entrenador.");
                    entrenador = null;
                }
                saveAndCloseDB();
                break;
            case "4":
                openDB();
                liga = buscarLiga();
                if (liga!=null)
                {
                    database.delete(liga);
                    System.out.println("Se ha eliminado la liga.");
                    liga = null;
                }
                saveAndCloseDB();
                break;
            case "5":
                break;
            default:
                break;
        }
        menu();
    }

    public static void menuMostrar()
    {
        System.out.println("-MENÚ VISUALIZACIÓN-");
        System.out.println("1. Visualizar jugador (características incluídas)");
        System.out.println("2. Visualizar equipo");
        System.out.println("3. Visualizar entrenador");
        System.out.println("4. Visualizar liga");
        System.out.println("5. Visualizar jugadores de un equipo");
        System.out.println("6. Visualizar jugadores de un equipo con fuerza menor o igual a 5");
        System.out.println("7. Visualizar jugadores de dos equipos");
        System.out.println("8. Visualizar jugadores de una liga");
        System.out.println("9. Visualizar equipos de una liga");
        System.out.println("0. Salir");
        System.out.println("------------------");

        switch (in.nextLine())
        {
            case "1":
                openDB();
                System.out.println(buscarJugador().toString());
                database.close();
                break;
            case "2":
                openDB();
                System.out.println(buscarEquipo().toString());
                database.close();
                break;
            case "3":
                openDB();
                System.out.println(buscarEntrenador().toString());
                database.close();
                break;
            case "4":
                openDB();
                System.out.println(buscarLiga().toString());
                database.close();
                break;
            case "5":
                openDB();
                jugadoresEquipo();
                database.close();
                break;
            case "6":
                openDB();
                jugadoresFuerzaMenor();
                database.close();
                break;
            case "7":
                System.out.println("Introduce el nombre del equipo 1");
                String nombre1 = in.nextLine();
                System.out.println("Introduce el nombre del equipo 2");
                String nombre2 = in.nextLine();
                jugadoresEquipoSoda(nombre1);
                jugadoresEquipoSoda(nombre2);
                break;
            case "8":
                openDB();
                jugadoresLiga();
                database.close();
                break;
            case "9":
                openDB();
                equiposLiga();
                database.close();
                break;
            case "0":
                break;
            default:
                break;
        }
        menu();
    }

    private static void menuOtrasOpciones()
    {
        System.out.println("-MENÚ OTRAS OPCIONES-");
        System.out.println("1. Traspasar jugador");
        System.out.println("2. Aumentar características de jugador");
        System.out.println("3. Cambiar equipo de liga");
        System.out.println("4. Cambiar entrenador de equipo");
        System.out.println("5. Cambiar patrocinador de liga");
        System.out.println("6. Salir");
        System.out.println("---------------------");

        switch (in.nextLine())
        {
            case "1":
                openDB();
                traspasarJugador();
                saveAndCloseDB();
                break;
            case "2":
                openDB();
                jugador = buscarJugador();
                System.out.println("Agilidad actual = "+jugador.getCaracteristicas().getAgilidad()+". Introduce la agilidad deseada:");
                byte agilidad = in.nextByte();
                System.out.println("Fuerza actual = "+jugador.getCaracteristicas().getFuerza()+". Introduce la fuerza deseada:");
                byte fuerza = in.nextByte();
                System.out.println("Velocidad actual = "+jugador.getCaracteristicas().getVelocidad()+". Introduce la velocidad deseada:");
                byte velocidad = in.nextByte();
                System.out.println("Resistencia actual = "+jugador.getCaracteristicas().getResistencia()+". Introduce la resistencia deseada:");
                byte resistencia = in.nextByte();
                System.out.println("Tiro actual = "+jugador.getCaracteristicas().getTiro()+". Introduce el tiro deseado:");
                byte tiro = in.nextByte();

                jugador.getCaracteristicas().modificarCaracteristicas(agilidad, fuerza, velocidad, resistencia, tiro);
                database.store(jugador);
                System.out.println("Se han modificado las características satisfactoriamente.");
                saveAndCloseDB();
                break;
            case "3":
                openDB();
                cambiarEquipoLiga();
                saveAndCloseDB();
                break;
            case "4":
                openDB();
                traspasarEntrenador();
                saveAndCloseDB();
                break;
            case "5":
                openDB();
                cambiarPatrocinador();
                saveAndCloseDB();
                break;
            case "6":
                break;
            default:
                System.out.println("Tu opción no coincide con ninguna opción del menú.");
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
        String altura = in.nextLine();

        jugador.setNombre(nombre);
        jugador.setApellido(apellido);
        jugador.setDni(dni);
        jugador.setAltura(Double.parseDouble(altura));

        System.out.println("CARACTERÍSTICAS DEL JUGADOR:");

        System.out.println("Introduzca la agilidad deseada:");
        byte agilidad = in.nextByte();
        System.out.println("Introduzca la fuerza deseada:");
        byte fuerza = in.nextByte();
        System.out.println("Introduzca la velocidad deseada:");
        byte velocidad = in.nextByte();
        System.out.println("Introduzca la resistencia deseada:");
        byte resistencia = in.nextByte();
        System.out.println("Introduzca el tiro deseado:");
        byte tiro = in.nextByte();
        jugador.setCaracteristicas(new Caracteristicas(agilidad, fuerza, velocidad, resistencia, tiro));

        System.out.println("Se ha creado el jugador correctamente.\n");

        return jugador;
    }

    public static Equipo crearEquipo(Equipo equipo)
    {
        System.out.println("Introduce el nombre del equipo:");
        String nombre = in.nextLine();
        System.out.println("Introduce nombre del estadio:");
        String estadio = in.nextLine();
        System.out.println("Introduce el nombre del entrenador:");
        Entrenador entrenador = elegirEntrenador();
        System.out.println("Introduce los jugadores del equipo:");
        ArrayList<Jugador> jugadores = elegirJugadores();

        equipo.setNombre(nombre);
        equipo.setEstadio(estadio);
        equipo.setEntrenador(entrenador);
        equipo.setJugadores(jugadores);

        System.out.println("Se ha creado el equipo correctamente.\n");
        return equipo;
    }

    public static Entrenador crearEntrenador(Entrenador entrenador)
    {
        System.out.println("Introduce el nombre del entrenador:");
        String nombre = in.nextLine();
        System.out.println("Introduce los años de experiencia:");
        String añosExp = in.nextLine();

        entrenador.setNombre(nombre);
        try {
            entrenador.setAñosExperiencia(Byte.parseByte(añosExp));
        } catch (NumberFormatException e) {
            System.out.println("Número mal introducido.");
        }
        System.out.println("Se ha creado el entrenador correctamente.\n");
        return entrenador;
    }

    public static Liga crearLiga(Liga liga)
    {
        System.out.println("Introduce el nombre de la liga:");
        String nombre = in.nextLine();
        System.out.println("Introduce el patrocinador de la liga:");
        String patrocinador = in.nextLine();
        System.out.println("Introduce la categoría de la liga:");
        String categoria = in.nextLine();
        System.out.println("Introduce los equipos de la liga:");
        ArrayList<Equipo> equipos = elegirEquipos();

        liga.setNombre(nombre);
        liga.setPatrocinador(patrocinador);
        try {
            liga.setCategoria(Byte.parseByte(categoria));
        } catch (NumberFormatException e) {
            System.out.println("Error al introducir la categoría");
        }
        liga.setEquipos(equipos);

        System.out.println("Se ha creado la liga correctamente.\n");
        return liga;
    }

    private static Entrenador elegirEntrenador() {
        try {
            ObjectSet<Entrenador> entrenadores = database.queryByExample(new Entrenador());
            ArrayList<Entrenador> entrenadoresSinEquipo= new ArrayList<>();

            for (Entrenador entrenadore : entrenadores)
            {
                if (!entrenadore.isTieneEquipo())
                {
                    System.out.println("Nombre = "+entrenadore.getNombre()+"\nAños de experiencia = "+entrenadore.getAñosExperiencia()+"\n");
                    entrenadoresSinEquipo.add(entrenadore);
                }
            }
            while (true) {
                if (entrenadoresSinEquipo.size()==0)
                {
                    throw new NullPointerException();
                }
                System.out.println("Existen "+entrenadoresSinEquipo.size()+" entrenadores registrados. Introduce el nombre del entrenador que quieres para tu equipo:");
                String nombre = in.nextLine();

                for (Entrenador entrenadore: entrenadoresSinEquipo)
                {
                   if (entrenadore.getNombre().equals(nombre))
                   {
                       return entrenadore;
                   }
                }
                System.out.println("Error. No has introducido el nombre correctamente.");
            }

        } catch (Db4oIOException | DatabaseClosedException e) {
            e.printStackTrace();
        }
        catch (NullPointerException npE)
        {
            System.out.println("Error. No hay entrenadores sin equipo en la base de datos.");
        }
        return null;
    }

    private static ArrayList<Jugador> elegirJugadores ()
    {
        try
        {
            ObjectSet<Jugador> jugadores = database.queryByExample(new Jugador());
            ArrayList<Jugador> jugadoresSinEquipo= new ArrayList<>();

            for (Jugador jugadore : jugadores)
            {
                if (!jugadore.isEnEquipo())
                {
                    System.out.println("Nombre = "+jugadore.getNombre()+"\nCaracterísticas = "+jugadore.getCaracteristicas().toString()+"\n");
                    jugadoresSinEquipo.add(jugadore);
                }
            }
            if (jugadoresSinEquipo.size()==0)
            {
                throw new NullPointerException();
            }
            System.out.println("Existen "+jugadoresSinEquipo.size()+" jugadores registrados. Introduce el nombre del jugador que quieres para tu equipo:");

            String nombre = in.nextLine();
            ArrayList<Jugador> jugadoresEquipo = new ArrayList<>();
            boolean added = false;
            while (true) {

                for (Jugador jugadore: jugadoresSinEquipo)
                {
                    if (jugadore.getNombre().equals(nombre))
                    {
                        jugadoresEquipo.add(jugadore);
                        jugadoresSinEquipo.remove(jugadore);
                        jugadore.setEnEquipo(true);
                        System.out.println("Jugador añadido correctamente.\n");
                        added = true;
                        break;
                    }
                }
                if (!added)
                {
                    System.out.println("Error. No has introducido el nombre correctamente.");
                }
                if (jugadoresSinEquipo.size()==0)
                {
                    System.out.println("No quedan más jugadores sin equipo. No puedes añadir más por ahora.");
                    return jugadoresEquipo;
                }
                else
                {
                    System.out.println("\nIntroduce el nombre del siguiente jugador que quieras añadir o '0' para dejar de añadir");
                    nombre = in.nextLine();
                    if (nombre.equals("0"))
                    {
                        return jugadoresEquipo;
                    }
                }
            }
    }
        catch (Db4oIOException | DatabaseClosedException e) {
        e.printStackTrace();
    }
        catch (NullPointerException npE)
    {
        System.out.println("Error. No hay jugadores sin equipo en la base de datos.");
    }
        return null;
    }

    private static ArrayList<Equipo> elegirEquipos() {
        try
        {
            ObjectSet<Equipo> equipos = database.queryByExample(new Equipo());
            ArrayList<Equipo> equiposSinLiga = new ArrayList<>();

            for (Equipo equipoe : equipos)
            {
                if (!equipoe.isEnLiga())
                {
                    System.out.println("Nombre = "+equipoe.getNombre()+"\n");
                    equiposSinLiga.add(equipoe);
                }
            }
            if (equiposSinLiga.size()==0)
            {
                throw new NullPointerException();
            }
            System.out.println("Existen "+equiposSinLiga.size()+" equipos registrados. Introduce el nombre del equipo que quieres para tu liga:");

            String nombre = in.nextLine();
            ArrayList<Equipo> EquiposLiga = new ArrayList<>();
            boolean added = false;
            while (true) {

                for (Equipo equipoe: equiposSinLiga)
                {
                    if (equipoe.getNombre().equals(nombre))
                    {
                        EquiposLiga.add(equipoe);
                        equiposSinLiga.remove(equipoe);
                        equipoe.setEnLiga(true);
                        System.out.println("Equipo añadido correctamente.");
                        added = true;
                        break;
                    }
                }
                if (!added)
                {
                    System.out.println("Error. No has introducido el nombre correctamente.");
                }
                if (equiposSinLiga.size()==0)
                {
                    System.out.println("No quedan más equipos sin liga. No puedes añadir más por ahora.");
                    return EquiposLiga;
                }
                else
                {
                    System.out.println("\nIntroduce el nombre del siguiente jugador que quieras añadir o '0' para dejar de añadir");
                    nombre = in.nextLine();
                    if (nombre.equals("0"))
                    {
                        return EquiposLiga;
                    }
                }
            }
        }
        catch (Db4oIOException | DatabaseClosedException e) {
            e.printStackTrace();
        }
        catch (NullPointerException npE)
        {
            System.out.println("Error. No hay equipos sin liga en la base de datos.");
        }
        return null;
    }

    public static Jugador buscarJugador()
    {
        System.out.println("Introduce el DNI del jugador:");
        String dni = in.next();
        Jugador jugador = null;
        try
        {
            ObjectSet<Jugador> jugadores = database.queryByExample(new Jugador());

            for (Jugador jugadore : jugadores) {
                if (jugadore.getDni().equals(dni)) {
                    jugador = jugadore;
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

    public static Entrenador buscarEntrenador()
    {
        System.out.println("Introduce el nombre del entrenador:");
        String nombre = in.nextLine();
        Entrenador entrenador = null;
        try
        {
            ObjectSet<Entrenador> entrenadores = database.queryByExample(new Entrenador());

            for (Entrenador entrenadore : entrenadores) {
                if (entrenadore.getNombre().equals(nombre)) {
                    entrenador = entrenadore;
                    return entrenador;
                }
            }
            System.out.println("No se ha encontrado el entrenador: "+nombre);
        }
        catch (NullPointerException e)
        {
            System.out.println("No hay ningún entrenador registrado en la base de datos.");
        }
        finally {
            return entrenador;
        }
    }

    public static Equipo buscarEquipo()
    {
        System.out.println("Introduce el nombre del equipo:");
        String nombre = in.nextLine();
        Equipo equipo = null;
        try
        {
            ObjectSet<Equipo> equipos = database.queryByExample(new Equipo());

            for (Equipo equipoe : equipos) {
                if (equipoe.getNombre().equals(nombre)) {
                    equipo = equipoe;
                    return equipo;
                }
            }
            System.out.println("No se ha encontrado el equipo: "+nombre);
        }
        catch (NullPointerException e)
        {
            System.out.println("No hay ningún equipo registrado en la base de datos.");
        }
        finally {
            return equipo;
        }
    }

    public static Liga buscarLiga()
    {
        System.out.println("Introduce el nombre de la liga:");
        String nombre = in.nextLine();
        Liga liga = null;
        try
        {
            ObjectSet<Liga> ligas = database.queryByExample(new Liga());

            for (Liga ligae : ligas) {
                if (ligae.getNombre().equals(nombre)) {
                    liga = ligae;
                    return liga;
                }
            }
            System.out.println("No se ha encontrado la liga: "+nombre);
        }
        catch (NullPointerException e)
        {
            System.out.println("No hay ninguna liga registrada en la base de datos.");
        }
        finally {
            return liga;
        }
    }

    public static void jugadoresEquipo()
    {
        Equipo equipo = buscarEquipo();
        if (equipo!=null)
        {
            for (Jugador jugadore: equipo.getJugadores())
            {
                System.out.println("Nombre = "+jugadore.getNombre());
            }
        }
    }

    public static void jugadoresEquipoSoda(String nombreEquipo)
    {
        Query query = database.query();
        query.constrain(Equipo.class);
        query.descend("nombre").constrain(nombreEquipo);

        ObjectSet<Equipo> equipos = query.execute();
        if (equipos!=null)
        {
            for (Equipo equipoe: equipos) {
                for (int i = 0; i < equipoe.getJugadores().size(); i++)
                {
                    System.out.println(equipoe.getJugadores().get(i).toString());
                }
            }
        }
    }

    public static void jugadoresFuerzaMenor()
    {
        Equipo equipo = buscarEquipo();
        if (equipo!=null)
        {
            for (Jugador jugadore: equipo.getJugadores())
            {
                if (jugadore.getCaracteristicas().getFuerza()<=5)
                {
                    System.out.println("Nombre = "+jugadore.getNombre());
                }
            }
        }
    }

    public static void jugadoresLiga()
    {
        Liga liga = buscarLiga();

        if (liga!=null)
        {
            for (int i = 0; i < liga.getEquipos().size(); i++) {
                for (int e = 0; e < liga.getEquipos().get(i).getJugadores().size(); e++)
                {
                    System.out.println(liga.getEquipos().get(i).getJugadores().get(e).toString());
                }
            }
        }
    }

    public static void equiposLiga()
    {
        Liga liga = buscarLiga();

        if (liga!=null)
        {
            for (int i = 0; i < liga.getEquipos().size(); i++) {
                System.out.println("Equipo = "+liga.getEquipos().get(i).getNombre());
            }
        }
    }

    public static void traspasarJugador()
    {
        System.out.println("Introduce el nombre del jugador que quieres traspasar:");
        String nombre = in.nextLine();
        System.out.println("Introduce el nombre de su nuevo equipo:");
        String nombreEquipo = in.nextLine();
        int iterator = -1;
        try
        {
            ObjectSet<Equipo> equipos = database.queryByExample(new Equipo());

            for (int i = 0; i < equipos.size(); i++)
            {
                if (equipos.get(i).getNombre().equals(nombre))
                {
                    iterator = i;
                }
            }
            if (iterator!=-1) {
                for (Equipo equipoe : equipos) {
                    for (int i = 0; i < equipoe.getJugadores().size(); i++) {
                        if (equipoe.getJugadores().get(i).getNombre().equals(nombre)) {
                            equipos.get(iterator).getJugadores().add(equipoe.getJugadores().get(i));
                            equipoe.getJugadores().remove(i);
                            database.store(equipos);
                        }
                    }
                }
            }
            else
            {
                System.out.println("No se ha encontrado el equipo destinatario");
            }
            System.out.println("No se ha encontrado el equipo: "+nombre);
        }
        catch (NullPointerException e)
        {
            System.out.println("No hay ningún equipo registrado en la base de datos.");
        }
    }

    public static void cambiarEquipoLiga()
    {
        System.out.println("Introduce el nombre del equipo que quieres cambiar de liga:");
        String nombre = in.nextLine();
        System.out.println("Introduce el nombre de su nueva liga:");
        String nombreLiga = in.nextLine();
        int iterator = -1;
        try
        {
            ObjectSet<Liga> ligas = database.queryByExample(new Liga());

            for (int i = 0; i < ligas.size(); i++)
            {
                if (ligas.get(i).getNombre().equals(nombreLiga))
                {
                    iterator = i;
                }
            }
            if (iterator!=-1) {
                for (Liga ligae : ligas) {
                    for (int i = 0; i < ligae.getEquipos().size(); i++) {
                        if (ligae.getEquipos().get(i).getNombre().equals(nombre)) {
                            ligas.get(iterator).getEquipos().add(ligae.getEquipos().get(i));
                            ligae.getEquipos().remove(i);
                            database.store(ligas);
                        }
                    }
                }
            }
            else
            {
                System.out.println("No se ha encontrado la liga destinataria");
            }
            System.out.println("No se ha encontrado la liga: "+nombre);
        }
        catch (NullPointerException e)
        {
            System.out.println("No hay ninguna liga registrada en la base de datos.");
        }
    }

    public static void traspasarEntrenador()
    {
        System.out.println("Introduce el nombre del entrenador que quieres traspasar:");
        String nombre = in.nextLine();
        System.out.println("Introduce el nombre de su nuevo equipo:");
        String nombreEquipo = in.nextLine();
        int iterator = -1;
        try
        {
            ObjectSet<Equipo> equipos = database.queryByExample(new Equipo());

            for (int i = 0; i < equipos.size(); i++)
            {
                if (equipos.get(i).getNombre().equals(nombreEquipo))
                {
                    iterator = i;
                }
            }
            if (iterator!=-1) {
                for (Equipo equipoe : equipos) {
                    if (equipoe.getEntrenador().getNombre().equals(nombre)) {
                        equipos.get(iterator).setEntrenador(equipoe.getEntrenador());
                        equipoe.setEntrenador(null);
                        database.store(equipos);
                    }
                }
            }
            else
            {
                System.out.println("No se ha encontrado la liga destinataria");
            }
            System.out.println("No se ha encontrado la liga: "+nombre);
        }
        catch (NullPointerException e)
        {
            System.out.println("No hay ninguna liga registrada en la base de datos.");
        }
    }

    public static void cambiarPatrocinador()
    {
        System.out.println("Introduce el nombre de la liga que quieres modificar:");
        String nombre = in.nextLine();
        System.out.println("Introduce el nombre de su nuevo patrocinador:");
        String nuevoPatrocinador = in.nextLine();

        try
        {
            ObjectSet<Liga> ligas = database.queryByExample(new Liga());

            for (Liga ligae: ligas)
            {
                if (ligae.getNombre().equals(nombre))
                {
                    ligae.setPatrocinador(nuevoPatrocinador);
                    database.store(ligae);
                }
            }
        }
        catch (NullPointerException e)
        {
            System.out.println("No hay ninguna liga registrada en la base de datos.");
        }
    }
}