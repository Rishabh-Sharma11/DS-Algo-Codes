package assignment_stackQueueAndLL;

import java.util.LinkedList;
import java.util.Scanner;

public class SumOfTwoLinkedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		LinkedList<Integer> llone = new LinkedList<>();
		LinkedList<Integer> lltwo = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			llone.addLast(scn.nextInt());
		}
		for (int i = 0; i < m; i++) {
			lltwo.addLast(scn.nextInt());
		}
		LinkedList<Integer> sum = SumOfLL(llone, lltwo, new LinkedList<>(), 0);
		while (sum.size() != 0) {
			System.out.print(sum.removeFirst() + " ");
		}
		
//		input:
//			3 3
//			5 6 3
//			8 4 2
	}

	private static LinkedList<Integer> SumOfLL(LinkedList<Integer> llone, LinkedList<Integer> lltwo,
			LinkedList<Integer> ans, int carry) {

		if (llone.size() != 0 && lltwo.size() != 0) {
			int n1 = llone.removeLast();
			int n2 = lltwo.removeLast();
			int nsum = n1 + n2 + carry;

			if (nsum <= 9) {
				ans.addFirst(nsum);
				carry = 0;
			} else {
				ans.addFirst(nsum % 10);
				carry = nsum / 10;
			}

			ans = SumOfLL(llone, lltwo, ans, carry);

			llone.addLast(n1);
			lltwo.addLast(n2);

		} else if (llone.size() == 0 && lltwo.size() != 0) {
			int n2 = lltwo.removeLast();
			ans.addFirst(n2);

			ans = SumOfLL(llone, lltwo, ans, 0);

			lltwo.addLast(n2);

		} else if (lltwo.size() == 0 && llone.size() != 0) {
			int n1 = llone.removeLast();
			ans.addFirst(n1);

			ans = SumOfLL(llone, lltwo, ans, 0);

			llone.addLast(n1);
		} else {
			if (carry != 0)
				ans.addFirst(carry);
		}
		return ans;

	}

}
