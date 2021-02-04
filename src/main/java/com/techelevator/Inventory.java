package com.techelevator;

import java.io.File;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Inventory {
	private Map<String, Stack<Item>> contents = new HashMap<>();
	private File file = new File(path); //need to add a path that will be correct on all devices
	
	public Inventory() {
		
		Scanner fileReader = new Scanner(file);
		
		while(fileReader.hasNextLine()) {
			String fileLine = fileReader.nextLine();
			String[] fileLineArray = fileLine.split("|");
			
			String code = fileLineArray[0];
			String name = fileLineArray[1];
			BigDecimal price = new BigDecimal(Double.parseDouble(fileLineArray[2]));
			String type = fileLineArray[3];
			
			if (contents.containsKey(code) == false) {
				Stack stack = new Stack();
				contents.put(code, stack);
			}
			
			if (type.equals("Chip")) {Chip newItem = new Chip(name, price);}
			else if (type.equals("Candy")) {Candy newItem = new Candy(name, price);}
			else if (type.equals("Gum")) {Gum newItem = new Gum(name, price);}
			else if (type.equals("Drink")) {Drink newItem = new Drink(name, price);}
			
			
			contents.get(code).push(newItem);
				
		}
		
	}

	public Map<String, Stack> getContents() {
		return contents;
	}
	
	public Item popItem(String code) {
		contents.get(code).pop();
	}
	
	public void printContents() {
		for (String key : contents.keySet()) {
			
			if (contents.get(key).isEmpty() == false) {
			
			String printLine = "";
			printline += key " | " + contents.get(key).peek().getName() + " | " + contents.get(key).peek().getPrice() + " | " + contents.get(key).peek().getName() // print key | .getName | .getPrice | get Stack Size
			System.out.println(printLine);
			
			}
		}

	}
	
}

