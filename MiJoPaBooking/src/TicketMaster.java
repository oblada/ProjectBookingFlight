import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TicketMaster {

	static Scanner scan = new Scanner(System.in);

	//    Constructor ----------------------------------------------

	public TicketMaster() {		//add ArrayList<Airport> destinations
		//this.destinations = destinations;
	}

	//Methods --------------------------------------------------

	public void start() {
		String name;

		System.out.println("Enter name:"); //TODO Add ticket number for change tickets
		name = scan.nextLine();
		Ticket newTicket = null;

		do {
			Airport destination = getAndPresentDestinations();
			if(destination ==null) {
				System.out.println("No destination chosen - do you want to quit? ");
				char choice = scan.next().charAt(0);
				if(choice=='N' || choice=='n') continue;
				scan.close();
				System.exit(0);
			}
			
			newTicket = getAndReserveSeat(name, destination);

			if(newTicket==null) {
				System.out.println("Do you want to try to book another flight (Y/N)");
				char choice = scan.next().charAt(0);
				if(choice=='Y' || choice=='y') continue;
				scan.close();
				System.exit(0);
			}

		}while(newTicket==null);

		TheFoodService(newTicket);
		
		System.out.println("Ticket is printed! (ie everything worked, ... or it seems so anyway)");
		scan.close();
	}




	//Internal Methods ----------------------------------------

	private Airport getAndPresentDestinations() {
		List<Airport> airportList = Arrays.asList(Airport.values());
		Airport destination = null;
		boolean finished = false;
		
		
		int n = 0;
		System.out.println("Chose destination:");
		do {
			int i = 1;
			int a = 0;
		for (Airport temp : airportList) {
			System.out.println(i+": "+temp.getCity());
			i++;
		}

		try {
			a = Integer.parseInt(scan.next());
		} catch (Exception e) {
			System.out.println("Only numbers allowed as input");
			scan.nextLine();		
			continue;
		}
		scan.nextLine();
		destination = airportList.get(a-1);
		finished = true;
		if(n>10) {
			System.out.println("Bailing from loop due to going around and around");
		}
		}while(!finished);
		
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

				System.out.println("Then you want to have to travel economy class? (Y/N)");
				char choice = scan.next().charAt(0);
				if(choice=='Y' || choice=='y') {
					Ticket newTicket = new Ticket(TICKETTYPE.ECONOMY, name, flight, "Hemma", destination, economySeatsUsed.size()+1, 12);
					flight.mySeatBusinessClass.add(newTicket);
					return newTicket;
				} else {
					System.out.println("Do you want to restart the booking? (Y/N)");
					char choiceB = scan.next().charAt(0);
					if(choiceB=='Y' || choiceB=='y') continue;
					else {
						System.out.println("Bailing out");
						scan.close();
						System.exit(0);
					}
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
		System.out.println("Do you want to have a meal on the flight? (Y/N)");
		char choice = scan.next().charAt(0);
		ArrayList<FOOD> foodChoices = new ArrayList<>();
		if(choice=='Y' || choice=='y') {
			List<FOOD> foodList = Arrays.asList(FOOD.values());
			if(newTicket.ticketType == TICKETTYPE.FIRST) { // First class food
				boolean finished = false;
				do {
					int n=0;
					int i=1;
					int a = 0;
					for (FOOD temp : foodList) {
						System.out.println(i+": "+temp.getFood());
						i++;
					}
					try {
						a = Integer.parseInt(scan.next());
					} catch (NumberFormatException e) {
						System.out.println("Only numbers allowed as input");
						scan.nextLine();		

						continue;
					}
					scan.nextLine();
					foodChoices.add(foodList.get(a-1));
					System.out.println("Anything else? (Y/N)");
					char choiceB = scan.next().charAt(0);
					if(choiceB=='N' || choiceB=='n') finished =true;// bail out
					if(choiceB=='Y' || choiceB=='y') n =0;
					// check if we just are going round and round in the loop
					n++;
					if(n>10) finished =true;
				}while(!finished);
			}else { // Economy class food
				boolean finished = false;
				do {
					int n=0;
					int i=1;
					int a = 0;
					for (FOOD temp : foodList) {
						if (temp.getCost()<200) System.out.println(i+": "+temp.getFood());
						i++;
					}

					try {
						a = Integer.parseInt(scan.next());
					} catch (NumberFormatException e) {
						System.out.println("Only numbers allowed as input");
						scan.nextLine();		

						continue;
					}
					scan.nextLine();
					foodChoices.add(foodList.get(a-1));
					System.out.println("Anything else? (Y/N)");
					char choiceC = scan.next().charAt(0);
					if(choiceC=='N' || choiceC=='n') finished =true;// bail out
					if(choiceC=='Y' || choiceC=='y') n =0;
					// check if we just are going round and round in the loop
					n++;
					if(n>10) finished =true;
				}while(!finished);
			}
			}else {
				System.out.println("Starve then!");
				foodChoices.add(FOOD.NOTHING);
			}

		 newTicket.setFoodChoices(foodChoices);

		}
// Getters and Setters -------------------------------------


	}
