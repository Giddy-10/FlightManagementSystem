package fms.model;

/**
 *
 * @author nyaga
 */
import java.sql.Time;

public class Schedule {
    private String day;
    private Time time;  
    
    //Constructor
    public Schedule(String day, Time time){
        this.day = day;
        this.time = time;
    }
    
    //getters & Setters
    public String getDay(){
        return day;
    }
    public void setDay(String Day){
        this.day = Day;
    }
    public Time getTime(){
        return time;
    }
    public void setTime(Time time){
        this.time = time;
    }
    
}