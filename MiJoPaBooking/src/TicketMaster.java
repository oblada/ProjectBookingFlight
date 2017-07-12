import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TicketMaster {

	static Scanner scan = new Scanner(System.in);

	// Constructor ----------------------------------------------

	public TicketMaster() {		//add ArrayList<Airport> destinations
		//this.destinations = destinations;
	}

	//Methods --------------------------------------------------

	public void start() {
		String name;
		TICKETTYPE ticketType;
		Food foodChoice;

		int seat;

		System.out.println("Enter name:"); //TODO Add ticket number for change tickets
		name = scan.nextLine();
		Ticket newTicket = null;

		do {
			Airport destination = getAndPresentDestinations();

			newTicket = getAndReserveSeat(name, destination);

			if(newTicket==null) {
				System.out.println("Do you want to try to book another flight (Y/N)");
				char choice = scan.next().charAt(0);
				if(choice=='N' || choice=='n') return;
			}

		}while(newTicket==null);

		TheFoodService(newTicket);

	}




	//Internal Methods ----------------------------------------
	
	private Airport getAndPresentDestinations() {
		List<Airport> airportList = Arrays.asList(Airport.values());
		int i =1;
		System.out.println("Chose destination:");
		for (Airport temp : airportList) {
			System.out.println(i+": "+temp.getCity());
			i++;
		}

		int a = Integer.parseInt(scan.next());
		scan.nextLine();
		Airport destination = airportList.get(a-1);
		
		return destination;
	}	

	private Ticket getAndReserveSeat(String name, Airport destination) {

		boolean finished=false;
		
		AirPlane flight = getTransport();

		do {
			ArrayList<Ticket> firstClassSeatsUsed = flight.mySeatFirstClass;
			ArrayList<Ticket> economySeatsUsed = flight.mySeatBusinessClass;

			int freeFirstClassSeats = flight.numberOfSeatsFirstClass - firstClassSeatsUsed.size();
			int freeEconomySeats = flight.numberOfSeatsBusinessClass - economySeatsUsed.size();

			System.out.println("On this flight there are "+freeFirstClassSeats+" seats free in First Class");
			System.out.println("On this flight there are also "+freeEconomySeats+" seats free in Economy Class");

			if(freeFirstClassSeats>0) {
				System.out.println("Do you want a first Class ticket (Y/N);");

				char choice = scan.next().charAt(0);

				if(choice=='Y' || choice=='y') {

					Ticket newTicket = new Ticket(TICKETTYPE.FIRST, name, flight, "Hemma", destination, firstClassSeatsUsed.size()+1, 12);
					flight.mySeatFirstClass.add(newTicket);
					return newTicket;

				}
			}

			if(freeEconomySeats>0) {

				System.out.println("Then will have to travel economy class? (Y/N");
				char choice = scan.next().charAt(0);
				if(choice=='Y' || choice=='y') {
					Ticket newTicket = new Ticket(TICKETTYPE.ECONOMY, name, flight, "Hemma", destination, economySeatsUsed.size()+1, 12);
					flight.mySeatBusinessClass.add(newTicket);
					return newTicket;
				} else {
					System.out.println("Do you want to restart the booking? (Y/N)");
					char choiceB = scan.next().charAt(0);
					if(choice=='Y' || choice=='y') continue;
					else return null;
				}
			}

			if(freeFirstClassSeats<1 && freeEconomySeats<1) {
				System.out.println("Currently this flight is fully booked, please try another destination");
				return null;
			}

		}while(!finished);

		return null;
	}

	private AirPlane getTransport() {
		
		return new PassengerPlane("The Goose", 20, 5, 5, 2012, "Catalina", "23");
	}

	private void TheFoodService(Ticket newTicket) {
		// TODO Auto-generated method stub

	}
// Getters and Setters -------------------------------------


}
