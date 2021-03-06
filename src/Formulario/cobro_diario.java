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
        usuario_cobro=carga.usuario_carga;  
        
        txtrecepcionista.setText(usuario_cobro);        
        bandera_cobro="bc";
        txtfechaactual.setText(fecha_actual());
        txtmontoporcobrar.setEnabled(false);
        txtmontocobrado.setEnabled(false);
        txtrecibido.setEnabled(false);
        txtalquiler.setEnabled(false);
        txtvuelto.setEnabled(false);
        btnguardar.setEnabled(false);
        txtfechaactual.setEnabled(false);
        txtrecepcionista.setEnabled(false);
        btncalcular.setEnabled(false);
        btnnuevo.setEnabled(false);
        txtid.setEnabled(false);
        obt_id();
            
    }
    
  
     public static String fecha_actual(){
        Date fecha = new Date(System.currentTimeMillis());
        //SimpleDateFormat formatodate= new SimpleDateFormat("YYYY-MM-dd");
        SimpleDateFormat formatofecha= new SimpleDateFormat("YYYY-MM-dd HH:mm:ss"); 
       return formatofecha.format(fecha); 
    
    }
    
    public void obt_id(){
        try{
            //obteniendo id de alquila.. id maximo            
            ResultSet rsa;
            Statement sent = cn.createStatement();
            rsa = sent.executeQuery("SELECT IFNULL(MAX(CAST(id_dinero AS UNSIGNED)), 0) codigoExterno FROM detalle_diario_dinero");
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
        jTable1.setEnabled(true);
        
               
    }
        
    void mostrardatos(String valor){
    DefaultTableModel modelo= new DefaultTableModel();
    modelo.addColumn("Nº ALQUILER");
    modelo.addColumn("NOMBRES");
    modelo.addColumn("APELLIDOS");
    modelo.addColumn("NRO HABITACION");
    modelo.addColumn("FECHA DE LLEGADA");      
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

        txtnombre = new javax.swing.JTextField();
        jcMousePanel1 = new jcMousePanel.jcMousePanel();
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
        jPanel2 = new javax.swing.JPanel();
        btnguardar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        btncalcular = new javax.swing.JButton();
        btnnuevo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnombreKeyReleased(evt);
            }
        });

        setTitle("Cobro Diario");
        setToolTipText("");

        jcMousePanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/fondo7.jpg"))); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nuevo Cobro Diario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtmontocobradoKeyTyped(evt);
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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtrecibidoKeyTyped(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nº Cobro");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(lb_vuelt_cb_diario3)
                        .addGap(4, 4, 4)
                        .addComponent(txtfechaactual))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb_id_alq_cb_diario)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap(29, Short.MAX_VALUE)
                                .addComponent(lb_id_recep_cb_diario)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtalquiler)
                            .addComponent(txtrecepcionista, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lb_mont_xc_cb_diario2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtfechaactual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lb_vuelt_cb_diario3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtmontoporcobrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lb_vuelt_cb_diario4)
                                .addComponent(txtrecepcionista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lb_id_recep_cb_diario))
                            .addComponent(txtvuelto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        btnguardar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/GUARdar1.png"))); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btnsalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cerrar13.png"))); // NOI18N
        btnsalir.setText("Cancelar");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        btncalcular.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btncalcular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/calcular.png"))); // NOI18N
        btncalcular.setText("Calcular");
        btncalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncalcularActionPerformed(evt);
            }
        });

        btnnuevo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/nuevo13.png"))); // NOI18N
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
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnsalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnnuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btncalcular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnguardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btncalcular)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnsalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre:");

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
                .addGap(20, 20, 20)
                .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(jcMousePanel1Layout.createSequentialGroup()
                        .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jcMousePanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jcMousePanel1Layout.setVerticalGroup(
            jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jcMousePanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jcMousePanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcMousePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcMousePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtmontocobradoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmontocobradoKeyPressed
        // TODO add your handling code here:
      
        String id =(txtalquiler.getText());
        try{
            ResultSet rs1;
            PreparedStatement pst=cn.prepareStatement("SELECT alquila_id_alquila FROM detalle_diario_dinero where alquila_id_alquila='"+id+"'");
            rs1 = pst.executeQuery();//buscando datos y guardando en interfaz
            if(rs1.next()){
                ResultSet moncob;
                Statement sent = cn.createStatement();
                moncob = sent.executeQuery("Select min(monto_xcobrado) as monto_xcobrar from detalle_diario_dinero where alquila_id_alquila='"+id+"'");
                while(moncob.next()){
                    this.txtmontoporcobrar.setText(moncob.getString("monto_xcobrar"));}
            }
            else{
                ResultSet moncob;
                Statement sent = cn.createStatement();
                moncob = sent.executeQuery("Select monto_total from alquila where id_alquila='"+id+"'");
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

    private void txtmontoporcobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmontoporcobrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmontoporcobrarActionPerformed

    private void txtrecibidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtrecibidoKeyPressed
        // TODO add your handling code here:
                 
        txtvuelto.setText("");
        txtvuelto.setEnabled(false);
    }//GEN-LAST:event_txtrecibidoKeyPressed

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
                PreparedStatement pst=cn.prepareStatement("INSERT INTO detalle_diario_dinero"
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

                if((a>0)){
                    JOptionPane.showMessageDialog(null,"Registro exitoso ");
                    txtid.setEnabled(false);
                    txtfechaactual.setEnabled(false);
                    txtmontocobrado.setEnabled(false);
                    txtmontoporcobrar.setEnabled(false);
                    txtvuelto.setEnabled(false);
                    txtalquiler.setEnabled(false);
                    txtrecibido.setEnabled(false);
                    txtrecepcionista.setEnabled(false);
                    jTable1.setEnabled(false);
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

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:   
        cc.desconectar();
        bandera_cobro=null;
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void btncalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncalcularActionPerformed
        // TODO add your handling code here:
        //btncalcular.setEnabled(false);
        btnnuevo.setEnabled(false);
        Double cobrado = Double.parseDouble(txtmontocobrado.getText());
        Double recibido = Double.parseDouble(txtrecibido.getText());
        String id =(txtalquiler.getText());
        try{
            ResultSet rs1;
            PreparedStatement pst=cn.prepareStatement("SELECT alquila_id_alquila FROM detalle_diario_dinero where alquila_id_alquila='"+id+"'");
            rs1 = pst.executeQuery();//buscando datos y guardando en interfaz
            if(rs1.next()){
                ResultSet moncob;
                Statement sent = cn.createStatement();
                moncob = sent.executeQuery("Select min(monto_xcobrado) as monto_xcobrar from detalle_diario_dinero where alquila_id_alquila='"+id+"'");
                while(moncob.next()){
                    Double montoxcobrar = Double.parseDouble(moncob.getString("monto_xcobrar"));
                    Double montoxcobrado = montoxcobrar - cobrado;
                    this.txtmontoporcobrar.setText(String.valueOf(montoxcobrado));}
            }
            else{
                ResultSet moncob;
                Statement sent = cn.createStatement();
                moncob = sent.executeQuery("Select monto_total from alquila where id_alquila='"+id+"'");
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

    private void txtnombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyReleased
        // TODO add your handling code here:
        mostrardatos(txtnombre.getText());
    }//GEN-LAST:event_txtnombreKeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int fila= jTable1.getSelectedRow();
        //txtusuario.setEnabled(true);

        if(fila>=0){
            txtalquiler.setText(jTable1.getValueAt(fila, 0).toString());
            btncalcular.setEnabled(true);
            btnnuevo.setEnabled(false);
            txtmontocobrado.setEnabled(true);
            txtrecibido.setEnabled(true);
            txtalquiler.setEnabled(true);
        }
        String id =(txtalquiler.getText());
        try{
            ResultSet rs1;
            PreparedStatement pst=cn.prepareStatement("SELECT alquila_id_alquila FROM detalle_diario_dinero where alquila_id_alquila='"+id+"'");
            rs1 = pst.executeQuery();//buscando datos y guardando en interfaz
            if(rs1.next()){
                ResultSet moncob;
                Statement sent = cn.createStatement();
                moncob = sent.executeQuery("Select min(monto_xcobrado) as monto_xcobrar from detalle_diario_dinero where alquila_id_alquila='"+id+"'");
                while(moncob.next()){
                    this.txtmontoporcobrar.setText(moncob.getString("monto_xcobrar"));}
            }
            else{
                ResultSet moncob;
                Statement sent = cn.createStatement();
                moncob = sent.executeQuery("Select monto_total from alquila where id_alquila='"+id+"'");
                while(moncob.next()){
                    this.txtmontoporcobrar.setText(moncob.getString("monto_total"));}
            }
        }
        catch(HeadlessException | SQLException e){
            System.err.println("No se pudo buscar");
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void txtmontocobradoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmontocobradoKeyTyped
        // TODO add your handling code here:
        int numerocaracteres=8;
        char d=evt.getKeyChar();
        if (txtmontocobrado.getText().length()>=numerocaracteres){
            evt.consume();
            JOptionPane.showMessageDialog(null,"Exceso de dígitos","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
        else if (Character.isLetter(d))
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"Solo números","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
        else if ((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=45
            ||(int)evt.getKeyChar()>46 && (int)evt.getKeyChar()<=47
            ||(int)evt.getKeyChar()>58 && (int)evt.getKeyChar()<=64
            ||(int)evt.getKeyChar()>91 && (int)evt.getKeyChar()<=96
            ||(int)evt.getKeyChar()>123 && (int)evt.getKeyChar()<=255)
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"No usar caracteres","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtmontocobradoKeyTyped

    private void txtrecibidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtrecibidoKeyTyped
        // TODO add your handling code here:
        int numerocaracteres=8;
        char d=evt.getKeyChar();
        if (txtrecibido.getText().length()>=numerocaracteres){
            evt.consume();
            JOptionPane.showMessageDialog(null,"Exceso de dígitos","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
        else if (Character.isLetter(d))
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"Solo números","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
        else if ((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=45
            ||(int)evt.getKeyChar()>46 && (int)evt.getKeyChar()<=47
            ||(int)evt.getKeyChar()>58 && (int)evt.getKeyChar()<=64
            ||(int)evt.getKeyChar()>91 && (int)evt.getKeyChar()<=96
            ||(int)evt.getKeyChar()>123 && (int)evt.getKeyChar()<=255)
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"No usar caracteres","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtrecibidoKeyTyped
    private void formWindowClosing(java.awt.event.WindowEvent evt) {                                   
        // cerrando ventana
        bandera_cobro=null;
    }
    

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
    private jcMousePanel.jcMousePanel jcMousePanel1;
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
