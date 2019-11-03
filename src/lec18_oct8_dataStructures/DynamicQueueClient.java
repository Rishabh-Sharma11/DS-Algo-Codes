package lec18_oct8_dataStructures;

import lec19_StackAndQueue.DynamicQueue;
import lec19_StackAndQueue.Queue;

public class DynamicQueueClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Queue q=new DynamicQueue();
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		q.display();
		q.enqueue(60);
		q.enqueue(70);
		q.enqueue(80);
		
		System.out.println(q.dequeue());
		q.display();
		System.out.println(q.dequeue());
		q.display();
		q.enqueue(90);
		q.enqueue(100);
		q.display();
		System.out.println(q.isFull());
		System.out.println(q.getfront());

	}

}
