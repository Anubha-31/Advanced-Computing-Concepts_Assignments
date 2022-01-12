package solution;

import graphs.CC;
import graphs.Graph;
import graphs.Queue;
import graphs.StdOut;
import graphs.SymbolGraph;

public class QuestionThree {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		SymbolGraph sg = new SymbolGraph("graphs/movies.txt", "/");
		Graph graph = sg.G();
		CC cc = new CC(graph);

		
		int M = cc.count();
		
		Queue<Integer>[] components = (Queue<Integer>[]) new Queue[M];
		for (int i = 0; i < M; i++) {
			components[i] = new Queue<Integer>();
		}
		for (int v = 0; v < graph.V(); v++) {
			components[cc.id(v)].enqueue(v);
		}

		for (int i = 0; i < M; i++) {
			for (int v : components[i]) {
				System.out.print(sg.name(v) + " ");
			}
			System.out.println("\n");
		}
		long endtime = System.currentTimeMillis();
		System.out.println("CPU Time : "+ (endtime - startTime)+ " ms");
	}
}
