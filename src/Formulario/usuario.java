
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

public class usuario extends javax.swing.JInternalFrame {
    Integer m=1;

    //ResultSet datos;
    public static String bandera_usuario;
    public usuario() {
        initComponents();
        btnactualizar.setEnabled(true);
        btnguardar.setEnabled(true);
        btnnuevo.setEnabled(false);
        mostrardatos("");
        jTable2.setEnabled(false);       
        bandera_usuario="bandera";
    }
    
    void mostrardatos(String valor){
    DefaultTableModel modelo= new DefaultTableModel();
    
    modelo.addColumn("NOMBRES");
    modelo.addColumn("APELLIDOS");
    modelo.addColumn("USUARIO");
    modelo.addColumn("CONTRASEÑA");   
    modelo.addColumn("TURNO");
    modelo.addColumn("TELEFONO"); 
    modelo.addColumn("TIPO");
    jTable2.setModel(modelo);
    String SQL="";
    if(valor.equals(""))
    {    String []datos = new String [7];

        SQL="SELECT * FROM usuario";
    }
    else{
        SQL="SELECT * FROM usuario WHERE nombre_usu LIKE '%"+valor+"%'";
    }
 
    String []datos = new String [7];
        try {
            Conectar cc=new Conectar();            
            Connection cn=cc.conexion();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while(rs.next()){
                datos[0]=rs.getString(2);                
                datos[1]=rs.getString(3);
                datos[2]=rs.getString(1);
                datos[3]=rs.getString(5);
                datos[4]=rs.getString(4);
                datos[5]=rs.getString(6);
                datos[6]=rs.getString(7);
                modelo.addRow(datos);
            }
            jTable2.setEnabled(false);
            cc.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(taxista.class.getName()).log(Level.SEVERE, null, ex);
        }                    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paneldatos2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbturno = new javax.swing.JComboBox<>();
        txtapellidos = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        txtusuario = new javax.swing.JTextField();
        txttelefono = new javax.swing.JTextField();
        cmbtipo = new javax.swing.JComboBox<>();
        txtcontrasena = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnpanel = new javax.swing.JPanel();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setTitle("REGISTRO DE USUARIO");

        paneldatos2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Usuario:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Nombres:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Apellidos:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Turno:");

        cmbturno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbturno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mañana", "Tarde", "Completo" }));
        cmbturno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbturnoActionPerformed(evt);
            }
        });

        txtapellidos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtapellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtapellidosKeyTyped(evt);
            }
        });

        txtnombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });
        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreKeyTyped(evt);
            }
        });

        txtusuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusuarioActionPerformed(evt);
            }
        });
        txtusuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtusuarioKeyTyped(evt);
            }
        });

        txttelefono.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txttelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelefonoActionPerformed(evt);
            }
        });
        txttelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttelefonoKeyTyped(evt);
            }
        });

        cmbtipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbtipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Recepcionista", "Administrador" }));
        cmbtipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbtipoActionPerformed(evt);
            }
        });

        txtcontrasena.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtcontrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcontrasenaActionPerformed(evt);
            }
        });
        txtcontrasena.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcontrasenaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcontrasenaKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Telefono:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Tipo:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Contraseña:");

        javax.swing.GroupLayout paneldatos2Layout = new javax.swing.GroupLayout(paneldatos2);
        paneldatos2.setLayout(paneldatos2Layout);
        paneldatos2Layout.setHorizontalGroup(
            paneldatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneldatos2Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(paneldatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(paneldatos2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(txtcontrasena))
                    .addGroup(paneldatos2Layout.createSequentialGroup()
                        .addGroup(paneldatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(paneldatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtapellidos, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                            .addComponent(txtnombre)
                            .addComponent(txtusuario)))
                    .addGroup(paneldatos2Layout.createSequentialGroup()
                        .addGroup(paneldatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(paneldatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txttelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                            .addGroup(paneldatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cmbtipo, javax.swing.GroupLayout.Alignment.LEADING, 0, 160, Short.MAX_VALUE)
                                .addComponent(cmbturno, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        paneldatos2Layout.setVerticalGroup(
            paneldatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneldatos2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneldatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(paneldatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paneldatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paneldatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcontrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(paneldatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paneldatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paneldatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbturno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnpanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

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

        btnactualizar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnactualizar.setText("Actualizar");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });

        btnsalir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout btnpanelLayout = new javax.swing.GroupLayout(btnpanel);
        btnpanel.setLayout(btnpanelLayout);
        btnpanelLayout.setHorizontalGroup(
            btnpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnpanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(btnpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnactualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                    .addComponent(btnguardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnnuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnsalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        btnpanelLayout.setVerticalGroup(
            btnpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnnuevo)
                .addGap(18, 18, 18)
                .addComponent(btnguardar)
                .addGap(21, 21, 21)
                .addComponent(btnactualizar)
                .addGap(21, 21, 21)
                .addComponent(btnsalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(paneldatos2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(31, 31, 31)
                .addComponent(btnpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(paneldatos2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbturnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbturnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbturnoActionPerformed

    private void txtapellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapellidosKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isDigit(c))
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"Ingresar solo letras","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        } int numerocaracteres=20;
        if (txtapellidos.getText().length()>=numerocaracteres){
        evt.consume();
        JOptionPane.showMessageDialog(null,"Exceso de dígitos","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
        if ((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=47
            ||(int)evt.getKeyChar()>58 && (int)evt.getKeyChar()<=64
            ||(int)evt.getKeyChar()>91 && (int)evt.getKeyChar()<=96
            ||(int)evt.getKeyChar()>123 && (int)evt.getKeyChar()<=255)
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"Ingrese solo letras","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtapellidosKeyTyped

    private void txtnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isDigit(c))
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"Ingresar solo letras","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        } int numerocaracteres=30;
        if (txtnombre.getText().length()>=numerocaracteres){
        evt.consume();
        JOptionPane.showMessageDialog(null,"Exceso de dígitos","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
        if ((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=47
            ||(int)evt.getKeyChar()>58 && (int)evt.getKeyChar()<=64
            ||(int)evt.getKeyChar()>91 && (int)evt.getKeyChar()<=96
            ||(int)evt.getKeyChar()>123 && (int)evt.getKeyChar()<=255)
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"Ingrese solo letras","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtnombreKeyTyped

    private void txtusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusuarioActionPerformed

    private void txttelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoKeyTyped
        // TODO add your handling code here:
        int numerocaracteres=9;
        char d=evt.getKeyChar();
        if (txttelefono.getText().length()>=numerocaracteres){
        evt.consume();
            JOptionPane.showMessageDialog(null,"Exceso de dígitos","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
        if (Character.isLetter(d)) 
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"Inserte solo números","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        } 
        if ((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=47
            ||(int)evt.getKeyChar()>58 && (int)evt.getKeyChar()<=64
            ||(int)evt.getKeyChar()>91 && (int)evt.getKeyChar()<=96
            ||(int)evt.getKeyChar()>123 && (int)evt.getKeyChar()<=255)
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"No usar caracteres","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_txttelefonoKeyTyped

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreActionPerformed

    private void txttelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelefonoActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:
        txtusuario.setText("");
        txtnombre.setText("");
        txtapellidos.setText("");
        cmbturno.setSelectedIndex(0); 
        txtcontrasena.setText("");
        txttelefono.setText("");
        cmbtipo.setSelectedIndex(0); 
        txtusuario.setEnabled(true); 
        txtnombre.setEnabled(true); 
        txtapellidos.setEnabled(true); 
        cmbturno.setEnabled(true); 
        txtcontrasena.setEnabled(true); 
        txttelefono.setEnabled(true); 
        cmbtipo.setEnabled(true);
        btnactualizar.setEnabled(true);
        btnguardar.setEnabled(true);
        btnnuevo.setEnabled(false);
        mostrardatos("");
        jTable2.setEnabled(false);
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        if(txtnombre.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Ingrese el nombre","¡Error!",JOptionPane.ERROR_MESSAGE);
        }
        else if(txtapellidos.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Ingrese el apellido","¡Error!",JOptionPane.ERROR_MESSAGE);
        }
        else if(txtusuario.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Ingrese el nombre de usuario","¡Error!",JOptionPane.ERROR_MESSAGE);
        }
        else if(txtcontrasena.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Ingrese la contraseña","¡Error!",JOptionPane.ERROR_MESSAGE);
        }
        else if(txttelefono.getText().length()>0 && txttelefono.getText().length()<9){
                JOptionPane.showMessageDialog(null,"Teléfono incompleto","¡Error!",JOptionPane.ERROR_MESSAGE);
        }
        else if(m==1){    
            try{ 
            Conectar cc=new Conectar();            
            Connection cn=cc.conexion();
            PreparedStatement pst=cn.prepareStatement("INSERT INTO usuario(id_usuario,nombre_usu,apellido_usu,turno_usu,contrasena,telefono_usu,tipo_usu) Values(?,?,?,?,?,?,?)");
            pst.setString(1,txtusuario.getText());
            pst.setString(2,txtnombre.getText());
            pst.setString(3,txtapellidos.getText());
            pst.setString(4,((String) cmbturno.getSelectedItem()));
            pst.setString(5,txtcontrasena.getText());
            pst.setString(6,txttelefono.getText());
            pst.setString(7,((String) cmbtipo.getSelectedItem()));
            jTable2.setEnabled(false);
            btnguardar.setEnabled(false);
            btnactualizar.setEnabled(false); 
            btnnuevo.setEnabled(true);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Registro exitoso","¡Aviso!",JOptionPane.INFORMATION_MESSAGE);   
            cc.desconectar();
        }catch (HeadlessException | SQLException e){
            System.out.print(e.getMessage());
            }     
    }//GEN-LAST:event_btnguardarActionPerformed
        
        else
        {
        try {

        Conectar cc=new Conectar();            
        Connection cn=cc.conexion();
        PreparedStatement pst = cn.prepareStatement("UPDATE usuario SET nombre_usu='"+txtnombre.getText()+"',apellido_usu='"+txtapellidos.getText()
                                +"',turno_usu='"+(String) cmbturno.getSelectedItem()+"',apellido_usu='"+txtapellidos.getText()+"',contrasena='"+txtcontrasena.getText()
                                +"',contrasena='"+txtcontrasena.getText()+"',tipo_usu='"+(String) cmbtipo.getSelectedItem()+"'  WHERE id_usuario='"+txtusuario.getText()+"'");
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null,"Modificacion exitosa","¡Aviso!",JOptionPane.INFORMATION_MESSAGE);   
        cc.desconectar();
        m=1;
        
            jTable2.setEnabled(false);
            btnguardar.setEnabled(false);
            btnactualizar.setEnabled(false);            
            btnnuevo.setEnabled(true);
        } catch (SQLException e) {
        System.out.print(e.getMessage());
       }   
        }
        mostrardatos("");
        }

    
    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
        bandera_usuario=null;
        dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void txtusuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtusuarioKeyTyped
        // TODO add your handling code here:
        int numerocaracteres=15;
        if (txtusuario.getText().length()>=numerocaracteres){
        evt.consume();
        JOptionPane.showMessageDialog(null,"Exceso de dígitos","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
        else if ((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=47
            ||(int)evt.getKeyChar()>58 && (int)evt.getKeyChar()<=64
            ||(int)evt.getKeyChar()>91 && (int)evt.getKeyChar()<=96
            ||(int)evt.getKeyChar()>123 && (int)evt.getKeyChar()<=255)
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"No se permite usar signos ni símbolos","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtusuarioKeyTyped

    private void txtcontrasenaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcontrasenaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcontrasenaKeyReleased

    private void txtcontrasenaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcontrasenaKeyTyped
        // TODO add your handling code here
        int numerocaracteres=15;
        if (txtcontrasena.getText().length()>=numerocaracteres){
        evt.consume();
        JOptionPane.showMessageDialog(null,"Exceso de dígitos","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
        if ((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=47
            ||(int)evt.getKeyChar()>58 && (int)evt.getKeyChar()<=64
            ||(int)evt.getKeyChar()>91 && (int)evt.getKeyChar()<=96
            ||(int)evt.getKeyChar()>123 && (int)evt.getKeyChar()<=255)
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"No se permite usar signos ni símbolos","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtcontrasenaKeyTyped

    private void txtcontrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcontrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcontrasenaActionPerformed

    private void cmbtipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbtipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbtipoActionPerformed

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
        // TODO add your handling code here:
        jTable2.setEnabled(true);
        txtusuario.setText("");
        txtnombre.setText("");
        txtapellidos.setText("");
        cmbturno.setSelectedIndex(-1); 
        txtcontrasena.setText("");
        txttelefono.setText("");
        cmbtipo.setSelectedIndex(-1);
        txtapellidos.setEnabled(false);
        txtusuario.setEnabled(false);
        cmbturno.setEnabled(false);
        txtcontrasena.setEnabled(false);
        txttelefono.setEnabled(false);
        cmbtipo.setEnabled(false);
        btnguardar.setEnabled(true);
        btnnuevo.setEnabled(false);
        btnactualizar.setEnabled(false);
        m=2;
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void txtnombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyReleased
        // TODO add your handling code here:
        mostrardatos(txtnombre.getText());
    }//GEN-LAST:event_txtnombreKeyReleased

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        int fila=jTable2.getSelectedRow();
        txtapellidos.setEnabled(true);
        txtusuario.setEnabled(true);
        cmbturno.setEnabled(true);
        txtcontrasena.setEnabled(true);
        txttelefono.setEnabled(true);
        cmbtipo.setEnabled(true);
        if(fila>=0){
            
        txtnombre.setText(jTable2.getValueAt(fila, 0).toString());
        txtapellidos.setText(jTable2.getValueAt(fila, 1).toString());
        txtusuario.setText(jTable2.getValueAt(fila, 2).toString());
        txtcontrasena.setText(jTable2.getValueAt(fila, 3).toString());
        txttelefono.setText(jTable2.getValueAt(fila, 5).toString());
        if(jTable2.getValueAt(fila, 6).toString().equals("Administrador"))
        {
            cmbturno.setSelectedIndex(2); 
            cmbtipo.setSelectedIndex(1);
        }
        else if(jTable2.getValueAt(fila, 4).toString().equals("Tarde")){
             cmbturno.setSelectedIndex(1); 
             cmbtipo.setSelectedIndex(0);
        }
        else
        {
            cmbturno.setSelectedIndex(0); 
            cmbtipo.setSelectedIndex(0);
        }
        }
    }//GEN-LAST:event_jTable2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JPanel btnpanel;
    private javax.swing.JButton btnsalir;
    private javax.swing.JComboBox<String> cmbtipo;
    private javax.swing.JComboBox<String> cmbturno;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JPanel paneldatos2;
    private javax.swing.JTextField txtapellidos;
    private javax.swing.JTextField txtcontrasena;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txttelefono;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
