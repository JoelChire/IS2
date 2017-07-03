
package Formulario;

import ClaseConectar.Conectar;
import Clases.fecha;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class reserva extends javax.swing.JInternalFrame {

    Conectar cc=new Conectar();
    Connection cn=cc.conexion();
    public static String bandera_reserva;
    public String usuario_reserva; 
    //public static seleccion_habitacion seleccion_h;
    public static seleccion_habitacion_re seleccion_ha;
    public static elegir_huesped_re elegir_h;
    DefaultTableModel modelo;
    Integer seleccionado;
    fecha fecha=new fecha();    
    Integer cantidadhabitaciones=0;    
    public String id_huesped_huesped;//recibe el huesped de la interfaz elegir
    //"Nro de Habitacion", "Tipo", "Estado","Costo","Nro Camas"
    public static String id_habitacion_seleccion; //guarda el id retornado
    public static String numero_h;
    public static String tipo_h;
    public static String estado_h;
    public static String costo_h;
    public static String camas_h;
    ////
    
    public reserva() {
        initComponents();
        this.setTitle("Reserva");
        bandera_reserva="bandera";
        this.setLocation(5,5);
        setResizable(false);
        
        usuario_reserva=MenuPrincipal.usuario_actual; 
        bandera_reserva="bandera";
        ////Tabla              
        modelo= new DefaultTableModel();        
        modelo.addColumn("Nro de Habitacion");
        modelo.addColumn("Tipo");
        modelo.addColumn("Estado");
        modelo.addColumn("Costo");       
        modelo.addColumn("Nro Camas");                
        this.tb_det.setModel(modelo);
        ///
        limpiar();  
        btnnuevo();        
        obt_id();
    }
    
    void bloqueorestantes(){
        btnbuscar_h.setEnabled(false);
        btnnuevohuesped.setEnabled(false); 
        btnexplorar.setEnabled(false);
        txtdni.setEnabled(false);
        txtnombre.setEnabled(false);
        txtapellido.setEnabled(false);
    }    
    void btnnuevo(){
        btnbuscar_h.setEnabled(true);
        btnnuevohuesped.setEnabled(true); 
        btnexplorar.setEnabled(true);
        btnbuscarhabitacion.setEnabled(false);
        btneliminar.setEnabled(false);
        btneliminart.setEnabled(false);
        
        btnguardar.setEnabled(false);
        //
        txtdni.setEnabled(true);
        txtdni.setEditable(true);
        txtnombre.setEnabled(true);
        txtapellido.setEnabled(true);
        txtcant.setEnabled(false);
        txtcant.setEditable(true);
        txtadelanto.setEnabled(false);
        
        txtidreserva.setEnabled(false);
        txtllegada.setEnabled(false);
        txtsalida.setEnabled(false);
        txtusuario.setEnabled(false);
        txtmontototal.setEnabled(false);
        txthabitaciones.setEnabled(false);          
    }    
    void limpiar(){
        txtdni.setText("");
        txtnombre.setText("");
        txtapellido.setText("");
        txtcant.setText("0");
        txtadelanto.setText("");
        obt_id(); 
        
        txtusuario.setText(usuario_reserva);
        txtmontototal.setText("");
        txthabitaciones.setText("");
        
        eliminarelementos();       
    }
    
    void eliminarelementos(){
        int cantfil=tb_det.getRowCount();
        for(int i=cantfil-1;i>=0;i--){
            modelo.removeRow(i);
            cantidadhabitaciones--;
        }
    }
    
    public void obt_id(){
        try{
            //obteniendo id de alquila.. id maximo            
            ResultSet rsa;
            Statement sent = cn.createStatement();
            rsa = sent.executeQuery("SELECT IFNULL(MAX(CAST(id_alquila AS UNSIGNED)), 0) codigoExterno FROM hotel_version10.alquila");
            int cont;
            while(rsa.next()){
                cont =Integer.parseInt(rsa.getString("codigoExterno"))+1;
                this.txtidreserva.setText(String.valueOf(cont));
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }  
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        panel_dt_huesp = new javax.swing.JPanel();
        lb_dni_alq = new javax.swing.JLabel();
        txtdni = new javax.swing.JTextField();
        lb_nom_alq = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtapellido = new javax.swing.JTextField();
        lb_ape_alq = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtcant = new javax.swing.JTextField();
        btnbuscar_h = new javax.swing.JButton();
        btnnuevohuesped = new javax.swing.JButton();
        btnexplorar = new javax.swing.JButton();
        panel_dt_hab = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btneliminar = new javax.swing.JButton();
        btneliminart = new javax.swing.JButton();
        btnbuscarhabitacion = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_det = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lb_num_camas_hab_alq1 = new javax.swing.JLabel();
        txtadelanto = new javax.swing.JTextField();
        lb_num_camas_hab_alq = new javax.swing.JLabel();
        txtmontototal = new javax.swing.JTextField();
        txthabitaciones = new javax.swing.JTextField();
        lb_obs_alq1 = new javax.swing.JLabel();
        panel_dt_reserva = new javax.swing.JPanel();
        lb_id_alq1 = new javax.swing.JLabel();
        lb_fech_lleg1 = new javax.swing.JLabel();
        lb_fech_sal1 = new javax.swing.JLabel();
        lb_id_recep1 = new javax.swing.JLabel();
        txtidreserva = new javax.swing.JTextField();
        txtusuario = new javax.swing.JTextField();
        txtsalida = new com.toedter.calendar.JDateChooser();
        txtllegada = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        btnnuevo = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();

        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        panel_dt_huesp.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Huésped", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("URW Gothic L", 1, 12))); // NOI18N
        panel_dt_huesp.setToolTipText("");

        lb_dni_alq.setFont(new java.awt.Font("URW Gothic L", 0, 12)); // NOI18N
        lb_dni_alq.setText("DNI:");

        txtdni.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtdni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdniActionPerformed(evt);
            }
        });
        txtdni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdniKeyTyped(evt);
            }
        });

        lb_nom_alq.setFont(new java.awt.Font("URW Gothic L", 0, 12)); // NOI18N
        lb_nom_alq.setText("Nombres:");

        txtnombre.setEditable(false);
        txtnombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtapellido.setEditable(false);
        txtapellido.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lb_ape_alq.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_ape_alq.setText("Apellidos:");

        jLabel2.setFont(new java.awt.Font("URW Gothic L", 0, 12)); // NOI18N
        jLabel2.setText("Cantidad de personas:");

        txtcant.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        txtcant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcantKeyTyped(evt);
            }
        });

        btnbuscar_h.setText("Buscar");
        btnbuscar_h.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscar_hActionPerformed(evt);
            }
        });

        btnnuevohuesped.setText("Nuevo Huesped");
        btnnuevohuesped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevohuespedActionPerformed(evt);
            }
        });

        btnexplorar.setText("Explorar");
        btnexplorar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexplorarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_dt_huespLayout = new javax.swing.GroupLayout(panel_dt_huesp);
        panel_dt_huesp.setLayout(panel_dt_huespLayout);
        panel_dt_huespLayout.setHorizontalGroup(
            panel_dt_huespLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_dt_huespLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_dt_huespLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_dt_huespLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtcant, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_dt_huespLayout.createSequentialGroup()
                        .addGroup(panel_dt_huespLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_nom_alq)
                            .addComponent(lb_ape_alq))
                        .addGap(33, 33, 33)
                        .addGroup(panel_dt_huespLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtnombre, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(txtapellido)))
                    .addGroup(panel_dt_huespLayout.createSequentialGroup()
                        .addComponent(lb_dni_alq)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_dt_huespLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnnuevohuesped)
                            .addGroup(panel_dt_huespLayout.createSequentialGroup()
                                .addComponent(btnbuscar_h)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnexplorar)))))
                .addGap(330, 330, 330))
        );
        panel_dt_huespLayout.setVerticalGroup(
            panel_dt_huespLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_dt_huespLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_dt_huespLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_dni_alq)
                    .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscar_h)
                    .addComponent(btnexplorar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnnuevohuesped)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_dt_huespLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_nom_alq)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(panel_dt_huespLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_ape_alq)
                    .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panel_dt_huespLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtcant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_dt_hab.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de Habitación", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("URW Gothic L", 1, 12))); // NOI18N

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btneliminart.setText("Eliminar Todo");
        btneliminart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminartActionPerformed(evt);
            }
        });

        btnbuscarhabitacion.setText("Buscar");
        btnbuscarhabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarhabitacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnbuscarhabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btneliminart)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btneliminar)
                    .addComponent(btneliminart)
                    .addComponent(btnbuscarhabitacion))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tb_det.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tb_det);

        lb_num_camas_hab_alq1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_num_camas_hab_alq1.setText("Adelanto");

        txtadelanto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtadelanto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtadelantoKeyTyped(evt);
            }
        });

        lb_num_camas_hab_alq.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_num_camas_hab_alq.setText("Monto Total:");

        txtmontototal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtmontototal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtmontototalKeyTyped(evt);
            }
        });

        txthabitaciones.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txthabitaciones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txthabitacionesKeyTyped(evt);
            }
        });

        lb_obs_alq1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_obs_alq1.setText("Cantidad de Habitaciones:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lb_num_camas_hab_alq1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtadelanto, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lb_num_camas_hab_alq, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtmontototal, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lb_obs_alq1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txthabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_num_camas_hab_alq1)
                    .addComponent(txtadelanto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_num_camas_hab_alq)
                    .addComponent(txtmontototal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_obs_alq1)
                    .addComponent(txthabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel_dt_habLayout = new javax.swing.GroupLayout(panel_dt_hab);
        panel_dt_hab.setLayout(panel_dt_habLayout);
        panel_dt_habLayout.setHorizontalGroup(
            panel_dt_habLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_dt_habLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 81, Short.MAX_VALUE))
            .addGroup(panel_dt_habLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_dt_habLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(panel_dt_habLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panel_dt_habLayout.setVerticalGroup(
            panel_dt_habLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_dt_habLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_dt_reserva.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Reserva"));
        panel_dt_reserva.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        lb_id_alq1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_id_alq1.setText("ID Reserva");

        lb_fech_lleg1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_fech_lleg1.setText("Fecha Llegada:");

        lb_fech_sal1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_fech_sal1.setText("Fecha Salida:");

        lb_id_recep1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_id_recep1.setText("ID recepcionista:");

        txtidreserva.setEditable(false);
        txtidreserva.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        txtidreserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidreservaActionPerformed(evt);
            }
        });

        txtusuario.setEditable(false);
        txtusuario.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N

        javax.swing.GroupLayout panel_dt_reservaLayout = new javax.swing.GroupLayout(panel_dt_reserva);
        panel_dt_reserva.setLayout(panel_dt_reservaLayout);
        panel_dt_reservaLayout.setHorizontalGroup(
            panel_dt_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_dt_reservaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_dt_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel_dt_reservaLayout.createSequentialGroup()
                        .addGroup(panel_dt_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lb_fech_sal1)
                            .addComponent(lb_fech_lleg1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panel_dt_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtidreserva, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(txtsalida, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(txtllegada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_dt_reservaLayout.createSequentialGroup()
                        .addComponent(lb_id_alq1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_dt_reservaLayout.createSequentialGroup()
                        .addComponent(lb_id_recep1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_dt_reservaLayout.setVerticalGroup(
            panel_dt_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_dt_reservaLayout.createSequentialGroup()
                .addGroup(panel_dt_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_id_alq1)
                    .addComponent(txtidreserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_dt_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_fech_lleg1)
                    .addComponent(txtllegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(panel_dt_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtsalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_fech_sal1))
                .addGap(18, 18, 18)
                .addGroup(panel_dt_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_id_recep1)
                    .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnsalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnnuevo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnguardar, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnnuevo)
                .addGap(18, 18, 18)
                .addComponent(btnguardar)
                .addGap(18, 18, 18)
                .addComponent(btnsalir)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel_dt_huesp, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel_dt_reserva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_dt_hab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel_dt_hab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(panel_dt_huesp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel_dt_reserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtdniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdniActionPerformed

    private void txtdniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdniKeyTyped
        // TIPEO DNI
        int numerocaracteres=8;
        char c = evt.getKeyChar();
        if (Character.isLetter(c))
        {
            getToolkit().beep();
            evt.consume();
            //JOptionPane.showMessageDialog(rootPane, "Solo numeros");
        }
        if ((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=47
            ||(int)evt.getKeyChar()>58 && (int)evt.getKeyChar()<=64
            ||(int)evt.getKeyChar()>91 && (int)evt.getKeyChar()<=96
            ||(int)evt.getKeyChar()>123 && (int)evt.getKeyChar()<=255)
        {
            getToolkit().beep();
            evt.consume();
            //JOptionPane.showMessageDialog(null,"No usar caracteres","!Advertencia!",JOptionPane.WARNING_MESSAGE);
        }else if(txtdni.getText().length()>=numerocaracteres){
            getToolkit().beep();
            evt.consume();
            //JOptionPane.showMessageDialog(null,"Exceso de dígitos","!Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtdniKeyTyped

    private void txtcantKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantKeyTyped
        // cantidad de huespedes
        char c = evt.getKeyChar();
        int numerocaracteres=1;
        if (Character.isLetter(c))
        {
            getToolkit().beep();
            evt.consume();
            //JOptionPane.showMessageDialog(rootPane, "Solo numeros");
        } else if ((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=47
            ||(int)evt.getKeyChar()>58 && (int)evt.getKeyChar()<=64
            ||(int)evt.getKeyChar()>91 && (int)evt.getKeyChar()<=96
            ||(int)evt.getKeyChar()>123 && (int)evt.getKeyChar()<=255)
        {
            getToolkit().beep();
            evt.consume();
            //JOptionPane.showMessageDialog(null,"No usar caracteres","!Advertencia!",JOptionPane.WARNING_MESSAGE);
        }else if(txtcant.getText().length()>=numerocaracteres){
            getToolkit().beep();
            evt.consume();
            //JOptionPane.showMessageDialog(null,"Exceso de dígitos","!Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtcantKeyTyped

    private void btnbuscar_hActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscar_hActionPerformed
        // boton buscar huesped
        if (txtdni.getText().length()!=8){
            JOptionPane.showMessageDialog(null,"Ingrese DNI Completo");
        }
        else
        {
            txtnombre.setText("");
            txtapellido.setText("");
            String dni= (txtdni.getText());
            try{
                ResultSet rs1;
                PreparedStatement pst=cn.prepareStatement("SELECT nombre_h,apellidos_h,id_huesped "
                    + "FROM hotel_version10.huesped where dni_huesped='"+dni+"'");
                rs1 = pst.executeQuery();//buscando datos y guardando en interfaz
                while(rs1.next()){
                    txtnombre.setText(rs1.getString("nombre_h"));
                    txtapellido.setText(rs1.getString("apellidos_h"));
                    id_huesped_huesped=rs1.getString("id_huesped");
                }
                if (txtnombre.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"DNI no encontrado, por favor registre al cliente","AVISO",JOptionPane.INFORMATION_MESSAGE);
                    txtdni.setText("");
                }else{
                    //desbloqueo
                    btnnuevohuesped.setEnabled(false);
                    txtcant.setEnabled(true);
                    btnbuscarhabitacion.setEnabled(true);
                    btnguardar.setEnabled(true);
                    //txtnumeroha.setEnabled(true);
                    //txttipoha.setEnabled(true);
                }
            }catch(HeadlessException | SQLException e){
                System.err.println("No se pudo buscar");
            }
        }
    }//GEN-LAST:event_btnbuscar_hActionPerformed

    private void btnnuevohuespedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevohuespedActionPerformed
        // boton nuevo huesped
        String bandera=huesped.bandera_huesped;
        try{
            if(bandera==null){
                huesped a= new huesped();
                this.getDesktopPane().add(a);
                a.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(rootPane,"La ventana ya esta abierta!");
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnnuevohuespedActionPerformed

    private void btnexplorarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexplorarActionPerformed
        // Boton explorar
        elegir_h=new elegir_huesped_re(this,true);
        elegir_h.setVisible(true);
        txtcant.setEnabled(true);
        btnbuscarhabitacion.setEnabled(true);
        //txtnumeroha.setEnabled(true);
        //txttipoha.setEnabled(true);
        //
        System.out.println("el ide huesped regresado: "+id_huesped_huesped);

    }//GEN-LAST:event_btnexplorarActionPerformed

    private void btnbuscarhabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarhabitacionActionPerformed
        //boton buscar habitacin
        
        //{"Nro de Habitacion", "Tipo", "Estado","Costo","Nro Camas"};  
        //System.out.println("id habitacion en alquiler xD : "+id_habitacion_seleccion);

        btnnuevohuesped.setEnabled(false);
        btnguardar.setEnabled(true);
        btnbuscar_h.setEnabled(false);
        btnexplorar.setEnabled(false);
        txtdni.setEditable(false);
        //
        if(txtcant.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Ingresa Cantidad de Personas","ERROR",JOptionPane.ERROR_MESSAGE);
        }else if(Integer.parseInt(txtcant.getText())>0){
            
            seleccion_ha=new seleccion_habitacion_re(this,true);
            seleccion_ha.setVisible(true);
            //
            txtcant.setEditable(false);            
            txtidreserva.setEnabled(true);
            txtllegada.setEnabled(true);
            txtsalida.setEnabled(true);
            txtusuario.setEnabled(true);
            //
            txtadelanto.setEnabled(true);
            txtmontototal.setEnabled(true);
            txthabitaciones.setEnabled(true);
            ////
            btnguardar.setEnabled(true);
            
            String []Dato=new String [10];
            Dato[0]=numero_h;
            Dato[1]=tipo_h;
            Dato[2]=estado_h;
            Dato[3]=costo_h;
            Dato[4]=camas_h;
            modelo.addRow(Dato);            
            cantidadhabitaciones++;     
            btneliminar.setEnabled(true);
            btneliminart.setEnabled(true);
            
        }else{
            JOptionPane.showMessageDialog(null,"Ingresa número válido de Personas","ERROR",JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnbuscarhabitacionActionPerformed

    private void txtadelantoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtadelantoKeyTyped
        // adelanto
        int numerocaracteres=7;
        char c = evt.getKeyChar();
        if (Character.isLetter(c))
        {
            getToolkit().beep();
            evt.consume();
            //JOptionPane.showMessageDialog(rootPane, "Solo numeros");
        }else if(txtmontototal.getText().length()>=numerocaracteres){
            getToolkit().beep();
            evt.consume();        
        }
    }//GEN-LAST:event_txtadelantoKeyTyped

    private void txtmontototalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmontototalKeyTyped
        // monto total
        int numerocaracteres=7;
        char c = evt.getKeyChar();
        if (Character.isLetter(c))
        {
            getToolkit().beep();
            evt.consume();
            //JOptionPane.showMessageDialog(rootPane, "Solo numeros");
        }else if(txtmontototal.getText().length()>=numerocaracteres){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtmontototalKeyTyped

    private void txtidreservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidreservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidreservaActionPerformed

    private void txthabitacionesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txthabitacionesKeyTyped
        // cantidad de habitaciones
        int numerocaracteres=7;
        char c = evt.getKeyChar();
        if (Character.isLetter(c))
        {
            getToolkit().beep();
            evt.consume();
            //JOptionPane.showMessageDialog(rootPane, "Solo numeros");
        }else if(txtmontototal.getText().length()>=numerocaracteres){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txthabitacionesKeyTyped

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // boton nuevo
        limpiar();
        btnnuevo();
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // boton salir
        cc.desconectar();
        bandera_reserva=null;
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // boton guardar
        
            if(txtdni.getText().length()!=8){
                JOptionPane.showMessageDialog(null,"Elija Huésped","ERROR",JOptionPane.ERROR_MESSAGE);
            }else if(txtcant.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Ingresa Cantidad de Personas","ERROR",JOptionPane.ERROR_MESSAGE);
            }else if(txtidreserva.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"No existe ID_Alquiler","ERROR",JOptionPane.ERROR_MESSAGE);
            }else if (txtllegada.getDate()==null) {
                JOptionPane.showMessageDialog(null,"Error en Fecha de llegada","ERROR",JOptionPane.ERROR_MESSAGE);
            }else if (txtsalida.getDate()==null) {
                JOptionPane.showMessageDialog(null,"Error en Fecha de Salida","ERROR",JOptionPane.ERROR_MESSAGE);
            }else if (txtusuario.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,"Error al obtener Usuario ","ERROR",JOptionPane.ERROR_MESSAGE);
            }else if (txtadelanto.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,"Ingresa monto adelantado","ERROR",JOptionPane.ERROR_MESSAGE);
            }else if (txtmontototal.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,"Ingresa Monto Total","ERROR",JOptionPane.ERROR_MESSAGE);
            }else if (txthabitaciones.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,"Ingresa Monto Total","ERROR",JOptionPane.ERROR_MESSAGE);
            
            }else if((Integer.parseInt(txtcant.getText())>1) && ((tb_det.getRowCount()+1)!=Integer.parseInt(txtcant.getText()))){
                JOptionPane.showMessageDialog(null,"Completa la Tabla de Huespedes en esta habitación","ERROR",JOptionPane.ERROR_MESSAGE);
            }else
            {
                try
                {
                    PreparedStatement pst=cn.prepareStatement("INSERT INTO hotel_version10.reserva"
                            + " (id_reserva,fecha_llegada,fecha_salida,nro_persona,mon_adelanto,nro_dias,"
                            + "num_habita_rese,huesped_id_huesped) VALUES ('1', '2017-07-07', '2017-07-08', '3', '100', '1', '3', '1')");
                    //pst.setString(1,txtnumeroha.getText());
                    pst.setString(1,txtidreserva.getText());//id alquiler
                    pst.setString(2,fecha.getFecha(txtllegada));
                    pst.setString(3,fecha.getFecha(txtsalida));//fecha salida
                    pst.setString(4,txtcant.getText());
                    pst.setString(5,txtadelanto.getText());//num camas
                    pst.setString(6,"1");//num dias
                    pst.setString(7,txthabitaciones.getText());
                    pst.setString(8,id_huesped_huesped);
                    
                    int a=pst.executeUpdate();
                    if(a>0){
                        System.out.println("Registro exitoso en Reserva");
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Error al agregar en Reserva ","Error",1);
                    }
                    int c=1;
                    String id="";
                    ResultSet rsa;
                    int cont;
                    for(int i=0;i<tb_det.getRowCount();i++)
                    {
                        /*Statement sent = cn.createStatement();
                        rsa = sent.executeQuery("SELECT IFNULL(MAX(CAST(id_detalle AS UNSIGNED)), 0) codigoExterno FROM hotel_version10.detalle_alquila");
                        while(rsa.next()){
                            cont =Integer.parseInt(rsa.getString("codigoExterno"))+1;
                            id=(String.valueOf(cont));
                        }/////detalle de alquiler
                        */
                        PreparedStatement pst2=cn.prepareStatement("INSERT INTO hotel_version10.detalle_reserva"
                                + " (reserva_id_reserva,habitacion_id_habitacion,estado) VALUES ('1', '1', 'Pendiente');");
                        /*Nombres,Apellidos,DNI,Fecha Nacimiento,Ciudad,Estado Civil,País,Teléfono,Ocupacion,Dirección*/
                        pst2.setString(1,txtidreserva.getText());// id detalle
                        pst2.setString(2,tb_det.getValueAt(i,0).toString());//nombre
                        pst2.setString(3,tb_det.getValueAt(i,1).toString());//apellido
                        pst2.setString(4,tb_det.getValueAt(i,2).toString());//dni
                        
                        c=pst2.executeUpdate();
                        if(c>0){
                            System.out.println("Registro exitoso en detalle_alquiler");
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Error al agregar ","Error",1);
                        }
                    }//fin for
                    
                    
                    
                    
                    //String habb=txtnumeroha.getText();
                    PreparedStatement pst1=cn.prepareStatement("UPDATE hotel_version10.habitacion"
                        + " SET estado='Ocupado' WHERE id_habitacion='"+id_habitacion_seleccion+"'");
                    int b=pst1.executeUpdate();
                    if(b>0){
                        System.out.println("Actualizacion exitosa en Habitacion");
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Error al actualizar habitación ","Error",1);
                    }
                    
                    ////  actualizar tabla detalle
                    if(Integer.parseInt(txtcant.getText())>1)
                    {
                        c=0;//sirve para dar mensaje de confirmacion
                        try
                        {
                            
                        } catch (Exception e) {
                            System.out.println("no se pudo actualizar detalle alquiler: "+e.getMessage());
                        }//fin trycatch
                    }// fin if para detalle alquiler
                    
                    if((a>0)&&(b>0)&&(c>0)){
                        JOptionPane.showMessageDialog(null,"Registro Exitoso","FELICITACIONES",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Error al agregar ");
                    }
                    
                    btnnuevo();
                    eliminarelementos();
                    bloqueorestantes();///fin de todos los insert

                }catch(HeadlessException | SQLException e){
                    JOptionPane.showMessageDialog(null, "error al agegar datos en alquila y detalle " +e);
                }//fin trycatch
            }//fn else
            ///
    }//GEN-LAST:event_btnguardarActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        // cerrrando ventana
        bandera_reserva=null;
    }//GEN-LAST:event_formInternalFrameClosing

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        // btn eliminar
        int filasel=tb_det.getSelectedRow();
        if(filasel>=0){
            modelo.removeRow(filasel);
            cantidadhabitaciones--;
            //bloquearcampoingreso(1);//desbloquenado campos
            
        }else{
            JOptionPane.showMessageDialog(null,"Elije registro para eliminar","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btneliminartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminartActionPerformed
        // boton eliminar todos elementos
        eliminarelementos();       
        btneliminar.setEnabled(false);
        btneliminart.setEnabled(false);
        //bloquearcampoingreso(1);
    }//GEN-LAST:event_btneliminartActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar_h;
    private javax.swing.JButton btnbuscarhabitacion;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btneliminart;
    private javax.swing.JButton btnexplorar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnnuevohuesped;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_ape_alq;
    private javax.swing.JLabel lb_dni_alq;
    private javax.swing.JLabel lb_fech_lleg1;
    private javax.swing.JLabel lb_fech_sal1;
    private javax.swing.JLabel lb_id_alq1;
    private javax.swing.JLabel lb_id_recep1;
    private javax.swing.JLabel lb_nom_alq;
    private javax.swing.JLabel lb_num_camas_hab_alq;
    private javax.swing.JLabel lb_num_camas_hab_alq1;
    private javax.swing.JLabel lb_obs_alq1;
    private javax.swing.JPanel panel_dt_hab;
    private javax.swing.JPanel panel_dt_huesp;
    private javax.swing.JPanel panel_dt_reserva;
    private javax.swing.JTable tb_det;
    public static javax.swing.JTextField txtadelanto;
    public static javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtcant;
    public static javax.swing.JTextField txtdni;
    private javax.swing.JTextField txthabitaciones;
    private javax.swing.JTextField txtidreserva;
    private com.toedter.calendar.JDateChooser txtllegada;
    public static javax.swing.JTextField txtmontototal;
    public static javax.swing.JTextField txtnombre;
    private com.toedter.calendar.JDateChooser txtsalida;
    public static javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
