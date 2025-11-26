
package fms.model;

public class ExtraLuggageTicket implements Ticket {
    private final String destination;
    private final Schedule schedule;
    
    public ExtraLuggageTicket(String destination, Schedule scdl) {
        this.destination = destination;
        this.schedule = scdl;
    }
    
    @Override
    public String getDescription() {
        return "Extra Luggage Ticket to " + destination + " on " + schedule.getDay() + " at " + schedule.getTime();
    }   
}
