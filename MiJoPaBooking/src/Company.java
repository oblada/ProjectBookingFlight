import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
/**
 * Manages our small airline company
 * @author youreakim
 *
 */

public class Company {
	/** List of the airplanes the company owns*/
	private ArrayList<AirPlane> airplanes	= new ArrayList<AirPlane>();
	
	/** List of the flights the company has flown and is going to fly*/ 
	private ArrayList<Flight> flights		= new ArrayList<Flight>();
	
	/**
	 * Default constructor, creates three airplanes
	 */
	public Company() {
		airplanes.add(new PassengerPlane("CrashN", 5, 5, "Tupol", "V"));
		airplanes.add(new PassengerPlane("Burn", 10, 20, "Sputter", "000"));
		airplanes.add(new PassengerPlane("N2DGround", 8, 14, "GasBag", "Hindenburg"));
	}
	
	/**
	 * 
	 * @return an ArrayList of AirPlane
	 */
	public ArrayList<AirPlane> getAirplanes() {
		return airplanes;
	}

	/**
	 * 
	 * @return an ArrayList of Flight
	 */
	public ArrayList<Flight> getFlights() {
		return flights;
	}
	
	/**
	 * 
	 * @param airplane
	 */
	public void addAirplane(AirPlane airplane) {
		airplanes.add(airplane);
	}
	
	/**
	 * Removes an airplane and removes all of its flights
	 * @param airplane
	 */
	public void removeAirplane(AirPlane airplane) {
		Iterator<Flight> it					= flights.iterator();
		while (it.hasNext()) {
			if (it.next().getAirPlane() == airplane) {
				it.remove();
			}
		}
		airplanes.remove(airplane);
	}
	
	/**
	 * Adds a Flight to list of flights
	 * @param flight
	 */
	public void addFlight(Flight flight) {
		flights.add(flight);
	}
	
	/**
	 * Find a flight by the flightnumber, returns null if none is found
	 * @param flightNumber
	 * @return
	 */
	public Flight findFlightByFlightNumber(int flightNumber) {
		for (Flight flight : flights) {
			if (flight.getFlightSerialNumber() == flightNumber) {
				return flight;
			}
		}
		return null;
	}
	
	/**
	 * Gets a list of all flights flying out of one Airport
	 * @param airport
	 * @return
	 */
	public List<Flight> findFlightFrom(Airport airport){
		return flights.stream().filter(a -> a.getTackOff() == airport).collect(Collectors.toList());
	}
	
	/**
	 * Gets a list of all flights with the destination Airport
	 * @param airport
	 * @return
	 */
	public List<Flight> findFlightDestination(Airport airport){
		return flights.stream().filter(a -> a.getDestination() == airport).collect(Collectors.toList());
	}
	
	/**
	 * Searches through the flights and returns the ticket specified by the ticketNumber
	 * @param ticketNumber
	 * @return
	 */
	public Ticket findTicket(int ticketNumber) {
		for (Flight flight : flights) {
			for (Ticket ticket : flight.getTicket()) {
				if (ticket.getTicketSerialNumber() == ticketNumber) {
					return ticket;
				}
			}
		}
		return null;
	}
	
	/**
	 * Calculates the the cost and incomes of the flight and returns the difference 
	 * @param flightNumber
	 * @return
	 */
	public int calcuteFlightResult(int flightNumber) {
		
		int profit							= 0;
		int multiplier						= 1; //multiply the price of the food 
		Flight flight						= findFlightByFlightNumber(flightNumber);
		
		if (flight != null) {
			int totalIncome					= 0;
			
			ArrayList<Ticket> tickets		= flight.getTicket();
			
			for (Ticket ticket : tickets ) {
				multiplier					= ticket.getTicketName() == TICKETTYPE.FIRST ? 2 : 1;
				totalIncome += ticket.getTicketName().getCostOfTicket();
				for (FOOD f : ticket.getFoodChoices()) {
					totalIncome += (f.getCost() * multiplier);
				}
			}
			
			int totalCost	= TICKETTYPE.ECONOMY.getCostOfTicket() * flight.getAirPlane().numberOfSeatsBusinessClass;
			totalCost += TICKETTYPE.FIRST.getCostOfTicket() * flight.getAirPlane().numberOfSeatsFirstClass;
			totalCost *= 0.7;
			
			profit 							= totalIncome - totalCost;
		}
		
		return profit;
		
	}
	
