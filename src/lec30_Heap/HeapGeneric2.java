package lec30_Heap;

import java.util.ArrayList;
import java.util.Comparator;

public class HeapGeneric2<T> {
	ArrayList<T> data = new ArrayList<>();
	Comparator<T> comp;

	public HeapGeneric2(Comparator<T> comp) {
		this.comp = comp;
	}

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

		if (comp.compare(data.get(ci), data.get(pi)) > 0) {
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
		if (lci < data.size() && comp.compare(data.get(lci), data.get(mini)) > 0) {
			mini = lci;
		}
		if (rci < data.size() && comp.compare(data.get(rci), data.get(mini)) > 0) {
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
