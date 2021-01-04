package lec38_Graph;

import java.util.HashMap;

public class GraphClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph graph = new Graph(7);

		graph.addEdge(1, 2, 10);
		graph.addEdge(2, 3, 20);
		graph.addEdge(1, 4, 30);
		graph.addEdge(3, 4, 78);
		graph.addEdge(4, 5, 90);
		graph.addEdge(5, 6, 67);
		graph.addEdge(6, 7, 23);
		graph.addEdge(5, 7, 89);
		
//		graph.display();
//		graph.printAllPaths(1, 6, new HashMap<Integer, Boolean>(), ""+1);
//		
//		System.out.println(graph.BFS(1, 6));
		
//		graph.BFT();
//		System.out.println(graph.getConnectedComponents());
		
		System.out.println(graph.isBipartite());
	}

}
