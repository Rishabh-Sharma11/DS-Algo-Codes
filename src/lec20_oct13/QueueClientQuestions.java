package lec20_oct13;

import lec19_StackAndQueue.DynamicQueue;
import lec19_StackAndQueue.Queue;

public class QueueClientQuestions {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Queue q=new DynamicQueue();
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		q.display();
		
		DisplayReverse(q, 0);
		System.out.println();
		q.display();
		System.out.println(" --Actual Reverse--");
		ActualReverse(q);
		
		q.display();

	}
	public static void DisplayReverse(Queue q,int count) throws Exception {
		if(count==q.size()) {
			return;
		}
		int n=q.dequeue();
		q.enqueue(n);
		DisplayReverse(q, count+1);
		System.out.print(n+" ");
		
		
	}
	public static void ActualReverse(Queue q) throws Exception {
		if (q.isEmpty()) {
			return;
		}

		int n = q.dequeue();

		ActualReverse(q);
		q.enqueue(n);
	}
	

}
