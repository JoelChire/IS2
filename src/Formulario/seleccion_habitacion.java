package Formulario;

import ClaseConectar.Conectar;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class seleccion_habitacion extends javax.swing.JDialog {

    public static alquiler alquile;
    Conectar cc=new Conectar();
    Connection cn=cc.conexion();
    ResultSet datos;
    DefaultTableModel model;
    String nrohab,nom_tipo,estado,costo,camas;
    String idhab="";
    /////////////
    public seleccion_habitacion(alquiler parent, boolean modal) {
        //super(parent, modal);
        this.alquile= parent;
        this.setModal(modal);
        this.setTitle("Seleccion de Habitación");
        initComponents();
        cargar("");
        this.setLocationRelativeTo(this);        
    }
  
    void cargar(String valor)
    {
        String [] titulos = {"Nro de Habitacion", "Tipo", "Estado","Costo","Nro Camas"};
        model =new DefaultTableModel(null,titulos);
        try{            
            PreparedStatement pst=cn.prepareStatement("SELECT  nro_hab,nombre_tipo,estado,costo,nro_camas "
                    + "FROM tip_habitacion inner join  habitacion on habitacion.tip_habitacion_id_tipo=tip_habitacion.id_tipo where nombre_tipo LIKE '%"+valor+"%' and estado='disponible' order by nro_hab");
            datos = pst.executeQuery();//buscando datos y guardando en datos           
            String [] fila = new String[5];
            while(datos.next()){
                fila[0]=datos.getString("nro_hab");
                fila[1]=datos.getString("nombre_tipo");
                fila[2]=datos.getString("estado");
                fila[3]=datos.getString("costo");
                fila[4]=datos.getString("nro_camas");
                model.addRow(fila); 
            } 
            jTable1.setModel(model);
        }catch(HeadlessException | SQLException e){
            System.err.println("No dispone de ese tipo");
        }
    }    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcMousePanel1 = new jcMousePanel.jcMousePanel();
        lb_tip_hab_alq = new javax.swing.JLabel();
        tipo_ha_alq = new javax.swing.JTextField();
        btnsalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jcMousePanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/fond3.jpg"))); // NOI18N

        lb_tip_hab_alq.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lb_tip_hab_alq.setForeground(new java.awt.Color(255, 255, 255));
        lb_tip_hab_alq.setText("Tipo:");

        tipo_ha_alq.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        tipo_ha_alq.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tipo_ha_alqKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tipo_ha_alqKeyTyped(evt);
            }
        });

        btnsalir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cerrar13.png"))); // NOI18N
        btnsalir.setText("Cancelar");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("URW Gothic L", 0, 18)); // NOI18N
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
                .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jcMousePanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(lb_tip_hab_alq)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tipo_ha_alq, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(btnsalir))
                    .addGroup(jcMousePanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jcMousePanel1Layout.setVerticalGroup(
            jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jcMousePanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_tip_hab_alq)
                    .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tipo_ha_alq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 37, Short.MAX_VALUE)))
                .addGap(18, 24, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
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

    private void tipo_ha_alqKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tipo_ha_alqKeyReleased
        // TODO add your handling code here:
        cargar(tipo_ha_alq.getText());
    }//GEN-LAST:event_tipo_ha_alqKeyReleased

    private void tipo_ha_alqKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tipo_ha_alqKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isDigit(c))
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"Solo letras","Advertencia.!!",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_tipo_ha_alqKeyTyped

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // clic mouse sobre tabla
        int fsel= jTable1.getSelectedRow();
        try {
            //int canti=0;
            if (fsel==-1) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una habitacion");
            }else{
                //System.out.println("habitacion seleccionada");
                //"Nro de Habitacion", "Tipo", "Estado","Costo","Nro Camas"
                //model= (DefaultTableModel) jTable1.getModel();
                nrohab= jTable1.getValueAt(fsel, 0).toString();
                nom_tipo= jTable1.getValueAt (fsel,1).toString();
                costo= jTable1.getValueAt (fsel,3).toString();
                camas=jTable1.getValueAt (fsel,4).toString();
                estado= jTable1.getValueAt (fsel,2).toString().toUpperCase();
                if (estado.equals("DISPONIBLE")) {
                    //System.out.println("numero habitacion: "+nrohab);
                    //conseguimos id habitacion
                    PreparedStatement pst=cn.prepareStatement("SELECT id_habitacion FROM habitacion"
                        + " where nro_hab='"+nrohab+"'");
                    datos = pst.executeQuery();//buscando datos y guardando en datos

                    while(datos.next()){
                        idhab=datos.getString("id_habitacion");
                    }
                    //
                    alquile.id_habitacion_seleccion=idhab;
                    alquile.txtnumeroha.setText(nrohab);
                    alquile.txttipoha.setText(nom_tipo);
                    alquile.txtmonto.setText(costo);
                    alquile.txtnumeroca.setText(camas);
                    this.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Seleccionar habitacion disponible");
                }
            }
        } catch (Exception e) {
        }
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
            java.util.logging.Logger.getLogger(seleccion_habitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(seleccion_habitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(seleccion_habitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(seleccion_habitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                seleccion_habitacion dialog = new seleccion_habitacion(alquile, true);
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
    private javax.swing.JTextField tipo_ha_alq;
    // End of variables declaration//GEN-END:variables
}
