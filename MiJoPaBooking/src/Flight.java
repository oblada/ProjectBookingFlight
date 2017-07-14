import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;

public class Flight {
	
	private Airport tackOff;
	private Airport destination;
	private LocalDateTime departurTime;
	private AirPlane airPlane;
	private static int flightNumber = 100;
	private int flightSerialNumber ;
	
	ArrayList <Ticket> ticket = new ArrayList <Ticket>();

	public Flight(Airport tackOff, Airport destination, LocalDateTime departurTime, AirPlane airPlane,
			ArrayList<Ticket> ticket) {
		flightNumber++;
		this.tackOff = tackOff;
		this.destination = destination;
		this.departurTime = departurTime;
		this.airPlane = airPlane;
		this.ticket = ticket;
		this.flightSerialNumber = flightNumber;
	}

	public Airport getDestination() {
		return destination;
	}

	public void setDestination(Airport destination) {
		this.destination = destination;
	}

	public Airport getTackOff() {
		return tackOff;
	}

	public LocalDateTime getDeparturTime() {
		return departurTime;
	}

	public AirPlane getAirPlane() {
		return airPlane;
	}

	public static int getFlightNumber() {
		return flightNumber;
	}

	public int getFlightSerialNumber() {
		return flightSerialNumber;
	}

	public ArrayList<Ticket> getTicket() {
		return ticket;
	}
	
	public void addTicket(Ticket t) {
		ticket.add(t);
	}
	
	public void removeTicket(Ticket t) {
		ticket.remove(t);
	}

	public int getNumberFirstClassTickets() {
		int count = 0;
		for (Ticket t : ticket) {
			if (t.getTicketName() == TICKETTYPE.FIRST) {
				count++;
			}
		}
		return count;
	}
	
	public int getNumberEconomyTickets() {
		int count = 0;
		for (Ticket t : ticket) {
			if (t.getTicketName() == TICKETTYPE.ECONOMY) {
				count++;
			}
		}
		return count;
	}
	
	public String toString() {
		return "From: " + getTackOff() + "\nTo:   " + getDestination() + "\nDate: " + getDeparturTime();
	}
	
}
