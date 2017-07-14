import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Class to manage a single flight
 * @author youreakim
 * @author oblada
 */
public class Flight {
	
	/** Origin of the flight*/
	private Airport tackOff;
	/** Destination of the flight*/
	private Airport destination;
	/** Date and time of the flight*/
	private LocalDateTime departurTime;
	/** The AirPlane that is used for the flight*/
	private AirPlane airPlane;
	/** Static variable used to instantiate the flightSerialNumber*/
	private static int flightNumber = 100;
	/** Serial Number of the flight*/
	private int flightSerialNumber ;
	/** List of all the tickets that has been booked to the flight*/
	ArrayList <Ticket> ticket = new ArrayList <Ticket>();

	/**
	 * 
	 * @param tackOff
	 * @param destination
	 * @param departurTime
	 * @param airPlane
	 */
	public Flight(Airport tackOff, Airport destination, LocalDateTime departurTime, AirPlane airPlane) {
		flightNumber++;
		this.tackOff = tackOff;
		this.destination = destination;
		this.departurTime = departurTime;
		this.airPlane = airPlane;
		//this.ticket = ticket;
		this.flightSerialNumber = flightNumber;
	}

	/**
	 * Get the destination of this flight
	 * @return
	 */
	public Airport getDestination() {
		return destination;
	}
	
	/**
	 * Change the destination of this flight
	 * @param destination
	 */
	public void setDestination(Airport destination) {
		this.destination = destination;
	}

	/**
	 * Get the take off Airport for the flight
	 * @return
	 */
	public Airport getTackOff() {
		return tackOff;
	}

	/**
	 * Get the departure time of this flight
	 * @return
	 */
	public LocalDateTime getDeparturTime() {
		return departurTime;
	}

	/**
	 * Get which AirPlane is making this flight
	 * @return
	 */
	public AirPlane getAirPlane() {
		return airPlane;
	}

	/**
	 * Get the flight number of this flight
	 * @return
	 */
	public int getFlightSerialNumber() {
		return flightSerialNumber;
	}

	/**
	 * Gets a list of all tickets booked on the current flight
	 * @return
	 */
	public ArrayList<Ticket> getTicket() {
		return ticket;
	}
	
	/**
	 * Add another ticket to the list of tickets
	 * @param t
	 */
	public void addTicket(Ticket t) {
		ticket.add(t);
	}
	
	/**
	 * Remove a ticket from the list of tickets
	 * @param t
	 */
	public void removeTicket(Ticket t) {
		ticket.remove(t);
	}

	/**
	 * Counts the number of first class tickets booked for this flight
	 * @return
	 */
	public int getNumberFirstClassTickets() {
		int count = 0;
		for (Ticket t : ticket) {
			if (t.getTicketName() == TICKETTYPE.FIRST) {
				count++;
			}
		}
		return count;
	}
	
	/**
	 * Counts the number of economy class tickets booked for this flight
	 * @return
	 */
	public int getNumberEconomyTickets() {
		int count = 0;
		for (Ticket t : ticket) {
			if (t.getTicketName() == TICKETTYPE.ECONOMY) {
				count++;
			}
		}
		return count;
	}
	
	@Override
	public String toString() {
		return "From: " + getTackOff() + "\nTo:   " + getDestination() + "\nDate: " + getDeparturTime();
	}
	
}
