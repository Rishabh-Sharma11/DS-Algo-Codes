package lec8_sept7;

import java.util.ArrayList;

public class Intersection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] one = { 10, 20, 20, 30, 40, 40, 90, 90, 100 };
		int[] two = { 10, 15, 20, 20, 20, 30, 30, 40, 40, 40, 90, 200, 300 };
		System.out.println(intersection(one, two));

	}

	public static ArrayList<Integer> intersection(int[] one, int[] two) {
		ArrayList<Integer> ans = new ArrayList<>();
		int i = 0;
		int j = 0;
		while (i < one.length && j < two.length) {
			if (one[i] < two[j]) {
				i++;
			} else if (two[j] < one[i]) {
				j++;
			} else {
				ans.add(one[i]);
				i++;
				j++;
			}
		}

		return ans;
	}

}
