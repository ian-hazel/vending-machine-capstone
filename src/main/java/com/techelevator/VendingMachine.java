package com.techelevator;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;

public class VendingMachine {

	private static Inventory inventory;
	private static BigDecimal balance = new BigDecimal("0.00");
	
	//main method goes here
	public static void main(String[] args) throws FileNotFoundException {
		
		
		//Construct new inventory
		inventory = new Inventory();

		
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
		Scanner startMenuChoice = new Scanner(System.in);
		
		System.out.println("> (1) Display Vending Machine Items");
		System.out.println("> (2) Purchase");
		System.out.println("> (3) Exit");
		
		//refactor as while loop w/ while input != 2 || 3
		
		String userChoice = startMenuChoice.nextLine();
		
		if (userChoice.equals("1")) {
			try {
				inventory.printContents();
			} catch (FileNotFoundException e) {
				e.printStackTrace(); //maybe change?? 
			}
			System.out.println();
			startMenu();
			
		}
		else if (userChoice.equals("2")) {
			purchaseMenu();
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
	
	
	public static void purchaseMenu() {
		//balance = new BigDecimal("0.00");
		
		Scanner purchaseMenuChoice = new Scanner(System.in);
		
		System.out.println("> (1) Feed Money");
		System.out.println("> (2) Select Product");
		System.out.println("> (3) Finish Transaction");
		
		String userPurchaseChoice = purchaseMenuChoice.nextLine();
		
		if (userPurchaseChoice.equals("1")) {
			feedMoney();
			//need way back to menu
		}
		else if (userPurchaseChoice.equals("2")) {
			purchaseItem();
			//do something else
		}
		else if (userPurchaseChoice.equals("3")) {
			//do the third thing
		}
		else {
			System.out.println("Invalid input!");
			purchaseMenu();
		}
		
		
	}
	
	public static void feedMoney() {
		Scanner insertMoney = new Scanner(System.in);
		
		System.out.println("Your balance is $" + balance);
		System.out.println();
		
		System.out.println("> (1) Insert $1");
		System.out.println("> (2) Insert $2");
		System.out.println("> (5) Insert $5");
		System.out.println("> (10) Insert $10");
		System.out.println("> (X) Done inserting.");
		
		String dollaDollaBillsYall = insertMoney.nextLine();
		
		if (dollaDollaBillsYall.equals("1") || dollaDollaBillsYall.equals("2") || dollaDollaBillsYall.equals("5") || dollaDollaBillsYall.equals("10")) {
			balance = balance.add(new BigDecimal(dollaDollaBillsYall));
			feedMoney();
		}
		else if (dollaDollaBillsYall.toLowerCase().equals("x")) {
			purchaseMenu();
		}
		else if (dollaDollaBillsYall.equals("20")) {
			System.out.println("This machine doesn't take $20s!!");
			feedMoney();
		}
		else {
			System.out.println("Invalid input!");
			System.out.println("=========================================");
			feedMoney();
		}
		
	}
	
	
	public static void purchaseItem() {
		Scanner itemChoice = new Scanner(System.in);
		
		try {
			inventory.printContents();
		} catch (FileNotFoundException e) {
			e.printStackTrace(); //maybe change per earlier??
		}
		
		System.out.println("What snack strikes your fancy today?");
		System.out.println("====== Or press \"X\" to exit ======");
		
		String userChoice = itemChoice.nextLine();
		
		if (userChoice.toLowerCase().equals("x")) {
			purchaseMenu();
		}
		
		//do we need to make sure the key exists in the map?
		
		//if (balance < inventory.getContents(userChoice)) {
			
	//	}
		Item dispensedItem = inventory.popItem(userChoice);
		
		if (dispensedItem != null) {
			System.out.println(dispensedItem.getName());
			System.out.println(dispensedItem.getPrice());
			
			balance = balance.subtract(dispensedItem.getPrice());
			System.out.println("Your balance is $" + balance);
			
			System.out.println(dispensedItem.getSound());
			
			purchaseMenu();
		}
		else {
			System.out.println("Invalid selection!");
			System.out.println("=========================================");
			purchaseItem();
		}
	}
	
	public static void finishTransaction() {
		//return change
		BigDecimal quarterValue = new BigDecimal("0.25");
		int quarters = 0;
		
		BigDecimal dimeValue = new BigDecimal("0.10");
		int dimes = 0;
		
		BigDecimal nickelValue = new BigDecimal("0.05");
		int nickels = 0;
		
		while(balance.compareTo(quarterValue) >= 0) {
			quarters++;
			balance.subtract(quarterValue);
		}
		
		while(balance.compareTo(dimeValue) >= 0) {
			dimes++;
			balance.subtract(dimeValue);
		}
		
		while(balance.compareTo(nickelValue) >= 0) {
			nickels++;
			balance.subtract(nickelValue);
		}
		
		System.out.println("Change dispensed:");
		System.out.println("Quarters: " + quarters);
		System.out.println("Dimes: " + dimes);
		System.out.println("Nickels: " + nickels);
		
		//zero out balance
		balance.subtract(balance);
		//run thankYou() to end
		thankYou();
	}


	public static void thankYou() {
		System.out.println("Thank you for using VENDO-MATIC 800!");
		System.out.println("===== Please enjoy again soon! =====");
		startMenu();	
	}
}
