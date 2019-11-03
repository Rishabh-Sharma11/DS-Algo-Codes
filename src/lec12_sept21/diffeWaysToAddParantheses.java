package lec12_sept21;

import java.util.ArrayList;
import java.util.Scanner;

public class diffeWaysToAddParantheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		ArrayList<Integer> res = DiffWaysForParantheses(str);
		System.out.println(res);

	}

	public static ArrayList<Integer> DiffWaysForParantheses(String str) {
		// TODO Auto-generated method stub
		ArrayList<Integer> mr = new ArrayList<>();
		for (int i = 0; i < str.length(); i++) {
			String p1 = str.substring(0, i);
			String p2 = str.substring(i + 1);

			char ch = str.charAt(i);

			if (ch == '+' || ch == '-' || ch == '*') {

				ArrayList<Integer> rr1 = DiffWaysForParantheses(p1);
				ArrayList<Integer> rr2 = DiffWaysForParantheses(p2);

				for (int val1 : rr1) {
					for (int val2 : rr2) {
						if (ch == '+') {
							mr.add(val1 + val2);
						} else if (ch == '-') {
							mr.add(val1 - val2);
						} else {
							mr.add(val1 * val2);
						}
					}
				}
			}

		}

		if (mr.size() == 0) {
			mr.add(Integer.parseInt(str));
		}
		return mr;
	}

}
