package fms.model;

/**
 *
 * @author nyaga
 */
public class Plane {
    private String name;
    private int capacity;
    
    public Plane(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
    }
    
    public String getName() {
        return this.name;
    }
    public int getCapacity(){
        return this.capacity;
    }
    public void setCapacity(int Capacity){
        this.capacity = Capacity;
    }
    
    public String getDetails() {
        return this.name + " - " + String.valueOf(this.capacity);
    }
}
