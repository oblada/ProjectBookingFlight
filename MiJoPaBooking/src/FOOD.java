
public enum FOOD {
	NOTHING ("No meal"), 
	VEGETARIAN ("Vegetarian" ), 
	FISH_ALLERGY ("No Fishy stuff"), 
	LACTOS_INTOLERANT ("No milk products"), 
	NOPORK ("Halal food"), 
	NOCOW("Indian cuisine"),
	POSH(" Campaign and Caviar");
	
	private String verboseFood;
	
	FOOD(String verboseFood){
		this.verboseFood = verboseFood;
	}

	public String getFood() {
		return verboseFood;
	}

}
