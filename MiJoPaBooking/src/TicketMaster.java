import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TicketMaster {

	static Scanner scan = new Scanner(System.in);
	Company company;

	//    Constructor ----------------------------------------------

	public TicketMaster(Company company) {		//add ArrayList<Airport> destinations
		this.company = company;
	}

	//Methods --------------------------------------------------

	public void start() {
		String name;
		Flight flight;
		
		System.out.println("Enter name:"); //TODO Add ticket number for change tickets
		name = scan.nextLine();
		Ticket newTicket = null;

		do {
			flight = getAndPresentDestinations();
			
			if(flight ==null) {
				System.out.println("No destination chosen - do you want to quit? ");
				char choice = scan.next().charAt(0);
				if(choice=='N' || choice=='n') continue;
				scan.close();
				System.exit(0);
			}
			
			

//			if(newTicket==null) {
//				System.out.println("Do you want to try to book another flight (Y/N)");
//				char choice = scan.next().charAt(0);
//				if(choice=='Y' || choice=='y') continue;
//				scan.close();
//				System.exit(0);
//			}

		}while(flight==null);
		
        newTicket = getAndReserveSeat(name, flight);
        
		TheFoodService(newTicket);
		
		System.out.println("Ticket is printed! (ie everything worked, ... or it seems so anyway)");
		scan.close();
	}




	//Internal Methods ----------------------------------------

	private Flight getAndPresentDestinations() {
		List<Flight> airportList = company.getFlights();
		Flight flight = null;
		boolean finished = false;
		
		int a = 0;
		int n = 0;
		System.out.println("Chose destination:");
		do {
			int i = 1;
			
		for (Flight temp : airportList) {
			System.out.println(i+": From"+temp.getTackOff().getCity()+" to "+temp.getDestination().getCity());
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
		
		finished = true;
		if(n>10) {
			System.out.println("Bailing from loop due to going around and around");
		}
		}while(!finished);
		
		flight = airportList.get(a-1);
		System.out.println(flight.toString());
		return flight;
	}	

	private Ticket getAndReserveSeat(String name, Flight flight) {

		boolean finished=false;

	

		do {
			int firstClassSeatsUsed = flight.getNumberFirstClassTickets();
			int economySeatsUsed = flight.getNumberEconomyTickets();

			int freeFirstClassSeats = flight.getAirPlane().numberOfSeatsFirstClass - firstClassSeatsUsed;
			int freeEconomySeats = flight.getAirPlane().numberOfSeatsBusinessClass - economySeatsUsed;

			System.out.println("On this flight there are "+freeFirstClassSeats+" seats free in First Class");
			System.out.println("On this flight there are also "+freeEconomySeats+" seats free in Economy Class");

			if(freeFirstClassSeats>0) {
				System.out.println("Do you want a first Class ticket (Y/N);");

				char choice = scan.next().charAt(0);

				if(choice=='Y' || choice=='y') {

					Ticket newTicket = new Ticket(TICKETTYPE.FIRST, name, LocalDateTime.now(), flight);

					return newTicket;

				}
			}

			if(freeEconomySeats>0) {

				System.out.println("Then you want to have to travel economy class? (Y/N)");
				char choice = scan.next().charAt(0);
				if(choice=='Y' || choice=='y') {
					Ticket newTicket = new Ticket(TICKETTYPE.ECONOMY, name,LocalDateTime.now(), flight);

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



	private void TheFoodService(Ticket newTicket) {
		System.out.println("Do you want to have a meal on the flight? (Y/N)");
		char choice = scan.next().charAt(0);
		ArrayList<FOOD> foodChoices = new ArrayList<>();
		if(choice=='Y' || choice=='y') {
			List<FOOD> foodList = Arrays.asList(FOOD.values());
			if(newTicket.getTicketName() == TICKETTYPE.FIRST) { // First class food
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
