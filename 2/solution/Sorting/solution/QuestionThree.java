package solution;

import java.util.Arrays;

import sorting.RadixSort;
import sorting.Sort;

public class QuestionThree {

	public static void main(String[] args) {

		sortStrings(4, 1);

		sortStrings(4, 10);
		
		sortStrings(6, 1);
		sortStrings(6, 10);
		
		sortStrings(8, 1);
		sortStrings(8, 10);
		
		sortStrings(10, 1);
		sortStrings(10, 10);
	}

	public static void sortStrings(int lengthOfStrings, int numberOfTimes) {
		
		Long mergeAvgTime = 0L;
		Long heapAvgTime = 0L;
		Long quickAvgTime = 0L;
		Long arrAvgTime = 0L;
		Long radixSortAvgTime = 0L;
		Long mergeworstCaseTime = 0L;
		Long heapworstCaseTime = 0L;
		Long quickworstCaseTime = 0L;
		Long arrworstCaseTime = 0L;
		Long radixworstCaseTime = 0L;
		System.out.println("\nSorted Strings for "+numberOfTimes+ " time/times and length of string is : "+ lengthOfStrings);
		
		for (int i = 0; i < numberOfTimes; i++) {
			String str[] = new String[100000];
			Helper.generateRandomStringArray(str, 100000, lengthOfStrings);
 
			String mergeSortArray[] = str;
			String quicksortArray[] = str;
			String heapSortArray[] = str;
			String radixSortArray[] = str;
			
			Long startTime = System.nanoTime();
			Sort.mergeSort(mergeSortArray);
			Long endTime = System.nanoTime();
			Long timeTaken = endTime-startTime;
			if(mergeworstCaseTime < timeTaken )
				mergeworstCaseTime = timeTaken;
			
			mergeAvgTime += (endTime-startTime);
			/*
			 * System.out.println("Using mergesort in Sort Class");
			 * System.out.println(Arrays.toString(mergeSortArray));
			 */

			startTime = System.nanoTime();
			Sort.quicksort(quicksortArray);
			endTime =System.nanoTime();
			timeTaken = endTime-startTime;
			if(quickworstCaseTime < timeTaken )
				quickworstCaseTime = timeTaken;
			
			quickAvgTime += (endTime-startTime);
			/*
			 * System.out.println("Using quickSort in Sort Class");
			 * System.out.println(Arrays.toString(mergeSortArray));
			 */
			
			
			startTime = System.nanoTime();
			Sort.heapsort(heapSortArray);
			endTime =System.nanoTime();
			timeTaken = endTime-startTime;
			if(heapworstCaseTime < timeTaken )
				heapworstCaseTime = timeTaken;
			
			heapAvgTime += (endTime-startTime);
			/*
			 * System.out.println("Using Heapsort in Sort Class");
			 * System.out.println(Arrays.toString(heapSortArray));
			 */
			
			startTime = System.nanoTime();
			Arrays.sort(str);
			endTime =System.nanoTime();
			timeTaken = endTime-startTime;
			if(arrworstCaseTime < timeTaken )
				arrworstCaseTime = timeTaken;
			arrAvgTime += (endTime-startTime);
			/*System.out.println("Using Dual Pivot Quicksort in Sort Class");
			System.out.println(Arrays.toString(arr));*/
			
			startTime = System.nanoTime();
			RadixSort.radixSortA(radixSortArray, lengthOfStrings);
			endTime =System.nanoTime();
			timeTaken = endTime-startTime;
			if(radixworstCaseTime < timeTaken )
				radixworstCaseTime = timeTaken;
			radixSortAvgTime += (endTime-startTime);
		}
		
		System.out.println("HeapSort \tAvg Time \t\tWorst case time");
		System.out.println("\t\t"+heapAvgTime/numberOfTimes+" ns"+"\t\t"+heapworstCaseTime+" ns");
		
		System.out.println("\nMergeSort \tAvg Time \t\tWorst case time");
		System.out.println("\t\t"+mergeAvgTime/numberOfTimes+" ns"+"\t\t"+mergeworstCaseTime+" ns");
		
		System.out.println("\nQuickSort \tAvg Time \t\tWorst case time");
		System.out.println("\t\t"+quickAvgTime/numberOfTimes+" ns"+"\t\t"+quickworstCaseTime+" ns");
		
		System.out.println("\nDualPivotSort \tAvg Time \t\tWorst case time");
		System.out.println("\t\t"+arrAvgTime/numberOfTimes+" ns"+"\t\t"+arrworstCaseTime+" ns");
		
		System.out.println("\nRadixSort \tAvg Time \t\tWorst case time");
		System.out.println("\t\t"+radixSortAvgTime/numberOfTimes+" ns"+"\t\t"+radixworstCaseTime+" ns");
		
		
		
	}

}
