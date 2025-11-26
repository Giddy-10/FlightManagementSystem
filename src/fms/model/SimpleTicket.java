package fms.model;

public class SimpleTicket implements Ticket {
    private final String destination;
    private final Schedule schedule;
    
    public SimpleTicket(String destination, Schedule scdl) {
        this.destination = destination;
        this.schedule = scdl;
    }
    
    @Override
    public String getDescription() {
        return "Standard Ticket to " + destination + " on " + schedule.getDay() + " at " + schedule.getTime();
    }
}
