/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formulario;

import Clases.Exporta;
import java.io.File;
import java.text.SimpleDateFormat;
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
    java.util.Date fecha = new java.util.Date();
    java.sql.Date fechasql = new java.sql.Date(fecha.getTime());
    public exportacion() {
        initComponents();
        label.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jFileChooser1 = new javax.swing.JFileChooser();
        jcMousePanel1 = new jcMousePanel.jcMousePanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtruta = new javax.swing.JTextField();
        label = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jTextPane1);

        setTitle("Respaldo");

        jcMousePanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/fondo7.jpg"))); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/respaldar.png"))); // NOI18N
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/generar.png"))); // NOI18N
        jButton2.setText("Generar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cerrar13.png"))); // NOI18N
        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txtruta.setEditable(false);
        txtruta.setToolTipText("");
        txtruta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtrutaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtrutaMouseExited(evt);
            }
        });

        label.setForeground(new java.awt.Color(255, 255, 255));
        label.setText("Seleccione una carpeta");

        javax.swing.GroupLayout jcMousePanel1Layout = new javax.swing.GroupLayout(jcMousePanel1);
        jcMousePanel1.setLayout(jcMousePanel1Layout);
        jcMousePanel1Layout.setHorizontalGroup(
            jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jcMousePanel1Layout.createSequentialGroup()
                .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jcMousePanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jcMousePanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtruta, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jcMousePanel1Layout.setVerticalGroup(
            jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jcMousePanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jcMousePanel1Layout.createSequentialGroup()
                        .addComponent(label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtruta, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jcMousePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcMousePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //selecciona la ruta donde se alojara el archivo exportado y lo muestra en tu anexo
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
        //ejecuta runtime, que permite ejecutar aplicaciones fuera de java y le pasa los parametros de la BD(usuario, pass, nombre) para generar un archivivo mediante la ruta del boton ruta;
        String ruta=txtruta.getText();
        //String nombre="\\backus.sql";
        SimpleDateFormat dd=new SimpleDateFormat("dd-MM-yyyy");
        String fecha=dd.format(fechasql);
        String nombre="\\BDHotelTerrazas_"+fecha+".sql";
        String backus="";    
        File fichero = new File(ruta);
        if (fichero.exists())
          {
    if(ruta.trim().length()!=0)
        {
       try
       {
       backus = "C:\\wamp\\bin\\mysql\\mysq5.5.24\\bin\\mysqldump --opt -u"+Exporta.getUs()+" -p"+Exporta.getPas()+" -B "+Exporta.getBd()+" -r \""+ruta+nombre+"\"";
       //backus = "C:\\wamp64\\bin\\mysql\\mysql5.7.14\\bin\\mysqldump --user="+Exporta.getUs()+" --password="+Exporta.getPas()+" -v "+Exporta.getBd()+" > "+ruta+nombre;
           System.out.println(backus);
       Runtime rt=Runtime.getRuntime();
       rt.exec(backus);
       JOptionPane.showMessageDialog(rootPane, "Exportado correctamente");

       }
       catch(Exception ex){
       JOptionPane.showMessageDialog(rootPane, ex.getMessage());}
        }}else{JOptionPane.showMessageDialog(rootPane, "El directorio no existe");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtrutaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtrutaMouseEntered
        // TODO add your handling code here:
        
        label.setVisible(true);
    }//GEN-LAST:event_txtrutaMouseEntered

    private void txtrutaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtrutaMouseExited
        // TODO add your handling code here:
        
        label.setVisible(false);
    }//GEN-LAST:event_txtrutaMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private jcMousePanel.jcMousePanel jcMousePanel1;
    private javax.swing.JLabel label;
    private javax.swing.JTextField txtruta;
    // End of variables declaration//GEN-END:variables
}
