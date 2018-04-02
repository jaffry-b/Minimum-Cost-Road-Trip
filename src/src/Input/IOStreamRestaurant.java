package Input;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import ADTs.Cities;
import ADTs.Stores;
//Creates a IOStream to read the restaurant file.
public class IOStreamRestaurant {
	
	private static IOStreamCities cities = new IOStreamCities();
	private static Cities[] newCity = cities.Parse();
	private static String RestName;
	private static double Lon;
	private static double Lat;
	private static String[] fileContents;
	private static String currentLine;
	private static Scanner rest_name;
	
	
	public static Cities[] ParseRest() throws FileNotFoundException {
			rest_name = new Scanner(new File("wendys.csv"));
			
			while (rest_name.hasNextLine()) {
				currentLine = rest_name.nextLine();
				fileContents = currentLine.split(",");
				
				Lon = Double.parseDouble(fileContents[0]);
				Lat = Double.parseDouble(fileContents[1]);
				RestName = fileContents[2];
				
				for(int i = 0; i < newCity.length; i++) {
					if((Math.abs(newCity[i].getLatitude() - Lat ) <= 0.5) && (Math.abs(newCity[i].getLongitude() - Lon) <= 0.5)) {
						newCity[i].add(new Stores(RestName, Lat, Lon));
						break;
					}
				}
			}
			
			rest_name.close();
			
			rest_name = new Scanner(new File("mcdonalds.csv"));
			
			while (rest_name.hasNextLine()) {
				currentLine = rest_name.nextLine();
				fileContents = currentLine.split(",");
				
				Lon = Double.parseDouble(fileContents[0]);
				Lat = Double.parseDouble(fileContents[1]);
				RestName = fileContents[2];
				
				for(int i = 0; i < newCity.length; i++) {
					if((Math.abs(newCity[i].getLatitude() - Lat ) <= 0.5) && (Math.abs(newCity[i].getLongitude() - Lon) <= 0.5)) {
						newCity[i].add(new Stores(RestName, Lat, Lon));
						break;
					}
				}
			}
			
			rest_name.close();
			
			rest_name = new Scanner(new File("burgerking.csv"));
			
			while (rest_name.hasNextLine()) {
				currentLine = rest_name.nextLine();
				fileContents = currentLine.split(",");
				
				Lon = Double.parseDouble(fileContents[0]);
				Lat = Double.parseDouble(fileContents[1]);
				RestName = fileContents[2];
				
				for(int i = 0; i < newCity.length; i++) {
					if((Math.abs(newCity[i].getLatitude() - Lat ) <= 0.5) && (Math.abs(newCity[i].getLongitude() - Lon) <= 0.5)) {
						newCity[i].add(new Stores(RestName, Lat, Lon));
						break;
					}
				}
			}
			
			rest_name.close();
			
			
			
			return newCity;
	}

}
