package mini_crud.application;

import com.formdev.flatlaf.FlatLightLaf;

import mini_crud.tela.TelaPrincipal;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author gustavo
 */
public class Program {
    public static void main(String args[]) { 
       
         try {
            javax.swing.UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaPrincipal().setVisible(true);
   
            }
        });
    }
}
