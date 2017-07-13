import java.util.ArrayList;
import java.util.Date;

public abstract class AirPlane {
	
	protected String airPlaneName;
	protected int numberOfSeatsFirstClass;
	protected int numberOfSeatsBusinessClass;

	protected double flyHours;
	protected Date flyingDate;	
	
	
	
	
	
	//Constructor
	public AirPlane(String airPlaneName, int numberOfSeatsFirstClass, int numberOfSeatsBusinessClass, double flyHours, Date flyingDate) {
		this.airPlaneName = airPlaneName;
		this.numberOfSeatsFirstClass = numberOfSeatsFirstClass;
		this.numberOfSeatsBusinessClass = numberOfSeatsBusinessClass;
		this.flyHours = flyHours;
		this.flyingDate = flyingDate;
		
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


	
	
	public ArrayList <Ticket> mySeatFirstClass = new ArrayList <Ticket>();
	public ArrayList <Ticket> mySeatBusinessClass = new ArrayList<Ticket>();
	
	
	
	

}