	/**
	 * Creates a new flight for an AirPlane from Airport at given LocalDateTime, chooses a destination at random 
	 * @param start
	 * @param airplane
	 * @param ldt
	 * @return
	 */
	public Flight generateFlight(Airport start, AirPlane airplane, LocalDateTime ldt) {
		Random random 						= new Random();
		Airport dest						= start;
		Airport[] ap 						= Airport.values();
		
		while (start == dest) {
			dest 							= ap[random.nextInt(ap.length)];
		}
		
		return new Flight(start, dest, ldt, airplane/*, new ArrayList<Ticket>()*/);
	}
	
	/**
	 * Checks where the Airplane last destination is (otherwise a random Airport is picked)
	 * and when it last flew date (if the AirPlane is new this is set to today), then generates five new flights for this plane 
	 */
	public void createFlightSchedule(AirPlane airplane) {
		Random random 						= new Random();
		LocalDateTime ldt					= LocalDateTime.now();
		Airport[] ap 						= Airport.values();
		Airport start						= ap[random.nextInt(ap.length)];
		for (Flight flight : flights) {
			if (flight.getAirPlane() == airplane) {
				ldt							= flight.getDeparturTime();
				start						= flight.getDestination();
			}
		}
		
		for (int days = 1; days <= 5; days++) {
			Flight newFlight				= generateFlight(start, airplane, ldt.plusDays(days));
			addFlight(newFlight);
			start							= newFlight.getDestination(); 
		}
		
	}

	/*
	 * method added that is used for testing the application, should be moved somewhere else
	 */
	public void generateFlights() {
		
		Random random 		= new Random();
		Airport[] ap 		= Airport.values();
		String[] names		= {"Ignatz Ratzkywatzky", "I Zitzkywitzky", "Trudy Kockenlocker", "Lady Eve Sidwich", 
								"Sinclair Beckstein", "John L Sullivan", "Dan McGinty", "Woodrow Truesmith",
								"Norval Jones", "JD Hackensacker III", "Seargent Heppelfinger"};
		int l				= names.length;
		
		for (AirPlane airplane: getAirplanes()) {
			
			int start 		= random.nextInt(ap.length);
			int dest 		= start;
			int seats		= airplane.getnumberOfSeatsBusinessClass() + airplane.getnumberOfSeatsFirstClass();
			
			for (int days = 1; days <= 5; days++) {
				
				while (start == dest) {
					dest 		= random.nextInt(ap.length);
				}
				
				Flight flight 	= new Flight(ap[start], ap[dest], LocalDateTime.now().plusDays(days), airplane/*, new ArrayList<Ticket>()*/);
				//Generate tickets
				int nop			= random.nextInt(seats);
				TICKETTYPE tp;
				for (int i = 0; i < nop; i++) {
					if (random.nextInt(10) % 2 == 0) {
						tp		= TICKETTYPE.FIRST;
					} else {
						tp		= TICKETTYPE.ECONOMY;
					}
					Ticket t	= new Ticket(tp, names[random.nextInt(l)], LocalDateTime.now().plusDays(days), flight);
					int f		= random.nextInt(6);
					FOOD[] g	= FOOD.values();
					ArrayList<FOOD> v = new ArrayList<>();
					
					v.add(g[random.nextInt(6)]);
 					
					if (random.nextInt(2) % 2 == 0) {
						v.add(FOOD.POSH);
					}

					t.setFoodChoices(v);
					//flight.addTicket(t);
				}
				start			= dest;
				addFlight(flight);
			}
		}

	}
	
}
