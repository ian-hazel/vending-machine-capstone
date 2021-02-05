package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Inventory {
	private Map<String, Stack<Item>> contents = new HashMap<>();
	private File file = new File("vendingmachine.csv"); //need to add a path that will be correct on all devices
	
	public Inventory() throws FileNotFoundException {
		
		Scanner fileReader = new Scanner(file);
		
		while(fileReader.hasNextLine()) {
			String fileLine = fileReader.nextLine();
			String[] fileLineArray = fileLine.split("\\|");
			
			String code = fileLineArray[0];
			String name = fileLineArray[1];
			BigDecimal price = new BigDecimal(fileLineArray[2]);
			String type = fileLineArray[3];
			
			if (contents.containsKey(code) == false) {
				Stack<Item> stack = new Stack<>();
				contents.put(code, stack);
			}
			
			Item newItem;
			
			if (type.equals("Chip")) {newItem = new Chip(name, price);}
			else if (type.equals("Candy")) {newItem = new Candy(name, price);}
			else if (type.equals("Gum")) {newItem = new Gum(name, price);}
			else if (type.equals("Drink")) {newItem = new Drink(name, price);}
			else newItem = null;
		
			
			
			if (newItem != null) {contents.get(code).push(newItem);}
				
		}
		
	}

	public Map<String, Stack<Item>> getContents() {
		return contents;
	}
	
	public Item popItem(String code) {
		try {
			Item returnItem = contents.get(code).pop();
			return returnItem;
		} catch (EmptyStackException e) {
			return null;
		}
	}
	
	public void printContents() {
		for (String key : contents.keySet()) {
			
			if (contents.get(key).isEmpty() == false) {
			
			String printLine = "";
			printLine += key + " | " + contents.get(key).peek().getName() + " | " + contents.get(key).peek().getPrice(); // print key | .getName | .getPrice
			System.out.println(printLine);
			
			}
		}

	}
	
}

