package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		int numItems = scan.nextInt();
		
		String[] itemNames = new String[numItems];
		double[] itemPrices = new double[numItems];
		
		// Get item names and prices
		for (int i=0; i<numItems; i++) {
			itemNames[i] = scan.next();
			itemPrices[i] = scan.nextDouble();
		}
		
		int numCustomers = scan.nextInt();
		
		String[] firstNames = new String[numCustomers];
        String[] lastNames = new String[numCustomers];
        int[] numCustomerItems = new int[numCustomers];
		int[][] custItemQuantity = new int[numCustomers][];
		String[][] custItemNames = new String[numCustomers][];
		double[] custTotals = new double[numCustomers];
		
		// get customer and order details
		for (int i=0; i<numCustomers; i++ ) {
			firstNames[i] = scan.next();
			lastNames[i] = scan.next();
			numCustomerItems[i] = scan.nextInt();
			custItemQuantity[i] = new int[numCustomerItems[i]];
			custItemNames[i] = new String[numCustomerItems[i]];
			
			for (int j=0; j<numCustomerItems[i]; j++) {
				custItemQuantity[i][j] = scan.nextInt();
				custItemNames[i][j] = scan.next();
			}
			custTotals[i] = calculateTotal(itemNames, itemPrices, custItemQuantity[i], custItemNames[i]);
		}

		scan.close();
		
		int indexBiggest = getBiggestIndex(custTotals);
		int indexSmallest = getSmallestIndex(custTotals);
		double average = getAverage(custTotals);
		
		// output required information
		System.out.println("Biggest: " + firstNames[indexBiggest] + " " + lastNames[indexBiggest] + " ("
				+ String.format("%.2f", custTotals[indexBiggest]) + ")");
		System.out.println("Smallest: " + firstNames[indexSmallest] + " " + lastNames[indexSmallest] + " ("
				+ String.format("%.2f", custTotals[indexSmallest]) + ")");
		System.out.println("Average: " + String.format("%.2f", average));
	}
	
	// accepts store items and prices and a customer's purchased items and quantity
	// returns the total order price
	static double calculateTotal(String[] storeItems, double[] itemPrices, int[] itemQuantity, String[] itemNames) {
		double total = 0.0;
		for (int i=0; i<itemQuantity.length; i++) {
			for (int j=0; j<storeItems.length; j++) {
				if(itemNames[i].equals(storeItems[j])) {
					total += itemQuantity[i] * itemPrices[j];
				}
			}
		}
		return total;
	}
	
	// accepts an array of doubles
	// returns the index of the largest value
	static int getBiggestIndex(double[] custTotals) {
		int index = 0;
		double biggest = custTotals[0];
		for (int i=1; i<custTotals.length; i++) {
			if (biggest < custTotals[i]) {
				biggest = custTotals[i];
				index = i;
			}
		}
		return index;
	}
	
	// accepts an array of doubles
	// returns the index of the smallest value
	static int getSmallestIndex(double[] custTotals) {
		int index = 0;
		double smallest = custTotals[0];
		for (int i=1; i<custTotals.length; i++) {
			if (smallest > custTotals[i]) {
				smallest = custTotals[i];
				index = i;
			}
		}
		return index;
	}
	
	// accepts an array of all customer order totals
	// returns an average of values
	static double getAverage(double[] custTotals) {
		double total = 0.0;
		for (int i=0; i<custTotals.length; i++) {
			total += custTotals[i];
		}
		return total / custTotals.length;
	}
}
