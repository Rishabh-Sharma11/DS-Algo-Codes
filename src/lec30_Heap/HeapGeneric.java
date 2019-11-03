package lec30_Heap;

import java.util.ArrayList;

public class HeapGeneric <T extends Comparable<T>>{
	ArrayList<T> data = new ArrayList<>();

	public int size() {
		return data.size();
		
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public void add(T item) {
		data.add(item);
		upheapify(data.size() - 1);
	}

	private void upheapify(int ci) {
		int pi = (ci - 1) / 2;

		if (data.get(ci).compareTo(data.get(pi))>0) {		//this line works(swapping occurs) if priority of ci is greater
			swap(pi, ci);
			upheapify(pi);
		}
	}

	private void swap(int pi, int ci) {
		T temp = data.get(pi);
		data.set(pi, data.get(ci));
		data.set(ci, temp);
	}

	public T remove() {

		T temp = data.get(0);
		swap(0, size() - 1);
		data.remove(data.size() - 1);
		downheapify(0);
		return temp;
	}

	private void downheapify(int pi) {

		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;
		int mini = pi;
		if (lci < data.size() && data.get(lci).compareTo(data.get(mini))>0) {		//this line works if priority of lci is greater
			mini = lci;
		}
		if (rci < data.size() && data.get(rci).compareTo(data.get(mini))>0) {		//this line works if priority of rci is greater
			mini = rci;
		}
		if (pi != mini) {
			swap(pi, mini);
			downheapify(mini);
		}

	}
	public T get() {
		return data.get(0) ;
	}

}
