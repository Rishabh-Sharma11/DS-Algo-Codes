package lec14_sept29Backtracking;

public class QueenPermutation1D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int tq = 2, qpsf = 0, nob = 4;
		boolean[] boxes = new boolean[nob];
		System.out.println(QueenPermutation(boxes, tq, qpsf, "", 0));
	}

	public static int QueenPermutation(boolean[] boxes, int tq, int qpsf, String ans, int count) {
		if (qpsf == tq) {
			System.out.println(++count + ". " + ans);
			return count;
		}
		for (int i = 0; i < boxes.length; i++) {
			if (boxes[i] == false) {
				boxes[i] = true;
				count = QueenPermutation(boxes, tq, qpsf + 1, ans + "q" + qpsf + "b" + i, count);
				boxes[i] = false;
			}
		}
		return count;
	}

}
