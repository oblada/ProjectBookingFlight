


public enum FOOD {
	
	/**
	 * FOOD class is a enum class that contains of food categories, allergies and fixed price
	 */
		
	NOTHING ("No meal", 0), 
	VEGETARIAN ("Vegetarian", 120 ), 
	FISH_ALLERGY ("No Fishy stuff", 120), 
	LACTOS_INTOLERANT ("No milk products", 120), 
	NOPORK ("Halal food", 120), 
	NOCOW("Indian cuisine", 120),
	POSH(" Champaigne and Caviar", 500);
	
	private String verboseFood;
	private int cost;
	
	/**
	 * Initialize the objects to set the value to enum types.
	 * @param verboseFood
	 * @param cost
	 */
	
	FOOD(String verboseFood, int cost){
		this.verboseFood = verboseFood;
		this.cost = cost;
	}

	public String getFood() {
		return verboseFood;
	}
	
	/**
	 * Invokes from TicketMaster class to calculate the price.
	 * @return
	 */
	public int getCost() {
		return cost;
	}

}
