package assignmentSolution;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class AssignmentSolutionOne {

	public static void main(String[] args) {

		AssignmentSolutionOne solution = new AssignmentSolutionOne();
		solution.assignmentQuestionOneSolution(15);
	}

	public Hashtable<Integer, String> assignmentQuestionOneSolution(double n) {
		List<Integer> list = AssignmentHelper.getAlphaNumericASCIIRange();
		List<String> randomlist = AssignmentHelper.generateRandomString(list, n, 10);
		System.out.println("List of random strings to be added in HashTable are :");
		randomlist.forEach(System.out::println);
		Hashtable<Integer, String> table = (Hashtable<Integer, String>) AssignmentHelper.insertIntoHashTable(randomlist,
				true);
		
		  List<String> header = new ArrayList<String>();
		  header.add("Time of Each Insertion In nano seconds in HashTable");
		  InsertDataIntoExcel obj = new InsertDataIntoExcel(header,
		  AssignmentHelper.timetaken, "Question_one"); obj.insertData();
		 
		return table;
	}

}
