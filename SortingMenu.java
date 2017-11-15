/**
 * @author Logan Hammond; hamm32637@email.ccbcmd.edu
 * CSIT 211, Braman
 * November 11, 2017
 * Description: Implementation of various different sorting algorithms. Methods for algorithms that require more than one function 
 * are under "Utility Methods". A function to create and print an array is provided as well. Unless otherwise noted parameter n 
 * passed to each function under "Sorting Methods" is an integer representing the size of an array to be created for that method. 
 * 
 * For functions that utilize createArray(n) adding a call to printArray() before and after sorting is the safest way
 * to test for proper sorting.
 */

import java.util.*;
public class SortingMenu {
	private Random rng = new Random();
	
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
	
	/**
	 *  Insertion Sort: Builds a partial sorted array from L to R and 
	 *  inserts elements as they should appear in sorted list.
	 * Time Complexity: O(n^2)
	 * Source: http://www.geeksforgeeks.org/insertion-sort/
	 */
	public void insertionSort(int n) {
		int[] array = createArray(n);
		
		for(int i = 1; i < array.length; i++) {
			int key = array[i];
			int j = i - 1;
			
			while(j >= 0 && array[j] > key) {
				array[j+1] = array[j];
				j = j - 1;
			}
			array[j+1] = key;
		}
	}
	
