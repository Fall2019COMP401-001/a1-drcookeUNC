package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		int numItems = scan.nextInt();
		
		String[] itemNames = new String[numItems];
		double[] itemPrices = new double[numItems];
		
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
		
		for (int i=0; i<numCustomers; i++ ) {
			// For each customer i
			firstNames[i] = scan.next();
			lastNames[i] = scan.next();
			numCustomerItems[i] = scan.nextInt();
			custItemQuantity[i] = new int[numCustomerItems[i]];
			custItemNames[i] = new String[numCustomerItems[i]];
			
			for (int j=0; j<numCustomerItems[i]; j++) {
				// For each item j they bought
				custItemQuantity[i][j] = scan.nextInt();
				custItemNames[i][j] = scan.next();
			}
			custTotals[i] = calculateTotal(itemNames, itemPrices, custItemQuantity[i], custItemNames[i]);
		}
		
		int indexBiggest = getBiggest(custTotals);
		int indexSmallest = getSmallest(custTotals);
		double average = getAverage(custTotals);
		
		System.out.println("Biggest: " + firstNames[indexBiggest] + " " + lastNames[indexBiggest] + " ("
				+ String.format("%.2f", custTotals[indexBiggest]) + ")");
		System.out.println("Smallest: " + firstNames[indexSmallest] + " " + lastNames[indexSmallest] + " ("
				+ String.format("%.2f", custTotals[indexSmallest]) + ")");
		System.out.println("Average: " + String.format("%.2f", average));
	}
	
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
	
	static int getBiggest(double[] custTotals) {
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
	
	static int getSmallest(double[] custTotals) {
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
	
	static double getAverage(double[] custTotals) {
		double total = 0.0;
		for (int i=0; i<custTotals.length; i++) {
			total += custTotals[i];
		}
		return total / custTotals.length;
	}
}
