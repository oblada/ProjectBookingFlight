import java.util.Date;

public class Ticket {
	
	public static int ticketNumber = 100;

	TICKETTYPE ticketType;
	String passengerName;
	AirPlane flight;
	String startingLocation;
	Airport destination;
	int ticketSerialNumber;
	int seatNumber;
	Date dateOfIssue;
	int flightDate;
	
	
	
	//Constructor
	public Ticket (TICKETTYPE ticketType, String passengerName, AirPlane flight, String startingLocation, Airport destination2, 
					int seatNumber, int i ){
		Ticket.ticketNumber++;
		this.ticketSerialNumber = ticketNumber;
		
		this.ticketType = ticketType;
		this.passengerName = passengerName;
		this.flight =flight;
		this.startingLocation = startingLocation;
		this.destination = destination2;		
		this.seatNumber = seatNumber;
		this.flightDate=i;
				
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

	public AirPlane getFlight() {
		return flight;
	}
	
		
	public void setFlightNumber(AirPlane flight) {
		this.flight = flight;
	}

	public String getStartingLocation() {
		return startingLocation;
	}

	public void setStartingLocation(String startingLocation) {
		this.startingLocation = startingLocation;
	}

	public Airport getDestination() {
		return destination;
	}

	public void setDestination(Airport destination) {
		this.destination = destination;
	}

	public int getTicketSerialNumber() {
		return ticketSerialNumber;
	}

	public Date getDateOfIssue() {
		return dateOfIssue;
	}

	public int getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(int flightDate) {
		this.flightDate = flightDate;
	}



	
}
