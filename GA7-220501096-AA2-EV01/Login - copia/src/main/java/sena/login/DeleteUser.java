
package sena.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Lau
 */
public class DeleteUser {
    public static void deleteUser(Connection connection) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese el nombre de usuario a eliminar: ");
            String username = scanner.nextLine();

            String sql = "DELETE FROM users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Usuario eliminado exitosamente.");
            } else {
                System.out.println("No se encontró ningún usuario con ese nombre.");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar el usuario: " + e.getMessage());
        }
    }
}
