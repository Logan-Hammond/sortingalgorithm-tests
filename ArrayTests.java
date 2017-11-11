import java.util.*;
public class ArrayTests {
	
	public void loganSort(int[] array) {
		
		int upperBound = array.length;
		int lowerBound = 0;
		int lowestNum;
		int highestNum;
		int boundedSum = 0;
		int numPasses = 0;
		int MAX_PASSES = array.length / 2;
		
		while(numPasses != MAX_PASSES) {
			lowestNum = array[upperBound];
			highestNum = array[lowerBound];
			
			for(int i = lowerBound; i < upperBound; i++) {
				if(array[i] < lowestNum) {
					lowestNum = array[i];
				}else if(array[i] > highestNum) {
					highestNum = array[i];
				}
				
				
			}
			
			lowerBound++;
			upperBound--;
		}
	}
}