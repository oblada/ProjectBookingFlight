import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TicketMaster {

	static Scanner scan = new Scanner(System.in);
	Company company;



	//    Constructor ----------------------------------------------

	public TicketMaster(Company company) {		
		this.company = company;
	}

	//Methods --------------------------------------------------

	public void start() {
		String name;
		Flight flight;
		int priceOfTicket;
		boolean TicketMasterfinished=false;
		boolean validName=false;
		
		do {
		System.out.println("Enter name (or ticket number to change existing ticket):");
		name = scan.nextLine();
		
		//check to see if number is entered and thus a ticket to change
		try {
			if(Integer.parseInt(name)>0) {
				ticketChanger(Integer.parseInt(name));
				return;
			}
		} catch (NumberFormatException e) {
			//just ignore this if not a number
		}
		
		// We don't accept names to short, get a real name for heavens sake!
			if(name.length()>3) validName=true;
				
		}while(!validName);
	
		Ticket newTicket = null;

		do {
			do {
				flight = getAndPresentDestinations();

				if(flight == null) {
					System.out.println("No destination chosen - do you want to quit? ");
					char choice = scan.next().charAt(0);
					scan.nextLine();
					if(choice=='N' || choice=='n') continue;
					scan.close();
					return;
				}

			}while(flight==null);

			do {
				newTicket = getAndReserveSeat(name, flight);

				if(newTicket==null) {
					System.out.println("Do you want to try to book another flight (Y/N)");
					char choice = scan.next().charAt(0);
					scan.nextLine();
					if(choice=='Y' || choice=='y') continue;
					scan.close();
					return;
				}

			}while(newTicket==null);

			TheFoodService(newTicket);

			priceOfTicket = getPrice(newTicket);

			System.out.println("The cost for this ticket will be "+ priceOfTicket);
			System.out.println("Accept ticket? (Y/N)");
			char choice = scan.next().charAt(0);
			scan.nextLine();

			if(choice=='Y' || choice=='y') {
				newTicket.setTicketPrice(priceOfTicket);
				System.out.println("Ticket is printed! (ie everything worked, ... or it seems so anyway)");

				break;
			}else {
				flight.removeTicket(newTicket);
				System.out.println(" Do you want to book another ticket instead (Y/N)");
				char choiceB = scan.next().charAt(0);
				scan.nextLine();

				if(choiceB=='Y' || choiceB=='y') continue;
				else {
					scan.close();
					return;
				}
			}

		}while(!TicketMasterfinished);





		scan.close();
	}




	//Internal Methods ----------------------------------------

	private void ticketChanger(int ticketNumber) {

		Ticket oldTicket = company.findTicket(ticketNumber);
		int a=0;
		boolean finished=false;
		Flight flightToChange=oldTicket.getFlight();
		do {
			
			System.out.println("What is wrong?");
			System.out.println("I want to change (enter a number):");
			System.out.println("1. My flight");
			System.out.println("2. My food choices");
			System.out.println("3. The ticket class");

			try {
				a = Integer.parseInt(scan.next());
			} catch (Exception e) {
				System.out.println("Only numbers allowed as input");
				scan.nextLine();		
				continue;
			}
			scan.nextLine();
			if(a>3 || a<1) continue;
			finished =true;
			
		}while(!finished);
		
		switch (a) {
		case 1: // Changing where to fly
			int priceOfoldTicket = getPrice(oldTicket);
			Flight newFlight= getAndPresentDestinations();
			Ticket newTicket = getAndReserveSeat(oldTicket.getPassengerName(), newFlight);
			TheFoodService(newTicket);
			int priceOfNewTicket = getPrice(newTicket);
			
			int cost1 = priceOfoldTicket-priceOfNewTicket;
			if(cost1<0) System.out.println("You will be refunded"+(-cost1/2));
			else System.out.println("The cost for this ticket will be "+ (cost1+500));
			
			System.out.println("Accept ticket? (Y/N)");
			char choice = scan.next().charAt(0);
			scan.nextLine();

			if(choice=='Y' || choice=='y') {
				newTicket.setTicketPrice(priceOfNewTicket);
				System.out.println("Ticket is printed! (ie everything worked, ... or it seems so anyway)");
				flightToChange.removeTicket(oldTicket);
				break;
			}
			newFlight.removeTicket(newTicket);
			System.out.println("Ok, restarting from the beginning");
			break;
		case 2: // Just changing the food
			int priceOfTicket1 = getPrice(oldTicket);
			TheFoodService(oldTicket);
			int priceOfTicket2 = getPrice(oldTicket);
			int cost2=Math.max(50,priceOfTicket1-priceOfTicket2+50);
			System.out.println("You will be charged"+cost2);
			break;
		case 3:
			System.out.println("not implemented yet!");
			break;

		default:
			System.out.println("not implemented yet!");
			break;
		}




	}

	private Flight getAndPresentDestinations() {

		List<Flight> airportList = company.getFlights();

		Flight myFlight = null;
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
				break;
			}
		}while(!finished);

		myFlight = airportList.get(a-1);
		System.out.println(myFlight.toString());
		return myFlight;
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
						finished=true;

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

	private int getPrice(Ticket newTicket) {

		int price;

		price = newTicket.getTicketName().getCostOfTicket();

		for(FOOD item: newTicket.getFoodChoices()) {
			price +=item.getCost();
		}

		return price;
	}


}
