package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		int numCustomers = scan.nextInt();
		
        String[] firstNames = new String[numCustomers];
        String[] lastNames = new String[numCustomers];
        int[] numItems = new int[numCustomers];
        double[] totalPrice = new double[numCustomers];
		
        for (int i=0; i<numCustomers; i++) {
		    firstNames[i] = scan.next();
		    lastNames[i] = scan.next();
		    numItems[i] = scan.nextInt();
		    
		    for (int j=0; j<numItems[i]; j++) {
		        int itemQuantity = scan.nextInt();
		        String itemName = scan.next();
		        double itemPrice = scan.nextDouble();
		        totalPrice[i] += itemQuantity * itemPrice;
		    }
		    System.out.println(firstNames[i].substring(0, 1) + ". " + lastNames[i] + ": "
		            + String.format("%.2f", totalPrice[i]));
		}
	}
}