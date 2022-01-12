package assignmentSolution;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Random;

import hashTable.CuckooHashTable;
import hashTable.QuadraticProbingHashTable;
import hashTable.SeparateChainingHashTable;

public class AssignmentHelper {

	public static Hashtable<Long, List<Long>> timetaken;

	/**
	 * generates a list of random numbers
	 * 
	 * @param al          : List Of ASCII values from which random number should be
	 *                    generated
	 * @param noOfStrings : no of random strings to be generated
	 * @param lenOfString : length of each String
	 * @return list of random numbers
	 */
	public static List<String> generateRandomString(List<Integer> al, double noOfStrings, int lenOfString) {

		List<String> randomNumbers = new ArrayList<>();

		if (!al.isEmpty()) {
			Random rand = new Random();
			for (int j = 0; j < noOfStrings; j++) {
				StringBuilder sb = new StringBuilder(lenOfString);

				for (int i = 0; i < lenOfString; i++) {
					int integerAtSelectedIndex = (int) al.get(rand.nextInt(al.size()));
					sb.append(Character.toChars(integerAtSelectedIndex));
				}
				randomNumbers.add(sb.toString());
			}
		}

		return randomNumbers;

	}

	/**
	 * Generates a list of ASCII Ranges from which the random number will be formed
	 * 
	 * @param al : list of ranges of characters from which random number needs to be
	 *           chozen
	 * @return a list of ASCII Ranges
	 */
	public static List<Integer> generateASCIIRangeForRandomNumber(List<RandomRangeModel> al) {
		ArrayList<Integer> ASCIIValues = new ArrayList<>();

		if (!al.isEmpty()) {
			for (RandomRangeModel model : al) {
				for (int i = (int) model.getLowerChar(); i <= (int) model.getUpperChar(); i++) {
					ASCIIValues.add(i);
				}
			}
		}
		return ASCIIValues;
	}

	/**
	 * inserts the list of random strings into a hashTable and calculates the time
	 * of each insertion
	 * 
	 * @param list: a list of random strings
	 */
	public static Map<Integer, String> insertIntoHashTable(List<String> list, boolean debugMode) {
		Hashtable<Integer, String> table = new Hashtable<>();
		timetaken = new Hashtable<>();
		if (debugMode)
			System.out.println("\nDetails of insertion in Hashtable are as follows:");

		long avgTime = 0;
		int size = list.size();
		for (int i = 0; i < size; i++) {
			long startTime = System.nanoTime();

			table.put(i, list.get(i));

			long endTime = System.nanoTime();
			long timeTaken = (endTime - startTime);
			avgTime += timeTaken;
			if (debugMode) {
				System.out.println(
						"Key: " + i + "\t\t" + "Value: " + list.get(i) + "\t\t" + "Time Taken: " + timeTaken + " ns");
			} 
				List<Long> list1 = new ArrayList<>();
				list1.add(timeTaken);
				timetaken.put((long) i, list1);
		}
		if (debugMode) {
			System.out.println("Avg Time Taken for " + size + " elements is " + avgTime / size +" ns");
		}
		return table;
	}

	public static List<Integer> getAlphaNumericASCIIRange() {
		ArrayList<RandomRangeModel> range = new ArrayList<>();
		range.add(new RandomRangeModel('a', 'z'));
		range.add(new RandomRangeModel('A', 'Z'));
		range.add(new RandomRangeModel('0', '9'));

		List<Integer> list = AssignmentHelper.generateASCIIRangeForRandomNumber(range);
		return list;
	}

	public static void findRandomStringInTable(List<String> randomlist, Map<Integer, String> initializedMap,
			boolean debugMode) {

		if (!initializedMap.isEmpty() && !randomlist.isEmpty()) {
			if (initializedMap instanceof Hashtable) {
				Hashtable<Integer, String> table = (Hashtable<Integer, String>) initializedMap;
				if(debugMode)
				System.out.println("\nStarting the Search\n");
				int i=0;
				long avgTime = 0;
				for (String randStr : randomlist) {
					long startTime = System.nanoTime();

					if (table.containsValue(randStr)) {
						ArrayList<Integer> keys = new ArrayList<>();
						for (Map.Entry<Integer, String> entry : table.entrySet()) {
							if (randStr.equals(entry.getValue())) {
								keys.add(entry.getKey());
							}
						}
						System.out.println("Deleting the value found in the table");
						keys.forEach((key) -> table.remove(key));
					}

					long endTime = System.nanoTime();
					long timeTaken = (endTime - startTime);
					avgTime += timeTaken;
					List<Long> list1 = new ArrayList<>();
					list1.add(timeTaken);
					timetaken.put((long) i++, list1);
					if (debugMode)
						System.out.println("Time Taken for searching " + randStr + " is " + timeTaken + " ns");
				}
				if(debugMode)
				System.out.println("Avg Time Taken for " + i + " elements is " + avgTime / randomlist.size() +" ns");
			}
		}
	}

	public static CuckooHashTable<String> insertIntoCukooHashTable(CuckooHashTable<String> cTable,
			List<String> randomlist) {
		Long i = (long) 0;
		for (String randStr : randomlist) {
			long startTime = System.nanoTime();
			cTable.insert(randStr);
			long endTime = System.nanoTime();
			logTime(i, startTime, endTime);
			i++;
		}
		return cTable;

	}

	public static void logTime(Long i, long startTime, long endTime) {
		long timeTaken = (endTime - startTime);
		if (!timetaken.isEmpty()) {
			List<Long> list = timetaken.get(i);
			list.add(timeTaken);
			timetaken.replace(i, list);
		}
	}

	public static QuadraticProbingHashTable<String> insertIntoQuadraticProbingHashTable(
			QuadraticProbingHashTable<String> qTable, List<String> randomlist) {
		Long i = (long) 0;
		for (String randStr : randomlist) {
			long startTime = System.nanoTime();
			qTable.insert(randStr);
			long endTime = System.nanoTime();
			logTime(i, startTime, endTime);
			i++;
		}
		return qTable;

	}

	public static SeparateChainingHashTable<String> insertIntoSeparateChainingHashTable(
			SeparateChainingHashTable<String> sTable, List<String> randomlist) {
		Long i = (long) 0;
		for (String randStr : randomlist) {
			long startTime = System.nanoTime();
			sTable.insert(randStr);
			long endTime = System.nanoTime();
			logTime(i, startTime, endTime);
			i++;
		}
		return sTable;

	}

}
