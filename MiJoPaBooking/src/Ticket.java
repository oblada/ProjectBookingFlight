import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class Ticket {
	
	public static int ticketNumber = 100;
	
	private TICKETTYPE ticketType;
	private String passengerName;
	private int ticketSerialNumber;
	private LocalDateTime dateOfIssue;
	private LocalDateTime flightDate;
	
	
	
	//Constructor
	public Ticket (TICKETTYPE ticketType, String passengerName, LocalDateTime flightDate ){
		Ticket.ticketNumber++;
		this.ticketSerialNumber = ticketNumber;
		this.ticketType = ticketType;
		this.passengerName = passengerName;
		this.flightDate = flightDate;
		this. dateOfIssue= LocalDateTime.now();
				
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


	ArrayList <FOOD> foodChoices = new ArrayList<FOOD>();
	
}
