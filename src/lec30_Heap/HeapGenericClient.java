package lec30_Heap;

import java.util.ArrayList;

import lec29_GenericFxn.IntegerComparator;

public class HeapGenericClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
		lists.add(new ArrayList<>());
		lists.add(new ArrayList<>());
		lists.add(new ArrayList<>());
		lists.add(new ArrayList<>());

		lists.get(0).add(5);
		lists.get(0).add(10);
		lists.get(0).add(15);
		lists.get(1).add(2);
		lists.get(1).add(7);
		lists.get(1).add(11);
		lists.get(1).add(14);
		lists.get(2).add(1);
		lists.get(2).add(6);
		lists.get(3).add(3);
		lists.get(3).add(8);
		lists.get(3).add(12);
		
		System.out.println(lists);
		mergeKSortedLists(lists);
		
		System.out.println();
		int[]arr= {5,12,16,20,40,3,60};
		KLargestElements(arr, 3);

	}

	private static class Pair implements Comparable<Pair> {
		int data;
		int lno;
		int idxno;

		@Override
		public int compareTo(Pair o) {
			return o.data - this.data;
		}
	}

	public static void mergeKSortedLists(ArrayList<ArrayList<Integer>> lists) {

		HeapGeneric<Pair> heap = new HeapGeneric<>();

		for (int i = 0; i < lists.size(); i++) {

//			if the class Pair would have not been static,then we would have needed to write this (bcz this fun is static):
//			HeapGenericClient hg=new HeapGenericClient();
//			Pair np=hg.new Pair();

			Pair np = new Pair();
			np.data = lists.get(i).get(0);
			np.lno = i;
			np.idxno = 0;
			heap.add(np);
		}

		while (!heap.isEmpty()) {
			Pair rp = heap.remove();
			System.out.print(rp.data + " ");
			if (rp.idxno < lists.get(rp.lno).size()-1) {
				rp.idxno++;
				rp.data=lists.get(rp.lno).get(rp.idxno);
				heap.add(rp);
			}
		}

	}
	
	public static void KLargestElements(int[] arr,int k) {
		HeapGeneric2<Integer> heap=new HeapGeneric2<>(new IntegerComparator());
		for(int i=0;i<k;i++) {
			heap.add(arr[i]);
		}
		
		for(int i=k;i<arr.length;i++) {
			int temp=heap.data.get(0);		//heap.get();
			if(arr[i]>temp) {
				heap.remove();
				heap.add(arr[i]);
			}
		}
		while(!heap.isEmpty()) {
			System.out.print(heap.remove()+" ");
		}
		
		
	}

}
