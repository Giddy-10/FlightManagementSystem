
package fms;

import javax.swing.JFrame;

public class interfaceUtils {
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
}
