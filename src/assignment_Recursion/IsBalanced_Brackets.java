package assignment_Recursion;

import java.util.Scanner;

public class IsBalanced_Brackets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(checkBalanced(str, 0, 0, 0, 0, 0, 0, 0));
//		cop=count of opening parantheses
//		coSB=count of opening Square Brackets
//		coCB=count of opening Curly Brackets
//		ccp=count of closing parantheses
//		ccSB=count of closing Square Brackets
//		ccCB=count of closing Curly Brackets

	}

	public static boolean checkBalanced(String str, int i, int cop, int coSB, int coCB, int ccp, int ccSB, int ccCB) {

		if (i == str.length()) {
			return true;
		}

		char ch = str.charAt(i);

		if (ch == '[' || ch == ']' || ch == '{' || ch == '}' || ch == '(' || ch == ')') {
			if (ch == '[') {
				return checkBalanced(str, i + 1, cop, coSB + 1, coCB, ccp, ccSB, ccCB);
			} else if (ch == ']') {
				if (cop != ccp || coCB != ccCB) {
					return false;
				} else {
					return checkBalanced(str, i + 1, cop, coSB, coCB, ccp, ccSB + 1, ccCB);
				}
			} else if (ch == '{') {
				return checkBalanced(str, i + 1, cop, coSB, coCB + 1, ccp, ccSB, ccCB);
			} else if (ch == '}') {
				if (cop != ccp) {
					return false;
				} else {
					return checkBalanced(str, i + 1, cop, coSB, coCB, ccp, ccSB, ccCB + 1);
				}
			} else if (ch == '(') {
				return checkBalanced(str, i + 1, cop + 1, coSB, coCB, ccp, ccSB, ccCB);
			} else {
				return checkBalanced(str, i + 1, cop, coSB, coCB, ccp + 1, ccSB, ccCB);
			}
		} else {
			return checkBalanced(str, i + 1, cop, coSB, coCB, ccp, ccSB, ccCB);
		}
	}

}
