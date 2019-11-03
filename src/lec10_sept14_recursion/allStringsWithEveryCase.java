package lec10_sept14_recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class allStringsWithEveryCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		ArrayList<String> res = listOfCases(str);
		System.out.println(res);
	}

	public static ArrayList<String> listOfCases(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> rr = listOfCases(ros);

		ArrayList<String> mr = new ArrayList<>();

//		for (String val : rr) {	
//			mr.add(ch + val);
//			if (Character.isLowerCase(ch)) {
//				mr.add(Character.toUpperCase(ch) + val);
//			} else if (Character.isUpperCase(ch)) {
//				mr.add(Character.toLowerCase(ch) + val);
//			}
//		}

		if (Character.isDigit(ch)) {
			for (String val : rr) {
				mr.add(ch + val);
			}
		} else {
			for (String val : rr) {
				mr.add(Character.toLowerCase(ch) + val);
				mr.add(Character.toUpperCase(ch) + val);
			}
		}

		return mr;

	}

}
