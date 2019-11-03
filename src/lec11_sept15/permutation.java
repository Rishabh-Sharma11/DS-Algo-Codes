package lec11_sept15;

import java.util.ArrayList;
import java.util.Scanner;

public class permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		ArrayList<String> res = Permutation(str);
		System.out.println(res);

	}

	public static ArrayList<String> Permutation(String str) {
		//base case
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		// smaller problem
		ArrayList<String> rr = Permutation(ros);
		//self work
		ArrayList<String> mr = new ArrayList<>();
		for (String val : rr) {
			for (int i = 0; i <= val.length(); i++) {
				mr.add(val.substring(0, i) + ch + val.substring(i));
			}
		}
		return mr;
	}

}
