package ADTs;

public class Menu {
	private final String Restaurant;
	private final String Meal;
	private final double Price;
	
	public Menu() {
		this.Restaurant = "";
		this.Meal = "";
		this.Price = 0;
	}
	
	public Menu(String Restaurant,  String Meal, double Price) {
		this.Restaurant = Restaurant;
		this.Meal = Meal;
		this.Price = Price;
	}
	
	
	public String getRestaurant() {
		return this.Restaurant;
	}
	
	public String getMeal() {
		return this.Meal;
	}
	
	public double getPrice() {
		return this.Price;
	}
	
	public String toString() {
		return "Restaurant name is, " + getRestaurant() + ", meal is " + 
				getMeal() + " and price of meal is $" + getPrice() + ".";
	}
	
	
}	
