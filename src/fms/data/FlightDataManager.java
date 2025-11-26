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
    
    private static int nextFlightNumber = 100;

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
        
        // Planes
        Plane nrg = new Plane("NRG-25", 1000);
        Plane nip = new Plane("NIP-31", 759);
        Plane kc = new Plane("KC-4", 1231);
        planes.add(nrg);
        planes.add(nip);
        planes.add(kc);
        
        // Destinations
        Destination london = new Destination("London", 563);
        Destination amsterdam = new Destination("Amsterdam", 549);
        Destination newYork = new Destination("New York", 905);
        destinations.add(london);
        destinations.add(amsterdam);
        destinations.add(newYork);

        // Flights
        flights.add(new Flight(getNextFlightNumber(), kc, new Schedule("Friday", Time.valueOf("10:27:00")), newYork));
        flights.add(new Flight(getNextFlightNumber(), nrg, new Schedule("Monday", Time.valueOf("08:30:00")), london, 726));
    }
    
    // Saves all lists to their respective files
    public void saveAllData() {
        JsonPersistenceService.save(flights, "flights.json");
        JsonPersistenceService.save(planes, "planes.json");
        JsonPersistenceService.save(destinations, "destinations.json");
    }

    public int getNextFlightNumber() {
        // Find the maximum existing flight number to prevent duplicates 
        // when loading data from the JSON file.
        int max = nextFlightNumber;
        for (Flight flight : flights) {
            if (flight.getFlightNumber() > max) {
                max = flight.getFlightNumber();
            }
        }
        // If data was loaded, start the counter from max + 1
        nextFlightNumber = max + 1;
        return nextFlightNumber;
    }
    
    // getters
    public List<Flight> getFlights() { return flights; }
    public List<Plane> getPlanes() { return planes; }
    public List<Destination> getDestinations() { return destinations; }
    
    public Plane getPlaneByName(String name) {
        for (Plane p : planes) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null; 
    }
    
    public Destination getDestinationByName(String name) {
        for (Destination d : destinations) {
            if (d.getName().equals(name)) {
                return d;
            }
        }
        return null;
    }
    
        
    public Flight getFlightByNumber(int flightNumber) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber() == flightNumber) {
                return flight;
            }
        }
        return null;
    }
    
    // Modification Methods
    public void addFlight(Plane plane, Schedule schedule, Destination destination) {
        int newFlightNum = getNextFlightNumber();
        Flight newFlight = new Flight(newFlightNum, plane, schedule, destination);
        flights.add(newFlight);
        saveAllData();
    }
    public void addFlight(Plane plane, Schedule schedule, Destination destination, int seats) {
        int newFlightNum = getNextFlightNumber();
        Flight newFlight = new Flight(newFlightNum, plane, schedule, destination, seats);
        flights.add(newFlight);
        saveAllData();
    }
    
    public boolean changeFlightPlane(int flightNumber, Plane newPlane) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber() == flightNumber) {
                if (newPlane.getCapacity() >= flight.getSeatsTaken()) { 
                    flight.setPlane(newPlane);
                    saveAllData(); 
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
    
    public boolean attemptBookFlight(int flightNumber, boolean extraLuggage) {
        Flight flight = getFlightByNumber(flightNumber);

        if (flight != null) {
            if (flight.bookSeat()) {
                if (extraLuggage) {
                    ExtraLuggageTicket extraTicket = new ExtraLuggageTicket(flight.getDestination().getName(), flight.getSchedule());
                } else {
                    SimpleTicket simpleTicket = new SimpleTicket(flight.getDestination().getName(), flight.getSchedule());
                }
                saveAllData();
                return true;
            }
        }
        return false;
    }
}
