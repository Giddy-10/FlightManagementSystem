package fms.data;

import com.google.gson.reflect.TypeToken;
import fms.model.Admin;
import fms.model.User;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class UserDataManager {
    
    private static final String ADMIN_FILE = "admins.json";
    private static final String CUSTOMER_FILE = "customers.json";
    
    // TypeTokens for Gson to handle Lists of complex objects
    private static final Type ADMIN_LIST_TYPE = new TypeToken<List<Admin>>(){}.getType();
    private static final Type USER_LIST_TYPE = new TypeToken<List<User>>(){}.getType();

    private List<Admin> admins;
    private List<User> customers;
    private static UserDataManager instance;

    private UserDataManager() {
        // Load data on instantiation
        admins = JsonPersistenceService.load(ADMIN_FILE, ADMIN_LIST_TYPE);
        customers = JsonPersistenceService.load(CUSTOMER_FILE, USER_LIST_TYPE);
        
        // Initialize default admins if the file is empty
        if (admins.isEmpty()) {
            initializeDefaultAdmins();
            saveAllData(); // Save the new default list
        }
    }
    
    public static UserDataManager getInstance() {
        if (instance == null) {
            instance = new UserDataManager();
        }
        return instance;
    }

    private void initializeDefaultAdmins() {
        System.out.println("Initializing default admins...");
        // Use your Admin constructor: (firstName, lastName, YoB, workID)
        admins.add(new Admin("Jane", "Doe", 1985, 101));
        admins.add(new Admin("John", "Smith", 1978, 102));
        admins.add(new Admin("System", "Admin", 1990, 999));
    }
    
    public void saveAllData() {
        JsonPersistenceService.save(admins, ADMIN_FILE);
        JsonPersistenceService.save(customers, CUSTOMER_FILE);
    }
    
    // Getters for lists
    public List<Admin> getAdmins() { return admins; }
    public List<User> getCustomers() { return customers; }
    
    // CRUD method for new customer registration
    public void addCustomer(User newUser) {
        customers.add(newUser);
        saveAllData(); 
    }
}