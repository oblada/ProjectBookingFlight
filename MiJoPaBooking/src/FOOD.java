


public enum FOOD {
	NOTHING ("No meal", 0), 
	VEGETARIAN ("Vegetarian", 120 ), 
	FISH_ALLERGY ("No Fishy stuff", 120), 
	LACTOS_INTOLERANT ("No milk products", 120), 
	NOPORK ("Halal food", 120), 
	NOCOW("Indian cuisine", 120),
	POSH(" Campaign and Caviar", 500);
	
	private String verboseFood;
	private int cost;
	
	FOOD(String verboseFood, int cost){
		this.verboseFood = verboseFood;
		this.cost = cost;
	}

	public String getFood() {
		return verboseFood;
	}
	
	public int getCost() {
		return cost;
	}

}
