
package fms.app;

/**
 *
 * @author nyaga
 */
import fms.interfaces.RegisterUI;
import fms.data.FlightDataManager;

public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        FlightDataManager.getInstance();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterUI().setVisible(true);
            }
        });
    }
    
}
