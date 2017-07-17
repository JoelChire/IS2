package Formulario;

import ClaseConectar.Conectar;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class visualizar_alquiler extends javax.swing.JInternalFrame {

    Conectar cc=new Conectar();
    Connection cn=cc.conexion();
    public static String bandera_visualizar_alquiler;
    ResultSet datos,datos2;
    DefaultTableModel model,modelo2;       
    public visualizar_alquiler() {
        initComponents();
        cargar("","");
        this.setTitle("Buscar Alquiler");
        bandera_visualizar_alquiler="akjh";
        
    }        
    void cargar(String valor,String ap)
    {
        //cargando datos a la tabla de alaquiler
        //String ap;
        String [] titulos = {"Nº Alquiler","Nº Habitación","Nombres","Apellidos","Nº DNI","Nº de Camas","Nº personas"};
        model =new DefaultTableModel(null,titulos);
        try{            
            PreparedStatement pst=cn.prepareStatement("select a.id_alquila as 'n_alquiler',ha.nro_hab AS 'n_habitacion',"
                    + "h.nombre_h AS 'nombres',h.apellidos_h AS 'apellidos',h.dni_huesped AS 'n_dni',"
                    + "a.num_camas AS 'n_camas',count(dt.alquila_id_alquila)+1 as 'personas'\n" +
                    "from huesped h inner join alquila a on h.id_huesped=a.huesped_id_huesped \n" +
                    "inner join habitacion ha on a.habitacion_id_habitacion=ha.id_habitacion\n" +
                    "left outer join detalle_alquila dt on a.id_alquila=dt.alquila_id_alquila\n" +
                    "where ha.estado='ocupado' and h.nombre_h like '%"+valor+"%' and h.apellidos_h like '%"+ap+"%'\n" +
                    "group by a.id_alquila,ha.nro_hab,h.nombre_h,h.apellidos_h,h.dni_huesped,a.num_camas");
            datos = pst.executeQuery();//buscando datos y guardando en datos           
            String [] fila = new String[7];
            while(datos.next()){
                fila[0]=datos.getString("n_alquiler");
                fila[1]=datos.getString("n_habitacion");
                fila[2]=datos.getString("nombres");
                fila[3]=datos.getString("apellidos");   
                fila[4]=datos.getString("n_dni");
                fila[5]=datos.getString("n_camas");   
                fila[6]=datos.getString("personas");
                model.addRow(fila);            
            } 
            t_datos.setModel(model);
            t_datos.getColumnModel().getColumn(0).setMaxWidth(500);
            t_datos.getColumnModel().getColumn(1).setMaxWidth(600);
            t_datos.getColumnModel().getColumn(2).setMaxWidth(1700);//nombres
            t_datos.getColumnModel().getColumn(3).setMaxWidth(1700);
            t_datos.getColumnModel().getColumn(4).setMaxWidth(500);//dni
            t_datos.getColumnModel().getColumn(5).setMaxWidth(1000);
            t_datos.getColumnModel().getColumn(6).setMaxWidth(1000);            
            DefaultTableCellRenderer tcr= new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.CENTER);
            t_datos.getColumnModel().getColumn(0).setCellRenderer(tcr);
            t_datos.getColumnModel().getColumn(1).setCellRenderer(tcr);
            t_datos.getColumnModel().getColumn(2).setCellRenderer(tcr);
            t_datos.getColumnModel().getColumn(3).setCellRenderer(tcr);
            t_datos.getColumnModel().getColumn(4).setCellRenderer(tcr);
            t_datos.getColumnModel().getColumn(5).setCellRenderer(tcr);
            t_datos.getColumnModel().getColumn(6).setCellRenderer(tcr);            
            t_datos.setModel(model);
        }catch(HeadlessException | SQLException e){
            System.err.println("El cliente no se encuentra registrado");           
        }
    }//fin de funcion cargar
    void cargardetalle(String id){
        //JOptionPane.showMessageDialog(null,"id alquiler en funcion detalle: "+id);        

        //cargando a la table detalle de alquiler
        String [] titulos2 = {"Nº","Nombres","Apellidos","Nº DNI","F. Nacimiento","Ciudad","Estado civil","País","Teléfono","Ocupación","Dirección","Nº de alquiler"};
        modelo2 =new DefaultTableModel(null,titulos2);
        try{            
            PreparedStatement pst2=cn.prepareStatement("SELECT * FROM detalle_alquila where alquila_id_alquila like '%"+id+"%'");
            datos2 = pst2.executeQuery();//buscando datos y guardando en datos           
            String [] fila = new String[12];
            while(datos2.next()){
                fila[0]=datos2.getString("id_detalle");
                fila[1]=datos2.getString("Nombres");
                fila[2]=datos2.getString("Apellidos");
                fila[3]=datos2.getString("dni");   
                fila[4]=datos2.getString("nacimiento");
                fila[5]=datos2.getString("ciudad");   
                fila[6]=datos2.getString("estado_civil");
                fila[7]=datos2.getString("pais");
                fila[8]=datos2.getString("telefono");
                fila[9]=datos2.getString("ocupacion");
                fila[10]=datos2.getString("direccion");
                fila[11]=datos2.getString("alquila_id_alquila");
                modelo2.addRow(fila);
            }
            t_datos1.setModel(modelo2);
                      
            t_datos.getColumnModel().getColumn(0).setMaxWidth(80);
            t_datos.getColumnModel().getColumn(1).setMaxWidth(400);
            t_datos.getColumnModel().getColumn(2).setMaxWidth(1700);//nombres
            t_datos.getColumnModel().getColumn(3).setMaxWidth(1700);
            t_datos.getColumnModel().getColumn(4).setMaxWidth(370);//dni
            t_datos.getColumnModel().getColumn(5).setMaxWidth(1000);
            t_datos.getColumnModel().getColumn(6).setMaxWidth(1000);
            t_datos.getColumnModel().getColumn(8).setMaxWidth(230); 
            t_datos.getColumnModel().getColumn(11).setMaxWidth(80);            
            DefaultTableCellRenderer tcr= new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.CENTER);
            t_datos.getColumnModel().getColumn(1).setCellRenderer(tcr);
            t_datos.getColumnModel().getColumn(2).setCellRenderer(tcr);
            t_datos.getColumnModel().getColumn(3).setCellRenderer(tcr);
            t_datos.getColumnModel().getColumn(4).setCellRenderer(tcr);
            t_datos.getColumnModel().getColumn(5).setCellRenderer(tcr);
            t_datos.getColumnModel().getColumn(6).setCellRenderer(tcr);            
            t_datos.setModel(model);
        }catch(HeadlessException | SQLException e){
            System.err.println("El cliente no se encuentra registrado");           
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcMousePanel1 = new jcMousePanel.jcMousePanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtape = new javax.swing.JTextField();
        btnresetear = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        t_datos = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_datos1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setTitle("Buscar Alquiler");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jcMousePanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/fond3.jpg"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombres:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Apellidos:");

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

        txtape.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtapeKeyReleased(evt);
            }
        });

        btnresetear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnresetear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/resetear1.png"))); // NOI18N
        btnresetear.setText("Resetear");
        btnresetear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetearActionPerformed(evt);
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

        t_datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        t_datos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        t_datos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_datosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(t_datos);

        t_datos1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        t_datos1.setToolTipText("");
        jScrollPane1.setViewportView(t_datos1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Acompañantes de Huéspedes Principales:");
        jLabel2.setToolTipText("");

        javax.swing.GroupLayout jcMousePanel1Layout = new javax.swing.GroupLayout(jcMousePanel1);
        jcMousePanel1.setLayout(jcMousePanel1Layout);
        jcMousePanel1Layout.setHorizontalGroup(
            jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jcMousePanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jcMousePanel1Layout.createSequentialGroup()
                .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jcMousePanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(52, 52, 52)
                        .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtape, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(72, 72, 72)
                        .addComponent(btnresetear, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jcMousePanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1064, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jcMousePanel1Layout.createSequentialGroup()
                        .addContainerGap(19, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1059, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jcMousePanel1Layout.setVerticalGroup(
            jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jcMousePanel1Layout.createSequentialGroup()
                .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jcMousePanel1Layout.createSequentialGroup()
                        .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jcMousePanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jcMousePanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE))
                    .addGroup(jcMousePanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnresetear, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
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

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        // cerrando interfaz
        bandera_visualizar_alquiler=null;
    }//GEN-LAST:event_formInternalFrameClosing

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreActionPerformed

    private void txtnombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyReleased
        // escribir texto en campo
        cargar(txtnombre.getText(),txtape.getText());
    }//GEN-LAST:event_txtnombreKeyReleased

    private void txtnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isDigit(c))
        {
            getToolkit().beep();
            evt.consume();
            //JOptionPane.showMessageDialog(null,"Solo se permite el Ingreso de Letras","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }int numerocaracteres=30;
        if (txtnombre.getText().length()>=numerocaracteres){
            evt.consume();
            //JOptionPane.showMessageDialog(null,"Exceso de dígitos","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
        if ((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=47
            ||(int)evt.getKeyChar()>58 && (int)evt.getKeyChar()<=64
            ||(int)evt.getKeyChar()>91 && (int)evt.getKeyChar()<=96
            ||(int)evt.getKeyChar()>123 && (int)evt.getKeyChar()<=255)
        {
            getToolkit().beep();
            evt.consume();
            //JOptionPane.showMessageDialog(null,"No se permite usar caracteres","¡Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtnombreKeyTyped

    private void txtapeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapeKeyReleased
        // escribiendo en campo apellido
        cargar(txtnombre.getText(),txtape.getText());
    }//GEN-LAST:event_txtapeKeyReleased

    private void btnresetearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetearActionPerformed
        // resetear
        txtnombre.setText("");
        txtape.setText("");
        cargar("","");
    }//GEN-LAST:event_btnresetearActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // salir
        this.dispose();
        bandera_visualizar_alquiler=null;
    }//GEN-LAST:event_btnsalirActionPerformed

    private void t_datosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_datosMouseClicked
       /* int cantfil=t_datos1.getRowCount();
        for(int i=cantfil-1;i>=0;i--){
            modelo2.removeRow(i);//limpiamos la tabla
        }*/
        int fila=t_datos.getSelectedRow();
        //JOptionPane.showMessageDialog(null,"id alquiler seleccionada: "+t_datos.getValueAt(fila,0).toString());

        cargardetalle(t_datos.getValueAt(fila,0).toString());
    }//GEN-LAST:event_t_datosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnresetear;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private jcMousePanel.jcMousePanel jcMousePanel1;
    private javax.swing.JTable t_datos;
    private javax.swing.JTable t_datos1;
    private javax.swing.JTextField txtape;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
