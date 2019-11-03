package assignment_stackQueueAndLL;

import java.util.Scanner;

public class HoodiesAtCodingBlocks {

	class Queue {

		protected int size;

		protected int front;
		protected Pair[] data;

		public Queue() {
			this.size = 0;
			this.front = 0;
			this.data = new Pair[5];
		}

		public Queue(int cap) {
			this.size = 0;
			this.front = 0;
			this.data = new Pair[cap];
		}

		public int size() {
			return size;
		}

		public boolean isEmpty() {
			return (size == 0);
		}

		public void enqueue(Pair item) throws Exception {
			if (this.size() == this.data.length) {
				Pair[] oa = this.data;
				Pair[] na = new Pair[oa.length * 2];
				for (int i = 0; i < this.size(); i++) {
					int idx = (i + front) % oa.length;
					na[i] = oa[idx];
				}

				this.data = na;
				this.front = 0;
			}

			// if (this.size == this.data.length) {
			// throw new Exception("queue is full");
			// }

			this.data[(front + size) % this.data.length] = item;
			size++;

		}

		public Pair dequeue() throws Exception {
			if (this.size == 0) {
				throw new Exception("queue is empty");

			}

			Pair rv = this.data[front];
			front = (front + 1) % this.data.length;
			size--;

			return rv;

		}

		public Pair getFront() throws Exception {
			if (this.size == 0) {
				throw new Exception("queue is empty");
			}

			Pair rv = this.data[front];

			return rv;
		}

		public void display() {
			System.out.println();
			for (int i = 0; i < size; i++) {
				int idx = (i + front) % this.data.length;
				System.out.print(this.data[idx] + " ");
			}
			System.out.print("END");
		}
	}

	private class Pair {
		int course;
		int rno;
	}

	public static void hoodies(int q) throws Exception {

		// Write your Code here
		HoodiesAtCodingBlocks obj = new HoodiesAtCodingBlocks();
		Queue queue = obj.new Queue();
		Queue helper = obj.new Queue();
		for (int i = 0; i < q; i++) {
			char ch = scn.next().charAt(0);
			if (ch == 'E') {
				int course = scn.nextInt();
				int rno = scn.nextInt();
				Pair np=obj.new Pair();
				np.course=course;
				np.rno=rno;
				int nof = 0;
				while (!queue.isEmpty()) {
					Pair rp = queue.dequeue();
					if (rp.course == course) {
						nof++;
					}
					helper.enqueue(rp);
				}
				if (nof == 0) {
					while (!helper.isEmpty())
						queue.enqueue(helper.dequeue());
					queue.enqueue(np);
				}else {
					while(!helper.isEmpty()) {
						Pair rp=helper.dequeue();
						queue.enqueue(rp);
						if(rp.course==course) {
							nof--;
							if(nof==0) {
								queue.enqueue(np);
							}
						}
					}
				}

			} else if (ch == 'D') {
				Pair rp = queue.dequeue();
				System.out.print(rp.course + " " + rp.rno);
				System.out.println();
			}
		}

	}

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {

		int n = scn.nextInt();

		hoodies(n);
	}

}
