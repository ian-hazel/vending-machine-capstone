package com.techelevator;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class VendingMachine {

	
	//main method goes here
	public static void main(String[] args) throws FileNotFoundException {
		
		
		//Construct new inventory
		Inventory inventory = new Inventory();
		
		//invoke greeting/welcome banner
		welcomeBanner();
		
		//startMenu displays first options
		startMenu();

		
		
		
	}
	
	
	
	
	
	
	
	
	public static void welcomeBanner() {
		System.out.println("=========================================");
		System.out.println("=== WELCOME TO THE VENDO-MATIC 800!!! ===");
		System.out.println("=========================================");
		System.out.println();
	}
	/*
	public static Inventory populateMachine() throws FileNotFoundException {
		Inventory inventory = new Inventory();
		return inventory;
	}
	*/
	
	public static void startMenu() {
		Scanner startMenuOptions = new Scanner(System.in);
		
		System.out.println("> (1) Display Vending Machine Items");
		System.out.println("> (2) Purchase");
		System.out.println("> (3) Exit");
		
		String userChoice = startMenuOptions.nextLine();
		
		if (userChoice.equals("1")) {
			// include code to display items + quantity
			//new method goes here
		}
		else if (userChoice.equals("2")) {
			//take user to purchase steps
			//new method advances program
		}
		else if (userChoice.equals("3")) {
			thankYou();
		}
		else {
			System.out.println("Invalid input!");
			startMenu();
		}
	}
	
	public static void thankYou() {
		System.out.println("Thank you for using VENDO-MATIC 800!");
		System.out.println("===== Please enjoy again soon! =====");
		System.exit(0);	
	}
}
