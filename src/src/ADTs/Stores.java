package ADTs;

import java.util.ArrayList;
import java.util.List;

public class Stores {
	private final String Restaurant;
	private final double Longitude;
	private final double Latitude;
	private List<Menu> menu = new ArrayList<Menu>();
	
	public Stores () {
		this.Restaurant = "";
		this.Latitude = 0;
		this.Longitude = 0;
	}
	
	public Stores(String Restaurant, double Latitude, double Longitude){
		this.Restaurant = Restaurant;
		this.Latitude = Latitude;
		this.Longitude = Longitude;
		
	}
	public List<Menu> getMenu(){
		return menu;
	}
	public double getLongitude() {
		return this.Longitude;
	}
	

	public double getLatitude() {
		return this.Latitude;
	}
	
	public String getRestaurant() {
		return this.Restaurant;
	}
	
	public String toString() {
		return "Restaurant is " + getRestaurant() + ", "
				+ "Longitude is " + getLongitude() + " and Latitude is " + getLatitude();
	}
}
