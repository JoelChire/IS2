/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ALCAZAR
 */
public class habitacion extends javax.swing.JInternalFrame {

    String r;
    Integer n=1;
    ResultSet rs;
    public static String bandera_habitacion;
    public habitacion() {
        Conectar cc=new Conectar();
        Connection cn=cc.conexion();
        initComponents();
        try{      
            PreparedStatement sent = cn.prepareStatement("select id_tipo, nombre_tipo from tip_habitacion order by nombre_tipo");
            rs = sent.executeQuery(); 
            this.cmbtipo.removeAllItems();
            while(rs.next()){
                this.cmbtipo.addItem(rs.getString("nombre_tipo"));
            }
            cc.desconectar();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        btneditar.setEnabled(true);
        btnguardar.setEnabled(true);
        btnnuevo.setEnabled(false);
        mostrardatos("");
        jTable1.setEnabled(false);
        bandera_habitacion="bandera";
    }

    void mostrardatos(String valor){
    DefaultTableModel modelo= new DefaultTableModel();
    modelo.addColumn("N° HABITACION");
    modelo.addColumn("ESTADO");
    modelo.addColumn("TIPO");
    jTable1.setModel(modelo);
    String SQL="";
    if(valor.equals(""))
    {    String []datos = new String [4];

        SQL="SELECT h.nro_hab,h.estado,a.id_tipo FROM  habitacion  h inner join tip_habitacion a on a.id_tipo=h.tip_habitacion_id_tipo";
    }
    else{
        SQL="SELECT h.nro_hab,h.estado,a.id_tipo FROM habitacion INNER JOIN tip_habitacion a ON a.id_tipo = h.tip_habitacion_id_tipo WHERE h.nro_hab LIKE '%"+valor+"%'";
    }
 
    String []datos = new String [4];
        try {
            Conectar cc=new Conectar();            
            Connection cn=cc.conexion();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while(rs.next()){
                datos[0]=rs.getString(1);                
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                modelo.addRow(datos);
            }
            jTable1.setModel(modelo);
            cc.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(taxista.class.getName()).log(Level.SEVERE, null, ex);
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

        panel1 = new java.awt.Panel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbestado = new javax.swing.JComboBox<>();
        cmbtipo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txthabitacion = new javax.swing.JTextField();
        panel12 = new java.awt.Panel();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btneditar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setTitle("REGISTRO DE HABITACION");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("N° Habitación:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Estado:");

        cmbestado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbestado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disponible", "Ocupado", "Reservado", "Inhabilitado" }));
        cmbestado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbestadoActionPerformed(evt);
            }
        });

        cmbtipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbtipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbtipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbtipoActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Tipo:");

        txthabitacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txthabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthabitacionActionPerformed(evt);
            }
        });
        txthabitacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txthabitacionKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txthabitacionKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txthabitacion, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cmbestado, javax.swing.GroupLayout.Alignment.LEADING, 0, 198, Short.MAX_VALUE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txthabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        btnnuevo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btnguardar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.setName("btnguardar"); // NOI18N
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btneditar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btneditar.setText("Editar");
        btneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarActionPerformed(evt);
            }
        });

        btnsalir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel12Layout = new javax.swing.GroupLayout(panel12);
        panel12.setLayout(panel12Layout);
        panel12Layout.setHorizontalGroup(
            panel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(panel12Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(panel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btneditar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnguardar)
                    .addComponent(btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        panel12Layout.setVerticalGroup(
            panel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnnuevo)
                .addGap(18, 18, 18)
                .addComponent(btnguardar)
                .addGap(11, 11, 11)
                .addComponent(btneditar)
                .addGap(18, 18, 18)
                .addComponent(btnsalir)
                .addContainerGap(16, Short.MAX_VALUE))
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
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbestadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbestadoActionPerformed

        //estado: Disponible,Ocupado,Reservado,Inhabilitado
    }//GEN-LAST:event_cmbestadoActionPerformed

    private void cmbtipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbtipoActionPerformed
        // TODO add your handling code here:
        Conectar cc=new Conectar();
        Connection cn=cc.conexion();
        try{
            Statement sent1 = cn.createStatement();
            ResultSet rs1 = sent1.executeQuery("select id_tipo, nombre_tipo from tip_habitacion where nombre_tipo = '"+this.cmbtipo.getSelectedItem()+"'");
            if(rs1.next()){
            r = String.valueOf(rs1.getString("id_tipo"));
            }            
            cc.desconectar();
        }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e);  
        }
    }//GEN-LAST:event_cmbtipoActionPerformed

    private void txthabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthabitacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthabitacionActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        bandera_habitacion=null;
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        if(txthabitacion.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Ingrese el nombre","¡Error!",JOptionPane.ERROR_MESSAGE);
            }
        else if(n==1){
        Conectar cc=new Conectar();
        Connection cn=cc.conexion();
        try{
            PreparedStatement pst=cn.prepareStatement("INSERT INTO habitacion(nro_hab,estado,tip_habitacion_id_tipo) Values(?,?,?)");
            pst.setString(1,txthabitacion.getText());
            pst.setString(2,(String)cmbestado.getSelectedItem());
            pst.setString(3,r);

            int a=pst.executeUpdate();
            if(a>0){
                JOptionPane.showMessageDialog(null,"registro exitoso");

            }
            else{
                JOptionPane.showMessageDialog(null,"error al agregar");
            }
            cc.desconectar();
        }catch(HeadlessException | SQLException e){
        }
        }
        else
        {
        try {
        Conectar cc=new Conectar();            
        Connection cn=cc.conexion();
        PreparedStatement pst = cn.prepareStatement("UPDATE habitacion SET nro_hab='"+txthabitacion.getText()+"',estado='"+(String) cmbestado.getSelectedItem()+"',tip_habitacion_id_tipo='"+(String) cmbtipo.getSelectedItem()+"' WHERE nro_hab='"+txthabitacion.getText()+"'");
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null,"Modificacion exitosa","¡Aviso!",JOptionPane.INFORMATION_MESSAGE);   
        cc.desconectar();
        n=1;
        jTable1.setEnabled(false);
            btnguardar.setEnabled(false);
            btneditar.setEnabled(false);            
            btnnuevo.setEnabled(true);
        } catch (SQLException e) {
        System.out.print(e.getMessage());
    }
        }        
        mostrardatos(""); 
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:
        txthabitacion.setText("");
        cmbestado.setSelectedIndex(0); 
        cmbtipo.setSelectedIndex(0);      
        cmbestado.setEnabled(true);
        cmbtipo.setEnabled(true);
        btneditar.setEnabled(true);
        btnguardar.setEnabled(true);
        btnnuevo.setEnabled(false);
        mostrardatos("");
        jTable1.setEnabled(false);
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void txthabitacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txthabitacionKeyTyped
        // TODO add your handling code here:
        int numerocaracteres=4;
        char d=evt.getKeyChar();
        if (txthabitacion.getText().length()>=numerocaracteres){
        evt.consume();
            JOptionPane.showMessageDialog(null,"Exceso de dígitos","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
        else if (Character.isLetter(d)) 
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"Solo números","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        } 
        else if ((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=47
            ||(int)evt.getKeyChar()>58 && (int)evt.getKeyChar()<=64
            ||(int)evt.getKeyChar()>91 && (int)evt.getKeyChar()<=96
            ||(int)evt.getKeyChar()>123 && (int)evt.getKeyChar()<=255)
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"No usar caracteres","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txthabitacionKeyTyped

    private void txthabitacionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txthabitacionKeyReleased
        // TODO add your handling code here:
                mostrardatos(txthabitacion.getText());

    }//GEN-LAST:event_txthabitacionKeyReleased

    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
        // TODO add your handling code here:
        jTable1.setEnabled(true);
        txthabitacion.setText("");
        cmbestado.setSelectedIndex(-1);
        cmbtipo.setSelectedIndex(-1);
        txthabitacion.setEnabled(true);
        cmbestado.setEnabled(false);   
        cmbtipo.setEnabled(false);
        btnguardar.setEnabled(true);
        btnnuevo.setEnabled(false);
        btneditar.setEnabled(false);
        n=2;
    }//GEN-LAST:event_btneditarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int fila= jTable1.getSelectedRow();
        txthabitacion.setEnabled(false);
        
        cmbestado.setEnabled(true);
        cmbtipo.setEnabled(true);
       
        if(fila>=0){
        txthabitacion.setText(jTable1.getValueAt(fila, 0).toString());
        if(jTable1.getValueAt(fila, 1).toString().equals("Disponible"))
        {
            cmbestado.setSelectedIndex(0); 
        }
        else if(jTable1.getValueAt(fila, 1).toString().equals("Ocupado"))
        {
            cmbestado.setSelectedIndex(1); 
        }
        else if(jTable1.getValueAt(fila, 1).toString().equals("Reservado"))
        {
            cmbestado.setSelectedIndex(2); 
        }
        else if(jTable1.getValueAt(fila, 1).toString().equals("Inhabilitado"))
        {
            cmbestado.setSelectedIndex(3); 
        }
        if(jTable1.getValueAt(fila, 4).toString().equals("H06"))
        {
            cmbtipo.setSelectedIndex(0); 
        }
        else if(jTable1.getValueAt(fila, 4).toString().equals("H02"))
        {
            cmbtipo.setSelectedIndex(1); 
        }
        else if(jTable1.getValueAt(fila, 4).toString().equals("H05"))
        {
            cmbtipo.setSelectedIndex(2); 
        }
        else if(jTable1.getValueAt(fila, 4).toString().equals("H03"))
        {
            cmbtipo.setSelectedIndex(4); 
        }
        else if(jTable1.getValueAt(fila, 4).toString().equals("H01"))
        {
            cmbtipo.setSelectedIndex(5); 
        }
        else if(jTable1.getValueAt(fila, 4).toString().equals("H07"))
        {
            cmbtipo.setSelectedIndex(6); 
        }
        else if(jTable1.getValueAt(fila, 4).toString().equals("H04"))
        {
            cmbtipo.setSelectedIndex(3); 
        }
    }//GEN-LAST:event_jTable1MouseClicked
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btneditar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JComboBox<String> cmbestado;
    private javax.swing.JComboBox<String> cmbtipo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private java.awt.Panel panel1;
    private java.awt.Panel panel12;
    private javax.swing.JTextField txthabitacion;
    // End of variables declaration//GEN-END:variables
}
