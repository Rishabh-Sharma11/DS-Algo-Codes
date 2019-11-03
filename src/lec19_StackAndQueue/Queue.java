package lec19_StackAndQueue;

public class Queue {
	protected int[] data;
	protected int size;
	protected int front;

	public Queue() {
		this.data = new int[5];
		this.size = 0;
		this.front = 0;
	}

	public Queue(int cap) {
		this.data = new int[cap];
		this.size = 0;
		this.front = 0;
	}

	public void enqueue(int item) throws Exception {
		if (isFull()) {
			throw new Exception("Queue is full");
		}
		int idx = (front + size) % data.length;
		data[idx] = item;
		size++;
	}

	public int dequeue() throws Exception {
		if (isEmpty()) {
			throw new Exception("Queue is empty");
		}
		int temp = data[front];
		data[front] = 0; // Not necessary
		front = (front + 1) % data.length;
		size--;
		return temp;
	}

	public int getfront() throws Exception {
		if (isEmpty()) {
			throw new Exception("Queue is empty");
		}
		return data[front];
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == data.length;
	}

	public void display() {
		for (int i = 0; i < size; i++) {
			int idx = (i + front) % data.length;
			System.out.print(data[idx] + " ");
		}
		System.out.println();
		System.out.println("--------------");
	}

}
