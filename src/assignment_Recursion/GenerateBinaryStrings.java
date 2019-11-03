package assignment_Recursion;

import java.util.Scanner;

public class GenerateBinaryStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for (int i = 0; i < t; i++) {
			String str = scn.next();
			binaryStrings(str, "", 0);
		}
	}

	public static void binaryStrings(String str, String ans, int vidx) {
		if (vidx == str.length()) {
			System.out.print(ans + " ");
			return;
		}

		char ch = str.charAt(vidx);
		if (ch == '?') {
			binaryStrings(str, ans + 0, vidx + 1);
			binaryStrings(str, ans + 1, vidx + 1);
		} else {
			binaryStrings(str, ans + ch, vidx + 1);
		}
	}

}
