package fms.data;

import com.google.gson.reflect.TypeToken;
import fms.model.*;
import java.lang.reflect.Type;
import java.util.List;
import java.sql.Time;

public class FlightDataManager {
    // TypeTokens to help Gson deserialize the complex List types
    private static final Type FLIGHT_TYPE = new TypeToken<List<Flight>>(){}.getType();
    private static final Type PLANE_TYPE = new TypeToken<List<Plane>>(){}.getType();
    private static final Type DESTINATION_TYPE = new TypeToken<List<Destination>>(){}.getType();

    // Data lists
    private List<Flight> flights;
    private List<Plane> planes;
    private List<Destination> destinations;
    // Schedules are simple enough to be created on demand, or handled similarly if preferred

    private static FlightDataManager instance;

    private FlightDataManager() {
        // 1. Load data for ALL lists
        planes = JsonPersistenceService.load("planes.json", PLANE_TYPE);
        destinations = JsonPersistenceService.load("destinations.json", DESTINATION_TYPE);
        flights = JsonPersistenceService.load("flights.json", FLIGHT_TYPE);

        // 2. Initialize default data only if the files are empty (first run)
        if (planes.isEmpty() || destinations.isEmpty() || flights.isEmpty()) {
            initializeDefaultData(); 
            // Save the newly created default data immediately
            saveAllData(); 
        }
    }
    
    // Singleton access method
    public static FlightDataManager getInstance() {
        if (instance == null) {
            instance = new FlightDataManager();
        }
        return instance;
    }

    private void initializeDefaultData() {
        System.out.println("Initializing default data...");
        // Define your objects here and add them to the respective lists
        
        // --- Planes ---
        Plane nrg = new Plane("NRG-25", 1000);
        Plane nip = new Plane("NIP-31", 759);
        Plane kc = new Plane("KC-4", 1231);
        planes.add(nrg);
        planes.add(nip);
        planes.add(kc);
        
        // --- Destinations ---
        Destination london = new Destination("London", 563);
        Destination amsterdam = new Destination("Amsterdam", 549);
        Destination newYork = new Destination("New York", 905);
        destinations.add(london);
        destinations.add(amsterdam);
        destinations.add(newYork);

        // --- Flights ---
        // Reuse the objects defined above!
        flights.add(new Flight(kc, new Schedule("Friday", Time.valueOf("10:27:00")), newYork));
        flights.add(new Flight(nrg, new Schedule("Monday", Time.valueOf("08:30:00")), london, 726));
    }
    
    // Saves all lists to their respective files
    public void saveAllData() {
        JsonPersistenceService.save(flights, "flights.json");
        JsonPersistenceService.save(planes, "planes.json");
        JsonPersistenceService.save(destinations, "destinations.json");
    }

    // --- Accessor Methods (Getters) ---
    public List<Flight> getFlights() { return flights; }
    public List<Plane> getPlanes() { return planes; }
    public List<Destination> getDestinations() { return destinations; }

    // --- Modification Methods ---
    // Example: Add a new flight and save all data
    public void addFlight(Flight newFlight) {
        flights.add(newFlight);
        saveAllData(); // Save immediately after modification
    }
}
