package solution;

import graphs.DepthFirstOrder;
import graphs.Digraph;
import graphs.In;

public class QuestionOne {

	public static void main(String[] args) {

        Digraph diagraph = new Digraph(new In("graphs/largeDG.txt"));
        
        DepthFirstOrder dfs = new DepthFirstOrder(diagraph);
        
        System.out.println("print vertices in post order");
        
        long worstTime = 0L;
        long avgTime = 0L;
        long startTime = 0L;
        long endTime = 0L;
        for(int v : dfs.post()) {
        	startTime = System.currentTimeMillis();
        	System.out.println(v+ " ");
        	endTime = System.currentTimeMillis();
        	long timeTaken = endTime - startTime;
        	if(worstTime < timeTaken)
        		worstTime = timeTaken;
        	avgTime += timeTaken;
        }
        System.out.println("CPU time: "+avgTime);
        System.out.println("Worst time: "+ worstTime);
        
        worstTime = 0L;
        avgTime = 0L;
        System.out.println("\nprint vertices in pre order");
        for(int v : dfs.pre()) {
        	startTime = System.currentTimeMillis();
        	System.out.println(v+ " ");
        	endTime = System.currentTimeMillis();
        	long timeTaken = endTime - startTime;
        	if(worstTime < timeTaken)
        		worstTime = timeTaken;
        	avgTime += timeTaken;
        }
        System.out.println("CPU time: "+avgTime);
        System.out.println("Worst time: "+ worstTime);

	}
}
