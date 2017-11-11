/**
 * @author Logan Hammond; hamm32637@email.ccbcmd.edu
 * CSIT 211, Braman
 * November 11, 2017
 * Description: Driver for sorting menu class. 
 */

import java.util.Scanner;
public class SortingMenuDriver {
	private static Scanner in = new Scanner(System.in);
	private static long startTime, endTime;

	public static void main(String[] args) {
		SortingMenu menu = new SortingMenu();
		boolean running = true;
		
		while(running) {
			System.out.print("Please choose an option...");
			System.out.print("\n1 : Bogo Sort");
			System.out.print("\n2 : Selection Sort");
			System.out.print("\n3 : Insertion Sort");
			System.out.print("\n4 : Bubble Sort");
			System.out.print("\n5 : Quick Sort");
			System.out.print("\n6 : Shell Sort");
			System.out.print("\n7 : Merge Sort");
			System.out.print("\n8 : Gnome Sort");
			System.out.print("\n9 : Cocktail Sort");
			System.out.print("\n10: Radix Sort");
			System.out.print("\n11: Custom Sort");
			System.out.print("\n-1: Exit");
			System.out.print("\n\nEnter Choice: ");
			int userChoice = in.nextInt();
			
			switch(userChoice) {
			case -1:
				running = false;
				break;
			case 1:
				System.out.print("\n\nEnter array size for Bogo Sort: ");
				int n = in.nextInt();

				startTime = System.nanoTime();
				menu.bogoSort(n);
				endTime = System.nanoTime();
				System.out.print("Elapsed Time: " +(endTime - startTime) / 100000 +" milliseconds\n\n");
				break;
			case 2:
				startTime = System.nanoTime();
				menu.selectionSort(20);
				endTime = System.nanoTime();
				System.out.print("Elapsed Time: " +(endTime - startTime) / 100000 +" milliseconds\n\n");
				break;
			case 3:

				break;
			case 4:

				break;
			case 5:

				break;
			case 6:

				break;
			case 7:

				break;
			case 8:

				break;
			case 9:

				break;
			case 10:

				break;

			case 11:

				break;
			case 12:

				break;
			default:

				break;
			}
		}
		System.out.print("\nProgram terminated.");
	}
}