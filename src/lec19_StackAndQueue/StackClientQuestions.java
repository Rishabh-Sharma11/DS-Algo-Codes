package lec19_StackAndQueue;

import lec18_oct8_dataStructures.DynamicStack;
import lec18_oct8_dataStructures.Stack;

public class StackClientQuestions {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Stack s = new DynamicStack();
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		System.out.println(" --Display Reverse--");
		DisplayReverse(s);
		System.out.println("\n --Actual Stack--");
		s.display();
		actualReverse(s, new DynamicStack());
		System.out.println(" --Actual Reverse-- ");
		s.display();

		System.out.println(" --Next Greater Element--");
		int[] arr = { 50, 20, 10, 40, 30, 60, 15, 12 };
		nextGreaterElement(arr);
		System.out.println("\n --orderedNextGreaterElement--");
		int[] ans = orderedNextGreaterElement(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + " -> " + ans[i]);
		}
		System.out.println("\n --Stock Span--");
		int[]arr2= {90,60,15,70,45,25,50,100,5,30,80};
		int[] res = Stock_Span(arr2);
		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i] + " -> " + res[i]);
		}

	}

	public static void DisplayReverse(Stack s) throws Exception {
		if (s.isEmpty()) {
			return;
		}

		int n = s.pop();

		DisplayReverse(s);
		System.out.print(n + " ");
		s.push(n);

	}

	public static void actualReverse(Stack s, Stack helper) throws Exception {
		if (s.isEmpty()) {
			actualReversehelper(s, helper);
			return;
		}

		int n = s.pop();
		helper.push(n);
		actualReverse(s, helper);
	}

	public static void actualReversehelper(Stack s, Stack helper) throws Exception {
		if (helper.isEmpty()) {
			return;
		}

		int temp = helper.pop();
		actualReversehelper(s, helper);
		s.push(temp);
	}

	public static void nextGreaterElement(int[] arr) {
		java.util.Stack<Integer> s = new java.util.Stack<Integer>();
		for (int i = 0; i < arr.length; i++) {
			while (!s.isEmpty() && arr[i] > s.peek()) {
				System.out.println(s.pop() + " -> " + arr[i]);
			}
			s.push(arr[i]);
		}
		while (!s.isEmpty()) {
			System.out.println(s.pop() + " -> " + (-1));
		}

	}

	public static int[] orderedNextGreaterElement(int[] arr) {
		int[] ans = new int[arr.length];
		java.util.Stack<Integer> s = new java.util.Stack<Integer>();
		for (int i = 0; i < arr.length; i++) {
			while (!s.isEmpty() && arr[i] > arr[s.peek()]) {
				ans[s.pop()] = arr[i];
			}

			s.push(i);
		}
		while (!s.isEmpty()) {
			ans[s.pop()] = -1;

		}

		return ans;
	}

	public static int[] Stock_Span(int[] arr) {
		int[] ans = new int[arr.length];
		java.util.Stack<Integer> s = new java.util.Stack<Integer>();
		for (int i = 0; i < arr.length; i++) {
			while (!s.isEmpty() && arr[i] > arr[s.peek()]) {
				s.pop();
			}
			if (s.isEmpty()) {
				ans[i] = i + 1;
			} else {
				ans[i] =  i-s.peek() ;
			}

			s.push(i);
		}

		return ans;
	}

}
