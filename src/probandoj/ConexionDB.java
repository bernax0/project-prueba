/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package probandoj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {//hola

    // Parámetros de la conexión
    private static final String URL = "jdbc:mysql://localhost:3306/registrousuario"; // Cambia 'localhost' si el servidor es diferente
    private static final String USER = "root"; // Nombre de usuario de la base de datos
    private static final String PASSWORD = "utesamao"; // Contraseña de la base de datos

    private Connection connection;

    // Método para conectar a la base de datos
    public Connection conectar() {
        try {
            // Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexión
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos.");
            return connection;
        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se encontró el driver de MySQL.");
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
        return null;
    }

    // Método para cerrar la conexión
    public void cerrar() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Conexión cerrada.");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }

    // Método principal para probar la conexión
    public static void main(String[] args) {
        ConexionDB db = new ConexionDB();
        Connection conn = db.conectar(); // Conectar

        if (conn != null) {
            db.cerrar(); // Cerrar la conexión si fue exitosa
        }
    }
}
