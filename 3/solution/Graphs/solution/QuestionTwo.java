package solution;

import graphs.DijkstraSP;
import graphs.DirectedEdge;
import graphs.Edge;
import graphs.EdgeWeightedDigraph;
import graphs.EdgeWeightedGraph;
import graphs.In;
import graphs.KruskalMST;
import graphs.StdOut;

public class QuestionTwo {

	public static void main(String[] args) {

		EdgeWeightedDigraph graph = new EdgeWeightedDigraph(new In("graphs/largeEWG.txt"));

		int source = 0;

		DijkstraSP sp = new DijkstraSP(graph, source);

		long startTime = System.currentTimeMillis();
		long avgTime = 0L;
		for (int i = 0; i < graph.V(); i++) {

			if (sp.hasPathTo(i)) {
				   StdOut.printf("%d to %d (%.3f)  \n", source, i, sp.distTo(i));
				for (DirectedEdge e : sp.pathTo(i)) {
					System.out.println("      "+e + "   ");
				}
			} else {
				StdOut.printf("%d to %d         no path\n", source, i);
			}
		}
		long endTime = System.currentTimeMillis();
		long timeTaken = endTime - startTime;
		avgTime += timeTaken;
		System.out.println("CPU time: "+ timeTaken+" ms");
		//395145 	//200079	//395146
		//15786		//200079
		//53370		//310931
		//54517		//339430
		//128999	//359324
		//157440	//380102
		System.out.println("------------------------------------------------------------");
		
        EdgeWeightedGraph graph1 = new EdgeWeightedGraph(new In("graphs/largeEWG.txt"));
        KruskalMST ms = new KruskalMST(graph1);
         avgTime = 0L;
         startTime = System.currentTimeMillis();
       
		for (Edge e : ms.edges()) {
            StdOut.println(e);
        }
		
        StdOut.printf("sum of the edge weights: %.5f\n", ms.weight());
        endTime = System.currentTimeMillis();
		timeTaken = endTime - startTime;
		avgTime += timeTaken;
		System.out.println("CPU time: "+ timeTaken+" ms");
	}

}
