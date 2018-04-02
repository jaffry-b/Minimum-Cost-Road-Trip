package Input;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

import ADTs.Menu;
public class IOStreamMenu {
	private static int count1;
	private static int i;
	private static int j;
	private static int k;
	private static int count2;
	private static int count3;
	private static String currentLine;
	private static String[] fileContents;
	
	public static String[][] ParseMenu() throws FileNotFoundException {
		Scanner in  = new Scanner(new File("menu.csv"));
		in.nextLine();
		
		while(in.hasNextLine()) {
			currentLine = in.nextLine();
			fileContents = currentLine.split(",");	
			if(fileContents[0].substring(0, 1).equals("M")) 
				count1++;
			else if(fileContents[0].substring(0,1).equals("B")) 
				count2++;
			else if(fileContents[0].substring(0,1).equals("W")) 
				count3++;
			
		}
		
		in.close();
		
		Scanner in2  = new Scanner(new File("menu.csv"));
		in2.nextLine();
		Menu[] McDonald = new Menu[count1];
		Menu[] BurgerKing = new Menu[count2];
		Menu[] Wendys = new Menu[count3];
		
		while(in2.hasNextLine()) {
			currentLine = in2.nextLine();
			fileContents = currentLine.split(",");	
			
			if(fileContents[0].substring(0, 1).equals("M")) {
				McDonald[i] = new Menu(fileContents[0],fileContents[1],Double.parseDouble(fileContents[2].replace("$", "")));
				i++;
			}
			else if(fileContents[0].substring(0,1).equals("B")) {
				BurgerKing[j] = new Menu(fileContents[0], fileContents[1], Double.parseDouble(fileContents[2].replace("$", "")));
				j++;
			}
			else if(fileContents[0].substring(0,1).equals("W")) {
				Wendys[k] = new Menu(fileContents[0], fileContents[1], Double.parseDouble(fileContents[2].replace("$", "")));
				k++;
			}
		
		}
		

		in2.close();
		
		String ordername[] =new String[Wendys.length+McDonald.length+BurgerKing.length];
		double costorder[] = new double[Wendys.length+McDonald.length+BurgerKing.length];
		for (int i = 0; i < BurgerKing.length; i++) {
			costorder[i] = BurgerKing[i].getPrice();
			ordername[i]= BurgerKing[i].getRestaurant() + " " + BurgerKing[i].getMeal() ;
			
		}
		for (int i = BurgerKing.length; i < BurgerKing.length+McDonald.length; i++) {
			costorder[i] = McDonald[i-BurgerKing.length].getPrice();
			ordername[i]= McDonald[i-BurgerKing.length].getRestaurant() + " " + McDonald[i-BurgerKing.length].getMeal();
		}
		
		for (int i = BurgerKing.length+McDonald.length; i < BurgerKing.length+McDonald.length+Wendys.length; i++) {
			costorder[i] = Wendys[i-BurgerKing.length-McDonald.length].getPrice();
			ordername[i]= Wendys[i-BurgerKing.length-McDonald.length].getRestaurant() + " " + Wendys[i-BurgerKing.length-McDonald.length].getMeal();
		}
		
		
		
		for(int i = 0; i < ordername.length; ++i) {
	            double key = costorder[i];
	            String key2 = ordername[i];
	            int j = i-1;
	            while (j>=0 && costorder[j] > key)
	            {
	                costorder[j+1] = costorder[j];
	                ordername[j+1] = ordername[j];
	                
	                j = j-1;
	            }
	            costorder[j+1] = key;
	            ordername[j+1] = key2;
	        }
		
		
		
		String finalArray[][] = new String[2][ordername.length];
		for(int i = 0 ; i < ordername.length; i++) {
			finalArray[0][i] = ordername[i];
			finalArray[1][i] = Double.toString(costorder[i]);
		}
	 
		return finalArray;
		
	}
	
	
	
	
}
