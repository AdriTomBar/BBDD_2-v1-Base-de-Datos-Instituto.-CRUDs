

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import Services.*;
import data.*;
import data.models.Departamento;

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

        Scanner sc = new Scanner(System.in);
            probarConexion();

            while (true) {
                mostrarMenuPrincipal();
                int eleccion = sc.nextInt();
                sc.nextLine();
                clearConsole();

                switch (eleccion) {
                    case 1 -> gestionarAlumno(sc, servicioAlumno);
                    case 2 -> gestionarDepartamento(sc, servicioDepartamento);
                    case 3 -> gestionarEdificio(sc, servicioEdificio);
                    case 4 -> gestionarAula(sc, servicioAula);
                    case 5 -> gestionarCurso(sc, servicioCurso);
                    case 6 -> gestionarTurno(sc, servicioTurno);
                    case 0 -> salirPrograma();
                    default -> System.out.println("Opción no válida");
                }
            }
        }
    

    private static void mostrarMenuPrincipal() {
        System.out.println("""
                \n-----Introduzca una opción para operar con los siguientes datos: -----
                1. Alumno
                2. Departamento
                3. Edificio
                4. Aula
                5. Curso
                6. Turno
                0. Salir
                """);
    }

    private static void gestionarAlumno(Scanner sc, ServicioAlumno servicioAlumno) {
        DaoAlumno daoAlumno = new DaoAlumno();
        mostrarMenuGestion("Alumno");
        int opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion) {
            case 1 -> servicioAlumno.create(daoAlumno.crearAlumno());
            case 2 -> {
                System.out.println("Introduzca el nrp del alumno a buscar");
                System.out.println(servicioAlumno.read(sc.next()));
            }
            case 3 -> servicioAlumno.update(daoAlumno.crearAlumno());
            case 4 -> {
                System.out.println("Introduzca el nrp del alumno a eliminar");
                servicioAlumno.delete(sc.next());
            }
            default -> System.out.println("Opción no válida");
        }
    }

    private static void gestionarDepartamento(Scanner sc, ServicioDepartamento servicioDepartamento) {
        DaoDepartamento daoDepartamento = new DaoDepartamento();
        mostrarMenuGestion("Departamento");
        int opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion) {
            case 1 -> servicioDepartamento.create(daoDepartamento.crearDepartamento());
            case 2 -> {
                System.out.println("Introduzca el código del departamento a buscar");
                System.out.println(servicioDepartamento.read(sc.next()));
            }
            case 3 -> servicioDepartamento.update(daoDepartamento.crearDepartamento());
            case 4 -> {
                System.out.println("Introduzca el código del departamento a eliminar");
                servicioDepartamento.delete(sc.next());
            }
            default -> System.out.println("Opción no válida");
        }
    }

    private static void gestionarEdificio(Scanner sc, ServicioEdificio servicioEdificio) {
        DaoEdificio daoEdificio = new DaoEdificio();
        mostrarMenuGestion("Edificio");
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1 -> servicioEdificio.create(daoEdificio.crearEdificio());
            case 2 -> {
                System.out.println("Introduzca el código del edificio a buscar");
                System.out.println(servicioEdificio.read(sc.next()));
            }
            case 3 -> servicioEdificio.update(daoEdificio.crearEdificio());
            case 4 -> {
                System.out.println("Introduzca el código del edificio a eliminar");
                servicioEdificio.delete(sc.next());
            }
            default -> System.out.println("Opción no válida");
        }
    }

    private static void gestionarAula(Scanner sc, ServicioAula servicioAula) {
        DaoAula daoAula = new DaoAula();
        mostrarMenuGestion("Aula");
        int opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion) {
            case 1 -> servicioAula.create(daoAula.crearAula());
            case 2 -> {
                System.out.println("Introduzca el número del aula a buscar");
                System.out.println(servicioAula.read(sc.next()));
            }
            case 3 -> servicioAula.update(daoAula.crearAula());
            case 4 -> {
                System.out.println("Introduzca el número del aula a eliminar");
                servicioAula.delete(sc.next());
            }
            default -> System.out.println("Opción no válida");
        }
    }

    private static void gestionarCurso(Scanner sc, ServicioCurso servicioCurso) {
        DaoCurso daoCurso = new DaoCurso();
        mostrarMenuGestion("Curso");
        int opcion = sc.nextInt();
        sc.nextLine();
        switch (opcion) {
            case 1 -> servicioCurso.create(daoCurso.crearCurso());
            case 2 -> {
                System.out.println("Introduzca el código del curso a buscar");
                System.out.println(servicioCurso.read(sc.next()));
            }
            case 3 -> servicioCurso.update(daoCurso.crearCurso());
            case 4 -> {
                System.out.println("Introduzca el código del curso a eliminar");
                servicioCurso.delete(sc.next());
            }
            default -> System.out.println("Opción no válida");
        }
    }

    private static void gestionarTurno(Scanner sc, ServicioTurno servicioTurno) {
        DaoTurno daoTurno = new DaoTurno();
        mostrarMenuGestion("Turno");
        int opcion = sc.nextInt();
        
        switch (opcion) {
            case 1 -> servicioTurno.create(daoTurno.crearTurno());
            case 2 -> {
                System.out.println("Introduzca el código del turno a buscar");
                System.out.println(servicioTurno.read(sc.next()));
            }
            case 3 -> servicioTurno.update(daoTurno.crearTurno());
            case 4 -> {
                System.out.println("Introduzca el código del turno a eliminar");
                servicioTurno.delete(sc.next());
            }
            default -> System.out.println("Opción no válida");
        }
    }

    private static void mostrarMenuGestion(String entidad) {
        System.out.printf("""
                \nElija una opción para %s:
                1. Insertar
                2. Leer
                3. Actualizar
                4. Eliminar
                0. Salir
                """, entidad);
    }

    private static void clearConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void probarConexion() {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Conexión exitosa a la base de datos");
        } catch (SQLException e) {
            System.err.println("Error en la conexión a la base de datos");
            e.printStackTrace();
        }
    }

    private static void salirPrograma() {
        System.out.println("Saliendo del programa...");
        System.exit(0);
    }
}

