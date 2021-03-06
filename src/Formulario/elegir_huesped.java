
package Formulario;

import ClaseConectar.Conectar;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class elegir_huesped extends javax.swing.JDialog {

    public static alquiler alquil;
    Conectar cc=new Conectar();
    Connection cn=cc.conexion();
    public static int idhues;
    ResultSet datos;
    DefaultTableModel model;
    //String dni,nomb,apellido,fono,ciudad,pais,direccion,ocupacion,estadocivil,nacimiento;
    public elegir_huesped(alquiler parent, boolean modal) {
        //super(parent, modal);
        initComponents();
        this.alquil= parent;
        this.setModal(modal);
        this.setTitle("Elegir Huésped");
        mostrardatos("");
        this.setLocationRelativeTo(this);
    }

    void mostrardatos(String valor){
        DefaultTableModel modelo= new DefaultTableModel(); 
        
        modelo.addColumn("DNI"); 
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellidos");      
        modelo.addColumn("Fecha Nac.");
        modelo.addColumn("Ciudad");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Estado Civil");
        modelo.addColumn("Código"); 
        modelo.addColumn("País");      
        modelo.addColumn("Dirección");
        modelo.addColumn("Ocupación");                                         

        jTable1.setModel(modelo);
        String SQL="";
        if(valor.equals(""))
        {
            //String []datos = new String [10];

            SQL="SELECT * FROM huesped";
        }
        else{
            //dni_huesped,nombre_h,apellidos_h,nacimiento,ciudad,telefono,estado_civil,id_huesped,pais,direccion,ocupacion
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
                    datos[7]=rs.getString(8);//id huesped
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
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jcMousePanel1 = new jcMousePanel.jcMousePanel();
        jLabel1 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jcMousePanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/fond3.jpg"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre:");

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

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cerrar13.png"))); // NOI18N
        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jcMousePanel1Layout = new javax.swing.GroupLayout(jcMousePanel1);
        jcMousePanel1.setLayout(jcMousePanel1Layout);
        jcMousePanel1Layout.setHorizontalGroup(
            jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jcMousePanel1Layout.createSequentialGroup()
                .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jcMousePanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel1)
                        .addGap(35, 35, 35)
                        .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(jButton1))
                    .addGroup(jcMousePanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 788, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jcMousePanel1Layout.setVerticalGroup(
            jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jcMousePanel1Layout.createSequentialGroup()
                .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jcMousePanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jcMousePanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcMousePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcMousePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreActionPerformed

    private void txtnombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyReleased
        // TODO add your handling code here:
        mostrardatos(txtnombre.getText());
    }//GEN-LAST:event_txtnombreKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // clic mouse sobre tabla
        //dni_huesped,nombre_h,apellidos_h,nacimiento,ciudad,telefono,estado_civil,id_huesped,pais,direccion,ocupacion
        int fila= jTable1.getSelectedRow();
        alquil.txtdni.setText(jTable1.getValueAt(fila, 0).toString());
        alquil.txtnombre.setText(jTable1.getValueAt(fila, 1).toString());
        alquil.txtapellido.setText(jTable1.getValueAt(fila, 2).toString());
        alquil.id_huesped_huesped=jTable1.getValueAt(fila, 7).toString();
        //id_huesped_huesped
        this.dispose();
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(elegir_huesped.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(elegir_huesped.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(elegir_huesped.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(elegir_huesped.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                elegir_huesped dialog = new elegir_huesped(alquil, true);
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
    private jcMousePanel.jcMousePanel jcMousePanel1;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
