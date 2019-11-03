package lec8_sept7;

import java.util.ArrayList;

public class SumOfArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a1 = { 9, 9, 6, 5 };
		int[] a2 = { 9, 9 };
		System.out.println(sumOfArrays(a1, a2));

	}

	public static ArrayList<Integer> sumOfArrays(int[] one, int[] two) {
		ArrayList<Integer> ans = new ArrayList<>();
		int carry = 0;
		int i = one.length - 1;
		int j = two.length - 1;
		while (i >= 0 || j >= 0) {
			int sum = carry;
			if (i >= 0)
				sum += one[i];
			if (j >= 0)
				sum += two[j];

			ans.add(0, (sum % 10));
			carry = sum / 10;

			i--;
			j--;

		}
		if (carry != 0)
			ans.add(0, carry);

		return ans;
	}

}
