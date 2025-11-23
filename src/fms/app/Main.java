
package fms.app;

/**
 *
 * @author nyaga
 */
import fms.interfaces.RegisterUI;

public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterUI().setVisible(true);
            }
        });
    }
    
}
