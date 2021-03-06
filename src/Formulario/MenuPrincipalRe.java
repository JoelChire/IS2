package Formulario;

import ClaseConectar.Conectar;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
//hola =)
public class MenuPrincipalRe extends javax.swing.JFrame {

    Conectar cc = new Conectar();
    Connection cn = cc.conexion();
    public static String usuario_actual;
    public MenuPrincipalRe() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("HOSTAL TERRAZAS");
        cerrar(); 
        Image icono = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Iconos/usuario.png"));
        this.setIconImage(icono);
    }
    public void obtenerusuario (String u){
        usuario_actual=u;        
    }
    public void cerrar(){
        try {
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e){
                    confirmarSalida();
                }
            });
        } catch (Exception e) {
        }
    }    
    public void confirmarSalida(){
        int valor=JOptionPane.showConfirmDialog(this,"¿Esta seguro de cerrar la ventana?","Advertencia",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        if (valor==JOptionPane.YES_OPTION){
            //JOptionPane.showMessageDialog(null,"gracias", "Gracias",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }                  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jcMousePanel1 = new jcMousePanel.jcMousePanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        MPcerrarsesion = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        MPsalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuItem9 = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jMenuItem10 = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        jMenuItem11 = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem13 = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        jMenuItem14 = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        jMenuItem15 = new javax.swing.JMenuItem();
        jSeparator12 = new javax.swing.JPopupMenu.Separator();
        jMenuItem19 = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        jMenuItem18 = new javax.swing.JMenuItem();
        jSeparator13 = new javax.swing.JPopupMenu.Separator();
        jMenuItem22 = new javax.swing.JMenuItem();
        jSeparator14 = new javax.swing.JPopupMenu.Separator();
        visualizardetallealquiler = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        escritorio.setPreferredSize(new java.awt.Dimension(1490, 709));

        jcMousePanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/TERRAZASFINAL.JPG"))); // NOI18N

        javax.swing.GroupLayout jcMousePanel1Layout = new javax.swing.GroupLayout(jcMousePanel1);
        jcMousePanel1.setLayout(jcMousePanel1Layout);
        jcMousePanel1Layout.setHorizontalGroup(
            jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1264, Short.MAX_VALUE)
        );
        jcMousePanel1Layout.setVerticalGroup(
            jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        escritorio.setLayer(jcMousePanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcMousePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcMousePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/inicio1.png"))); // NOI18N
        jMenu1.setText("Login");
        jMenu1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        MPcerrarsesion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        MPcerrarsesion.setText("Cerrar Sesión");
        MPcerrarsesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MPcerrarsesionActionPerformed(evt);
            }
        });
        jMenu1.add(MPcerrarsesion);
        jMenu1.add(jSeparator1);

        MPsalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        MPsalir.setText("Salir ");
        MPsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MPsalirActionPerformed(evt);
            }
        });
        jMenu1.add(MPsalir);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/registros1.png"))); // NOI18N
        jMenu2.setText("Registro");
        jMenu2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jMenuItem3.setText("Huésped");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);
        jMenu2.add(jSeparator2);

        jMenuItem5.setText("Taxista");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);
        jMenu2.add(jSeparator4);

        jMenuItem6.setText("Habitación");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/recepcion2.png"))); // NOI18N
        jMenu3.setText("Recepción");
        jMenu3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem8.setText("Alquiler");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);
        jMenu3.add(jSeparator5);

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem9.setText("Reserva");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem9);
        jMenu3.add(jSeparator6);

        jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem10.setText("Cobro Diario");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem10);
        jMenu3.add(jSeparator7);

        jMenuItem11.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem11.setText("Cierre Diario");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem11);
        jMenu3.add(jSeparator8);

        jMenuItem1.setText("Taxista recomienda");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuBar1.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/consultas2.png"))); // NOI18N
        jMenu4.setText("Consultas");
        jMenu4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jMenuItem12.setText("Buscar  Húesped");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem12);
        jMenu4.add(jSeparator3);

        jMenuItem13.setText("Buscar Taxista");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem13);
        jMenu4.add(jSeparator9);

        jMenuItem14.setText("Buscar  Alquiler");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem14);
        jMenu4.add(jSeparator10);

        jMenuItem15.setText("Buscar Habitación");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem15);
        jMenu4.add(jSeparator12);

        jMenuItem19.setText("Buscar Reserva");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem19);
        jMenu4.add(jSeparator11);

        jMenuItem18.setText("Buscar Clientes por taxista");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem18);
        jMenu4.add(jSeparator13);

        jMenuItem22.setText("Huésped atendido por recepcionista");
        jMenuItem22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem22ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem22);
        jMenu4.add(jSeparator14);

        visualizardetallealquiler.setText("Buscar Húesped por Taxista");
        visualizardetallealquiler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizardetallealquilerActionPerformed(evt);
            }
        });
        jMenu4.add(visualizardetallealquiler);

        jMenuBar1.add(jMenu4);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/AYUDA14.png"))); // NOI18N
        jMenu5.setText("Ayuda");
        jMenu5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 1264, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MPsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MPsalirActionPerformed
        // TODO add your handling code here:
      System.exit(0);
    }//GEN-LAST:event_MPsalirActionPerformed

    private void MPcerrarsesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MPcerrarsesionActionPerformed
        // TODO add your handling code here:
        Sesion a= new Sesion();
        a.setVisible(true);
        dispose();
    }//GEN-LAST:event_MPcerrarsesionActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // boton huesped     
        String bandera=huesped.bandera_huesped;
        try{            
            if(bandera==null){            
                huesped a= new huesped();
                this.escritorio.add(a);
                a.setVisible(true);            
            }else{
                JOptionPane.showMessageDialog(rootPane,"La ventana ya esta abierta!");
            }    
        }catch(Exception e){
            e.printStackTrace();    
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // habitacion
        String bandera=habitacion.bandera_habitacion;
        try{            
            if(bandera==null){            
                habitacion a= new habitacion(); 
                this.escritorio.add(a);
                a.setVisible(true);            
            }else{
                JOptionPane.showMessageDialog(rootPane,"La ventana ya esta abierta!");
            }    
        }catch(Exception e){
            e.printStackTrace();    
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // taxista
        String bandera=taxista.bandera_taxista;
        try{            
            if(bandera==null){            
                taxista a= new taxista();  
                this.escritorio.add(a);
                a.setVisible(true);            
            }else{
                JOptionPane.showMessageDialog(rootPane,"La ventana ya esta abierta!");
            }    
        }catch(Exception e){
            e.printStackTrace();    
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // alquiler
        String bandera=alquiler.bandera_alquiler;
        try{            
            if(bandera==null){            
                alquiler a= new alquiler();  
                this.escritorio.add(a);
                a.obtenerusuario(usuario_actual);
                a.txtusuario.setText(usuario_actual);             
                a.setVisible(true);                
            }else{
                JOptionPane.showMessageDialog(rootPane,"La ventana ya esta abierta!");
            }    
        }catch(Exception e){
            e.printStackTrace();    
        }     
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        //reserva
        String bandera_reserva=reserva.bandera_reserva;
        try{            
            if(bandera_reserva==null){            
                reserva a= new reserva();
                this.escritorio.add(a);
                a.obtenerusuario(usuario_actual);
                a.txtusuario.setText(usuario_actual);
                a.setVisible(true);            
            }else{
                JOptionPane.showMessageDialog(rootPane,"La ventana ya esta abierta!");
            }    
        }catch(Exception e){
            e.printStackTrace();    
        }
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // cobro diario
        String bandera_cobro=cobro_diario.bandera_cobro;
        try{            
            if(bandera_cobro==null){            
                cobro_diario a= new cobro_diario();
                this.escritorio.add(a);
                a.setVisible(true);            
            }else{
                JOptionPane.showMessageDialog(rootPane,"La ventana ya esta abierta!");
            }    
        }catch(Exception e){
            e.printStackTrace();    
        }
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // cierre diario
        String bandera=cierrediario.bandera_cierrediario;
        try{            
            if(bandera==null){            
                cierrediario a= new cierrediario(); 
                this.escritorio.add(a);
                a.setVisible(true);            
            }else{
                JOptionPane.showMessageDialog(rootPane,"La ventana ya esta abierta!");
            }    
        }catch(Exception e){
            e.printStackTrace();    
        }
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // buscar huesped
       String bandera=buscar_huesped.bandera_buscar_huesped;
        try{            
            if(bandera==null){            
                buscar_huesped a= new buscar_huesped();  
                this.escritorio.add(a);
                a.setVisible(true);            
            }else{
                JOptionPane.showMessageDialog(rootPane,"La ventana ya esta abierta!");
            }    
        }catch(Exception e){
            e.printStackTrace();    
    }//GEN-LAST:event_jMenuItem12ActionPerformed
    }
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        String bandera=huespedportaxista.bandera_huespedportaxista;
        try{            
            if(bandera==null){            
                huespedportaxista a= new huespedportaxista();  
                this.escritorio.add(a);
                a.obtenerusuario(usuario_actual);
                a.txtusuario.setText(usuario_actual);
                a.setVisible(true);            
            }else{
                JOptionPane.showMessageDialog(rootPane,"La ventana ya esta abierta!");
            }    
        }catch(Exception e){
            e.printStackTrace();    
        } 
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        // TODO add your handling code here:
        String bandera=buscar_taxista_consulta.bandera_buscar_taxista;
        try{
            if(bandera==null){
                buscar_taxista_consulta a= new buscar_taxista_consulta();
                this.escritorio.add(a);
                a.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(rootPane,"La ventana ya esta abierta!");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        // Visualizar Alquileres
        String bandera=visualizar_alquiler.bandera_visualizar_alquiler;
        try{
            if(bandera==null){
                visualizar_alquiler a= new visualizar_alquiler();
                this.escritorio.add(a);
                a.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(rootPane,"La ventana ya esta abierta!");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        // Buscar habitacion
        String bandera=visualizar_habitacion.bandera_visualizar_habitaciones;
        try{
            if(bandera==null){
                visualizar_habitacion a= new visualizar_habitacion();
                this.escritorio.add(a);
                a.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(rootPane,"La ventana ya esta abierta!");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        //buscar reserva
        String bandera=Buscar_reserva.bandera_buscar_reserva;
        try{
            if(bandera==null){
                Buscar_reserva a=new Buscar_reserva();
                this.escritorio.add(a);
                a.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(rootPane,"La ventana ya esta abierta!");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        //clientes por taxista
        String bandera=Buscar_clientes_por_taxistas.bandera_clientes_taxista;
        try{
            if(bandera==null){
                Buscar_clientes_por_taxistas a=new Buscar_clientes_por_taxistas();
                this.escritorio.add(a);
                a.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(rootPane,"La ventana ya esta abierta!");
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem22ActionPerformed
        // TODO add your handling code here:
        String bandera=Huespedes_recepcionista.bandera_huesped_recepcionista;
        try{
            if(bandera==null){
                Huespedes_recepcionista a=new Huespedes_recepcionista();
                this.escritorio.add(a);
                a.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(rootPane,"La ventana ya esta abierta!");
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }//GEN-LAST:event_jMenuItem22ActionPerformed

    private void visualizardetallealquilerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizardetallealquilerActionPerformed
        // visualizar detalle de alquiler
        String bandera=visualizar_detalle_alquiler.bandera_visualizar_detalle_alquiler;
        try{
            if(bandera==null){
                visualizar_detalle_alquiler a= new visualizar_detalle_alquiler();
                this.escritorio.add(a);
                a.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(rootPane,"La ventana ya esta abierta!");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_visualizardetallealquilerActionPerformed

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        // TODO add your handling code here:
        try {
            Desktop.getDesktop().open(new File("C:\\Users\\Usuario\\Downloads\\Compilador\\Crear exe apartir de jar\\Guía de Usuario\\Guia de Usuario Hostal Terrazas.pdf"));
        } catch (IOException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenu5MouseClicked

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
            java.util.logging.Logger.getLogger(MenuPrincipalRe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalRe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalRe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalRe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipalRe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MPcerrarsesion;
    private javax.swing.JMenuItem MPsalir;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator11;
    private javax.swing.JPopupMenu.Separator jSeparator12;
    private javax.swing.JPopupMenu.Separator jSeparator13;
    private javax.swing.JPopupMenu.Separator jSeparator14;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private jcMousePanel.jcMousePanel jcMousePanel1;
    private javax.swing.JMenuItem visualizardetallealquiler;
    // End of variables declaration//GEN-END:variables
}
