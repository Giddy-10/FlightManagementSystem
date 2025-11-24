package fms.model;

import java.io.Serializable;

/**
 *
 * @author nyaga
 */
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String firstname;
    private String lastname;
    private int YoB;
    //constructor
    public Person (String firstName, String lastName, int YoB){
        this.firstname = firstName;
        this.lastname = lastName;
        this.YoB = YoB;
    }
    //Getters & Setters
    public String getFirstName(){
        return firstname;
    }
    public void FirstName(String firstName){
        this.firstname = firstName;
    }
    public String getLastName(){
        return lastname;
    }
    public void setLastName (String lastName){
        this.lastname = lastName;
    }
    public int getYoB(){
        return YoB;
    }
    public void setYoB (int YoB){
        this.YoB = YoB;
    }
   

    // Method
    public void showDetails(){
        System.out.println("Name:" + firstname + "" + lastname);
        System.out.println("Year of Birth:" + YoB);
    }
}
