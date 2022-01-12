package solution;

import java.io.IOException;
import java.io.PrintStream;

import graphs.In;
import memoryManagement.BTree;


public class QuestionSix {

	public static void main(String[] args) {
		In in = new In("solution/ChIP-seq-reads-1M.dat");
		String[] lines = in.readAllLines();
		
		BTree<Integer, String> tree = new BTree<Integer, String>();
		
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < lines.length; i++) {
			tree.put(i, lines[i]);
		}
		long endtime = System.currentTimeMillis();
		System.out.println("CPU time: "+(endtime-startTime)+" ms");
		
		
		try {
		
			 PrintStream stream = new PrintStream("solution/BTree.dat");
			 System.setOut(stream);
			 System.out.println(tree.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
