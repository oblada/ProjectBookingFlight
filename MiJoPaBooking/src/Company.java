import java.util.ArrayList;

public class Company {
	
	private ArrayList<AirPlane> airplanes	= new ArrayList<AirPlane>();
	private ArrayList<Flight> flights		= new ArrayList<Flight>;
	
	public Company() {
//		airplanes.add(new PassengerPlane(airPlaneName, numberOfSeatsFirstClass, numberOfSeatsBusinessClass, flyHours, i, modelName, model));
//		airplanes.add(new PassengerPlane(airPlaneName, numberOfSeatsFirstClass, numberOfSeatsBusinessClass, flyHours, i, modelName, model));
//		airplanes.add(new PassengerPlane(airPlaneName, numberOfSeatsFirstClass, numberOfSeatsBusinessClass, flyHours, i, modelName, model));
		
	}
	public ArrayList<AirPlane> getAirplanes() {
		return airplanes;
	}

	public ArrayList<Flight> getFlights() {
		return flights;
	}
	
	public void addAirplane(AirPlane airplane) {
		airplanes.add(airplane);
	}
	
	public void addFlight(Flight flight) {
		flights.add(flight)
	}
	
	public void calcuteFlightResult(int flightNumber) {
		Flight flight						= 
	}
	
}
