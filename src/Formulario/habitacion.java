/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formulario;

import ClaseConectar.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.awt.HeadlessException;
import java.sql.Statement;

/**
 *
 * @author usuario
 */
public class habitacion extends javax.swing.JInternalFrame {

    /**
     * Creates new form habitacion
     */
    Integer r;
    Integer n=1;
    ResultSet rs;
    public static String bandera_habitacion;       
    public static String id;   
    public static String numhabitacion;
    public static buscar_habitacion buscar_habit;
    public habitacion() {
        initComponents();
        Conectar cc=new Conectar();
        Connection cn=cc.conexion();
        try{      
            PreparedStatement sent = cn.prepareStatement("select id_tipo, nombre_tipo from tip_habitacion order by id_tipo");
            rs = sent.executeQuery(); 
            this.cmbtipo.removeAllItems();
            while(rs.next()){
                this.cmbtipo.addItem(rs.getString("nombre_tipo"));
            }
            cc.desconectar();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        btnactualizar.setEnabled(false);
        bandera_habitacion="bandera";
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txthabitacion = new javax.swing.JTextField();
        cmbestado = new javax.swing.JComboBox<>();
        cmbtipo = new javax.swing.JComboBox<>();
        btnbuscar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();

        setTitle("REGISTRO DE HABITACIÓN");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de Nueva Habitación", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Nº Habitación:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Estado:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Tipo:");

        txthabitacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txthabitacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txthabitacionKeyTyped(evt);
            }
        });

        cmbestado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbestado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disponible", "Ocupado", "Inhabilitado", "Reservad" }));

        cmbtipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbtipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbtipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbtipoActionPerformed(evt);
            }
        });

        btnbuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txthabitacion)
                    .addComponent(cmbestado, 0, 105, Short.MAX_VALUE)
                    .addComponent(cmbtipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnbuscar)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txthabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
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
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btnsalir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        btnactualizar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnactualizar.setText("Actualizar");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnguardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnnuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnsalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnactualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnnuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnactualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(btnguardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnsalir)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
        bandera_habitacion=null;
        dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        String numero1=null;
        if(txthabitacion.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Ingrese el Nº de habitación","¡Error!",JOptionPane.ERROR_MESSAGE);
        }
        else {      
        try{
            Conectar cc=new Conectar();
            Connection cn=cc.conexion();
            PreparedStatement sent = cn.prepareStatement("select nro_hab from habitacion where nro_hab='"+txthabitacion.getText()+"'");
            rs = sent.executeQuery(); 
            while(rs.next()){  
                 numero1= rs.getString("nro_hab");
            }              
            if (txthabitacion.getText().equals(numero1)){
                    JOptionPane.showMessageDialog(null, "Numero de habitacion ya existe: " + numero1, "Mensaje",JOptionPane.INFORMATION_MESSAGE);
                }
            else{
                    PreparedStatement pst=cn.prepareStatement("INSERT INTO habitacion(id_habitacion,nro_hab,estado,tip_habitacion_id_tipo) Values(?,?,?,?)");
                    pst.setString(1,null);
                    pst.setString(2,String.valueOf(txthabitacion.getText()));
                    pst.setString(3,(String)cmbestado.getSelectedItem());
                    pst.setString(4,String.valueOf(r));
                    int a=pst.executeUpdate();
                    if(a>0){
                        JOptionPane.showMessageDialog(null,"registro exitoso");
                        txthabitacion.setEnabled(false);
                        cmbtipo.setEnabled(false);
                        cmbestado.setEnabled(false);
                        btnactualizar.setEnabled(false);
                        btnguardar.setEnabled(false);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"error al agregar");
                    }
                    
                }
            cc.desconectar();
            }catch(HeadlessException | SQLException e){
            }
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:
        txthabitacion.setText("");
        cmbestado.setSelectedIndex(0); 
        cmbtipo.setSelectedIndex(0);      
        cmbestado.setEnabled(true);
        txthabitacion.setEnabled(true);
        cmbtipo.setEnabled(true);
        btnguardar.setEnabled(true);
        btnactualizar.setEnabled(false);
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // TODO add your handling code here:
        buscar_habit=new buscar_habitacion(this,true);
        buscar_habit.setVisible(true);
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void cmbtipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbtipoActionPerformed
        // TODO add your handling code here:
        Conectar cc=new Conectar();
        Connection cn=cc.conexion();
        try{
            Statement sent1 = cn.createStatement();
            ResultSet rs1 = sent1.executeQuery("select id_tipo, nombre_tipo from tip_habitacion where nombre_tipo = '"+this.cmbtipo.getSelectedItem()+"'");
            if(rs1.next()){
                r = Integer.valueOf(rs1.getString("id_tipo"));
            }
            cc.desconectar();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_cmbtipoActionPerformed

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
        // TODO add your handling code here:
        String numero=null;
        String id_hab=null;
        if(txthabitacion.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Ingrese el Nº habitación","¡Error!",JOptionPane.ERROR_MESSAGE);
        }
        else
        {
        try {
                Conectar cc=new Conectar();            
                Connection cn=cc.conexion();
                PreparedStatement sent = cn.prepareStatement("select id_habitacion,nro_hab from habitacion where nro_hab='"+txthabitacion.getText()+"'");
                rs = sent.executeQuery(); 
                while(rs.next()){
                    numero = rs.getString("nro_hab");
                    id_hab =rs.getString("id_habitacion");
                }

                if ((id.equals(id_hab) && txthabitacion.getText().equals(numhabitacion))|| (!txthabitacion.getText().equals(numero))){
                    Integer tip=cmbtipo.getSelectedIndex()+1; 
                        PreparedStatement pst = cn.prepareStatement("UPDATE habitacion SET nro_hab='"+txthabitacion.getText()+"',estado='"+(String) cmbestado.getSelectedItem()+"',tip_habitacion_id_tipo='"+tip+"' WHERE id_habitacion="+id);
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Modificacion exitosa","¡Aviso!",JOptionPane.INFORMATION_MESSAGE);   
                        cc.desconectar();
                        txthabitacion.setEnabled(false);
                        cmbtipo.setEnabled(false);
                        cmbestado.setEnabled(false);
                        btnactualizar.setEnabled(false);
                        btnguardar.setEnabled(false);
                        cc.desconectar();    
                }
                else{
                    JOptionPane.showMessageDialog(null, "Numero de habitacion ya existe: " + numero, "Mensaje",JOptionPane.INFORMATION_MESSAGE);
                    }
        }
            catch (SQLException e) {
                System.out.print(e.getMessage());
            }
        }
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void txthabitacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txthabitacionKeyTyped
        // TODO add your handling code here:
        int numerocaracteres=5;
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnactualizar;
    private javax.swing.JButton btnbuscar;
    public static javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    public static javax.swing.JComboBox<String> cmbestado;
    public static javax.swing.JComboBox<String> cmbtipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JTextField txthabitacion;
    // End of variables declaration//GEN-END:variables
}
