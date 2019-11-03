package lec8_sept7;

import java.util.Scanner;

public class StringOps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
//		System.out.println(checkPalindrome(str));
//		subStrings(str);
		System.out.println(CountPalindromeSubString(str));

	}

	public static boolean checkPalindrome(String str) {
		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	public static void subStrings(String str) {
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				System.out.println(str.substring(i, j));
			}
		}
	}

	public static int CountPalindromeSubString(String str) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				String subString = str.substring(i, j);
				boolean check;
				check = checkPalindrome(subString);
				if (check)
					count++;

			}
		}
		return count;
	}

}
