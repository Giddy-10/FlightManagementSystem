package fms.app;

/**
 *
 * @author nyaga
 */
import fms.model.*;
import java.sql.Time;
public class Main {
    public static void main(String[] args){
        
        Plane plane=new Plane(100);        
        Destination destination = new Destination("Mombasa", 60);       
        Schedule schedule = new Schedule("Monday", Time.valueOf("08:30:00"));
        
        Flight flight = new Flight(plane, schedule, destination);
        User user = new User ("Angy","Kim",2001, 98765432);
        
        //Print details
        flight.printDetails(plane, schedule, destination);
        
        //User books seats
        user.bookFlight(flight);
        
        System.out.println("Available seats: "
                + flight.availableSeats(flight.getSeatsTaken(), plane));
    }
    
}
