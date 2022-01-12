package assignment4.sol;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Question5 {

	public static void main(String[] args) {
	
		File dirctory = new File(
				"D:\\Windsor\\Term1\\Advanced Computing Concepts\\Assignments\\Assignment4\\W3C Web Pages");
		File listOfFiles[] = dirctory.listFiles();
		//String pattern = "((http|https)://)(www.)?[a-zA-Z0-9@:%._\\+~#?&//=]{2,256}\\.[a-z]{2,6}([-a-zA-Z0-9@:%._\\+~#?&//=]*)";
		//findWebLinks(pattern, listOfFiles);
		
		//String pattern = "((http|https)://)(www.w3.org)([-a-zA-Z0-9@:%._\\+~#?&//=]*)";
		//findWebLinks(pattern, listOfFiles);
		
		String pattern = "((http|https)://)(www.w3.org)([-a-zA-Z0-9@:%._\\+~#?&//=]*)/#([-a-zA-Z0-9@:%._\\+~#?&//=]*)";
		findWebLinks(pattern, listOfFiles);
	}

	private static void findWebLinks(String patt,File[] listOfFiles) {
		
		Pattern pattern = Pattern.compile(patt);

		for (File file : listOfFiles) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String lines = br.readLine();
				
				while(lines != null) {
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

}
