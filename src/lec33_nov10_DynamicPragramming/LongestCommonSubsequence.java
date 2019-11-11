package lec33_nov10_DynamicPragramming;

import java.util.Arrays;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s1 = "abcd";
		String s2 = "agcfd";
//		System.out.println(LCS(s1,s2));

		int[][] storage = new int[s1.length() + 1][s2.length() + 1];
		for (int[] val : storage) {
			Arrays.fill(val, -1); // 0 not stored because it could be the result of some recursive call
		}

		System.out.println(LCS_TopDown(s1, s2, storage));

		System.out.println(LCS_BottomUp(s1, s2));

	}

	public static int LCS(String s1, String s2) {
		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		int ans = 0;
		if (ch1 == ch2) {
			ans = LCS(ros1, ros2) + 1;
		} else {
			int r1 = LCS(s1, ros2);
			int r2 = LCS(ros1, s2);
			ans = Math.max(r1, r2);
		}

		return ans;
	}

	public static int LCS_TopDown(String s1, String s2, int[][] storage) {
		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}

		if (storage[s1.length()][s2.length()] != -1) {
			return storage[s1.length()][s2.length()];
		}

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		int ans = 0;
		if (ch1 == ch2) {
			ans = LCS(ros1, ros2) + 1;
		} else {
			int r1 = LCS_TopDown(s1, ros2, storage);
			int r2 = LCS_TopDown(ros1, s2, storage);
			ans = Math.max(r1, r2);
		}

		storage[s1.length()][s2.length()] = ans;

		return ans;
	}

	public static int LCS_BottomUp(String s1, String s2) {
		int[][] storage = new int[s1.length() + 1][s2.length() + 1];

		for (int row = s1.length() - 1; row >= 0; row--) {

			for (int col = s2.length() - 1; col >= 0; col--) {

				if (s1.charAt(row) == s2.charAt(col)) {

					storage[row][col] = storage[row + 1][col + 1] + 1;

				} else {

					int n1 = storage[row][col + 1];
					int n2 = storage[row + 1][col];
					storage[row][col] = Math.max(n1, n2);
				}
			}
		}
		return storage[0][0];
	}

}
