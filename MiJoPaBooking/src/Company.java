import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

public class Company {
	
	private ArrayList<AirPlane> airplanes	= new ArrayList<AirPlane>();
	private ArrayList<Flight> flights		= new ArrayList<Flight>();
	
	public Company() {
		airplanes.add(new PassengerPlane("CrashN", 5, 5, "Tupol", "V"));
		airplanes.add(new PassengerPlane("Burn", 10, 20, "Sputter", "000"));
		airplanes.add(new PassengerPlane("N2DGround", 8, 14, "GasBag", "Hindenburg"));
	}
	
	public ArrayList<AirPlane> getAirplanes() {
		return airplanes;
	}

	public ArrayList<Flight> getFlights() {
		return flights;
	}
	
	public void addAirplane(AirPlane airplane) {
		airplanes.add(airplane);
	}
	
	public void addFlight(Flight flight) {
		flights.add(flight);
	}
	
	public Flight findFlight(int flightNumber) {
		for (Flight flight : flights) {
			if (flight.getFlightSerialNumber() == flightNumber) {
				return flight;
			}
		}
		return null;
	}
	
	public void calcuteFlightResult(int flightNumber) {
		Flight flight						= findFlight(flightNumber);
		
		if (flight != null) {
			int totalIncome						= 0;
			
			for (Ticket ticket : flight.getTicket()) {
				totalIncome += ticket.getTicketName().getCostOfTicket();
			}
			
			int totalCost	= TICKETTYPE.ECONOMY.getCostOfTicket() * flight.getAirPlane().numberOfSeatsBusinessClass;
			totalCost += TICKETTYPE.FIRST.getCostOfTicket() * flight.getAirPlane().numberOfSeatsFirstClass;
			totalCost *= 0.7;
			
			if (totalCost > totalIncome) {
				System.out.println("The company made a loss of " + (totalCost - totalIncome));
			} else {
				System.out.println("The company made a profit of " + (totalIncome - totalCost));
			}
		}
	}
	
	public void generateFlights() {
		
		Random random 		= new Random();
		Airport[] ap 		= Airport.values();		
		
		for (AirPlane airplane: getAirplanes()) {
			
			int start 		= random.nextInt(ap.length);
			int dest 		= start;
			
			for (int days = 1; days <= 5; days++) {
				
				while (start == dest) {
					dest 		= random.nextInt(ap.length);
				}
				
				Flight flight 	= new Flight(ap[start], ap[dest], LocalDateTime.now().plusDays(days), airplane, new ArrayList<Ticket>());
				start			= dest;
				addFlight(flight);
			}
		}

	}
	
}
