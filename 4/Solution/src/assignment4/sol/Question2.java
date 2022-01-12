package assignment4.sol;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.StringTokenizer;

import textprocessing.TST;

public class Question2 {

	public static void main(String[] args) {

		String keys[] = { "protein", "complex", "PPI", "prediction" };

		Path path = Paths.get("src/textprocessing/Protein.txt");

		TST<Integer> tst = new TST<Integer>();
		
		for (int i = 0; i < keys.length; i++) {
			tst.put(keys[i], 0);
		}
		try {
			List<String> strings = Files.readAllLines(path);
			for (String line : strings) {
				StringTokenizer token = new StringTokenizer(line);
				while (token.hasMoreTokens()) {
					String to = token.nextToken();
					if (tst.get(to) != null) {
						int count = tst.get(to);
						tst.put(to, count + 1);
					}

				}

			}
			for (int i = 0; i < keys.length; i++) {
				
				System.out.println("key :"+keys[i] +" occurance "+ tst.get(keys[i]));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
