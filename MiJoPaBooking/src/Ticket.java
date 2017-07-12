import java.util.Date;

public class Ticket {

	TICKETTYPE ticketType;
	String passengerName;
	String flightNumber;
	String startingLocation;
	String destination;
	int ticketSerialNumber;
	int seatNumber;
	Date dateOfIssue;
	Date flightDate;
	
	
	
	//Constructor
	public Ticket (TICKETTYPE ticketType, String passengerName, String flightNumber, String startingLocation, String destination, int ticketSerialNumber, 
					int seatNumber, Date flightDate ){
		this.ticketType = ticketType;
		this.passengerName = passengerName;
		this.flightNumber =flightNumber;
		this.startingLocation = startingLocation;
		this.destination = destination;
		this.ticketSerialNumber = ticketSerialNumber;
		this.seatNumber = seatNumber;
		this.flightDate=flightDate;
				
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

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getFlightNumber() {
		return flightNumber;
	}
	
		
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getStartingLocation() {
		return startingLocation;
	}

	public void setStartingLocation(String startingLocation) {
		this.startingLocation = startingLocation;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getTicketSerialNumber() {
		return ticketSerialNumber;
	}

	public Date getDateOfIssue() {
		return dateOfIssue;
	}

	public Date getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(Date flightDate) {
		this.flightDate = flightDate;
	}



	
}
