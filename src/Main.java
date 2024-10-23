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
        Scanner sc = new Scanner(System.in);
        DaoAlumno daoAlumno = new DaoAlumno();
        probarConexion();
        while (true) {
            System.out.println("Introduzca una opción para operar con los siguientes datos:"+ //
                                "\r\n" + //
                                "\r\n"+"1. Alumno\r\n" + //
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
                                "0. Salir"
                                    );
            int eleccion = sc.nextInt();

            switch (eleccion) {
                case 1:
                    System.out.println("Elija una opcion: "+
                                        "\n Insertar: 1"+
                                        "\n Leer: 2"+
                                        "\n Actualizar: 3"+
                                        "\n Eliminar: 4");

                    int eleccionAlumno = sc.nextInt();

                    switch (eleccionAlumno) {
                        
                        case 1:
                            System.out.println("Insertar alumno");
                            Alumno alumno = new Alumno();
                            System.out.println("Intruduzca un nrp");
                            alumno.setNrp(sc.next());
                            System.out.println("Intruduzca un nombre");
                            alumno.setNombre(sc.next());
                            System.out.println("Intruduzca un apellido1");
                            alumno.setApellido1(sc.next());
                            System.out.println("Intruduzca un apellido2");
                            alumno.setApellido2(sc.next());
                            System.out.println("Intruduzca un dni");
                            alumno.setDni(sc.next());
                            System.out.println("Intruduzca un tipo_via");
                            alumno.setTipo_via(sc.next());
                            System.out.println("Intruduzca un nombre_via");
                            alumno.setNombre_via(sc.next());
                            System.out.println("Intruduzca un numero");
                            alumno.setNumero(sc.next());
                            System.out.println("Intruduzca un escalera");
                            alumno.setEscalera(sc.next());
                            System.out.println("Intruduzca un piso");
                            alumno.setPiso(sc.next());
                            System.out.println("Intruduzca un puerta");
                            alumno.setPuerta(sc.next());
                            System.out.println("Intruduzca un cp");
                            alumno.setCp(sc.next());
                            System.out.println("Intruduzca un pais");
                            alumno.setPais(sc.next());
                            System.out.println("Intruduzca un tlfn_fijo");
                            alumno.setTlfn_fijo(sc.next());
                            System.out.println("Intruduzca un tlfn_movil");
                            alumno.setTlfn_movil(sc.next());
                            System.out.println("Intruduzca un email");
                            alumno.setEmail(sc.next());
                            System.out.println("Intruduzca un fecha_nac");
                            alumno.setFecha_nac(sc.next());
                            System.out.println("Intruduzca un cod_departamento");
                            alumno.setCod_departamento(sc.next());
                            daoAlumno.create(alumno);
                            break;
                        case 2:
                            System.out.println("Leer alumno");
                            System.out.println("Introduzca el nrp del alumno a buscar");
                            String nrp = sc.next();
                            daoAlumno.read(nrp);
                            break;
                        case 3:
                            System.out.println("Actualizar alumno");
                            System.out.println("Introduzca el nrp del alumno a actualizar");
                            String nrpUpdate = sc.next();
                            Alumno alumnoUpdate = daoAlumno.read(nrpUpdate);
                            
                            break;
                        case 4:
                            System.out.println("Eliminar alumno");
                            break;
                        default:
                            System.out.println("Opción no válida");
                            break;
                    }
                    
                    break;
                
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:

                case (0):
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                    break;
                default:
                   System.out.println("Opción no válida");
                   break;
            }

        }
        
    }
    
    private static void probarConexion(){
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Conexión exitosa a la base de datos"); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}