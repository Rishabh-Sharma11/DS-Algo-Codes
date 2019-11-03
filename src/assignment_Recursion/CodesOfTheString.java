package assignment_Recursion;

import java.util.ArrayList;
//import java.util.Scanner;

public class CodesOfTheString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner scn = new Scanner(System.in);
//		String str = scn.next();
//		System.out.println(getCodesOfTheString(str));
		System.out.println(getCodesOfTheString("1127"));

	}

	public static ArrayList<String> getCodesOfTheString(String str) {

		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char p1 = str.charAt(0);
		String ros1 = str.substring(1);
		String code1 = code(p1 + "");
		ArrayList<String> rr1 = getCodesOfTheString(ros1);

		ArrayList<String> mr = new ArrayList<>();

		for (String val : rr1) {
			mr.add(code1 + val);
		}
		if (str.length() > 1) {
			String p2 = str.substring(0, 2);
			if (Integer.parseInt(p2) > 26) {
				return mr;
			}
			String ros2 = str.substring(2);
			String code2 = code(p2);
			ArrayList<String> rr2 = getCodesOfTheString(ros2);
			for (String val : rr2) {
				mr.add(code2 + val);
			}
		}
		return mr;

	}

	public static String code(String s) {
		switch (s) {
		case "1":
			return "a";
		case "2":
			return "b";
		case "3":
			return "c";
		case "4":
			return "d";
		case "5":
			return "e";
		case "6":
			return "f";
		case "7":
			return "g";
		case "8":
			return "h";
		case "9":
			return "i";
		case "10":
			return "j";
		case "11":
			return "k";
		case "12":
			return "l";
		case "13":
			return "m";
		case "14":
			return "n";
		case "15":
			return "o";
		case "16":
			return "p";
		case "17":
			return "q";
		case "18":
			return "r";
		case "19":
			return "s";
		case "20":
			return "t";
		case "21":
			return "u";
		case "22":
			return "v";
		case "23":
			return "w";
		case "24":
			return "x";
		case "25":
			return "y";
		case "26":
			return "z";
		default:
			return "";
		}
	}

}
