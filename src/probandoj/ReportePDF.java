/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package probandoj;

/**
 *
 * @author bmade
 */
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.sql.*;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;

public class ReportePDF {

    private static final String URL = "jdbc:mysql://localhost:3306/registrousuario"; // Cambiar según sea necesario
    private static final String USER = "root";
    private static final String PASSWORD = "utesamao";

    public static void generarReporte() {
        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Conectar a la base de datos
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = connection.createStatement();
            String query = "SELECT * FROM usuarios";
            rs = stmt.executeQuery(query);

            // Crear documento PDF
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("reporte_usuarios.pdf"));
            document.open();

            // Título del reporte
            Paragraph title = new Paragraph("Reporte de Usuarios", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16));
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            // Crear tabla con 9 columnas
            PdfPTable table = new PdfPTable(9);
            table.setWidthPercentage(100);

            // Añadir encabezados
            table.addCell("ID");
            table.addCell("Nombres");
            table.addCell("Apellidos");
            table.addCell("Usuario");
            table.addCell("Contraseña");
            table.addCell("Departamento");
            table.addCell("Estado");
            table.addCell("Nivel");
            table.addCell("Fecha");

            // Llenar la tabla con los datos de la base de datos
            while (rs.next()) {
                table.addCell(String.valueOf(rs.getInt("id")));
                table.addCell(rs.getString("nombres"));
                table.addCell(rs.getString("apellidos"));
                table.addCell(rs.getString("usuarios"));
                table.addCell(rs.getString("password"));
                table.addCell(rs.getString("departamento"));
                table.addCell(rs.getString("estado"));
                table.addCell(rs.getString("nivel"));
                table.addCell(rs.getString("fecha"));
            }

            // Añadir la tabla al documento
            document.add(table);

            // Cerrar el documento
            document.close();
            System.out.println("PDF creado Correctamente!!");
            JOptionPane.showMessageDialog(null, "Reporte generado correctamente.");
        } catch (DocumentException | HeadlessException | FileNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al generar el reporte: " + e.getMessage());
        } finally {
            // Cerrar recursos
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
            }
        }
    }
}
