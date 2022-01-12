package solution;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import graphs.In;
import memoryManagement.IndexMinPQ;
import memoryManagement.Multiway;
import memoryManagement.StdOut;

public class QuestionFive {
	
	BufferedWriter buffwriter;

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		In in = new In("solution/ChIP-seq-reads-1M.dat");
		String[] lines = in.readAllLines();
		
		ArrayList<String> a = new ArrayList<String>();
		ArrayList<String> b = new ArrayList<String>();
		ArrayList<String> c = new ArrayList<String>();
		ArrayList<String> d = new ArrayList<String>();
		
		for (int i = 0; i < lines.length/4; i++) {
			a.add(lines[i]);
		}
		for (int i = lines.length/4; i < lines.length/2; i++) {
			b.add(lines[i]);
		}
		for (int i = lines.length/2; i < ((lines.length)*3)/4 ; i++) {
			c.add(lines[i]);
		}
		for (int i = ((lines.length)*3)/4; i < lines.length; i++) {
			d.add(lines[i]);
		}
		
		
		try {
			FileWriter writer = new FileWriter("solution/A.dat");
			BufferedWriter buffwriter = new BufferedWriter(writer);	
			  for (String string : a) { 
				  buffwriter.write(string); 
				  buffwriter.newLine();
				  }
			  
			  buffwriter.flush();
			  buffwriter.close();
			  writer.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			FileWriter writer = new FileWriter("solution/B.dat");
			BufferedWriter buffwriter = new BufferedWriter(writer);	
			  for (String string : b) { 
				  buffwriter.write(string); 
				  buffwriter.newLine();
				  }
			  
			  buffwriter.flush();
			  buffwriter.close();
			  writer.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			FileWriter writer = new FileWriter("solution/C.dat");
			BufferedWriter buffwriter = new BufferedWriter(writer);	
			  for (String string : c) { 
				  buffwriter.write(string); 
				  buffwriter.newLine();
				  }
			  
			  buffwriter.flush();
			  buffwriter.close();
			  writer.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			FileWriter writer = new FileWriter("solution/D.dat");
			BufferedWriter buffwriter = new BufferedWriter(writer);	
			  for (String string : d) { 
				  buffwriter.write(string); 
				  buffwriter.newLine();
				  }
			  
			  buffwriter.flush();
			  buffwriter.close();
			  writer.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Collections.sort(a);
		Collections.sort(b);
		Collections.sort(c);
		Collections.sort(d);
		
		
		try {
			FileWriter writer = new FileWriter("solution/AS.dat");
			BufferedWriter buffwriter = new BufferedWriter(writer);	
			  for (String string : a) { 
				  buffwriter.write(string); 
				  buffwriter.newLine();
				  }
			  
			  buffwriter.flush();
			  buffwriter.close();
			  writer.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			FileWriter writer = new FileWriter("solution/BS.dat");
			BufferedWriter buffwriter = new BufferedWriter(writer);	
			  for (String string : b) { 
				  buffwriter.write(string); 
				  buffwriter.newLine();
				  }
			  
			  buffwriter.flush();
			  buffwriter.close();
			  writer.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			FileWriter writer = new FileWriter("solution/CS.dat");
			BufferedWriter buffwriter = new BufferedWriter(writer);	
			  for (String string : c) { 
				  buffwriter.write(string); 
				  buffwriter.newLine();
				  }
			  
			  buffwriter.flush();
			  buffwriter.close();
			  writer.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			FileWriter writer = new FileWriter("solution/DS.dat");
			BufferedWriter buffwriter = new BufferedWriter(writer);	
			  for (String string : d) { 
				  buffwriter.write(string); 
				  buffwriter.newLine();
				  }
			  
			  buffwriter.flush();
			  buffwriter.close();
			  writer.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		 * a.addAll(b); a.addAll(c); a.addAll(d); Collections.sort(a);
		 */
		
		In [] stream = new In[4];
		
		stream[0] = new In("solution/AS.dat");
		stream[1]= new In("solution/BS.dat");
		stream[2] = new In("solution/CS.dat");
		stream[3] = new In("solution/DS.dat");
		
		ArrayList<String> sortedList = merge(stream);
		
		try {
			FileWriter writer = new FileWriter("solution/ChIP-seq-reads-1M-sorted.dat");
			BufferedWriter buffwriter = new BufferedWriter(writer);	
			  for (String string : sortedList) { 
				  buffwriter.write(string); 
				  buffwriter.newLine();
				  }
			  
			  buffwriter.flush();
			  buffwriter.close();
			  writer.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long endtime = System.currentTimeMillis();
		System.out.println("CPU time: "+(endtime-startTime)+" ms");

	}
	
	 public static ArrayList<String> merge(In[] streams) { 
	        int N = streams.length; 
	        ArrayList<String> sortedList = new ArrayList<String>();
	        IndexMinPQ<String> queue = new IndexMinPQ<String>(N); 
	        for (int i = 0; i < N; i++) 
	            if (!streams[i].isEmpty()) 
	            	queue.insert(i, streams[i].readString()); 
 
	        while (!queue.isEmpty()) {
	        	sortedList.add(queue.minKey());
	            int i = queue.delMin(); 
	            if (!streams[i].isEmpty()) 
	            	queue.insert(i, streams[i].readString()); 
	        }
	        return sortedList;
	    } 

}
