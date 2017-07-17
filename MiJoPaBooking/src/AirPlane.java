import java.util.ArrayList;
import java.util.Date;

public abstract class AirPlane {
	
	/** Cache the name of the plane for AirPlane */
	protected String airPlaneName;
	
	/** Captures the number of seats for the first class  */
	protected int numberOfSeatsFirstClass;
	
	/** Captures the number of seats for the economy class  */
	protected int numberOfSeatsBusinessClass;

	
	/**
	 * Initialize the objects to set the value to enum types.
	 * @param airPlaneName
	 * @param numberOfSeatsFirstClass
	 * @param numberOfSeatsBusinessClass
	 */
	public AirPlane(String airPlaneName, int numberOfSeatsFirstClass, int numberOfSeatsBusinessClass) {
		this.airPlaneName = airPlaneName;
		this.numberOfSeatsFirstClass = numberOfSeatsFirstClass;
		this.numberOfSeatsBusinessClass = numberOfSeatsBusinessClass;
	
		
	}


	//Methods
	public String getAirPlaneName() {
		return airPlaneName;
	}


	public void setAirPlaneName(String airPlaneName) {
		this.airPlaneName = airPlaneName;
	}


	public int getnumberOfSeatsFirstClass() {
		return numberOfSeatsFirstClass;
	}


	public void setnumberOfSeatsFirstClass(int numberOfSeatsFirstClass) {
		this.numberOfSeatsFirstClass = numberOfSeatsFirstClass;
	}
	
	public int getnumberOfSeatsBusinessClass() {
		return numberOfSeatsBusinessClass;
	}


	public void setnumberOfSeatsBusinessClass(int numberOfSeatsBusinessClass) {
		this.numberOfSeatsFirstClass = numberOfSeatsBusinessClass;
	}
	

	
	
//	public ArrayList <Ticket> mySeatFirstClass = new ArrayList <Ticket>();
//	public ArrayList <Ticket> mySeatBusinessClass = new ArrayList<Ticket>();
	
	
	
	

}
