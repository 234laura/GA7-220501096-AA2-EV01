package sena.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Lau
 */
public class CreateUser {
        public static void createUser(Connection connection) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese el nombre de usuario: ");
            String username = scanner.nextLine();
            System.out.print("Ingrese el correo electrónico: ");
            String email = scanner.nextLine();
            System.out.print("Ingrese la contraseña: ");
            String password = scanner.nextLine();

            // Preparar la consulta SQL para insertar un nuevo usuario
            String sql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, email);
            statement.setString(3, password);

            // Ejecutar la consulta
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Usuario creado exitosamente.");
            } else {
                System.out.println("No se pudo crear el usuario.");
            }
        } catch (SQLException e) {
            System.out.println("Error al crear el usuario: " + e.getMessage());
        }
 }
}

