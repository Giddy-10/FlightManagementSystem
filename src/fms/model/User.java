package fms.model;

/**
 *
 * @author nyaga
 */
public class User extends Person {
    private int natID;
    
    //Constructor
    public User (String firstName, String lastName, int YoB, int natID){
        super(firstName, lastName, YoB);
        this.natID = natID;
    }
    //Getters & Setters
    public int getNatID(){
        return natID;
    }
    public void setNatID(int natID){
        this.natID= natID;
    }
    
    //Methods
    @Override
    public String showDetails() {
        return "Admin: " + this.getFirstName() + " " + this.getLastName()+ ", " + this.natID;
    }
    public void bookFlight(Flight flight){
        System.out.println("Booking flight...");
        flight.bookSeat();
    }
}
