/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package probandoj;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 *
 * @author bmade
 */
public class EjemploBER_PDF {
private String nombre;
private String apellido;
private String fecha;

Document documento;
FileOutputStream archivo;
Paragraph titulo;


public EjemploBER_PDF(String nombre, String apellido, String fecha){
this.nombre= nombre;
this.apellido= apellido;
this.fecha= fecha;

documento  = new Document();
titulo = new Paragraph("REPORTE DE USUARIOS DE AUTENTICACION AL SISTEMA");
}
public void reporte(){
    try {
        archivo = new FileOutputStream ("joan.pdf");
        PdfWriter.getInstance(documento, archivo);
        documento.open();
        titulo.setAlignment(1);
        documento.add(titulo);
        
        documento.add(new Paragraph("nombre: "+nombre));
        documento.add(new Paragraph("apellido: "+apellido));
        
        documento.add(Chunk.NEWLINE);
        
        Paragraph texto = new Paragraph("El código ASCII (siglas en ingles para American Standard Code for Information Interchange, es decir Código Americano ( Je! lease estadounidense... ) Estándar para el intercambio de Información ) ( se pronuncia Aski ).\n" +
"\n" +
"Fue creado en 1963 por el Comité Estadounidense de Estándares o \"ASA\", este organismo cambio su nombre en 1969 por \"Instituto Estadounidense de Estándares Nacionales\" o \"ANSI\" como se lo conoce desde entonces.\n" +
"\n" +
"Este código nació a partir de reordenar y expandir el conjunto de símbolos y caracteres ya utilizados en aquel momento en telegrafía por la compañía Bell. En un primer momento solo incluía letras mayúsculas y números, pero en 1967 se agregaron las letras minúsculas y algunos caracteres de control, formando así lo que se conoce como US-ASCII, es decir los caracteres del 0 al 127.\n" +
"Así con este conjunto de solo 128 caracteres fue publicado en 1967 como estándar, conteniendo todos lo necesario para escribir en idioma ingles.\n" +
"\n" +
"En 1981, la empresa IBM desarrolló una extensión de 8 bits del código ASCII, llamada \"pagina de código 437\", en esta versión se reemplazaron algunos caracteres de control obsoletos, por caracteres gráficos. Además se incorporaron 128 caracteres nuevos, con símbolos, signos, gráficos adicionales y letras latinas, necesarias para la escrituras de textos en otros idiomas, como por ejemplo el español. Así fue como se sumaron los caracteres que van del ASCII 128 al 255.\n" +
"IBM incluyó soporte a esta página de código en el hardware de su modelo 5150, conocido como \"IBM-PC\", considerada la primera computadora personal. El sistema operativo de este modelo, el \"MS-DOS\" también utilizaba el código ASCII extendido.");

texto.setAlignment(Element.ALIGN_JUSTIFIED);
documento.add(texto);

documento.add(Chunk.NEWLINE);

documento.add(new Paragraph("fecha: "+fecha));
documento.close();

    } catch (FileNotFoundException | DocumentException e) {
        System.err.println(e.getMessage());
    }

}    
}
