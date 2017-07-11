
package Clases;

import javax.swing.JProgressBar;
 
public class cargar extends Thread{
    
 JProgressBar progreso;
 public cargar(JProgressBar progreso)
 {
     
     super();
     this.progreso = progreso;
     
 }
 @Override
 public void run()
 {
     
     for(int a = 1; a<=100; a++)
     {
         progreso.setValue(a);
         pausa(25);
     }
     
 }
 
 public void pausa(int mlseg)
 {
     try {
         Thread.sleep(mlseg);
         
     } catch (Exception e) {
     }
 }
   
}
