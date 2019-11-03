package lec13_sept22;

public class PalindromePartitioning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		palindromePartitioning("nitin", "");

	}

	public static void palindromePartitioning(String str, String ans) {
		if (str.length() == 0) {
			System.out.println(ans);
			return;
		}
		for (int i = 1; i <= str.length(); i++) {
			String part = str.substring(0, i);
			String ros = str.substring(i);
			if (isPalindrome(part)) {
				palindromePartitioning(ros, ans + part + " ");
			}
		}

	}

	public static boolean isPalindrome(String str) {
		int i = 0, j = str.length() - 1;
		while (i <= j) {
			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

}
