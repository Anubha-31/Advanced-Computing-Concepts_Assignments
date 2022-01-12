package solution;

import java.util.Arrays;
import java.util.Random;

import sorting.RadixSort;
import sorting.Sort;

public class QuestionOne {

	public static void main(String[] args) {
		Long arr[] = new Long[100];
		String str[] = new String[100];
		Helper.generateRandomArray(arr, 100);
		usingHeapSortClass(arr);
		Helper.generateRandomArray(arr, 100);
		usingArraySort(arr);
		Helper.generateRandomStringArray(str, 100,10);
		usingRadixSort(str);

	}

	private static void usingRadixSort(String[] arr) {
		RadixSort.radixSortA(arr, 10);
		System.out.println("\nUsing Radixsort");
		System.out.println(Arrays.toString(arr));
	}

	private static void usingArraySort(Long[] arr) {
		Arrays.sort(arr);
		System.out.println("\nUsing Arrays.sort()");
		System.out.println(Arrays.toString(arr));

	}

	private static void usingHeapSortClass(Long[] arr) {
		Sort.heapsort(arr);
		System.out.println("Using Heapsort in Sort Class");
		System.out.println(Arrays.toString(arr));
	}

}
