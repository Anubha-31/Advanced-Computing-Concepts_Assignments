package solution;

import java.util.ArrayList;
import java.util.List;

import graphs.In;

public class QuestionFour {

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();

		List<String> names = new ArrayList<String>();
		names.add("DiCaprio, Leonardo");
		List<String> movies = findMovies(names);
		System.out.println("leonardo Dicaprio movies");
		movies.forEach(i -> System.out.println(i));

		names = new ArrayList<String>();
		names.add("Roberts, Julia (I)");
		movies = findMovies(names);
		System.out.println("\nJulia Roberts Movies");
		movies.forEach(i -> System.out.println(i));

		names = new ArrayList<String>();
		names.add("Grant, Hugh (I)");
		movies = findMovies(names);
		System.out.println("\nHugh Grant Movies");
		movies.forEach(i -> System.out.println(i));

		names = new ArrayList<String>();
		names.add("Grant, Hugh (I)");
		names.add("Roberts, Julia (I)");
		movies = findMovies(names);
		System.out.println("\nHugh Grant and Julia roberts's Movies Movies");
		movies.forEach(i -> System.out.println(i));

		long endtime = System.currentTimeMillis();
		System.out.println("CPU time: "+(endtime-startTime)+" ms");
	}

	private static List<String> findMovies(List<String> names) {
		In in = new In("graphs/movies.txt");
		List<String> movies = new ArrayList<String>();
		
		while (!in.isEmpty()) {
			String[] elements = in.readLine().split("/");
			int containsNames = 0;
			int size = names.size();
			for (String name : elements) {
				for (int j = 0; j < size; j++) {
					if (name.equalsIgnoreCase(names.get(j))) {
						containsNames++;
					}
				}
				if(containsNames == size) {
					movies.add(elements[0]);
					break;
				}
			}
			
		}
		return movies;
	}

}
