/**
 * @author Logan Hammond; hamm32637@email.ccbcmd.edu
 * CSIT 211, Braman
 * November 11, 2017
 * Description: Driver for sorting menu class. If an algorithm needs to be passed
 * an array for proper functionality (recursive algorithms) they are declared and 
 * initialized in this class.
 */

import java.util.Scanner;
public class SortingMenuDriver {
	private static Scanner in = new Scanner(System.in);
	private static long startTime, endTime;
	
	public static void main(String[] args) {
		SortingMenu menu = new SortingMenu();
		boolean running = true;
		
		while(running) {
			System.out.print("\nPlease choose an option...");
			System.out.print("\n 1: Bogo Sort");
			System.out.print("\n 2: Selection Sort");
			System.out.print("\n 3: Insertion Sort");
			System.out.print("\n 4: Bubble Sort");
			System.out.print("\n 5: Quick Sort");
			System.out.print("\n 6: Shell Sort");
			System.out.print("\n 7: Merge Sort");
			System.out.print("\n 8: Gnome Sort");
			System.out.print("\n 9: Cocktail Sort");
			System.out.print("\n10: Radix Sort");
			System.out.print("\n11: Custom Sort");
			System.out.print("\n-1: Exit");
			System.out.print("\n\nEnter Choice: ");
			int userChoice = in.nextInt();
			
			switch(userChoice) {
			case -1:
				running = false;
				break;
			case 1: //Bogo Sort
				System.out.print("\nEnter array size for Bogo Sort: ");
				int n = in.nextInt();

				startTime = System.nanoTime();
				menu.bogoSort(n);
				endTime = System.nanoTime();
				System.out.print("Bogo Sort ("+n +") -  Elapsed Time: " +(endTime - startTime) / 100000 +" milliseconds\n");
				break;
			case 2: // Selection Sort
				startTime = System.nanoTime();
				menu.selectionSort(20);
				endTime = System.nanoTime();
				System.out.print("Selection Sort (20)  - Elapsed Time: " +(endTime - startTime) / 100000 +" milliseconds\n");
				
				startTime = System.nanoTime();
				menu.selectionSort(100);
				endTime = System.nanoTime();
				System.out.print("Selection Sort (100) - Elapsed Time: " +(endTime - startTime) / 100000 +" milliseconds\n");
				
				startTime = System.nanoTime();
				menu.selectionSort(500);
				endTime = System.nanoTime();
				System.out.print("Selection Sort (500) - Elapsed Time: " +(endTime - startTime) / 100000 +" milliseconds\n");
				
				startTime = System.nanoTime();
				menu.selectionSort(1000);
				endTime = System.nanoTime();
				System.out.print("Selection Sort (1000) - Elapsed Time: " +(endTime - startTime) / 100000 +" milliseconds\n");
				break;
			case 3: //Insertion Sort
				startTime = System.nanoTime();
				menu.insertionSort(20);
				endTime = System.nanoTime();
				System.out.print("Insertion Sort (20)  - Elapsed Time: " +(endTime - startTime) / 100000 +" milliseconds\n");
				
				startTime = System.nanoTime();
				menu.insertionSort(100);
				endTime = System.nanoTime();
				System.out.print("Insertion Sort (100) - Elapsed Time: " +(endTime - startTime) / 100000 +" milliseconds\n");
				
				startTime = System.nanoTime();
				menu.insertionSort(500);
				endTime = System.nanoTime();
				System.out.print("Insertion Sort (500) - Elapsed Time: " +(endTime - startTime) / 100000 +" milliseconds\n");
				
				startTime = System.nanoTime();
				menu.insertionSort(1000);
				endTime = System.nanoTime();
				System.out.print("Insertion Sort (1000) - Elapsed Time: " +(endTime - startTime) / 100000 +" milliseconds\n");
				break;
			case 4: // Bubble Sort
				startTime = System.nanoTime();
				menu.bubbleSort(20);
				endTime = System.nanoTime();
				System.out.print("Bubble Sort (20)  - Elapsed Time: " +(endTime - startTime) / 100000 +" milliseconds\n");
				
				startTime = System.nanoTime();
				menu.bubbleSort(100);
				endTime = System.nanoTime();
				System.out.print("Bubble Sort (100)  - Elapsed Time: " +(endTime - startTime) / 100000 +" milliseconds\n");
				
				startTime = System.nanoTime();
				menu.bubbleSort(500);
				endTime = System.nanoTime();
				System.out.print("Bubble Sort (500)  - Elapsed Time: " +(endTime - startTime) / 100000 +" milliseconds\n");
				
				startTime = System.nanoTime();
				menu.bubbleSort(1000);
				endTime = System.nanoTime();
				System.out.print("Bubble Sort (1000)  - Elapsed Time: " +(endTime - startTime) / 100000 +" milliseconds\n");
				break;
			case 5: // Quick Sort
				int[] quickArray20 = menu.createArray(20);
				int[] quickArray100 = menu.createArray(100);
				int[] quickArray500 = menu.createArray(500);
				int[] quickArray1000 = menu.createArray(1000);
				
				startTime = System.nanoTime();
				menu.quickSort(quickArray20, 0, quickArray20.length-1);
				endTime = System.nanoTime();
				System.out.print("Quick Sort (20)  - Elapsed Time: " +(endTime - startTime) / 100000 +" milliseconds\n");
				
				startTime = System.nanoTime();
				menu.quickSort(quickArray100, 0, quickArray100.length-1);
				endTime = System.nanoTime();
				System.out.print("Quick Sort (100)  - Elapsed Time: " +(endTime - startTime) / 100000 +" milliseconds\n");
				
				startTime = System.nanoTime();
				menu.quickSort(quickArray500, 0, quickArray500.length-1);
				endTime = System.nanoTime();
				System.out.print("Quick Sort (500)  - Elapsed Time: " +(endTime - startTime) / 100000 +" milliseconds\n");
				
				startTime = System.nanoTime();
				menu.quickSort(quickArray1000, 0, quickArray1000.length-1);
				endTime = System.nanoTime();
				System.out.print("Quick Sort (1000)  - Elapsed Time: " +(endTime - startTime) / 100000 +" milliseconds\n");
				break;
			case 6: // Shell Sort
				startTime = System.nanoTime();
				menu.shellSort(20);
				endTime = System.nanoTime();
				System.out.print("Shell Sort (20)  - Elapsed Time: " +(endTime - startTime) / 100000 +" milliseconds\n");
				
				startTime = System.nanoTime();
				menu.shellSort(100);
				endTime = System.nanoTime();
				System.out.print("Shell Sort (100)  - Elapsed Time: " +(endTime - startTime) / 100000 +" milliseconds\n");
				
				startTime = System.nanoTime();
				menu.shellSort(500);
				endTime = System.nanoTime();
				System.out.print("Shell Sort (500)  - Elapsed Time: " +(endTime - startTime) / 100000 +" milliseconds\n");
				
				startTime = System.nanoTime();
				menu.shellSort(1000);
				endTime = System.nanoTime();
				System.out.print("Shell Sort (1000)  - Elapsed Time: " +(endTime - startTime) / 100000 +" milliseconds\n");
				break;
			case 7: // Merge Sort
				int[] mergeArray20 = menu.createArray(20);
				int[] mergeArray100 = menu.createArray(100);
				int[] mergeArray500 = menu.createArray(500);
				int[] mergeArray1000 = menu.createArray(1000);
				
				startTime = System.nanoTime();
				menu.mergeSort(mergeArray20, 0, mergeArray20.length-1);
				endTime = System.nanoTime();
				System.out.print("Merge Sort (20)  - Elapsed Time: " +(endTime - startTime) / 100000 +" milliseconds\n");
				
				startTime = System.nanoTime();
				menu.mergeSort(mergeArray100, 0, mergeArray100.length-1);
				endTime = System.nanoTime();
				System.out.print("Merge Sort (100)  - Elapsed Time: " +(endTime - startTime) / 100000 +" milliseconds\n");
				
				startTime = System.nanoTime();
				menu.mergeSort(mergeArray500, 0, mergeArray500.length-1);
				endTime = System.nanoTime();
				System.out.print("Merge Sort (500)  - Elapsed Time: " +(endTime - startTime) / 100000 +" milliseconds\n");
				
				startTime = System.nanoTime();
				menu.mergeSort(mergeArray1000, 0, mergeArray1000.length-1);
				endTime = System.nanoTime();
				System.out.print("Merge Sort (1000)  - Elapsed Time: " +(endTime - startTime) / 100000 +" milliseconds\n");
				break;
			case 8: // Gnome Sort. Seems to work slowly for arrays of size 40 or greater
				startTime = System.nanoTime();
				menu.gnomeSort(20);
				endTime = System.nanoTime();
				System.out.print("Gnome Sort (20)  - Elapsed Time: " +(endTime - startTime) / 100000 +" milliseconds\n");
				
				startTime = System.nanoTime();
				menu.gnomeSort(100);
				endTime = System.nanoTime();
				System.out.print("Gnome Sort (100)  - Elapsed Time: " +(endTime - startTime) / 100000 +" milliseconds\n");
				
				startTime = System.nanoTime();
				menu.gnomeSort(500);
				endTime = System.nanoTime();
				System.out.print("Gnome Sort (500)  - Elapsed Time: " +(endTime - startTime) / 100000 +" milliseconds\n");
				
				startTime = System.nanoTime();
				menu.gnomeSort(1000);
				endTime = System.nanoTime();
				System.out.print("Gnome Sort (1000)  - Elapsed Time: " +(endTime - startTime) / 100000 +" milliseconds\n");
				break;
			case 9: // Cocktail Sort
				startTime = System.nanoTime();
				menu.cocktailSort(20);
				endTime = System.nanoTime();
				System.out.print("Cocktail Sort (20)  - Elapsed Time: " +(endTime - startTime) / 100000 +" milliseconds\n");
				
				startTime = System.nanoTime();
				menu.cocktailSort(100);
				endTime = System.nanoTime();
				System.out.print("Cocktail Sort (100)  - Elapsed Time: " +(endTime - startTime) / 100000 +" milliseconds\n");
				
				startTime = System.nanoTime();
				menu.cocktailSort(500);
				endTime = System.nanoTime();
				System.out.print("Cocktail Sort (500)  - Elapsed Time: " +(endTime - startTime) / 100000 +" milliseconds\n");
				
				startTime = System.nanoTime();
				menu.cocktailSort(1000);
				endTime = System.nanoTime();
				System.out.print("Cocktail Sort (1000)  - Elapsed Time: " +(endTime - startTime) / 100000 +" milliseconds\n");
				break;
			case 10:
				startTime = System.nanoTime();
				menu.radixSort(20);
				endTime = System.nanoTime();
				System.out.print("Radix Sort (20)  - Elapsed Time: " +(endTime - startTime) / 100000 +" milliseconds\n");
				
				startTime = System.nanoTime();
				menu.radixSort(100);
				endTime = System.nanoTime();
				System.out.print("Radix Sort (100)  - Elapsed Time: " +(endTime - startTime) / 100000 +" milliseconds\n");
				
				startTime = System.nanoTime();
				menu.radixSort(500);
				endTime = System.nanoTime();
				System.out.print("Radix Sort (500)  - Elapsed Time: " +(endTime - startTime) / 100000 +" milliseconds\n");
				
				startTime = System.nanoTime();
				menu.radixSort(1000);
				endTime = System.nanoTime();
				System.out.print("Radix Sort (1000)  - Elapsed Time: " +(endTime - startTime) / 100000 +" milliseconds\n");
				break;
			case 11:

				break;
			default:
				
				break;
			}
		}
		System.out.print("\nProgram terminated.");
	}
}
