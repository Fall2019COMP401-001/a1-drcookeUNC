package a1;

import java.util.Scanner;

public class A1Jedi {

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
		
		int custPurchasedCount[] = new int[numItems];
		int itemPurchasedCount[] = new int[numItems];
		
		for (int i=0; i<numCustomers; i++ ) {
			firstNames[i] = scan.next();
			lastNames[i] = scan.next();
			numCustomerItems[i] = scan.nextInt();
			custItemQuantity[i] = new int[numCustomerItems[i]];
			custItemNames[i] = new String[numCustomerItems[i]];
			
			boolean[] alreadyPurchased = new boolean[numItems];
			
			for (int j=0; j<numCustomerItems[i]; j++) {
				custItemQuantity[i][j] = scan.nextInt();
				custItemNames[i][j] = scan.next();
				
				int index = getItemIndex(itemNames, custItemNames[i][j]);
				if (!alreadyPurchased[index]) {
					alreadyPurchased[index] = true;
					custPurchasedCount[index] += 1;
				}
				itemPurchasedCount[index] += custItemQuantity[i][j];
			}
		}
				
		for (int i=0; i<itemNames.length; i++) {
			if (custPurchasedCount[i] == 0) {
				System.out.println("No customers bought " + itemNames[i]);
			} else {
				System.out.println(custPurchasedCount[i] + " customers bought "
						+ itemPurchasedCount[i] + " " + itemNames[i]);
			}
		}
		
	}
	
	static int getItemIndex(String[] itemNames, String custItemName) {
		int index = -1;
		for (int i=0; i<itemNames.length; i++) {
			if (itemNames[i].equals(custItemName)) {
				return i;
			}
		}
		return index;
	}
}
