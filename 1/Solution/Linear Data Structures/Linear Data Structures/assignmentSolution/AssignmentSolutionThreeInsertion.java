package assignmentSolution;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import hashTable.CuckooHashTable;
import hashTable.QuadraticProbingHashTable;
import hashTable.SeparateChainingHashTable;
import hashTable.StringHashFamily;

public class AssignmentSolutionThreeInsertion {

	Map<Integer, Double> power = new Hashtable<Integer, Double>();
	Long hashTableTime;
	Long cuckooTableTime;
	Long quadTableTime;
	Long separateTableTime;
	static Map<Long,List<Long>> excelData = new Hashtable<Long, List<Long>>();

	public static void main(String[] args) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		System.out.println(timestamp);
		AssignmentSolutionThreeInsertion obj = new AssignmentSolutionThreeInsertion();
		obj.solution();
		insertToExcel("Insertion");

	}

	public static void insertToExcel(String sheetName) {

		List<String> header = new ArrayList<String>();
		header.add("n");
		header.add("HashTable");
		header.add("cuckooHashTable");
		header.add("QuadraticProbingHashTable");
		header.add("SeparateChainingHashTable");

		InsertDataIntoExcel obj = new InsertDataIntoExcel(header, excelData, sheetName);
		obj.insertData();

	}

	private void solution() {
		List<Integer> list = AssignmentHelper.getAlphaNumericASCIIRange();
		List<String> previousList = new ArrayList<String>();
		List<String> randomlist;
		for (int i = 1; i <= 20; i++) {

			// optimize this.
			randomlist = randomListGenerator(list, previousList, i);

			previousList = randomlist;

			insertToCollections(randomlist);

			System.out.println("\nPrinting Entries for 2 power " + i);
			System.out.println("----------------------------------");
			logTimeOnConsole(i);

		}

	}

	public List<String> randomListGenerator(List<Integer> list, List<String> previousList, int i) {
		if (!power.containsKey(i)) {
			if (i > 1) {
				power.put(i, power.get(i - 1) * 2);
			} else {
				power.put(1, (double) 2);
			}
		}
		//System.out.println(power);
		List<String> randomlist;
		if (i > 1) {
			randomlist = AssignmentHelper.generateRandomString(list, power.get(i - 1), 10);
			randomlist.addAll(previousList);
		} else {
			randomlist = AssignmentHelper.generateRandomString(list, power.get(i), 10);
		}
		//randomlist.forEach((n) -> System.out.println(n));
		return randomlist;
	}

	public List<Object> insertToCollections(List<String> randomlist) {

		Hashtable<Integer, String> table1 = (Hashtable<Integer, String>) AssignmentHelper
				.insertIntoHashTable(randomlist, false);

		CuckooHashTable<String> cTable = new CuckooHashTable<>(new StringHashFamily(10), randomlist.size());
		cTable = AssignmentHelper.insertIntoCukooHashTable(cTable, randomlist);

		QuadraticProbingHashTable<String> qTable = new QuadraticProbingHashTable<String>(randomlist.size());
		qTable = AssignmentHelper.insertIntoQuadraticProbingHashTable(qTable, randomlist);

		SeparateChainingHashTable<String> sTable = new SeparateChainingHashTable<String>(randomlist.size());
		sTable = AssignmentHelper.insertIntoSeparateChainingHashTable(sTable, randomlist);

		List<Object> collection = new ArrayList<Object>();
		collection.add(table1);
		collection.add(cTable);
		collection.add(qTable);
		collection.add(sTable);
		return collection;
	}

	public void logTimeOnConsole(int power) {
		System.out.println("\t\t\t\t\tHashMap\t\t\tCuckoo\t\t\tQuadratic\t\t\tSeparateChaining");
		int size = AssignmentHelper.timetaken.size();
		insertToExcel();
		hashTableTime = (long) 0;
		cuckooTableTime = (long) 0;
		quadTableTime = (long) 0;
		separateTableTime = (long) 0;
		
		for (int i = 0; i < size; i++) {
			List<Long> list = AssignmentHelper.timetaken.get((long) i);
			System.out.println("Time taken for entry number : " + i + " is:\t " + list.get(0) + "\t\t\t" + list.get(1)
					+ "\t\t\t" + list.get(2) + "\t\t\t" + list.get(3));
			hashTableTime += list.get(0);
			cuckooTableTime += list.get(1);
			quadTableTime += list.get(2);
			separateTableTime += list.get(3);
		}

		hashTableTime = hashTableTime/size;
		cuckooTableTime = cuckooTableTime/size;
		quadTableTime = quadTableTime/size;
		separateTableTime = separateTableTime/size;
		System.out.println(
				"\nTime taken by each collection is:\t" + hashTableTime + "ns \t\t\t" + cuckooTableTime
						+ "ns \t\t\t" + quadTableTime + " ns\t\t\t" + separateTableTime + " ns");
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		System.out.println(timestamp);
		addData(power);
	}

	private void insertToExcel() {
		List<String> headers = new ArrayList<String>();
		headers.add("HashMap");
		headers.add("Cuckoo Map");
		headers.add("Quadratic Chaining");
		headers.add("Seperate Chaining");

		List<String> rowHeader = new ArrayList<String>();
		int size = AssignmentHelper.timetaken.size();
		for (int i = 0; i < size; i++) {
			rowHeader.add("Time taken for entry number : " + i);
		}

		InsertDataIntoExcel excel = new InsertDataIntoExcel(headers, AssignmentHelper.timetaken,
				"n =" + String.valueOf(AssignmentHelper.timetaken.size()), rowHeader);
		//excel.insertData();

	}

	private void addData(int power) {

		List<Long> data = new ArrayList<Long>();
		data.add((long) power);
		data.add(hashTableTime);
		data.add(cuckooTableTime);
		data.add(quadTableTime);
		data.add(separateTableTime);
		excelData.put((long) power, data);

	}

}
