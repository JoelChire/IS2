/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formulario;

import ClaseConectar.Conectar;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
//import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Belen Ño
 */
public class editar_huesped extends javax.swing.JDialog {

    /**
     * Creates new form editar_huesped
     */    
    
    
    public static huesped hues;
//public static huesped huespededi ;
    Conectar cc=new Conectar();
    Connection cn=cc.conexion();
    public static int idhues;
    ResultSet datos;
    DefaultTableModel model;
    String dni,nomb,apellido,fono,ciudad,pais,direccion,ocupacion,estadocivil,nacimiento;
    
    public editar_huesped(huesped parent, boolean modal) {
        //super(parent, modal);        
        this.hues= parent;
        this.setModal(modal);
        this.setTitle("BUSCAR HUESPED");
        initComponents();
        mostrardatos("");
        this.setLocationRelativeTo(this);
        
        
    }
    
    void mostrardatos(String valor){
    DefaultTableModel modelo= new DefaultTableModel(); 
    modelo.addColumn(" CODIGO"); 
    modelo.addColumn(" DNI"); 
    modelo.addColumn("NOMBRES");
    modelo.addColumn("APELLIDOS");      
    modelo.addColumn("NACIMIENTO");
    modelo.addColumn("CIUDAD");
    modelo.addColumn("TELEFONO");
    modelo.addColumn("ESTADO CIVIL");
    modelo.addColumn(" PAIS ");      
    modelo.addColumn("  DIRECCION  ");
    modelo.addColumn(" OCUPACION ");                                         
    
    jTable1.setModel(modelo);
    String SQL="";
    if(valor.equals(""))
    {
        String []datos = new String [10];

        SQL="SELECT * FROM huesped";
    }
    else{
        SQL="SELECT * FROM huesped WHERE nombre_h LIKE  '%"+valor+"%'";
    }
 
    String []datos = new String [11];
        try {
            Conectar cc=new Conectar();            
            Connection cn=cc.conexion();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while(rs.next()){
                datos[0]=rs.getString(1);                
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
                datos[5]=rs.getString(6);
                datos[6]=rs.getString(7);
                datos[7]=rs.getString(8);
                datos[8]=rs.getString(9);
                datos[9]=rs.getString(10);  
                datos[10]=rs.getString(11);                     
                modelo.addRow(datos);
            }
            jTable1.setModel(modelo);
            
            
            /*jTable1.getColumnModel().getColumn(0).setMaxWidth(50);         
            jTable1.getColumnModel().getColumn(1).setMaxWidth(350);             
            jTable1.getColumnModel().getColumn(2).setMaxWidth(350);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(350);     
            jTable1.getColumnModel().getColumn(4).setMaxWidth(300);
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.CENTER);
            jTable1.getColumnModel().getColumn(0).setCellRenderer(tcr);           
            jTable1.getColumnModel().getColumn(1).setCellRenderer(tcr);
            jTable1.getColumnModel().getColumn(4).setCellRenderer(tcr); */
            cc.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(huesped.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    } 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("NOMBRE:");

        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });
        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnombreKeyReleased(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("SALIR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton1)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtnombre, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 821, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int fila= jTable1.getSelectedRow();
        int colum = jTable1.getSelectedColumn();
        
        try {
                
            huesped.id=jTable1.getValueAt(fila, 0).toString();
            ////////////////huesped.idhues.jTable1.getValueAt(fila,0),toString();
            huesped.txtdni.setText(jTable1.getValueAt(fila, 1).toString());
            huesped.txtnombre.setText(jTable1.getValueAt(fila, 2).toString());
            huesped.txtapellido.setText(jTable1.getValueAt(fila, 3).toString());
            
            String fechaSeleccionada = (String) jTable1.getModel().getValueAt(fila,4);
            //Date fecha = new Date();
            SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd");
            Date fecha;
            fecha = df.parse(fechaSeleccionada);
            huesped.txtfecha.setDate(fecha); 
            
            
            huesped.txtciudad.setText(jTable1.getValueAt(fila, 5).toString());             
           // int filaSeleccionada = jTable1.getSelectedRow();        

            /*DateFormat df = new SimpleDateFormat("dd-MMMM-yyyy");            
            Date fecha = df.parse(fechaSeleccionada);    
           
            huesped.txtfecha.setDate(fechaSeleccionada);*/  
          //  huesped.txtfecha.setDate(jTable1.getValueAt(fila, 5));
            huesped.txttelefono.setText(jTable1.getValueAt(fila, 6).toString()); 
            huesped.cmbestadocivil.setSelectedItem(jTable1.getValueAt(fila, 7).toString());
            huesped.txtpais.setText(jTable1.getValueAt(fila, 8).toString());            
            huesped.txtdireccion.setText(jTable1.getValueAt(fila, 9).toString());
            huesped.txtocupacion.setText(jTable1.getValueAt(fila, 10).toString());
            
                      
            this.dispose();
           
       /* txtapellido.setEnabled(true);
        txtdni.setEnabled(true);
        txtfecha.setEnabled(true);
        txtestadocivil.setEnabled(true);
        txttelefono.setEnabled(true);        */
        
      /* if(fila>=0){
        txtdni.setText(jTable1.getValueAt(fila, 0).toString());
        txtnombre.setText(jTable1.getValueAt(fila, 1).toString());
        txtapellido.setText(jTable1.getValueAt(fila, 2).toString());
        //txtfecha.setDate(jTable1.getValueAt(fila, 3).toString());
        txtestadocivil.setText(jTable1.getValueAt(fila, 4).toString());
        txttelefono.setText(jTable1.getValueAt(fila, 5).toString());
        } */
            

        } catch (Exception e) {
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void txtnombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyReleased
        // TODO add your handling code here:
        mostrardatos(txtnombre.getText());
    }//GEN-LAST:event_txtnombreKeyReleased

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
            java.util.logging.Logger.getLogger(editar_huesped.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editar_huesped.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editar_huesped.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editar_huesped.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               editar_huesped dialog = new editar_huesped(hues , true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
