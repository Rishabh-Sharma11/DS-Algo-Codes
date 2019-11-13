package lec33_nov10_DynamicPragramming;

public class Wildcard_Matching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String src = "abcdaea";
		String pattern = "a?**a";
		System.out.println(WildcardMatching(src, pattern));
		System.out.println(WildcardMatchingTD(src, pattern, new int[src.length() + 1][pattern.length() + 1]));
		System.out.println(WildcardMatchingBU(src, pattern));

	}

	public static boolean WildcardMatching(String src, String pat) {

		if (src.length() == 0 && pat.length() == 0) {
			return true;
		}
		if (src.length() != 0 && pat.length() == 0) {
			return false;
		}
		if (src.length() == 0 && pat.length() != 0) {
			for (int i = 0; i < pat.length(); i++) {
				if (pat.charAt(i) != '*') {
					return false;
				}
			}
			return true;
		}

		char chs = src.charAt(0);
		char chp = pat.charAt(0);
		String ros = src.substring(1);
		String rop = pat.substring(1);
		boolean ans;
		if (chp == chs || chp == '?') {
			ans = WildcardMatching(ros, rop);
		} else if (chp == '*') {
			ans = WildcardMatching(src, rop) || WildcardMatching(ros, pat);
		} else {
			ans = false;
		}

		return ans;
	}

	public static boolean WildcardMatchingTD(String src, String pat, int[][] storage) {

		if (src.length() == 0 && pat.length() == 0) {
			return true;
		}
		if (src.length() != 0 && pat.length() == 0) {
			return false;
		}
		if (src.length() == 0 && pat.length() != 0) {
			for (int i = 0; i < pat.length(); i++) {
				if (pat.charAt(i) != '*') {
					return false;
				}
			}
			return true;
		}

		if (storage[src.length()][pat.length()] != 0) {
			return storage[src.length()][pat.length()] == 2 ? true : false;
		}

		char chs = src.charAt(0);
		char chp = pat.charAt(0);
		String ros = src.substring(1);
		String rop = pat.substring(1);
		boolean ans;
		if (chp == chs || chp == '?') {
			ans = WildcardMatchingTD(ros, rop, storage);
		} else if (chp == '*') {
			ans = WildcardMatchingTD(src, rop, storage) || WildcardMatchingTD(ros, pat, storage);
		} else {
			ans = false;
		}

		storage[src.length()][pat.length()] = (ans == true ? 2 : 1);

		return ans;
	}

	public static boolean WildcardMatchingBU(String src, String pat) {
		boolean[][] storage = new boolean[src.length() + 1][pat.length() + 1];
		storage[src.length()][pat.length()] = true;
		for (int row = src.length(); row >= 0; row--) {
			for (int col = pat.length() - 1; col >= 0; col--) {

				char chp = pat.charAt(col);

				if (row == src.length()) {
					if (chp == '*') {
						storage[row][col] = storage[row][col + 1];
					} else {
						storage[row][col] = false;
					}
					continue;
				}

				char chs = src.charAt(row);

				boolean ans;
				if (chp == chs || chp == '?') {
					ans = storage[row + 1][col + 1];
				} else if (chp == '*') {
					ans = storage[row][col + 1] || storage[row + 1][col];
				} else {
					ans = false;
				}

				storage[row][col] = ans;

			}
		}
		return storage[0][0];
	}

}
