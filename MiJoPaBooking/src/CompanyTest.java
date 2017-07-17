import java.util.Scanner;

public class CompanyTest {
	
	public static void main(String [] args) {
		Scanner scanner				= new Scanner(System.in);
		
		Company comp = new Company();
		comp.generateFlights();
		
		for (Flight flight : comp.getFlights()) {
			System.out.println(flight);
			
			System.out.println(comp.calcuteFlightResult(flight.getFlightSerialNumber()));
			
			System.out.println("================================================");
			
			for (Ticket t : flight.getTicket()) {
				t.setTicketPrice(t.calculateTicketPrice());
				System.out.println(t);
			}
			
		}
		
		comp.addAirplane(new PassengerPlane("Blowout", 6, 12, "Grounded", "X52"));
		System.out.println("Press enter to creates a new airplane and add flights to all");
		scanner.nextLine();
		for (AirPlane airplane : comp.getAirplanes()) {
			
			comp.createFlightSchedule(airplane);
			
		}
		
		
		for (Flight flight : comp.getFlights()) {
			System.out.println(flight);
			System.out.println("================================================");
				
		}

	}
}
