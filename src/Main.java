import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import data.DaoAlumno;
import data.DaoDepartamento;
import data.models.Alumno;
import data.models.Departamento;

public class Main {

    public final static String URL = "jdbc:mysql://localhost:3306/instituto";
    public final static String USER = "adrian";
    public final static String PASSWORD = "mysqlAdmin";

    public static void main(String[] args) {
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

                        int eleccionAlumno = sc.nextInt();

                        switch (eleccionAlumno) {

                            case 1:
                                System.out.println("Insertar alumno");
                                Alumno alumno = daoAlumno.crearAlumno();
                                daoAlumno.create(alumno);
                                break;
                            case 2:
                                System.out.println("Leer alumno");
                                System.out.println("Introduzca el nrp del alumno a buscar");
                                String nrp = sc.next();
                                System.out.println(daoAlumno.read(nrp));
                                break;
                            case 3:
                                System.out.println("Actualizar alumno");
                                System.out.println("Introduzca los datos del alumno a actualizar");
                                Alumno alumnoUpdate = daoAlumno.crearAlumno();
                                daoAlumno.update(alumnoUpdate);
                                System.out.println("----Alumno actualizado----");
                                System.out.println(alumnoUpdate);
                                break;
                            case 4:
                                System.out.println("Eliminar alumno");
                                System.err.println("Introduzca el nre del alumno a eliminar");
                                String nreDelete = sc.next();
                                daoAlumno.delete(nreDelete);
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

                        sc.nextLine();
                        int eleccionDep = sc.nextInt();
                        sc.nextLine();
                        switch (eleccionDep) {
                            case 1:
                                System.out.println("Insertar departamento");
                                Departamento departamento = daoDepartamento.crearDepartamento();
                                daoDepartamento.create(departamento);
                                break;
                            case 2:
                                System.out.println("Leer departamento");
                                System.out.println("Introduzca el codigo del departamento a buscar");
                                String cod = sc.nextLine();
                                System.out.println(daoDepartamento.read(cod));
                                break;
                            case 3:
                                System.out.println("Actualizar departamento");
                                System.out.println("Introduzca los datos del departamento a actualizar");
                                Departamento departamentoUpdate = daoDepartamento.crearDepartamento();
                                daoDepartamento.update(departamentoUpdate);
                                System.out.println("----Departamento actualizado----");
                                System.out.println(departamentoUpdate);
                                break;
                            case 4:

                                System.out.println("Eliminar departamento");
                                System.err.println("Introduzca el codigo del departamento a eliminar");
                                String codDelete = sc.nextLine();
                                daoDepartamento.delete(codDelete);
                                break;
                            default:
                                System.out.println("Opción no válida");
                                break;
                        }
                        break;

                    case 3:
                        clearConsole();
                    case 4:
                        clearConsole();
                    case 5:
                        clearConsole();
                    case 6:
                        clearConsole();
                    case 7:
                        clearConsole();

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