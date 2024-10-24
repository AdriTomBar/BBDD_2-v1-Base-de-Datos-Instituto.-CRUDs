import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import Services.*;
import data.*;

public class Main {

    public final static String URL = "jdbc:mysql://localhost:3306/instituto";
    public final static String USER = "adrian";
    public final static String PASSWORD = "mysqlAdmin";

    public static void main(String[] args) {
        ServicioAlumno servicioAlumno = new ServicioAlumno();
        ServicioEdificio servicioEdificio = new ServicioEdificio();
        ServicioAula servicioAula = new ServicioAula();
        ServicioDepartamento servicioDepartamento = new ServicioDepartamento();
        ServicioCurso servicioCurso = new ServicioCurso();
        ServicioTurno servicioTurno = new ServicioTurno();

        try (Scanner sc = new Scanner(System.in)) {
            DaoAlumno daoAlumno = new DaoAlumno();
            probarConexion();
            while (true) {
                System.out.println("\n-----Introduzca una opción para operar con los siguientes datos: -----" + //
                        "\r\n" + //
                        "\r\n" + "\n1. Alumno\r\n" + //
                        "\r\n" + //
                        "2. Departamento\r\n" + //
                        "\r\n" + //
                        "3. Edificio\r\n" + //
                        "\r\n" + //
                        "4. Aula\r\n" + //
                        "\r\n" + //
                        "5. Curso\r\n" + //
                        "\r\n" + //
                        "6. Turno\r\n" + //
                        "\r\n" + //
                        "0. Salir");
                int eleccion = sc.nextInt();

                switch (eleccion) {
                    case 1:
                        clearConsole();
                        System.out.println("\n-----Elija una opcion para Alumno: -----" +
                                "\n Insertar: 1" +
                                "\n Leer: 2" +
                                "\n Actualizar: 3" +
                                "\n Eliminar: 4" +
                                "\n Salir: 0");

                        switch (sc.nextInt()) {

                            case 1:
                                System.out.println("Insertar alumno");
                                servicioAlumno.create(daoAlumno.crearAlumno());
                                break;
                            case 2:
                                System.out.println("Leer alumno");
                                System.out.println("Introduzca el nrp del alumno a buscar");
                                System.out.println(servicioAlumno.read(sc.next()));
                                break;
                            case 3:
                                System.out.println("Actualizar alumno");
                                servicioAlumno.update(daoAlumno.crearAlumno());
                                break;
                            case 4:
                                System.out.println("Eliminar alumno");
                                servicioAlumno.delete(sc.next());
                                break;
                            default:
                                System.out.println("Opción no válida");
                                break;
                        }
                        break;

                    case 2:
                        clearConsole();
                        DaoDepartamento daoDepartamento = new DaoDepartamento();
                        System.out.println("\nElija una opcion para Departamento: " +
                                "\n Insertar: 1" +
                                "\n Leer: 2" +
                                "\n Actualizar: 3" +
                                "\n Eliminar: 4"
                                + "\n Salir: 0");

                        switch (sc.nextInt()) {
                            case 1:
                                System.out.println("Insertar departamento");
                                servicioDepartamento.create(daoDepartamento.crearDepartamento());
                                break;
                            case 2:
                                System.out.println("Leer departamento");
                                System.out.println("Introduzca el codigo del departamento a buscar");
                                System.out.println(servicioDepartamento.read(sc.next()));
                                break;
                            case 3:
                                System.out.println("Actualizar departamento");
                                System.out.println("Introduzca los datos del departamento a actualizar");
                                Departamento departamentoUpdate = daoDepartamento.crearDepartamento();
                                servicioDepartamento.update(departamentoUpdate);
                                System.out.println("----Departamento actualizado----");
                                break;
                            case 4:

                                System.out.println("Eliminar departamento");
                                System.err.println("Introduzca el codigo del departamento a eliminar");
                                servicioDepartamento.delete(sc.next());
                                break;
                            default:
                                System.out.println("Opción no válida");
                                break;
                        }
                        break;

                    case 3:
                        clearConsole();
                        DaoEdificio edificio = new DaoEdificio();
                        System.out.println("\nElija una opcion para Edificio: " +
                                "\n Insertar: 1" +
                                "\n Leer: 2" +
                                "\n Actualizar: 3" +
                                "\n Eliminar: 4"
                                + "\n Salir: 0");

                        switch (sc.nextInt()) {
                            case 1:
                                System.out.println("Insertar edificio");
                                servicioEdificio.create(edificio.crearEdificio());
                                break;
                            case 2:
                                System.out.println("Leer edificio");
                                System.out.println("Introduzca el codigo del edificio a buscar");
                                System.out.println(servicioEdificio.read(sc.next()));
                                break;
                            case 3:
                                System.out.println("Actualizar edificio");
                                System.out.println("Introduzca los datos del edificio a actualizar");
                                edificio.crearEdificio();
                                servicioEdificio.update(edificio.crearEdificio());
                                break;
                            case 4:
                                System.out.println("Eliminar edificio");
                                System.err.println("Introduzca el codigo del edificio a eliminar");
                                servicioAlumno.delete(sc.next());
                                break;
                            default:
                                System.out.println("Opción no válida");
                                break;
                        }
                    case 4:
                        clearConsole();
                        DaoAula daoAula = new DaoAula();
                        System.out.println("\nElija una opcion para Aula: " +
                                "\n Insertar: 1" +
                                "\n Leer: 2" +
                                "\n Actualizar: 3" +
                                "\n Eliminar: 4"
                                + "\n Salir: 0");

                        switch (sc.nextInt()) {
                            case 1:
                                System.out.println("Insertar aula");
                                servicioAula.create(daoAula.crearAula());
                                break;
                            case 2:
                                System.out.println("Leer aula");
                                System.out.println("Introduzca el numero del aula a buscar");
                                System.out.println(servicioAula.read(sc.next()));
                                break;
                            case 3:
                                System.out.println("Actualizar aula");
                                System.out.println("Introduzca los datos del aula a actualizar");
                                servicioAula.update(daoAula.crearAula());
                                break;
                            case 4:
                                System.out.println("Eliminar aula");
                                System.err.println("Introduzca el numero del aula a eliminar");
                                servicioAula.delete(sc.next());
                                break;
                            default:
                                System.out.println("Opción no válida");
                                break;
                        }
                    case 5:
                        clearConsole();
                        DaoCurso daoCurso = new DaoCurso();
                        System.out.println("\nElija una opcion para Curso: " +
                                "\n Insertar: 1" +
                                "\n Leer: 2" +
                                "\n Actualizar: 3" +
                                "\n Eliminar: 4"
                                + "\n Salir: 0");

                        switch (sc.nextInt()) {
                            case 1:
                                System.out.println("Insertar curso");
                                servicioCurso.create(daoCurso.crearCurso());
                                break;
                            case 2:
                                System.out.println("Leer curso");
                                System.out.println("Introduzca el codigo del curso a buscar");
                                System.out.println(servicioCurso.read(sc.next()));
                                break;
                            case 3:
                                System.out.println("Actualizar curso");
                                System.out.println("Introduzca los datos del curso a actualizar");
                                servicioCurso.update(daoCurso.crearCurso());
                                break;
                            case 4:
                                System.out.println("Eliminar curso");
                                System.err.println("Introduzca el codigo del curso a eliminar");
                                servicioCurso.delete(sc.next());
                                break;
                            default:
                                System.out.println("Opción no válida");
                                break;
                        }
                    case 6:
                        clearConsole();
                        DaoTurno daoTurno = new DaoTurno();
                        System.out.println("\nElija una opcion para Turno: " +
                                "\n Insertar: 1" +
                                "\n Leer: 2" +
                                "\n Actualizar: 3" +
                                "\n Eliminar: 4"
                                + "\n Salir: 0");

                        switch (sc.nextInt()) {

                            case 1:
                                System.out.println("Insertar turno");
                                servicioTurno.create(daoTurno.crearTurno());
                                break;
                            case 2:
                                System.out.println("Leer turno");
                                System.out.println("Introduzca el codigo del turno a buscar");
                                System.out.println(servicioTurno.read(sc.next()));
                                break;
                            case 3:
                                System.out.println("Actualizar turno");
                                System.out.println("Introduzca los datos del turno a actualizar");
                                servicioTurno.update(daoTurno.crearTurno());
                                break;
                            case 4:
                                System.out.println("Eliminar turno");
                                System.err.println("Introduzca el codigo del turno a eliminar");
                                servicioTurno.delete(sc.next());
                                break;
                            default:
                                System.out.println("Opción no válida");
                                break;
                        }
                    case (0):
                        clearConsole();
                        System.out.println("Saliendo del programa...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }

            }
        }

    }

    private static void clearConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void probarConexion() {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Conexión exitosa a la base de datos");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}