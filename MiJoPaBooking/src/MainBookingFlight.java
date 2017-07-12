import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MainBookingFlight {
	
	private static final int FIRST_CLASS_TICKET_PRICE = 20000;
	private static final int ECONOMY_CLASS_TICKET_PRICE = 6000;
	public TicketMaster tm;
	public static List<AirPlane> airplanes;
	
	public List<String> airports = Arrays.asList("Reykjavik", "Dublin", "Edinburgh", 
									"London", "Oslo", "Copenhagen", "Stockholm", "Helsinki");

	public static void main(String[] args) {
		
		airplanes 		= Arrays.asList(new AirPlane("Rustbucket model V", 5, 5, 5.0, new Date(), ));
		
		tm				= new TicketMaster(airports);
		tm.start();
		
		//när bokningarna är färdiga anropas calculateProfit
		System.out.println(calculateProfit());

	}
	
	public static int calculateProfit() {
		 
		//hämta antalet passagerare i första klass multiplicera med 20000, spara summan
		//hämta antalet passagerare i ekonomiklass multiplicera med 6000, lägg det till förra summan
		//jämför med totalCost
		int totalIncome = 0;

		totalIncome += FIRST_CLASS_TICKET_PRICE * tm.getFirstClassPassengers();
		totalIncome += ECONOMY_CLASS_TICKET_PRICE * tm.getEconomyClassPassengers();
		
		//Vi skulle antagligen använda oss av en lista av flights istället
		for (AirPlane airplane : airplanes) {
			totalIncome -= FIRST_CLASS_TICKET_PRICE * airplane.getNumberOfFirstClassSeats();
			totalIncome -= ECONOMY_CLASS_TICKET_PRICE * airplane.getNumberOfEconomyClassSeats();
		}
		
		return totalIncome;
		
	}

}
