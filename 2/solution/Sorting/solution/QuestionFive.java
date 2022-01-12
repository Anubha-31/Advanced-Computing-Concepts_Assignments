package solution;

import algorithmDesign.Sequences;

public class QuestionFive {

	public static void main(String[] args) {

		
		generateStrings(10);
		generateStrings(20);		
		generateStrings(50);		
		generateStrings(100);	 
		
	}

	private static void generateStrings(int length) {
		long startTime = System.nanoTime();
		
		String str[] = new String[1000];
		
		Helper.generateRandomStringArray(str, 1000, length);
		System.out.println("\nPrinting entries for length : "+ length);
		findDistance(str);
		
		long endTime = System.nanoTime();
		long timeTaken = endTime - startTime;
		System.out.println("Running time of algorithm : "+ timeTaken+" ns");
		
		
	}

	private static void findDistance(String[] str) {
		
		long avgtime = 0L;
		for(int i =0 ; i<999; i++) {
			long startTime = System.nanoTime();
			int d = Sequences.editDistance(str[i], str[i+1]);
			long endTime = System.nanoTime();
			long timeTaken = endTime - startTime;
			avgtime +=timeTaken;
			//System.out.println("Distance\t timeTaken");
			//System.out.println(d +"\t\t"+timeTaken+" ns");
		}
		System.out.println("Average time taken: "+avgtime/1000+" ns");
		
	}

}
