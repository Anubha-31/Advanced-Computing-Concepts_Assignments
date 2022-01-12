package assignment4.sol;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Question4 {

	public static void main(String[] args) {
		File dir = new File("directory");
		File listOfFiles[] = dir.listFiles();

		System.out.println("Finding mobile Numbers");
		findMobileNumber(listOfFiles);

		System.out.println("\n\nFinding Email ID");
		findEmailId(listOfFiles);

	}

	private static void findEmailId(File[] listOfFiles) {

		Pattern pattern = Pattern.compile("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[A-Za-z0-9.-]+$");

		for (File file : listOfFiles) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String lines = br.readLine();

				while (lines != null) {
					String[] str = lines.split(" ");
					Matcher match;
					for (String word : str) {
						match = pattern.matcher(word);
						if (match.find()) {
							System.out.println(match.group());
						}
					}

					lines = br.readLine();
				}

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	private static void findMobileNumber(File[] listOfFiles) {

		Pattern pattern = Pattern.compile("(\\()?(\\d){3}(\\))?[ -]?(\\d){3}-(\\d){4}");

		for (File file : listOfFiles) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String lines = br.readLine();

				while (lines != null) {
					Matcher match = pattern.matcher(lines);

					while (match.find()) {
						System.out.println(match.group(0));
					}
					lines = br.readLine();
				}

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
