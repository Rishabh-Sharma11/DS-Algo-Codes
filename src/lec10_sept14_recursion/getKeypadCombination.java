package lec10_sept14_recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class getKeypadCombination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		ArrayList<String> res = getKPC(str, 0);
		System.out.println(res);
	}

	public static String getCode(char ch) {
		if (ch == '1')
			return "abc";
		else if (ch == '2')
			return "def";
		else if (ch == '3')
			return "ghi";
		else if (ch == '4')
			return "jk";
		else if (ch == '5')
			return "lmno";
		else if (ch == '6')
			return "pqr";
		else if (ch == '7')
			return "stu";
		else if (ch == '8')
			return "vwx";
		else if (ch == '9')
			return "yz";
		else if (ch == '0')
			return "@#";
		else
			return "";
	}

	public static ArrayList<String> getKPC(String str, int count) {

		if (count == str.length()) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);
		String code = getCode(str.charAt(count));
		ArrayList<String> rr = getKPC(str, count + 1);
		ArrayList<String> mr = new ArrayList<>();

		for (int i = 0; i < code.length(); i++) {
			for (String val : rr) {
				mr.add(code.charAt(i) + val);

			}
		}

		return mr;

	}

}
