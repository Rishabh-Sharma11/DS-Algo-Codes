package lec33_nov10_DynamicPragramming;

import java.util.Arrays;

public class Edit_Distance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "abcda;sdufa";
		String s2 = "agcfdasudfasli";
//		System.out.println(EditDistance(s1, s2));
//		System.out.println(EditDistance("Saturday", "Sunday"));

		int[][] storage = new int[s1.length() + 1][s2.length() + 1]; // fill -1
		for (int[] val : storage) {
			Arrays.fill(val, -1);
		}
		System.out.println(EditDistanceTD(s1, s2, storage));

		System.out.println(EditDistanceBU(s1, s2));

	}

	public static int EditDistance(String s1, String s2) {
		if (s1.length() == 0 || s2.length() == 0) {
			return Math.max(s1.length(), s2.length());
		}

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		int ans = 0;
		if (ch1 == ch2) {
			ans = EditDistance(ros1, ros2);
		} else {
			int i = EditDistance(ros1, s2);
			int d = EditDistance(s1, ros2);
			int r = EditDistance(ros1, ros2);
			ans = Math.min(r, Math.min(i, d)) + 1;
		}

		return ans;

	}

	public static int EditDistanceTD(String s1, String s2, int[][] storage) {
		if (s1.length() == 0 || s2.length() == 0) {
			return Math.max(s1.length(), s2.length());
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
			ans = EditDistance(ros1, ros2);
		} else {
			int i = EditDistanceTD(ros1, s2, storage);
			int d = EditDistanceTD(s1, ros2, storage);
			int r = EditDistanceTD(ros1, ros2, storage);
			ans = Math.min(r, Math.min(i, d)) + 1;
		}

		storage[s1.length()][s2.length()] = ans;

		return ans;
	}

	public static int EditDistanceBU(String s1, String s2) {
		int[][] storage = new int[s1.length() + 1][s2.length() + 1];
		for (int row = s1.length(); row >= 0; row--) {
			for (int col = s2.length(); col >= 0; col--) {

				if (row == s1.length()) {
					storage[row][col] = s2.length() - col;
					continue;
				}

				if (col == s2.length()) {
					storage[row][col] = s1.length() - row;
					continue;
				}

				if (s1.charAt(row) == s2.charAt(col)) {
					storage[row][col] = storage[row + 1][col + 1];
				} else {
					int i = storage[row + 1][col];
					int d = storage[row][col + 1];
					int r = storage[row + 1][col + 1];
					storage[row][col] = Math.min(r, Math.min(i, d)) + 1;
				}

			}

		}

		return storage[0][0];

	}

}
