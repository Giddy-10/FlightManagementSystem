package fms.model;

/**
 *
 * @author nyaga
 */
public class Flight {
    private Plane plane;
    private Schedule flightTime;
    private int seatsTaken;
    private Destination flightDestination;
    
    //Constructors
    public Flight(Plane plane, Schedule flightTime, Destination flightDestination){
        this.plane = plane;
        this.flightTime = flightTime;
        this.flightDestination = flightDestination;
        this.seatsTaken = 0;
    }
    public Flight(Plane plane, Schedule flightTime, Destination flightDestination, int seats){
        this.plane = plane;
        this.flightTime = flightTime;
        this.flightDestination = flightDestination;
        this.seatsTaken = seats;
    }
    //Getters 
    public Plane getPlane(){
        return plane;
    }
    public Schedule getSchedule(){
        return flightTime;
    }
    public Destination getDestination(){
        return flightDestination;
    }
    public int getSeatsTaken(){
        return seatsTaken;
    }
    //Setters
     public void setPlane (Plane plane){
         this.plane = plane;
     }
     public void setSchedule(Schedule flightTime){
         this.flightTime = flightTime;
     }
     public void setDestination(Destination flightDestination){
         this.flightDestination = flightDestination;
     }
     public void setSeatsTaken(){
         this.seatsTaken = seatsTaken;
     }
            
    public int availableSeats(int seatsTaken, Plane plane){
        return plane.getCapacity() - seatsTaken;
    }
    public void printDetails(Plane plane, Schedule flightTime, Destination flightDestination){
        System.out.println("Flight Details:");
        System.out.println("Plane capacity: " + plane.getCapacity());
        System.out.println("Flight day: " + flightTime.getDay());
        System.out.println("Destination: " + flightDestination.getName());
    }
    public boolean bookSeat(){
        if (seatsTaken < plane.getCapacity()){
            seatsTaken++;
            System.out.println("Seat booked. Seats taken:" + seatsTaken);
            return true;
        }
        System.out.println("Flight is full");
        return false;
    }
    
}
