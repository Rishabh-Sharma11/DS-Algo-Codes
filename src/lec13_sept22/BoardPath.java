package lec13_sept22;

public class BoardPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(boardPath(10, 0, ""));

	}

	public static int boardPath(int end, int curr, String ans) {
		if (curr == end) {
			System.out.println(ans);
			return 1;
		}
		if (curr > end) {
			return 0;
		}
		int c = 0;
		for (int dice = 1; dice <= 6; dice++) {
			c += boardPath(end, curr + dice, ans + dice);
		}
		return c;
	}

}
