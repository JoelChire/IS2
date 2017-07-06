package Formulario;

import ClaseConectar.Conectar;
import java.awt.HeadlessException;
import java.sql.Connection;
import static java.sql.JDBCType.NULL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class cobro_diario extends javax.swing.JInternalFrame {

    Conectar cc=new Conectar();
    Connection cn=cc.conexion();
    Integer n=1;
    public static String bandera_cobro;
    public String usuario_cobro;
    public cobro_diario() {        
        initComponents();
        this.setLocation(15, 10);
        setResizable(false);
        this.setTitle("Cobro Diario");
        mostrardatos("");
        usuario_cobro=MenuPrincipal.usuario_actual;  
        
        txtrecepcionista.setText(usuario_cobro);        
        bandera_cobro="bc";
        txtfechaactual.setText(fecha_actual());
        txtmontoporcobrar.setEnabled(false);
        txtmontocobrado.setEnabled(false);
        txtrecibido.setEnabled(false);
        txtalquiler.setEnabled(false);
        txtvuelto.setEnabled(false);
        btnguardar.setEnabled(false);
        btncalcular.setEnabled(false);
        btnnuevo.setEnabled(false);
        txtid.setEnabled(false);
        obt_id();
            
    }
    
  
    public static String fecha_actual(){
        Date fecha = new Date();
        SimpleDateFormat formatoFecha= new SimpleDateFormat("YYYY-MM-dd");
        return formatoFecha.format(fecha);
    
    }
    
    public void obt_id(){
        try{
            //obteniendo id de alquila.. id maximo            
            ResultSet rsa;
            Statement sent = cn.createStatement();
            rsa = sent.executeQuery("SELECT IFNULL(MAX(CAST(id_dinero AS UNSIGNED)), 0) codigoExterno FROM hotel_version10.detalle_diario_dinero");
            int cont;
            while(rsa.next()){
                cont =Integer.parseInt(rsa.getString("codigoExterno"))+1;
                this.txtid.setText(String.valueOf(cont));
            }            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }      
    } 
    void limpiar(){
        txtmontocobrado.setText("");
        txtnombre.setText("");
        txtrecibido.setText("");
        txtmontoporcobrar.setText("");
        txtvuelto.setText("");
        txtid.setText("");
        txtalquiler.setText("");
        btncalcular.setEnabled(false);
        obt_id(); 
        txtfechaactual.setText(fecha_actual());
        txtrecepcionista.setText(usuario_cobro);
        
               
    }
        
    void mostrardatos(String valor){
    DefaultTableModel modelo= new DefaultTableModel();
    modelo.addColumn("ID ALQUILA");
    modelo.addColumn("NOMRES");
    modelo.addColumn("APELLIDOS");
    modelo.addColumn("NRO HABITACION");
    modelo.addColumn("FECHA_LLEGADA");      
    jTable1.setModel(modelo);
    String SQL="";
    if(valor.equals(""))
    {    String []datos = new String [5];

        SQL="SELECT a.id_alquila,h.nombre_h,h.apellidos_h,ha.nro_hab,a.fecha_llegada\n" +
"FROM alquila a INNER JOIN huesped h on a.huesped_id_huesped=h.id_huesped\n" +
"INNER JOIN habitacion ha on a.habitacion_id_habitacion=ha.id_habitacion";
    }
    else{
        SQL="SELECT a.id_alquila,h.nombre_h,h.apellidos_h,ha.nro_hab,a.fecha_llegada\n" +
"FROM alquila a INNER JOIN huesped h on a.huesped_id_huesped=h.id_huesped\n" +
"INNER JOIN habitacion ha on a.habitacion_id_habitacion=ha.id_habitacion WHERE h.nombre_h LIKE '%"+valor+"%'";
    }
 
    String []datos = new String [5];
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
                modelo.addRow(datos);
            }
            jTable1.setModel(modelo);
            cc.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(cobro_diario.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel2 = new javax.swing.JPanel();
        btnguardar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        btncalcular = new javax.swing.JButton();
        btnnuevo = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lb_id_alq_cb_diario = new javax.swing.JLabel();
        txtalquiler = new javax.swing.JTextField();
        lb_vuelt_cb_diario3 = new javax.swing.JLabel();
        txtfechaactual = new javax.swing.JTextField();
        lb_id_recep_cb_diario = new javax.swing.JLabel();
        txtrecepcionista = new javax.swing.JTextField();
        lb_mont_c_cb_diario = new javax.swing.JLabel();
        txtmontocobrado = new javax.swing.JTextField();
        lb_mont_xc_cb_diario2 = new javax.swing.JLabel();
        lb_vuelt_cb_diario4 = new javax.swing.JLabel();
        txtvuelto = new javax.swing.JTextField();
        txtmontoporcobrar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtrecibido = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtnombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setTitle("COBRO DIARIO");
        setToolTipText("");

        jPanel2.setBackground(new java.awt.Color(221, 227, 238));

        btnguardar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btnsalir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        btncalcular.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btncalcular.setText("Calcular");
        btncalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncalcularActionPerformed(evt);
            }
        });

        btnnuevo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btncalcular, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnguardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnnuevo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnnuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btncalcular)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnguardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnsalir)
                .addGap(17, 17, 17))
        );

        jPanel3.setBackground(new java.awt.Color(220, 226, 237));

        lb_id_alq_cb_diario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_id_alq_cb_diario.setText("Alquiler:");

        txtalquiler.setEditable(false);

        lb_vuelt_cb_diario3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_vuelt_cb_diario3.setText("Fecha Actual: ");

        txtfechaactual.setEditable(false);

        lb_id_recep_cb_diario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_id_recep_cb_diario.setText("Recepcionista:");

        txtrecepcionista.setEditable(false);

        lb_mont_c_cb_diario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_mont_c_cb_diario.setText("Monto Cobrado:");

        txtmontocobrado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtmontocobradoKeyPressed(evt);
            }
        });

        lb_mont_xc_cb_diario2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_mont_xc_cb_diario2.setText("Monto por Cobrar:");

        lb_vuelt_cb_diario4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_vuelt_cb_diario4.setText("Vuelto:");

        txtvuelto.setEditable(false);

        txtmontoporcobrar.setEditable(false);
        txtmontoporcobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmontoporcobrarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Monto Recibido:");

        txtrecibido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtrecibidoKeyPressed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ID:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lb_id_alq_cb_diario)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lb_id_recep_cb_diario)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtalquiler)
                            .addComponent(txtrecepcionista, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtid))
                            .addComponent(lb_vuelt_cb_diario3))
                        .addGap(4, 4, 4)
                        .addComponent(txtfechaactual)))
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_mont_xc_cb_diario2)
                    .addComponent(lb_vuelt_cb_diario4)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_mont_c_cb_diario))
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtvuelto, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtrecibido, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmontoporcobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmontocobrado, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtmontocobrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_mont_c_cb_diario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtalquiler, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lb_id_alq_cb_diario))
                            .addComponent(txtrecibido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lb_mont_xc_cb_diario2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtfechaactual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lb_vuelt_cb_diario3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtmontoporcobrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lb_vuelt_cb_diario4)
                                .addComponent(txtrecepcionista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lb_id_recep_cb_diario))
                            .addComponent(txtvuelto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnombreKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Nombre:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        btnguardar.setEnabled(false);
        btncalcular.setEnabled(false);
        btnnuevo.setEnabled(true);
        if(txtmontocobrado.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Ingrese el monto cobrado ","ERROR",JOptionPane.ERROR_MESSAGE);
        }else   if (txtrecibido.getText().isEmpty()) {            
            JOptionPane.showMessageDialog(null,"Ingrese el monto recibido","ERROR",JOptionPane.ERROR_MESSAGE); 
        }else
        {
            try
            {            
                PreparedStatement pst=cn.prepareStatement("INSERT INTO hotel_version10.detalle_diario_dinero"
                    + " (id_dinero,fecha_actual_dinero,id_usuario_dinero,monto_cobrado,monto_xcobrado,vuelto,alquila_id_alquila)"
                     + " VALUES (?,?,?,?,?,?,?);");
                pst.setString(1,txtid.getText());          
                pst.setString(2,txtfechaactual.getText());
                pst.setString(3,txtrecepcionista.getText());
                pst.setString(4,txtmontocobrado.getText());             
                pst.setString(5,txtmontoporcobrar.getText());
                pst.setString(6,txtvuelto.getText());   
                pst.setString(7,txtalquiler.getText());
                int a=pst.executeUpdate();
                //
               /*
                String habb=nro_habitacion_a.getText();
                PreparedStatement pst1=cn.prepareStatement("UPDATE hotel_version7.habitacion SET estado='Ocupado' WHERE nro_hab='"+habb+"'");                
                int b=pst1.executeUpdate();
                */
                if((a>0)){                    
                    JOptionPane.showMessageDialog(null,"Registro exitoso ");                                       
                }
                else{
                    JOptionPane.showMessageDialog(null,"error al agregar ");
                }  
                
            }catch(HeadlessException | SQLException e){
                JOptionPane.showMessageDialog(null, "error al agegar datos en detalle_diario_dinero " +e);
            }
            n=1;
            mostrardatos("");
            //tty
        }
    }//GEN-LAST:event_btnguardarActionPerformed
    private void formWindowClosing(java.awt.event.WindowEvent evt) {                                   
        // cerrando ventana
        bandera_cobro=null;
    }
    
    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
        
        bandera_cobro=null;
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        btncalcular.setEnabled(true);
        btnnuevo.setEnabled(false);
        txtmontocobrado.setEnabled(true);
        txtrecibido.setEnabled(true);
        txtalquiler.setEnabled(true);
       int fila= jTable1.getSelectedRow();
        //txtusuario.setEnabled(true);
        
        if(fila>=0){
        txtalquiler.setText(jTable1.getValueAt(fila, 0).toString());
        
        }
        String id =(txtalquiler.getText());
            try{
                ResultSet rs1;
                PreparedStatement pst=cn.prepareStatement("SELECT alquila_id_alquila FROM hotel_version10.detalle_diario_dinero where alquila_id_alquila='"+id+"'");
                rs1 = pst.executeQuery();//buscando datos y guardando en interfaz
                if(rs1.next()){
                    ResultSet moncob;
                    Statement sent = cn.createStatement();
                    moncob = sent.executeQuery("Select min(monto_xcobrado) as monto_xcobrar from hotel_version10.detalle_diario_dinero where alquila_id_alquila='"+id+"'"); 
                    while(moncob.next()){ 
                    this.txtmontoporcobrar.setText(moncob.getString("monto_xcobrar"));}
                }    
                else{
                    ResultSet moncob;
                    Statement sent = cn.createStatement();
                    moncob = sent.executeQuery("Select monto_total from hotel_version10.alquila where id_alquila='"+id+"'"); 
                    while(moncob.next()){ 
                    this.txtmontoporcobrar.setText(moncob.getString("monto_total"));}
                }   
            }
            catch(HeadlessException | SQLException e){
                System.err.println("No se pudo buscar");
            }
    }//GEN-LAST:event_jTable1MouseClicked

    private void txtnombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyReleased
        // TODO add your handling code here:
        mostrardatos(txtnombre.getText());
    }//GEN-LAST:event_txtnombreKeyReleased

    private void txtmontoporcobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmontoporcobrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmontoporcobrarActionPerformed

    private void btncalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncalcularActionPerformed
        // TODO add your handling code here:
        //btncalcular.setEnabled(false);
        btnnuevo.setEnabled(false);
        Double cobrado = Double.parseDouble(txtmontocobrado.getText()); 
        Double recibido = Double.parseDouble(txtrecibido.getText());
        String id =(txtalquiler.getText());
        try{
                ResultSet rs1;
                PreparedStatement pst=cn.prepareStatement("SELECT alquila_id_alquila FROM hotel_version10.detalle_diario_dinero where alquila_id_alquila='"+id+"'");
                rs1 = pst.executeQuery();//buscando datos y guardando en interfaz
                if(rs1.next()){
                    ResultSet moncob;
                    Statement sent = cn.createStatement();
                    moncob = sent.executeQuery("Select min(monto_xcobrado) as monto_xcobrar from hotel_version10.detalle_diario_dinero where alquila_id_alquila='"+id+"'"); 
                    while(moncob.next()){ 
                    Double montoxcobrar = Double.parseDouble(moncob.getString("monto_xcobrar"));
                    Double montoxcobrado = montoxcobrar - cobrado;
                    this.txtmontoporcobrar.setText(String.valueOf(montoxcobrado));}
                }    
                else{
                    ResultSet moncob;
                    Statement sent = cn.createStatement();
                    moncob = sent.executeQuery("Select monto_total from hotel_version10.alquila where id_alquila='"+id+"'"); 
                    while(moncob.next()){
                    Double montoxcobrar = Double.parseDouble(moncob.getString("monto_total"));
                    Double montoxcobrado = montoxcobrar - cobrado;
                    this.txtmontoporcobrar.setText(String.valueOf(montoxcobrado));}
                }   
            }
            catch(HeadlessException | SQLException e){
                System.err.println("No se pudo buscar");
            }
        txtmontoporcobrar.setEnabled(true);
        Double vuelto = recibido - cobrado;
        this.txtvuelto.setText(String.valueOf(vuelto));
        txtvuelto.setEnabled(true);
        btnguardar.setEnabled(true);
    }//GEN-LAST:event_btncalcularActionPerformed

    private void txtmontocobradoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmontocobradoKeyPressed
        // TODO add your handling code here:
        String id =(txtalquiler.getText());
            try{
                ResultSet rs1;
                PreparedStatement pst=cn.prepareStatement("SELECT alquila_id_alquila FROM hotel_version10.detalle_diario_dinero where alquila_id_alquila='"+id+"'");
                rs1 = pst.executeQuery();//buscando datos y guardando en interfaz
                if(rs1.next()){
                    ResultSet moncob;
                    Statement sent = cn.createStatement();
                    moncob = sent.executeQuery("Select min(monto_xcobrado) as monto_xcobrar from hotel_version10.detalle_diario_dinero where alquila_id_alquila='"+id+"'"); 
                    while(moncob.next()){ 
                    this.txtmontoporcobrar.setText(moncob.getString("monto_xcobrar"));}
                }    
                else{
                    ResultSet moncob;
                    Statement sent = cn.createStatement();
                    moncob = sent.executeQuery("Select monto_total from hotel_version10.alquila where id_alquila='"+id+"'"); 
                    while(moncob.next()){ 
                    this.txtmontoporcobrar.setText(moncob.getString("monto_total"));}
                }   
            }
            catch(HeadlessException | SQLException e){
                System.err.println("No se pudo buscar");
            }
            txtvuelto.setText("");
            txtmontoporcobrar.setEnabled(false);
            txtvuelto.setEnabled(false);
    }//GEN-LAST:event_txtmontocobradoKeyPressed

    private void txtrecibidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtrecibidoKeyPressed
        // TODO add your handling code here:
        txtvuelto.setText("");
        txtvuelto.setEnabled(false);
    }//GEN-LAST:event_txtrecibidoKeyPressed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:
        limpiar(); 
        txtmontoporcobrar.setEnabled(false);
        txtmontocobrado.setEnabled(false);
        txtrecibido.setEnabled(false);
        txtalquiler.setEnabled(false);
        txtvuelto.setEnabled(false);
        btnguardar.setEnabled(false);
        btncalcular.setEnabled(false);
        btnnuevo.setEnabled(false);
        txtid.setEnabled(false);
    }//GEN-LAST:event_btnnuevoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncalcular;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lb_id_alq_cb_diario;
    private javax.swing.JLabel lb_id_recep_cb_diario;
    private javax.swing.JLabel lb_mont_c_cb_diario;
    private javax.swing.JLabel lb_mont_xc_cb_diario2;
    private javax.swing.JLabel lb_vuelt_cb_diario3;
    private javax.swing.JLabel lb_vuelt_cb_diario4;
    private javax.swing.JTextField txtalquiler;
    private javax.swing.JTextField txtfechaactual;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtmontocobrado;
    private javax.swing.JTextField txtmontoporcobrar;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtrecepcionista;
    private javax.swing.JTextField txtrecibido;
    private javax.swing.JTextField txtvuelto;
    // End of variables declaration//GEN-END:variables
}
