
package sena.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Lau
 */
public class ReadUser {
    public static void readUser(Connection connection) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese el nombre de usuario que desea consultar: ");
            String username = scanner.nextLine();

            // Verificar si el usuario existe antes de consultar
            if (!checkUserExists(connection, username)) {
                System.out.println("El usuario no existe en la base de datos.");
                return;
            }

            // Preparar la consulta SQL para obtener la información del usuario
            String sql = "SELECT * FROM users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);

            // Ejecutar la consulta
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                System.out.println("Información del usuario:");
                System.out.println("Nombre de usuario: " + resultSet.getString("username"));
                System.out.println("Correo electrónico: " + resultSet.getString("email"));
                System.out.println("Contraseña: " + resultSet.getString("password"));
            } else {
                System.out.println("No se pudo obtener la información del usuario.");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la información del usuario: " + e.getMessage());
        }
    }

    private static boolean checkUserExists(Connection connection, String username) throws SQLException {
        String sql = "SELECT * FROM users WHERE username = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);
        ResultSet resultSet = statement.executeQuery();
        return resultSet.next();
    }
    
}
