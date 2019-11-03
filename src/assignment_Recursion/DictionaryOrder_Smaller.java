package assignment_Recursion;

import java.util.Scanner;

public class DictionaryOrder_Smaller {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		dictionarySmall(str, str, "");

	}

	public static void dictionarySmall(String str, String ostr, String ans) {
		if (str.length() == 0) {
			if (ostr.compareTo(ans) > 0) {
				System.out.println(ans);
			}
			return;
		}
		for (int i = 0; i < str.length(); i++) {
			String ques = str.substring(0, i) + str.substring(i + 1);
			char ch = str.charAt(i);
//			if(ostr.compareTo(ans)>0) {
			dictionarySmall(ques, ostr, ans + ch);
//			}else {
//				return;
//			}
		}

	}

}