	/**
	 * Bubble Sort: Swaps neighbor elements in array from L to R
	 * until the array is properly sorted.
	 * Time Complexity: O(n^2)
	 * Source: http://www.geeksforgeeks.org/bubble-sort/
	 */
	public void bubbleSort(int n) {
		int[] array = createArray(n);
		
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < n - i - 1; j++) {
				if(array[j] > array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}
	
	/**
	 * Quick Sort: Recursive, divide-and-conquer algorithm using pivots to
	 * check and swap elements.
	 * @param array Array to be sorted.
	 * @param low Lower bound of array to sort.
	 * @param high Upper bound of array to sort.
	 * Time Complexity: O(n^2)
	 * Source: http://www.geeksforgeeks.org/quick-sort/
	 */
	public void quickSort(int[] array, int low, int high) {
		if(low < high) {
			int pi = partition(array, low, high);
			quickSort(array, low, pi-1);
			quickSort(array, pi+1, high);
		}
	}
	
	/**
	 * Shell Sort: Variation of Insertion sort. Compares elements in "gap"
	 * (bounded area) rather than just the elements adjacent cells. 
	 * Time Complexity: O(n^2)
	 * Source: http://www.geeksforgeeks.org/shellsort/
	 */
	public void shellSort(int n) {
		int[] array = createArray(n);
		
		for(int gap = array.length / 2; gap > 0; gap /= 2) {
			for(int i = gap; i < array.length; i++) {
				int temp = array[i];
				int j;
				for(j = i; j >= gap && array[j - gap] > temp; j -= gap) {
					array[j] = array[j - gap];
				}
				array[j] = temp;
			}
		}
	}
	
	/**
	 * Merge Sort: Recursive, divide-and-conquer algorithm that splits array
	 * into chunks of <= 2, sorts the chunks, and then, merges the sub-lists together.
	 * @param array Array to be sorted
	 * @param l Lower bound of array to be sorted
	 * @param r Upper bound of array to be sorted
	 * Time Complexity: O(n * log(n))
	 * Source: http://www.geeksforgeeks.org/merge-sort/
	 */
	public void mergeSort(int[] array, int l, int r) {
		if (l < r){
			int m = l+(r-l)/2;

			mergeSort(array, l, m);
			mergeSort(array, m+1, r);
			merge(array, l, m, r);
		}
	}
	
	/**
	 * Gnome Sort: 
	 * Time Complexity: O(n^2)
	 * Source: http://www.geeksforgeeks.org/gnome-sort-a-stupid-one/
	 */
	public void gnomeSort(int n) {
		int[] array = createArray(n);
		
		int index = 0;
		while(index < array.length) {
			if(index == 0 || array[index] > array[index-1]) {
				index++;
			}else {
				int temp = 0;
				temp = array[index];
				array[index] = array[index-1];
				array[index-1] = temp;
				index--;
			}
		}
	}
	
	/**
	 * Cocktail Sort: Variation of Bubble sort that iterates through array 
	 * in both directions.
	 * Time Complexity: O(n^2)
	 * Source: http://www.geeksforgeeks.org/cocktail-sort/
	 */
	public void cocktailSort(int n) {
		int[] array = createArray(n);
		
		boolean swapped = true;
		int start = 0;
		int end = array.length;
		
		while(swapped == true) {
			swapped = false;
			for(int i = start; i < end-1; ++i) {
				if(array[i] > array[i+1]) {
					int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    swapped = true;
				}
			}
			
			if(swapped == false) {
				break;
			}
			swapped = false;
			end--;
			
			for(int i = end - 1; i >= start; i--) {
				if(array[i] > array[i+1]) {
					int temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
					swapped = true;
				}
			}
			start++;
		}
	}
	
	/**
	 * Radix Sort:
	 * Time Complexity:
	 * Source: http://www.geeksforgeeks.org/radix-sort/
	 */
	public void radixSort(int n) {
		int[] array = createArray(n);
		int m = getMax(array);
		for(int exp = 1; m/exp > 0; exp *=10) {
			countSort(array, array.length, exp);
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
	 * Prints out passed array of integers.
	 * @param array Array to be printed 
	 */
	public void printArray(int[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.print("\n" +i +": " +array[i]);
		}
		System.out.println();
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
	 * Pivot function for Quick Sort.
	 * @param array Array to be partitioned.
	 * @param low Lower bound of array.
	 * @param high Upper bound of array.
	 * @return i+1 
	 * Source: http://www.geeksforgeeks.org/quick-sort/
	 */
	public int partition(int[] array, int low, int high) {
		int pivot = array[high];
		int i = low - 1;
		for(int j = low; j < high; j++) {
			if(array[j] <= pivot) {
				i++;
				int temp  = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		int temp = array[i+1];
		array[i+1] = array[high];
		array[high] = temp;
		
		return i+1;
	}
	
	/**
	 * Merges two sub-lists of array[].
	 * Source: http://www.geeksforgeeks.org/merge-sort/
	 */
	public void merge(int[] array, int l, int m, int r) {
		int i, j, k;
	    int n1 = m - l + 1;
	    int n2 =  r - m;
	 
	    /* create temp arrays */
	    int[] L = new int[n1];
	    int[] R = new int[n2];
	 
	    /* Copy data to temp arrays L[] and R[] */
	    for (i = 0; i < n1; i++)
	        L[i] = array[l + i];
	    for (j = 0; j < n2; j++)
	        R[j] = array[m + 1+ j];
	 
	    /* Merge the temp arrays back into arr[l..r]*/
	    i = 0; // Initial index of first subarray
	    j = 0; // Initial index of second subarray
	    k = l; // Initial index of merged subarray
	    while (i < n1 && j < n2)
	    {
	        if (L[i] <= R[j])
	        {
	            array[k] = L[i];
	            i++;
	        }
	        else
	        {
	            array[k] = R[j];
	            j++;
	        }
	        k++;
	    }
	 
	    /* Copy the remaining elements of L[], if there
	       are any */
	    while (i < n1)
	    {
	        array[k] = L[i];
	        i++;
	        k++;
	    }
	 
	    /* Copy the remaining elements of R[], if there
	       are any */
	    while (j < n2)
	    {
	        array[k] = R[j];
	        j++;
	        k++;
	    }
	}
	
	/**
	 * Function for Radix sort. Finds and returns largest element in passed array.
	 * @return max Value of largest element in array
	 */
	public int getMax(int[] array) {
		int max = array[0];
		for(int i = 0; i < array.length; i++) {
			if(array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}
	
	/**
	 * Function for Radix Sort.
	 * Source: http://www.geeksforgeeks.org/radix-sort/
	 */
	public void countSort(int[] array, int n, int exp) {
		int[] output = new int[n];
		int i;
		int count[] = new int[10];
		Arrays.fill(count, 0);
		
		for(i = 0; i < n; i++) {
			count[(array[i] / exp) % 10]++;
		}
		for(i = 1; i < 10; i++) {
			count[i] += count[i-1];
		}
		for(i = n-1; i >= 0; i--) {
			output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
		}
		for(i = 0; i < n; i++) {
			array[i] = output[i];
		}
	}
}
