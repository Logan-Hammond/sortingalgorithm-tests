/**
 * @author Logan Hammond; hamm32637@email.ccbcmd.edu
 * CSIT 211, Braman
 * November 11, 2017
 * Description: Driver for sorting menu class. 
 */

import java.util.*;
public class SortingMenu {
	private Random rng = new Random();
	
	public SortingMenu(){
		//Empty?
	}
	
	// Sorting Methods
	/**
	 * Bogo Sort: Sorts by randomly shuffling elements in array. After every
	 * shuffle the array is checked for proper sortedness.
	 * Time complexity: O(n * n!)
	 * Source: http://www.javacodex.com/Sorting/Bogo-Sort
	 */
	public void bogoSort(int n) {
		int[] array = createArray(n);
		
		while (!isSorted(array)) {  
			for (int i = 0; i < array.length; i++){  
				int randomPosition = rng.nextInt(array.length);  
				int temp = array[i];  
				array[i] = array[randomPosition];  
				array[randomPosition] = temp;  
			}  
		}  
	}
	
	/**
	 * Selection Sort: Finds minima in a bounded area based on number 
	 * of previous passes.
	 * Time Complexity: O(n^2)
	 * Source: http://www.geeksforgeeks.org/selection-sort/
	 */
	public void selectionSort(int n) {
		int[] array = createArray(n);
		int l = array.length;
		
		for(int i = 0; i < (l - 1); i++) {
			int minIndex = i;
			for(int j = (i + 1); j < l; j++) {
				if(array[j] < array[minIndex]) {
					minIndex = j;
				}
			}
			int temp = array[minIndex];
			array[minIndex] = array[i];
			array[i] = temp;
		}
	}
	
	// Utility Methods
	/**
	 * Creates an array of size n. Then fills the array with pseudo-random integers from 1-999. 
	 * @param n Number of cells in array
	 * @return Initialized array
	 */
	public int[] createArray(int n) {
		int[] array = new int[n];
		for(int i = 0; i < array.length; i++) {
			array[i] = rng.nextInt(998) + 1;
		}
		return array;
	}
	
	/**
	 * Checks to see if passed array of integers is sorted properly for Bogo Sort.
	 * Works for any array based sorting algorithm as well.
	 * @param array Array to be checked for proper sorting.
	 * @return true if array is properly sorted, false otherwise.
	 */
	private static boolean isSorted(int[] array) {  
		for (int i = 1; i < array.length; i++){
			if (array[i] < array[i - 1]) {
				return false;  
			}
		}
		return true;  
	}
	
	/**
	 * Prints out passed array of integers.
	 * @param array Array to be printed 
	 */
	public void printArray(int[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.print(i +": " +array[i]);
		}
	}
}