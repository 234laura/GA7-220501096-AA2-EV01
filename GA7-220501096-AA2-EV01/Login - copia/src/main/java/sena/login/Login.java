package sena.login;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;


/**
 *
 * @author Lau
 */


public class Login {

    private static Object UserCreator;

    public static void main(String[] args) throws SQLException {

        ConnectionMysql connectionmysql = new ConnectionMysql();
        Connection connectionbd;
        connectionbd = connectionmysql.connectMysql();

        
        if ( connectionbd != null){
            System.out.println("Conexión establecida");
            Scanner scanner = new Scanner(System.in);
            CreateUser createUser = new CreateUser();
            ReadUser readUser = new ReadUser();
            UpdateUser updateUser = new UpdateUser();
            DeleteUser deleteUser = new DeleteUser();
                boolean exit = false;

                while (!exit) {
                    System.out.println("Menú de opciones:");
                    System.out.println("1. Crear usuario");
                    System.out.println("2. Mostrar usuario");
                    System.out.println("3. Actualizar usuario");
                    System.out.println("4. Eliminar usuario");
                    System.out.println("5. Salir");
                    System.out.print("Seleccione una opción: ");
                    int choice = scanner.nextInt();

                    switch (choice) {
                        case 1:
                            CreateUser.createUser(connectionbd);
                            break;
                        case 2:
                            ReadUser.readUser(connectionbd);
                            break;
                        case 3:
                            UpdateUser.updateUser(connectionbd);
                            break;
                        case 4:
                            DeleteUser.deleteUser(connectionbd);
                            break;
                        case 5:
                            exit = true;
                            break;
                        default:
                            System.out.println("Opción no válida. Por favor, seleccione una opción del 1 al 5.");
                    }
                }
            connectionmysql.CloseConnectionMysql(connectionbd);
        } else {
            System.out.println("Error en conexión");
        }
    }
}
