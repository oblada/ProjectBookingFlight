
enum Airport {
	REYKJAVIK("Reykjavik"),
	DUBLIN("Dublin"), 
	EDINBURGH("Edinburgh"), 
	LONDON("London"), 
	OSLO("Oslo"), 
	COPENHAGEN("Copenhagen"), 
	STOCKHOLM("Stockholm"), 
	HELSINKI("Helsinki");
	
	private String city;
	
	Airport(String c){ city = c; }
	
	String getCity() { return city; }

}
