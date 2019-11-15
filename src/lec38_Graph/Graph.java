package lec38_Graph;

import java.util.HashMap;
import java.util.LinkedList;

public class Graph {

	int[][] matrix;

	public Graph(int v) {
		matrix = new int[v + 1][v + 1];
	}

	public void addEdge(int u, int v, int cost) {
		matrix[u][v] = cost;
		matrix[v][u] = cost;
	}

	public int removeEdge(int u, int v) {
		int temp = matrix[u][v];
		matrix[u][v] = 0;
		matrix[v][u] = 0;
		return temp;
	}

	public boolean containsEdge(int u, int v) {
		return matrix[u][v] != 0;
	}

	public int numEdges() {
		int count = 0;
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] != 0) {
					count++;
				}
			}
		}
		return count / 2;
	}

	public void display() {
		for (int i = 1; i < matrix.length; i++) {
			String str = i + " -> ";
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] != 0) {
					str += j + "@" + matrix[i][j] + ", ";
				}
			}
			System.out.println(str);
		}
	}

	public boolean hasPath(int src, int dst, HashMap<Integer, Boolean> visited) {
		if (src == dst) {
			return true;
		}
		visited.put(src, true);
		for (int j = 1; j < matrix[src].length; j++) {
			if (matrix[src][j] != 0 && !visited.containsKey(j)) {
				boolean res = hasPath(j, dst, visited);
				if (res) {
					return true;
				}

			}
		}
		return false;
	}

	public void printAllPaths(int src, int dst, HashMap<Integer, Boolean> visited, String ans) {
		if (src == dst) {
			System.out.println(ans);
			return;
		}
		visited.put(src, true);
		for (int j = 1; j < matrix[src].length; j++) {
			if (matrix[src][j] != 0 && !visited.containsKey(j)) {
				printAllPaths(j, dst, visited, ans + j);
			}
		}
		visited.remove(src); // Backtrack

	}

	private class Pair {
		int vname;
		String psf;
	}

	public boolean BFS(int src, int dst) {
		HashMap<Integer, Boolean> visited = new HashMap<>();
//		Queue<Pair> queue =new LinkedList<>();
		LinkedList<Pair> queue = new LinkedList<>();

		Pair sp = new Pair();
		sp.vname = src;
		sp.psf = src + "";

		queue.addLast(sp);

		while (!queue.isEmpty()) {
			Pair rp = queue.removeFirst();

			if (visited.containsKey(rp.vname)) {
//				if we reach this block, then it is sure that there is a loop in the graph
				continue;
			}

			if (rp.vname == dst) {
				System.out.println(rp.psf);
				return true;
			}

			visited.put(rp.vname, true);

			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[rp.vname][j] != 0 && !visited.containsKey(j)) {
					Pair np = new Pair();
					np.vname = j;
					np.psf = rp.psf + j;
					queue.addLast(np);
				}
			}
		}

		return false;

	}

}
