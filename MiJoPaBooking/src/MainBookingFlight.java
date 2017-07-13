import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MainBookingFlight {
	
	public static TicketMaster tm;
	public static List<AirPlane> airplanes;
	
	public static void main(String[] args) {
		
		//airplanes 		= Arrays.asList(new AirPlane("Rustbucket model V", 5, 5, 5.0, new Date(), ));
		
		tm				= new TicketMaster();
		tm.start();
		
//		//när bokningarna är färdiga anropas calculateProfit
//		System.out.println(calculateProfit());
//
//	}
//	
//	public static int calculateProfit() {
//		 
//		//hämta antalet passagerare i första klass multiplicera med 20000, spara summan
//		//hämta antalet passagerare i ekonomiklass multiplicera med 6000, lägg det till förra summan
//		//jämför med totalCost
//		int totalIncome = 0;
//
//		totalIncome += TICKETTYPE.FIRST * tm.getFirstClassPassengers();
//		totalIncome += TICKETTYPE.ECONOMY * tm.getEconomyClassPassengers();
//		
//		//Vi skulle antagligen använda oss av en lista av flights istället
//		for (AirPlane airplane : airplanes) {
//			totalIncome -= TICKETTYPE.FIRST * airplane.getNumberOfFirstClassSeats();
//			totalIncome -= TICKETTYPE.ECONOMY * airplane.getNumberOfEconomyClassSeats();
//		}
//		
//		return totalIncome;
//		
	}

}
