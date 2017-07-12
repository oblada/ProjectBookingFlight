import java.util.Date;

public class PassengerPlane extends AirPlane {
	
	private String modelName;
	private String model;
	
	
	public PassengerPlane(String airPlaneName, int numberOfSeatsFirstClass, int numberOfSeatsBusinessClass, double flyHours, Date flyingDate, String modelName, String model) {
		super(airPlaneName, numberOfSeatsFirstClass, numberOfSeatsBusinessClass, flyHours, flyingDate);
		this.modelName = modelName;
		this.model = model;
		
	}


	public String getModelName() {
		return modelName;
	}


	public String getModel() {
		return model;
	}


	
	
	

}
