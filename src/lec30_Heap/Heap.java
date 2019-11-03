package lec30_Heap;

import java.util.ArrayList;

public class Heap {
	ArrayList<Integer> data = new ArrayList<>();

	public int size() {
		return data.size();

	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public void add(int item) {
		data.add(item);
		upheapify(data.size() - 1);
	}

	private void upheapify(int ci) {
		int pi = (ci - 1) / 2;

		if (data.get(pi) > data.get(ci)) {
			swap(pi, ci);

			upheapify(pi);
		}
	}

	private void swap(int pi, int ci) {
		int temp = data.get(pi);
		data.set(pi, data.get(ci));
		data.set(ci, temp);
	}

	public int remove() {

		int temp = data.get(0);
		swap(0, size() - 1);
		data.remove(data.size() - 1);
		downheapify(0);
		return temp;
	}

	private void downheapify(int pi) {

		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;
		int mini = pi;
		if (lci < data.size() && data.get(lci) < data.get(mini)) {
			mini = lci;
		}
		if (rci < data.size() && data.get(rci) < data.get(mini)) {
			mini = rci;
		}
		if (pi != mini) {
			swap(pi, mini);
			downheapify(mini);
		}

	}
	public int get() {
		return data.get(0) ;
	}

}
