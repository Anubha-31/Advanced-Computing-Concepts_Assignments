package assignmentSolution;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import hashTable.CuckooHashTable;
import hashTable.QuadraticProbingHashTable;
import hashTable.SeparateChainingHashTable;

public class AssignmentSolutionThreeSearchAndDelete {

	public static void main(String[] args) {

		AssignmentSolutionThreeInsertion insertSol = new AssignmentSolutionThreeInsertion();
		List<Integer> list = AssignmentHelper.getAlphaNumericASCIIRange();
		List<String> initialRandomlist = AssignmentHelper.generateRandomString(list, 30000, 10);
		List<Object> coll = insertSol.insertToCollections(initialRandomlist);

		List<String> previousList = new ArrayList<String>();
		List<String> randomlist;
		AssignmentHelper.timetaken = new Hashtable<Long, List<Long>>();
		for (int i = 1; i <= 20; i++) {
			randomlist = insertSol.randomListGenerator(list, previousList, i);
			previousList = randomlist;
			Long j = (long) 0;
			for (Object obj : coll) {

				if (obj instanceof Hashtable<?, ?>) {
					AssignmentHelper.findRandomStringInTable(randomlist, (Map<Integer, String>) obj, false);
				} else if (obj instanceof CuckooHashTable<?>) {
					CuckooHashTable<String> cTable = (CuckooHashTable<String>) obj;
					j = (long) 0;
					for (String rand : randomlist) {
						Long startTime = System.nanoTime();
						if (cTable.contains(rand)) {
							cTable.remove(rand);
						}
						Long endTime = System.nanoTime();
						Long timeTaken = endTime - startTime;
						AssignmentHelper.logTime(j, startTime, endTime);
						j++;
					}
				} else if (obj instanceof QuadraticProbingHashTable<?>) {
					QuadraticProbingHashTable<String> qtable = (QuadraticProbingHashTable<String>) obj;
					j = (long) 0;
					for (String rand : randomlist) {
						Long startTime = System.nanoTime();
						if (qtable.contains(rand)) {
							qtable.remove(rand);
						}
						Long endTime = System.nanoTime();
						Long timeTaken = endTime - startTime;
						AssignmentHelper.logTime(j, startTime, endTime);
						j++;
					}

				} else if (obj instanceof SeparateChainingHashTable<?>) {
					SeparateChainingHashTable<String> sTable = (SeparateChainingHashTable<String>) obj;
					j = (long) 0;
					for (String rand : randomlist) {
						Long startTime = System.nanoTime();
						if (sTable.contains(rand)) {
							sTable.remove(rand);
						}
						Long endTime = System.nanoTime();
						Long timeTaken = endTime - startTime;
						AssignmentHelper.logTime(j, startTime, endTime);
						j++;
					}
				}

			}

			System.out.println("\nPrinting Entries for 2 power " + i);
			System.out.println("----------------------------------");
			insertSol.logTimeOnConsole(i);
		}
		AssignmentSolutionThreeInsertion.insertToExcel("Search_Question_three");
	}

}
