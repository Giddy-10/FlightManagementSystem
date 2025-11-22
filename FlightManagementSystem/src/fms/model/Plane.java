package fms.model;

/**
 *
 * @author nyaga
 */
public class Plane {
    private int capacity;
    
    public Plane(int capacity){
        this.capacity = capacity;
    }
    
    public int getCapacity(){
        return capacity;
    }
    public void setCapacity(int Capacity){
        this.capacity = Capacity;
    }
}
