
public enum TICKETTYPE {
	
	FIRST ("First Class Ticket", 20000),
	ECONOMY ("Economy Class Ticket", 5000);
	
	
	private String typeOfTicketClass;
	private int costOfTicket;

	public String getTypeOfTicketClass() {
		return typeOfTicketClass;
	}

	public int getCostOfTicket() {
		return costOfTicket;
	}

	TICKETTYPE(String typeOfTicketClass, int costOfTicket){
		this.typeOfTicketClass=typeOfTicketClass;
		this.costOfTicket=costOfTicket;
	}

}
