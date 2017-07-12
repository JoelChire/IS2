/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formulario;

import ClaseConectar.Conectar;
import Clases.fecha;
import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author MALY
 */
public class cierrediario extends javax.swing.JInternalFrame {

    /**
     * Creates new form cierrediario
     */
    Conectar cc=new Conectar();
    Connection cn=cc.conexion();
    fecha fecha=new fecha();
    
    public String usuario_cierrediario;
   
    public static String bandera_cierrediario;
    public cierrediario() {
        initComponents();
          this.setLocation(15, 10);
        setResizable(false);
        this.setTitle("Cierre diario");
        txtid.setEnabled(false);
        txtfecha.setText(fecha_actual());
        usuario_cierrediario=carga.usuario_carga; 
        btnguardar.setEnabled(false);
        txtrecepcionista.setText(usuario_cierrediario);
        String id =(txtrecepcionista.getText());
            try{
                ResultSet rs1;
                PreparedStatement pst=cn.prepareStatement("SELECT turno FROM usuario where id_usuario='"+id+"'");
                rs1 = pst.executeQuery();//buscando datos y guardando en interfaz
                while(rs1.next()){
                    txtturno.setText(rs1.getString("turno"));
                }
            }catch(HeadlessException | SQLException e){
                System.err.println("No se pudo buscar");
            }
        montocobrado();
        obt_id();
    }
        
    public int confirmarSalida(){
        int valor=JOptionPane.showConfirmDialog(this,"Los datos una vez ingresados, no seran modificados ¿Desea continuar? ","Advertencia",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        return valor;
    }
    public static String fecha_actual(){
        Date fecha = new Date();
        SimpleDateFormat formatoFecha= new SimpleDateFormat("YYYY-MM-dd");
        return formatoFecha.format(fecha);
    }  
    public void montoneto(){
            //obteniendo monto recaudado      
        //String montoc,gastos;
        //montoc=txtrecaudado.getText();
        //gastos=txtgastos.getText();
        Double recaudado = Double.parseDouble(txtrecaudado.getText()); 
        Double gastos = Double.parseDouble(txtgastos.getText()); 
        Double neto = recaudado - gastos;
        this.txtneto.setText(String.valueOf(neto)); 
    }    
    
    public void montocobrado(){
        try{
            //obteniendo monto recaudado      
            ResultSet rz,rn;
            Statement sent = cn.createStatement();
            rn = sent.executeQuery("Select sum(detalle_diario_dinero.monto_cobrado) as recaudada\n" +
"from detalle_diario_dinero inner join usuario\n" +
"on detalle_diario_dinero.id_usuario_dinero=usuario.id_usuario\n" +
"where date(detalle_diario_dinero.fecha_actual_dinero)=curdate()\n" +
"and usuario.turno='Nocturno' or usuario.turno= 'Completo'");
            Statement sentz = cn.createStatement();
            rz = sentz.executeQuery("Select sum(detalle_diario_dinero.monto_cobrado) as recaudado\n" +
"from detalle_diario_dinero inner join usuario\n" +
"on detalle_diario_dinero.id_usuario_dinero=usuario.id_usuario\n" +
"where date(detalle_diario_dinero.fecha_actual_dinero)=curdate()\n" +
"and usuario.turno='Diurno' or usuario.turno= 'Completo'");
            String turno;
            turno=txtturno.getText();
            if(turno.equals("Diurno")){
                
                while(rz.next()){ 
                
                    this.txtrecaudado.setText(rz.getString("recaudado"));
                    JOptionPane.showMessageDialog(null,"holu","¡Aviso!",JOptionPane.INFORMATION_MESSAGE);
                }  
            }   else if(turno.equals("Nocturno")){
                    while(rn.next()){
            
                    this.txtrecaudado.setText(rn.getString("recaudada"));
                    }  
            }   else if(turno.equals("Completo")){
            	Calendar calendar = Calendar.getInstance();
                int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
                if(hourOfDay>= 8 && hourOfDay<20){
                    while(rz.next()){ 
                        this.txtrecaudado.setText(rz.getString("recaudado"));
                    }  
                }else{
                    while(rn.next()){
                        this.txtrecaudado.setText(rn.getString("recaudada"));
                    }  
            }
        }   
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }      
    }    
    public void obt_id(){
        try{
            //obteniendo id de alquila.. id maximo            
            ResultSet rsa;
            Statement sent = cn.createStatement();
            rsa = sent.executeQuery("SELECT IFNULL(MAX(CAST(id_cierre AS UNSIGNED)), 0) codigoExterno FROM cierre_diario");
            int cont;
            while(rsa.next()){
                cont =Integer.parseInt(rsa.getString("codigoExterno"))+1;
                this.txtid.setText(String.valueOf(cont));
            }            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
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

        jcMousePanel1 = new jcMousePanel.jcMousePanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        txtfecha = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtrecepcionista = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtturno = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtrecaudado = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtgastos = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtneto = new javax.swing.JTextField();
        txtid = new javax.swing.JTextField();
        btnguardar = new javax.swing.JButton();
        btncalcular = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();

        setTitle("Cierre Diario");

        jcMousePanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/fondo7.jpg"))); // NOI18N

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nº Cierre: ");

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Fecha Actual: ");

        txtfecha.setEditable(false);

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Recepcionista:");

        txtrecepcionista.setEditable(false);

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Turno:");

        txtturno.setEditable(false);

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Monto Recaudado:");

        txtrecaudado.setEditable(false);

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Gastos:");

        txtgastos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtgastostxtgastosActionPerformed(evt);
            }
        });
        txtgastos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtgastostxtgastosKeyPressed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("Monto Neto:");

