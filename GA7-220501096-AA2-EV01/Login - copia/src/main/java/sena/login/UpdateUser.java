
package sena.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Lau
 */
public class UpdateUser {
    public static void updateUser(Connection connection) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese el nombre de usuario que desea actualizar: ");
            String username = scanner.nextLine();

            // Verificar si el usuario existe antes de actualizar
            if (!checkUserExists(connection, username)) {
                System.out.println("El usuario no existe en la base de datos.");
                return;
            }

            System.out.print("Ingrese el nuevo correo electrónico: ");
            String newEmail = scanner.nextLine();
            System.out.print("Ingrese la nueva contraseña: ");
            String newPassword = scanner.nextLine();

            // Preparar la consulta SQL para actualizar la información del usuario
            String sql = "UPDATE users SET email = ?, password = ? WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, newEmail);
            statement.setString(2, newPassword);
            statement.setString(3, username);

            // Ejecutar la consulta
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Usuario actualizado exitosamente.");
            } else {
                System.out.println("No se pudo actualizar el usuario.");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar el usuario: " + e.getMessage());
        }
    }

    private static boolean checkUserExists(Connection connection, String username) throws SQLException {
        String sql = "SELECT * FROM users WHERE username = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);
        return statement.executeQuery().next();
    }
}
