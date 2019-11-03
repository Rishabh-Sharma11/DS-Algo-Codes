package lec19_StackAndQueue;

import lec18_oct8_dataStructures.DynamicStack;
import lec18_oct8_dataStructures.Stack;

public class DynamicStackClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Stack s=new DynamicStack();
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		s.push(50);
		s.push(60);
		s.push(70);
		s.push(80);
		s.display();
		System.out.println(s.pop());
		s.display();
		System.out.println(s.peek());
		s.display();

	}

}
