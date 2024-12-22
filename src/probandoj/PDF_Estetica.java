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
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import javax.swing.JOptionPane;

public class PDF_Estetica {

    // Constantes de conexión a la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/registrousuario";
    private static final String USER = "root";
    private static final String PASSWORD = "utesamao";

    // Ruta donde se guardará el PDF
    private static final String PDF_PATH = "C:\\Users\\bmade\\Documents\\NetBeansProjects\\ProbandoJ\\PDF_Estetica.pdf";

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
            Document document = new Document(PageSize.A4, 50, 50, 50, 50);
            PdfWriter.getInstance(document, new FileOutputStream(PDF_PATH));
            document.open();

            // Título del reporte
            Paragraph title = new Paragraph("Reporte de Usuarios", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20, BaseColor.DARK_GRAY));
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingAfter(20);
            document.add(title);

            // Crear tabla con 7 columnas
            PdfPTable table = new PdfPTable(7);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10);
            table.setSpacingAfter(10);

            // Definir anchos de columna
            float[] columnWidths = {2.5f, 2.5f, 2f, 2f, 1.5f, 1.5f, 2f};
            table.setWidths(columnWidths);

            // Encabezados de la tabla con estilo
            agregarEncabezado(table);

            // Llenar la tabla con los datos de la base de datos
            while (rs.next()) {
                agregarFila(table, rs);
            }

            // Añadir la tabla al documento
            document.add(table);

            // Cerrar el documento
            document.close();

            // Mensaje de éxito
            JOptionPane.showMessageDialog(null, "Reporte generado correctamente.");
            System.out.println("PDF creado correctamente.");

            // Abrir el PDF automáticamente
            abrirPDF();

        } catch (DocumentException | HeadlessException | FileNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al generar el reporte: " + e.getMessage());
        } finally {
            // Cerrar recursos
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para abrir el PDF automáticamente
    private static void abrirPDF() {
        try {
            File pdfFile = new File(PDF_PATH);
            if (pdfFile.exists()) {
                Desktop.getDesktop().open(pdfFile);
            } else {
                JOptionPane.showMessageDialog(null, "El archivo PDF no se encontró.");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al abrir el PDF: " + e.getMessage());
        }
    }

    // Método para agregar encabezados con estilo
    private static void agregarEncabezado(PdfPTable table) {
        Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.WHITE);
        BaseColor headerColor = new BaseColor(0, 102, 204); // Color azul para los encabezados

        agregarCeldaEncabezado(table, "Nombres", headerFont, headerColor);
        agregarCeldaEncabezado(table, "Apellidos", headerFont, headerColor);
        agregarCeldaEncabezado(table, "Usuario", headerFont, headerColor);
        agregarCeldaEncabezado(table, "Departamento.", headerFont, headerColor);
        agregarCeldaEncabezado(table, "Est.", headerFont, headerColor);
        agregarCeldaEncabezado(table, "Nivel", headerFont, headerColor);
        agregarCeldaEncabezado(table, "Fecha", headerFont, headerColor);
    }

    // Método auxiliar para agregar una celda de encabezado con estilo
    private static void agregarCeldaEncabezado(PdfPTable table, String text, Font font, BaseColor backgroundColor) {
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setBackgroundColor(backgroundColor);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(10);
        table.addCell(cell);
    }

    // Método para agregar filas con datos de la base de datos
    private static void agregarFila(PdfPTable table, ResultSet rs) throws SQLException {
        Font cellFont = FontFactory.getFont(FontFactory.HELVETICA, 8);
        table.addCell(new PdfPCell(new Phrase(rs.getString("nombres"), cellFont)));
        table.addCell(new PdfPCell(new Phrase(rs.getString("apellidos"), cellFont)));
        table.addCell(new PdfPCell(new Phrase(rs.getString("usuarios"), cellFont)));
        table.addCell(new PdfPCell(new Phrase(rs.getString("departamento"), cellFont)));
        table.addCell(new PdfPCell(new Phrase(rs.getString("estado"), cellFont)));
        table.addCell(new PdfPCell(new Phrase(rs.getString("nivel"), cellFont)));
        table.addCell(new PdfPCell(new Phrase(rs.getString("fecha"), cellFont)));
    }

    public static void main(String[] args) {
        generarReporte();
    }
}


