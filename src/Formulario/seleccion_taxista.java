package Formulario;

import ClaseConectar.Conectar;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class seleccion_taxista extends javax.swing.JDialog {

    public static taxista tax;
    Conectar cc=new Conectar();
    Connection cn=cc.conexion();
    ResultSet datos;
    DefaultTableModel model;
    /////////////
    public seleccion_taxista(taxista parent, boolean modal) {
        //super(parent, modal);
        this.tax= parent;
        this.setModal(modal);
        this.setTitle("Seleccionar taxista");
        initComponents();
        cargar("");
        this.setLocationRelativeTo(this);        
    }

    ///7///
    //public void enviodato(){
    //    alquile.poner();
    // }
    //////////////////
    void cargar(String valor)
    {
        DefaultTableModel modelo= new DefaultTableModel();
    
    modelo.addColumn("  Nº");
    modelo.addColumn("DOC. IDENTIDAD");
    modelo.addColumn("     NOMBRES");
    modelo.addColumn("     APELLIDOS");
    modelo.addColumn("    TELEFONO");     
    modelo.addColumn("    PLACA");  
    jTable1.setModel(modelo);
    String SQL="";
    if(valor.equals(""))
    {    String []datos = new String [6];

        SQL="SELECT * FROM taxista";
    }
    else{
        SQL="SELECT * FROM taxista WHERE nombre LIKE '%"+valor+"%'";
    }
 
    String []datos = new String [6];
        try {
            Conectar cc=new Conectar();            
            Connection cn=cc.conexion();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while(rs.next()){
                datos[0]=rs.getString(5);                
                datos[1]=rs.getString(1);
                datos[2]=rs.getString(2);
                datos[3]=rs.getString(3);               
                datos[4]=rs.getString(4);                         
                datos[5]=rs.getString(6);
                modelo.addRow(datos);
            }
            jTable1.setModel(modelo);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(50);         
            jTable1.getColumnModel().getColumn(1).setMaxWidth(350);
             
            jTable1.getColumnModel().getColumn(2).setMaxWidth(350);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(350);     
            jTable1.getColumnModel().getColumn(4).setMaxWidth(300);
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.CENTER);
            jTable1.getColumnModel().getColumn(0).setCellRenderer(tcr);           
            jTable1.getColumnModel().getColumn(1).setCellRenderer(tcr);
            jTable1.getColumnModel().getColumn(4).setCellRenderer(tcr);
            cc.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(taxista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcMousePanel1 = new jcMousePanel.jcMousePanel();
        txtnombre = new javax.swing.JTextField();
        lb_tip_hab_alq = new javax.swing.JLabel();
        btnsalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jcMousePanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/fond3.jpg"))); // NOI18N

        txtnombre.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreKeyTyped(evt);
            }
        });

        lb_tip_hab_alq.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lb_tip_hab_alq.setForeground(new java.awt.Color(255, 255, 255));
        lb_tip_hab_alq.setText("Nombre:");

        btnsalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cerrar13.png"))); // NOI18N
        btnsalir.setText("Cancelar");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
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
                .addGap(34, 34, 34)
                .addComponent(lb_tip_hab_alq)
                .addGap(18, 18, 18)
                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jcMousePanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jcMousePanel1Layout.setVerticalGroup(
            jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jcMousePanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_tip_hab_alq)
                    .addComponent(btnsalir))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcMousePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcMousePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyReleased
        // TODO add your handling code here:
        cargar(txtnombre.getText());
    }//GEN-LAST:event_txtnombreKeyReleased

    private void txtnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isDigit(c))
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"Solo letras","Advertencia.!!",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtnombreKeyTyped

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int fsel= jTable1.getSelectedRow();
        taxista.idtaxista=jTable1.getValueAt(fsel, 0).toString();
        taxista.txtdni.setText(jTable1.getValueAt(fsel, 1).toString());
        taxista.dnitaxista=jTable1.getValueAt(fsel, 1).toString();
        taxista.txtnombre.setText(jTable1.getValueAt(fsel, 2).toString());
        taxista.txtapellido.setText(jTable1.getValueAt(fsel, 3).toString());
        taxista.txttelefono.setText(jTable1.getValueAt(fsel, 4).toString());
        taxista.txtplaca.setText(jTable1.getValueAt(fsel, 5).toString());
        taxista.txtnombre.setEnabled(true);
        taxista.txtapellido.setEnabled(true);
        taxista.txtdni.setEnabled(true);
        taxista.txtplaca.setEnabled(true);
        taxista.txttelefono.setEnabled(true);
        taxista.btnactualizar.setEnabled(true);
        taxista.btnguardar.setEnabled(false);
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
            java.util.logging.Logger.getLogger(seleccion_taxista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(seleccion_taxista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(seleccion_taxista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(seleccion_taxista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                seleccion_taxista dialog = new seleccion_taxista(tax, true);
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
    private javax.swing.JButton btnsalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private jcMousePanel.jcMousePanel jcMousePanel1;
    private javax.swing.JLabel lb_tip_hab_alq;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
