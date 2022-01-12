package assignmentSolution;

import java.util.Hashtable;
import java.util.List;

public class AssignmentSolutionTwo {

	public static void main(String[] args) {

		AssignmentSolutionOne solution = new AssignmentSolutionOne();
		Hashtable table = solution.assignmentQuestionOneSolution(15);

		AssignmentSolutionTwo sol = new AssignmentSolutionTwo();
		sol.assignmentQuestionTwoSolution(10, table);
	}

	private void assignmentQuestionTwoSolution(double n, Hashtable map) {
		List<Integer> listToBeFound = AssignmentHelper.getAlphaNumericASCIIRange();
		List<String> randomlist = AssignmentHelper.generateRandomString(listToBeFound, n, 10);
		System.out.println("\nList of random strings to be found in HashTable are :");
		//randomlist.forEach((i) -> System.out.println(i));
		System.out.println(randomlist);
		AssignmentHelper.findRandomStringInTable(randomlist, map, true);
		/*
		 * List<String> header = new ArrayList<String>();
		 * header.add("Time of Each Insertion In nano seconds in HashTable");
		 * InsertDataIntoExcel obj = new InsertDataIntoExcel(header,
		 * AssignmentHelper.timetaken, "Question_two"); obj.insertData();
		 */
	}
}
