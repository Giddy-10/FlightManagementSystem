package fms.model;

/**
 *
 * @author nyaga
 */
public class Admin extends Person{
    public int workID;
    
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
    public void showDetails(String firstName, String lastName, int natID){
        System.out.println("Admin:" + firstName + "" + lastName);
        System.out.println("Work ID:" + workID);
        System.out.println("National ID:" + natID);
    }
    public void setPlane(Flight flight){
        System.out.println("Setting plane for the flight...");
    }
    public void createFlight(){
        System.out.println("Creating a new flight...");
    }
}
