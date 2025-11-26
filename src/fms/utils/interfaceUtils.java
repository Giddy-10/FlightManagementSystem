
package fms.utils;

import fms.interfaces.CustomerDashboard;
import fms.interfaces.AdminDashboard;
import fms.interfaces.FlightInformationUI;
import fms.interfaces.RegisterUI;
import javax.swing.JFrame;

public interface interfaceUtils {
    public static void openAdminDashboard(JFrame currentScreen, String adminName) {
        AdminDashboard adminWindow = new AdminDashboard(adminName);

        adminWindow.setVisible(true);

        currentScreen.dispose();
    }
    
    public static void openCustomerDashboard(JFrame currentScreen, String customerName) {
        CustomerDashboard adminWindow = new CustomerDashboard(customerName);

        adminWindow.setVisible(true);

        currentScreen.dispose();
    }
    
    public static void openRegisterUI(JFrame currentScreen) { // <-- NEW METHOD
        RegisterUI registerWindow = new RegisterUI(); // Assuming RegisterUI constructor takes no arguments

        registerWindow.setVisible(true);

        currentScreen.dispose();
    }
    
    public static void openFlightInfoDisplay(JFrame currentScreen) {
        FlightInformationUI infoWindow = new FlightInformationUI();

        infoWindow.setVisible(true);
    }
}
