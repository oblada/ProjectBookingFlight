import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MainBookingFlight {
	
	public static TicketMaster tm;
	public static List<AirPlane> airplanes;
	
	public static void main(String[] args) {
		
		Company comp	= new Company();
		comp.generateFlights();
		
		tm				= new TicketMaster(comp);
		tm.start();
	}

}
