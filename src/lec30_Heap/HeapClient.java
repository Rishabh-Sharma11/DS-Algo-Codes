package lec30_Heap;

public class HeapClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Heap heap = new Heap();
		heap.add(10);
		heap.add(2);
		heap.add(3);
		heap.add(25);
		heap.add(4);

		while (!heap.isEmpty()) {
			System.out.println(heap.remove());
		}

	}

}
