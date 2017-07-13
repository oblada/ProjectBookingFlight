import java.util.Date;

public class PassengerPlane extends AirPlane {
	
	private String modelName;
	private String model;
	
	
	public PassengerPlane(String airPlaneName, int numberOfSeatsFirstClass, int numberOfSeatsBusinessClass, String modelName, String model) {
		super(airPlaneName, numberOfSeatsFirstClass, numberOfSeatsBusinessClass);
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
