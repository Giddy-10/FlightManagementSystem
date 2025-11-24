
package fms.data;

import fms.model.Destination;
import fms.model.Flight;
import fms.model.Plane;
import fms.model.Schedule;
import java.sql.Time;

public class Data {
    Plane nrg = new Plane("NRG-25",1000);
    Plane nip = new Plane("NIP-31", 759);
    Plane kc = new Plane("KC-4", 1231);
    
    Destination london = new Destination("London", 563);
    Destination amsterdam = new Destination("Amsterdam", 549);
    Destination newYork = new Destination("New York", 905);
    
//    Flight toNewYork = new Flight(kc, new Schedule("Friday", Time.valueOf("10:27:00")), newYork);
//    Flight toLondon = new Flight(nrg, new Schedule("Monday", Time.valueOf("08:30:00")), london, 726);
}
