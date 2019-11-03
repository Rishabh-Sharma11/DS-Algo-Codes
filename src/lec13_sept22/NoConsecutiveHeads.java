package lec13_sept22;

public class NoConsecutiveHeads {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		noconsecutiveHeads(n, "");

	}

	public static void noconsecutiveHeads(int n, String ans) {
		if (n == 0) {
			System.out.println(ans);
			return;
		}

		if (ans.length() == 0 || ans.charAt(ans.length() - 1) != 'H') {
			noconsecutiveHeads(n - 1, ans + 'H');
		}
		noconsecutiveHeads(n - 1, ans + 'T');
	}

}
