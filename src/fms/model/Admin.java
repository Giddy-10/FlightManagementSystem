package fms.model;

/**
 *
 * @author nyaga
 */
public class Admin extends Person{
    private int workID;
    
    //constructor
    public Admin (String firstName, String lastName, int YoB, int workID){
        super (firstName, lastName, YoB);
        this.workID = workID;
    }
    
    //getters & Setters
    public int getworkID(){
        return workID;
    }
    public void setworkID(int workID){
        this.workID = workID;
    }
    
    //Methods
    @Override
    public String showDetails() {
        return "Admin: " + this.getFirstName() + " " + this.getLastName()+ ", " + this.workID;
    }
    public void setPlane(Flight flight){
        System.out.println("Setting plane for the flight...");
    }
    public void createFlight(){
        System.out.println("Creating a new flight...");
    }
    
    // Polymorphism (overriding)
    @Override
    public String getNames() {
        return "Admin name: " + this.getFirstName() + " " + this.getLastName();
    }
}
