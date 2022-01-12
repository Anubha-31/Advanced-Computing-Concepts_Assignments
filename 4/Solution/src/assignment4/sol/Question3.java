package assignment4.sol;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Question3 {

	public static void main(String[] args) {
		File dirctory = new File(
				"D:\\Windsor\\Term1\\Advanced Computing Concepts\\Assignments\\Assignment4\\W3C Web Pages");
		File listOfFiles[] = dirctory.listFiles();

		File dir = new File("directory");
		dir.mkdir();
		for (File file : listOfFiles) {
			try {
				covertToTextAndSave(dir,file);		

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void covertToTextAndSave(File dir,File file) throws IOException {
		
		String path = dir.getAbsolutePath()+"//"+file.getName().split(".htm")[0];
		File newFile = new File(path);
		newFile.createNewFile();

		Document doc = Jsoup.parse(file, "UTF-8");
		Elements element = doc.select("*");

		BufferedWriter bf = new BufferedWriter(new FileWriter(newFile));
		for (Element e : element) {
			bf.write(e.ownText());
			bf.newLine();
		}

		bf.flush();
		bf.close();
	}
}
