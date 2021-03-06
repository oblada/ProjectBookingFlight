import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class Ticket {

	/** Ticket number starts at 100	 */
	
	public static int ticketNumber = 100;

	private TICKETTYPE ticketType;
	private String passengerName;
	private int ticketSerialNumber;
	private LocalDateTime dateOfIssue;
	private LocalDateTime flightDate;
	private Flight flight;
	private int ticketPrice;
	
	/** List of food that customer can choose from.	 */	
	private ArrayList <FOOD> foodChoices = new ArrayList<FOOD>();

	//Constructor
	public Ticket (TICKETTYPE ticketType, String passengerName, LocalDateTime flightDate, Flight flight){
		Ticket.ticketNumber++;
		this.ticketSerialNumber = ticketNumber;
		this.ticketType = ticketType;
		this.passengerName = passengerName;
		this.flightDate = flightDate;
		this. dateOfIssue= LocalDateTime.now();
		this.flight = flight;
		flight.addTicket(this);
	}

	//All the methods
	public TICKETTYPE getTicketName() {
		return ticketType;
	}

	public void setTicketName(TICKETTYPE ticketName) {
		this.ticketType = ticketName;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}


	public int getTicketSerialNumber() {
		return ticketSerialNumber;
	}

	public LocalDateTime getDateOfIssue() {
		return dateOfIssue;
	}

	public LocalDateTime getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(LocalDateTime flightDate) {
		this.flightDate = flightDate;
	}

	public void setFoodChoices(ArrayList<FOOD> foodChoices) {
		this.foodChoices = foodChoices;
	}

	public ArrayList<FOOD> getFoodChoices(){
		//ArrayList<FOOD> temp = new ArrayList<>(foodChoices);
		return foodChoices;
	}
	
	public Flight getFlight() {		
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	/**
	 * @return Ticket price calculates in TicketMaster
	 */
	public int getTicketPrice(){
		return ticketPrice;
	}

	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	
	public int calculateTicketPrice() {
		int cost = getTicketName().getCostOfTicket();
		for (FOOD f : getFoodChoices()) {
			cost += f.getCost();
		}
		return cost;
	}
	
	@Override
	public String toString() {
		String outString = String.format("%-30s%-10s%-20s%-20s%6d", getPassengerName(), getTicketName(), getFlight().getTackOff(), getFlight().getDestination(), getTicketPrice());
		return outString;
	}

	
}
