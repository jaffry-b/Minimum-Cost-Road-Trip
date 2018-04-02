package ADTs;

import java.util.List;
import java.util.ArrayList;

public class Cities {
	private final String CityName;
	private final double Longitude;
	private final double Latitude;
	private List<Stores> stores = new ArrayList<Stores>();
	
	public Cities() {
		this.CityName = "";
		this.Latitude = 0;
		this.Longitude = 0;
	}
	public void add(Stores a) {
		this.stores.add(a);
	}
	
	
	public Cities(String CityName, double Latitude, double Longitude){
		this.CityName = CityName;
		this.Latitude = Latitude;
		this.Longitude = Longitude;
		
	}
	
	public List<Stores> getStore(){
		return stores;
	}
	
	public double getLongitude() {
		return this.Longitude;
	}
	public double getLatitude() {
		return this.Latitude;
	}
	
	public String getCityName() {
		return this.CityName;
	}
	
	public String toString() {
		return "CityName is " + getCityName() + " Restaurant name is  " + ", Longitude is " +
				getLongitude() + " and Latitude is " + getLatitude();
	}
	
}
