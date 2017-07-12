import java.util.Date;

public abstract class AirPlane {
	
	protected String airPlaneName;
	protected int numberOfSeats;
	protected int seatNumber;
	protected double flyHours;
	protected Date flyingDate;	
	
	PassengerPlane modelName;
	PassengerPlane model;
	
	
	
	//Constructor
	public AirPlane(String airPlaneName, int numberOfSeats, int seatNumber, double flyHours,Date flyingDate, PassengerPlane modelName,
			PassengerPlane model) {
		this.airPlaneName = airPlaneName;
		this.numberOfSeats = numberOfSeats;
		this.seatNumber = seatNumber;
		this.flyHours = flyHours;
		this.flyingDate = flyingDate;
		this.modelName = modelName;
		this.model = model;
	}


	//Methods
	public String getAirPlaneName() {
		return airPlaneName;
	}


	public void setAirPlaneName(String airPlaneName) {
		this.airPlaneName = airPlaneName;
	}


	public int getSeatNumber() {
		return seatNumber;
	}


	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}


	public double getFlyHours() {
		return flyHours;
	}


	public void setFlyHours(double flyHours) {
		this.flyHours = flyHours;
	}


	public Date getFlyingDate() {
		return flyingDate;
	}


	public void setFlyingDate(Date flyingDate) {
		this.flyingDate = flyingDate;
	}


	public int getNumberOfSeats() {
		return numberOfSeats;
	}


	public PassengerPlane getModelName() {
		return modelName;
	}


	public PassengerPlane getModel() {
		return model;
	}
	
	
	
	
	
	
	

}