        txtneto.setEditable(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtgastos, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtfecha)
                            .addComponent(txtrecepcionista)
                            .addComponent(txtturno, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(txtrecaudado, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtneto, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(txtrecaudado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel21)
                        .addComponent(txtrecepcionista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel24))
                    .addComponent(txtgastos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(txtturno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtneto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtid.setEditable(false);
        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });

        btnguardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/GUARdar1.png"))); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btncalcular.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btncalcular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/calcular.png"))); // NOI18N
        btncalcular.setText("Calcular");
        btncalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncalcularActionPerformed(evt);
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

        javax.swing.GroupLayout jcMousePanel1Layout = new javax.swing.GroupLayout(jcMousePanel1);
        jcMousePanel1.setLayout(jcMousePanel1Layout);
        jcMousePanel1Layout.setHorizontalGroup(
            jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jcMousePanel1Layout.createSequentialGroup()
                .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jcMousePanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jcMousePanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jcMousePanel1Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btncalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jcMousePanel1Layout.setVerticalGroup(
            jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jcMousePanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncalcular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
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

    private void txtgastostxtgastosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtgastostxtgastosActionPerformed
        // TODO add your handling code here:
        //txtneto.setText("");
    }//GEN-LAST:event_txtgastostxtgastosActionPerformed

    private void txtgastostxtgastosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtgastostxtgastosKeyPressed
        // TODO add your handling code here:
        txtneto.setText("");
    }//GEN-LAST:event_txtgastostxtgastosKeyPressed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        //cerrar();
        if(txtgastos.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Ingrese el gasto","¡Error!",JOptionPane.ERROR_MESSAGE);
        } else if (txtneto.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Calcule el monto neto","¡Error!",JOptionPane.ERROR_MESSAGE);
        }

        else{
            int option=confirmarSalida();
            if (option==JOptionPane.NO_OPTION){
                //JOptionPane.showMessageDialog(null,"gracias", "Gracias",JOptionPane.INFORMATION_MESSAGE);

            } else{
                Conectar cc=new Conectar();
                Connection cn=cc.conexion();

                PreparedStatement pst;
                try {
                    pst = cn.prepareStatement("INSERT INTO cierre_diario(usuario_id_usuario,fecha_actual,mon_recaudado,gasto_diario,turno_diario,monto_neto,id_cierre) Values(?,?,?,?,?,?,?)");
                    pst.setString(1,txtrecepcionista.getText());
                    pst.setString(2,txtfecha.getText());
                    pst.setString(3,txtrecaudado.getText());
                    pst.setString(4,txtgastos.getText());
                    pst.setString(5,txtturno.getText());
                    pst.setString(6,txtneto.getText());
                    pst.setString(7,txtid.getText());
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Registro exitoso","¡Aviso!",JOptionPane.INFORMATION_MESSAGE);
                    cc.desconectar();
                } catch (SQLException ex) {
                    Logger.getLogger(cierrediario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btncalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncalcularActionPerformed
        // TODO add your handling code here:
        montoneto();
        btnguardar.setEnabled(true);
    }//GEN-LAST:event_btncalcularActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncalcular;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel5;
    private jcMousePanel.jcMousePanel jcMousePanel1;
    private javax.swing.JTextField txtfecha;
    private javax.swing.JTextField txtgastos;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtneto;
    private javax.swing.JTextField txtrecaudado;
    private javax.swing.JTextField txtrecepcionista;
    private javax.swing.JTextField txtturno;
    // End of variables declaration//GEN-END:variables
}
