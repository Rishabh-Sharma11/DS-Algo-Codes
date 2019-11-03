package lec10_sept14_recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class RecursionGet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		ArrayList<String> res = getSS(str);
		System.out.println(res);
	}

	public static ArrayList<String> getSS(String str) { // getSubSequences
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);

		// smaller problem
		ArrayList<String> rr = getSS(ros);

		// self work
		ArrayList<String> mr = new ArrayList<>();

		for (String val : rr) {
			mr.add(val); // no
			mr.add(ch + val); // yes
		}

		return mr;
	}

}
