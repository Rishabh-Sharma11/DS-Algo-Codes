package DoubtResolvingSession;

import lec10_sept14_recursion.getKeypadCombination;

public class RecursionPrintPalindromicPartitioning {
	public static void main(String[] args) {
		// printSS("abc", "");
		// System.out.println(printKPC("145", ""));
		// System.out.println(count);
		// printPermutation2("abc", "");
		// coinToss(3, "");
		// validParenthesis(2, "", 0, 0);
		// System.out.println(boardPath(0, 10, ""));
		// System.out.println(mazePath(0, 0, 2, 2, ""));

		// lexicoCounting(0, 1000);

		palindromePartitioning("nitin", "");
		// palindromePartitioning("nitin", "");

		coinTossNoConsecutiveHead(3, "", false);

	}

	public static void printSS(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}
		char ch = ques.charAt(0);
		String roq = ques.substring(1);
		printSS(roq, ans); // no
		printSS(roq, ans + ch); // yes
	}
	static int count = 0;

	// Q : https://leetcode.com/problems/letter-combinations-of-a-phone-number/
	

	public static void printKPC(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}
		char ch = ques.charAt(0);
		String roq = ques.substring(1);
		String code = getKeypadCombination.getCode(ch);
		for (int i = 0; i < code.length(); i++) {
			printKPC(roq, ans + code.charAt(i));
		}
	}
	public static void printPermutation(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}
		for (int i = 0; i < ques.length(); i++) {
			char ch = ques.charAt(i);
			String roq = ques.substring(0, i) + ques.substring(i + 1);
			printPermutation(roq, ans + ch);
		}
	}
	public static void printPermutation2(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}
		char ch = ques.charAt(0);
		String roq = ques.substring(1);
		for (int i = 0; i <= ans.length(); i++) {
			printPermutation2(roq, ans.substring(0, i) + ch + ans.substring(i));
		}
	}
	public static void coinToss(int n, String ans) {
		if (n == 0) {
			System.out.println(ans);
			return;
		}
		coinToss(n - 1, ans + "H");
		coinToss(n - 1, ans + "T");

	}

	public static void coinTossNoConsecutiveHead(int n, String ans, boolean wasLastHead) {

		if (n == 0) {
			System.out.println(ans);
			return;
		}

		if (wasLastHead) {
			coinTossNoConsecutiveHead(n - 1, ans + "T", false);
		} else {
			coinTossNoConsecutiveHead(n - 1, ans + "H", true);
			coinTossNoConsecutiveHead(n - 1, ans + "T", false);
		}
	}

	// Q : https://leetcode.com/problems/generate-parentheses/

	public static void validParenthesis(int n, String ans, int open, int close) {
		if (open == n && close == n) {
			System.out.println(ans);
			return;
		}
		if (open > n || close > n || close > open) {
			return;
		}
		validParenthesis(n, ans + "(", open + 1, close);
		validParenthesis(n, ans + ")", open, close + 1);
	}
	public static int boardPath(int curr, int end, String ans) {
		if (curr == end) {
			System.out.println(ans);
			return 1;
		}
		if (curr > end) {
			return 0;
		}
		int c = 0;
		// if (curr == 0) {
		// c += boardPath(curr + 1, end, ans + 1);
		// c += boardPath(curr + 6, end, ans + 6);
		// } else {
		for (int dice = 1; dice <= 6; dice++) {
			c += boardPath(curr + dice, end, ans + dice);
		}
		// }
		return c;
	}
	public static int mazePath(int cr, int cc, int er, int ec, String ans) {
		if (cr == er && cc == ec) {
			System.out.println(ans);
			return 1;
		}
		if (cr > er || cc > ec) {
			return 0;
		}
		int ch = mazePath(cr, cc + 1, er, ec, ans + "H");
		int cv = mazePath(cr + 1, cc, er, ec, ans + "V");
		return ch + cv;
	}
	public static void lexicoCounting(int curr, int end) {
		if (curr > end) {
			return;
		}
		System.out.println(curr);
		int i = 0;
		if (curr == 0) {
			i = 1;
		}
		while (i < 10) {
			lexicoCounting(curr * 10 + i, end);
			i++;
		}
	}

	// Q : https://leetcode.com/problems/palindrome-partitioning/
	

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
		int i = 0;
		int j = str.length() - 1;
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
