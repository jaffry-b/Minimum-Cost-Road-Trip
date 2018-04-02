package Input;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import ADTs.Cities;

public class IOStreamCities {
	private static double Lat;
	private static double Lon;
	private static String[] fileContents;
	private static int count;
	private static int numOfCities;
	private static String currentLine;
	
	public static Cities[] Parse() {
		try {
			Scanner in  = new Scanner(new File("USCities.csv"));
			in.nextLine();
			
			while (in.hasNextLine()) {
				count++;
				in.nextLine();
			}
			in.close();
			Cities[] city = new Cities[count];
			Scanner in2 = new Scanner(new File("USCities.csv"));	
			in2.nextLine();
		
			while(in2.hasNextLine()) {
			
					currentLine = in2.nextLine();
					fileContents = currentLine.split(",");
					
					Lat = Double.parseDouble(fileContents[4]);
					Lon = Double.parseDouble(fileContents[5]);
					
					city[numOfCities] = new Cities(fileContents[3],Lat,Lon);
					numOfCities++;
			}
			in2.close();
			return city;
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found.");
		}
		return null;

	}
	
	
}
	
