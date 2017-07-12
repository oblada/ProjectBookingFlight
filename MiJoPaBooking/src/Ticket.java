import java.util.Date;

public class Ticket {

	String ticketName;
	String passengerName;
	String flightNumber;
	String startingLocation;
	String destination;
	int ticketSerialNumber;
	int seatNumber;
	Date localDate;
	double ticketPrice;
	
	
	//Constructor
	public Ticket (String ticketName, String passengerName, String flightNumber, String startingLocation, String destination, int ticketSerialNumber, 
					int seatNumber, double ticketPrice){
		this.ticketName = ticketName;
		this.passengerName = passengerName;
		this.flightNumber =flightNumber;
		this.startingLocation = startingLocation;
		this.destination = destination;
		this.ticketSerialNumber = ticketSerialNumber;
		this.seatNumber = seatNumber;
		this.ticketPrice = ticketPrice;
				
	}

	//All the methods
	public String getTicketName() {
		return ticketName;
	}

	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
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

	public Date getLocalDate() {
		return localDate;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}
	
	
	
	
	
}
