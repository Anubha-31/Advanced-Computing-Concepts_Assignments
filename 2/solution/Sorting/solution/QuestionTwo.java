package solution;

import java.util.Arrays;

import sorting.Sort;

public class QuestionTwo {

	public static void main(String[] args) {
		Long mergeAvgTime = 0L;
		Long heapAvgTime = 0L;
		Long quickAvgTime = 0L;
		Long arrAvgTime = 0L;
		

		for (int i = 0; i < 100; i++) {
			Long arr[] = new Long[100000];
			Helper.generateRandomArray(arr, 100000);
			
			Long mergeSortArray[] = arr;
			Long quicksortArray[] = arr;
			Long heapSortArray[] = arr;
			
			Long startTime = System.nanoTime();
			Sort.mergeSort(mergeSortArray);
			Long endTime = System.nanoTime();
			mergeAvgTime += (endTime-startTime);
			/*
			 * System.out.println("Using mergesort in Sort Class");
			 * System.out.println(Arrays.toString(mergeSortArray));
			 */

			startTime = System.nanoTime();
			Sort.quicksort(quicksortArray);
			endTime =System.nanoTime();
			quickAvgTime += (endTime-startTime);
			/*
			 * System.out.println("Using quickSort in Sort Class");
			 * System.out.println(Arrays.toString(mergeSortArray));
			 */
			
			
			startTime = System.nanoTime();
			Sort.heapsort(heapSortArray);
			endTime =System.nanoTime();
			heapAvgTime += (endTime-startTime);
			/*
			 * System.out.println("Using Heapsort in Sort Class");
			 * System.out.println(Arrays.toString(heapSortArray));
			 */
			
			startTime = System.nanoTime();
			Arrays.sort(arr);
			endTime =System.nanoTime();
			arrAvgTime += (endTime-startTime);
			/*System.out.println("Using Dual Pivot Quicksort in Sort Class");
			System.out.println(Arrays.toString(arr));*/
		}
		
		System.out.println("HeapSort avg Time: "+heapAvgTime/100000+" ns");
		System.out.println("MergeSort avg Time: "+mergeAvgTime/100000+" ns");
		System.out.println("QuickSort avg Time: "+quickAvgTime/100000+" ns");
		System.out.println("Dual-Pivot QuickSort avg Time: "+arrAvgTime/100000+" ns");

	}

}
