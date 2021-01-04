package lec38_Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import lec30_Heap.HeapGeneric;

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
		String color;
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

	public boolean DFS(int src, int dst) {
		HashMap<Integer, Boolean> visited = new HashMap<>();
//		Queue<Pair> queue =new LinkedList<>();
		LinkedList<Pair> stack = new LinkedList<>();

		Pair sp = new Pair();
		sp.vname = src;
		sp.psf = src + "";

		stack.addFirst(sp);

		while (!stack.isEmpty()) {
			Pair rp = stack.removeFirst();

			if (visited.containsKey(rp.vname)) {
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
					stack.addFirst(np);
				}
			}
		}

		return false;

	}

	public void BFT() {
		HashMap<Integer, Boolean> visited = new HashMap<>();
//		Queue<Pair> queue =new LinkedList<>();
		LinkedList<Pair> queue = new LinkedList<>();
		for (int src = 1; src < matrix.length; src++) {
			if (visited.containsKey(src)) {
				continue;
			}
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

				System.out.println(rp.vname + " via " + rp.psf);

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
		}

	}

	public void DFT() {
		HashMap<Integer, Boolean> visited = new HashMap<>();
//		Queue<Pair> queue =new LinkedList<>();
		LinkedList<Pair> stack = new LinkedList<>();
		for (int src = 1; src < matrix.length; src++) {
			if (visited.containsKey(src)) {
				continue;
			}
			Pair sp = new Pair();
			sp.vname = src;
			sp.psf = src + "";

			stack.addFirst(sp);

			while (!stack.isEmpty()) {
				Pair rp = stack.removeFirst();

				if (visited.containsKey(rp.vname)) {
					continue;
				}

				System.out.println(rp.vname + " via " + rp.psf);

				visited.put(rp.vname, true);

				for (int j = 1; j < matrix[0].length; j++) {
					if (matrix[rp.vname][j] != 0 && !visited.containsKey(j)) {
						Pair np = new Pair();
						np.vname = j;
						np.psf = rp.psf + j;
						stack.addFirst(np);
					}
				}
			}

		}

	}

	public boolean isConnected() {
		HashMap<Integer, Boolean> visited = new HashMap<>();
//		Queue<Pair> queue =new LinkedList<>();
		LinkedList<Pair> queue = new LinkedList<>();
		int count = 0;
		for (int src = 1; src < matrix.length; src++) {
			if (visited.containsKey(src)) {
				continue;
			}
			count++;
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

				System.out.println(rp.vname + " via " + rp.psf);

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
		}

		if (count > 1) {
			return false;
		}
		return true;

	}

	public boolean isCyclic() {
		HashMap<Integer, Boolean> visited = new HashMap<>();
//		Queue<Pair> queue =new LinkedList<>();
		LinkedList<Pair> queue = new LinkedList<>();
		for (int src = 1; src < matrix.length; src++) {
			if (visited.containsKey(src)) {
				continue;
			}
			Pair sp = new Pair();
			sp.vname = src;
			sp.psf = src + "";

			queue.addLast(sp);

			while (!queue.isEmpty()) {
				Pair rp = queue.removeFirst();

				if (visited.containsKey(rp.vname)) {
//				if we reach this block, then it is sure that there is a loop in the graph
					return true;
				}

				System.out.println(rp.vname + " via " + rp.psf);

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
		}
		return false;

	}

	public boolean isTree() {
		if (!this.isCyclic() && this.isConnected())
			return true;
		return false;
	}

	public ArrayList<ArrayList<Integer>> getConnectedComponents() {
		HashMap<Integer, Boolean> visited = new HashMap<>();
//		Queue<Pair> queue =new LinkedList<>();
		LinkedList<Pair> queue = new LinkedList<>();
		ArrayList<ArrayList<Integer>> all = new ArrayList<ArrayList<Integer>>();
		for (int src = 1; src < matrix.length; src++) {
			if (visited.containsKey(src)) {
				continue;
			}
			ArrayList<Integer> list = new ArrayList<>();
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

				list.add(rp.vname);

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
			all.add(list);
		}
		return all;

	}

	public boolean isBipartite() {
		HashMap<Integer, String> visited = new HashMap<>();
//		Queue<Pair> queue =new LinkedList<>();
		LinkedList<Pair> queue = new LinkedList<>();
		for (int src = 1; src < matrix.length; src++) {
			if (visited.containsKey(src)) {
				continue;
			}
			Pair sp = new Pair();
			sp.vname = src;
			sp.psf = src + "";
			sp.color = "R";

			queue.addLast(sp);

			while (!queue.isEmpty()) {
				Pair rp = queue.removeFirst();

				if (visited.containsKey(rp.vname)) {
//				if we reach this block, then it is sure that there is a loop in the graph
					if (!rp.color.equals(visited.get(rp.vname))) {
						return false;
					}
					continue;
				}

				System.out.println(rp.vname + " via " + rp.psf);

				visited.put(rp.vname, rp.color);

				for (int j = 1; j < matrix[0].length; j++) {
					if (matrix[rp.vname][j] != 0 && !visited.containsKey(j)) {
						Pair np = new Pair();
						np.vname = j;
						np.psf = rp.psf + j;
						np.color = rp.color.equals("R") ? "Y" : "R";
						queue.addLast(np);
					}
				}
			}
		}

		return true;

	}
	
	private class PrimsPair implements Comparable<PrimsPair>{
		int vname;
		int aqvname;
		int cost;
		@Override
		public int compareTo(PrimsPair o) {
			return o.cost-this.cost;
		}
	}
//	public Graph prims() {
//		Graph mst=new Graph(matrix.length-1);
//		HashMap<Integer,PrimsPair> map=new HashMap<Integer, Graph.PrimsPair>();
//		HeapGeneric<PrimsPair> heap=new HeapGeneric<>();
//		for(int i=1;i<matrix.length;i++) {
//			PrimsPair sp=new PrimsPair();
//			sp.vname=i;
//			sp.aqvname=0;
//			sp.cost=Integer.MAX_VALUE;
//			
//			heap.add(sp);
//			map.put(i, sp);
//		}
//		
//		while(!heap.isEmpty()) {
//			PrimsPair rp=heap.remove();
//			map.remove(rp);
//			for(int j=1;j<matrix.length;j++) {
//				if(matrix[rp.vname][j]!=0&&)
//			}
//		}
//	}
}
