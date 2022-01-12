package solution;

import java.util.Random;

public class Helper {

	public static void generateRandomStringArray(String[] str, int numberOfStrings, int lengthOfString) {
		String character = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random rand = new Random();

		for (int j = 0; j < numberOfStrings; j++) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < lengthOfString; i++) {
				int selectedIndex = rand.nextInt(character.length());
				sb.append(character.charAt(selectedIndex));
			}
			str[j] = sb.toString();
		}
	}

	public static void generateRandomArray(Long[] arr, int numberOfStrings) {
		for (int i = 0; i < numberOfStrings; i++) {
			Long a =  (long) (Math.random() * 100000);
			arr[i] = a;
		}
	}
}
