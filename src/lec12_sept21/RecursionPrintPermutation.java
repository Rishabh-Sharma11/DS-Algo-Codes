package lec12_sept21;

public class RecursionPrintPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printPermutation("abc", "");

	}

	public static void printPermutation(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = 0; i < ques.length(); i++) {
			char ch = ques.charAt(i);
			String roq = ques.substring(0, i) + ques.substring(i + 1);
			printPermutation(roq, ans + ch);
		}
	}

}
