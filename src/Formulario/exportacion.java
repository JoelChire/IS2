/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formulario;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author z510
 */
public class exportacion extends javax.swing.JInternalFrame {

    /**
     * Creates new form exportacion
     */
    public exportacion() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        txtruta = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jScrollPane1.setViewportView(jTextPane1);

        jButton1.setText("Ruta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Generar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(txtruta, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(62, 62, 62)
                .addComponent(jButton1)
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(txtruta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// chire gay este codigo selecciona la ruta donde se alojara el archivo exportado y lo muestra en tu anexo
JFileChooser ch=new JFileChooser();       
    ch.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    int se=ch.showSaveDialog(null);
    if(se == JFileChooser.APPROVE_OPTION){
    String ruta=ch.getSelectedFile().getPath();
    txtruta.setText(ruta);
    }
            // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//chire mariposa este codigo ejecuta runtime, que permite ejecutar aplicaciones fuera de java y le pasa los parametros de la BD(usuario, pass, nombre) para generar un archivivo mediante la ruta del boton ruta;
String ruta=txtruta.getText();
    String nombre="\\backus.sql";
    
    String backus="";
    if(ruta.trim().length()!=0)
        {
       try
       {
       backus = "C:\\wamp64\\bin\\mysql\\mysql5.7.14\\bin\\mysqldump --opt -u"+Exporta.getUs()+" -p"+Exporta.getPas()+" -B "+Exporta.getBd()+" -r "+ruta+nombre;
       //backus = "C:\wamp\bin\mysql\mysql5.5.24\bin\\mysqldump --user="+Exporta.getUs()+" --password="+Exporta.getPas()+" -v "+Exporta.getBd()+" > "+ruta+nombre;
       System.out.println(backus);
       Runtime rt=Runtime.getRuntime();
       rt.exec(backus);
       JOptionPane.showMessageDialog(rootPane, "Exportado correctamente");

       }
       catch(Exception ex){
       JOptionPane.showMessageDialog(rootPane, ex.getMessage());}
        }
           // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextField txtruta;
    // End of variables declaration//GEN-END:variables
}
