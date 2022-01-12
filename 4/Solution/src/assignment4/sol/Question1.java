package assignment4.sol;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import textprocessing.BoyerMoore;
import textprocessing.BruteForceMatch;
import textprocessing.KMP;

public class Question1 {

	public static void main(String[] args) {

		// File file = new File("src/textprocessing/hardisk.txt");
		String[] patterns = { "hard", "disk", "hard disk", "hard dist", "xltpru" };

		for (int i = 0; i < 100; i++) {
			long start = System.nanoTime();
			applyBruteForceMethod(patterns);
			long end = System.nanoTime();
			System.out.println("Average Time : " + (end - start) + " ms");
			System.out.println("-------------------------------------------------------------------------------");


			start = System.nanoTime();
			applyBoyerMethod(patterns);
			end = System.nanoTime();
			System.out.println("Average Time : " + (end - start) + " ms");
			System.out.println("-------------------------------------------------------------------------------");


			start = System.nanoTime();
			applyKMP(patterns);
			end = System.nanoTime();
			System.out.println("Average Time : " + (end - start) + " ms");
			System.out.println("-------------------------------------------------------------------------------");


		}

	}

	private static void applyBoyerMethod(String[] patterns) {

		Path path = Paths.get("src/textprocessing/hardisk.txt");
		try {
			List<String> strings = Files.readAllLines(path);
			System.out.println("Searching with BoyerMoore");
			for (String pattern : patterns) {
				int count = 0;
				int initialPos = 0;
				for (String str : strings) {
					BoyerMoore br = new BoyerMoore(pattern);
					int offset = br.search(str);
					if (offset < str.length()) {
						offset = offset + initialPos;
						System.out.print("Offset: " + offset + " ");
						count++;
					}
					initialPos = initialPos + str.length();
				}
				System.out.println("\nPattern : " + pattern + " occurance: " + count + "\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void applyKMP(String[] patterns) {
		try {
			Path path = Paths.get("src/textprocessing/hardisk.txt");
			List<String> strings = Files.readAllLines(path);
			System.out.println("Searching with KMP");
			for (String pattern : patterns) {
				int count = 0;
				int initialPos = 0;
				for (String str : strings) {
					KMP kmp = new KMP(pattern);
					int offset = kmp.search(str);
					if (offset < str.length()) {
						offset = offset + initialPos;
						System.out.print("Offset: " + offset + " ");
						count++;
					}
					initialPos = initialPos + str.length();
				}
				System.out.println("\nPattern : " + pattern + " occurance: " + count + "\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static Path applyBruteForceMethod(String[] patterns) {
		Path path = Paths.get("src/textprocessing/hardisk.txt");
		try {
			System.out.println("Searching with BruteForceMatch");
			List<String> strings = Files.readAllLines(path);

			for (String pattern : patterns) {
				int count = 0;
				int initialPos = 0;

				for (String str : strings) {
					int offset = BruteForceMatch.search1(pattern.trim(), str);
					if (offset < str.length()) {
						offset = offset + initialPos;
						System.out.print("Offset: " + offset + " ");
						count++;
					}
					initialPos = initialPos + str.length();
				}
				System.out.println("\nPattern : " + pattern + " occurance: " + count + "\n");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}

}
