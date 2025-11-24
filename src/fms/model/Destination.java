package fms.model;

/**
 *
 * @author nyaga
 */
public class Destination {
    private String name;
    private int duration; 
    
    //Constructor
    public Destination(String name, int duration){
        this.name = name;
        this.duration = duration;
    }
    // Getters & Setters
    public String getName(){
        return name;
    }
    public void setName (String Name){
        this.name = Name;
    }
    public int getDuration(){
        return duration;
    }
    public void setDuration (int Duration){
        this.duration = Duration;
    }
}

