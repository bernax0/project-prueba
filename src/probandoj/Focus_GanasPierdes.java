/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package probandoj;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author bmade
 */
public class Focus_GanasPierdes extends javax.swing.JFrame {

    /**
     * Creates new form Focus_GanasPierdes
     */
    public Focus_GanasPierdes() {
        initComponents();
        jB_Salir.requestFocus();
        
        // Añadir el FocusListener a cada JTextField
        jTF_Nombres.addFocusListener(focusListener);
        jTF_Apellidos.addFocusListener(focusListener);
        jTF_Usuario.addFocusListener(focusListener);
        jTF_Password.addFocusListener(focusListener);
    }

    
    // Crear un FocusListener
        FocusListener focusListener = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Cuando el JTextField obtiene el foco
                JTextField textField = (JTextField) e.getSource();
                textField.setBackground(new Color(250, 239, 201)); // Color #faefc9 
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Cuando el JTextField pierde el foco
                JTextField textField = (JTextField) e.getSource();
                textField.setBackground(Color.WHITE);
            }
        };
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTF_Apellidos = new javax.swing.JTextField();
        jTF_Usuario = new javax.swing.JTextField();
        jTF_Password = new javax.swing.JTextField();
        jTF_Nombres = new javax.swing.JTextField();
        jB_Salir = new javax.swing.JButton();
        jB_ProbandoDB = new javax.swing.JButton();
        jB_EjemploPDF = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTF_Apellidos.setText(" ");

        jTF_Usuario.setText(" ");

        jTF_Password.setText(" ");

        jTF_Nombres.setText(" ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTF_Apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTF_Nombres, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTF_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTF_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(182, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jTF_Nombres, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTF_Apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jTF_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTF_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jB_Salir.setText("Salir");
        jB_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_SalirActionPerformed(evt);
            }
        });

        jB_ProbandoDB.setText("ProbarBD");
        jB_ProbandoDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_ProbandoDBActionPerformed(evt);
            }
        });

        jB_EjemploPDF.setText("PDF-ejemplo");
        jB_EjemploPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_EjemploPDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addComponent(jB_ProbandoDB)
                .addGap(53, 53, 53)
                .addComponent(jB_EjemploPDF)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jB_Salir)
                .addGap(114, 114, 114))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_Salir)
                    .addComponent(jB_ProbandoDB, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jB_EjemploPDF))
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jB_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_SalirActionPerformed
        this.dispose();//Cesarina German tatis 217-0103 74
    }//GEN-LAST:event_jB_SalirActionPerformed

    private void jB_ProbandoDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_ProbandoDBActionPerformed
        //ReportePDF.generarReporte(); 
        
        PDF_Estetica.generarReporte();
        
    }//GEN-LAST:event_jB_ProbandoDBActionPerformed

    private void jB_EjemploPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_EjemploPDFActionPerformed
 EjemploBER_PDF epdf = new EjemploBER_PDF("Bernardo","Madera","18-12-2024");
        epdf.reporte();
        File pdfFile = new File("C:\\Users\\bmade\\Documents\\NetBeansProjects\\ProbandoJ\\joan.pdf");
        try {
            Desktop.getDesktop().open(pdfFile);
        } catch (IOException ex) {
            Logger.getLogger(Focus_GanasPierdes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jB_EjemploPDFActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Focus_GanasPierdes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Focus_GanasPierdes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Focus_GanasPierdes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Focus_GanasPierdes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Focus_GanasPierdes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_EjemploPDF;
    private javax.swing.JButton jB_ProbandoDB;
    private javax.swing.JButton jB_Salir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTF_Apellidos;
    private javax.swing.JTextField jTF_Nombres;
    private javax.swing.JTextField jTF_Password;
    private javax.swing.JTextField jTF_Usuario;
    // End of variables declaration//GEN-END:variables
}