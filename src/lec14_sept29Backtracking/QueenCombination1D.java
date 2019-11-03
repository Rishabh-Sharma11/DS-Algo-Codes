package lec14_sept29Backtracking;

public class QueenCombination1D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(QueenCombination(new boolean[4], 2, 0, "", -1, 0));
	}

	public static int QueenCombination(boolean[] boxes, int tq, int qpsf, String ans, int lastBoxUsed, int count) {
		if (qpsf == tq) {
			System.out.println(++count + ". " + ans);
			return count;
		}
		for (int i = lastBoxUsed + 1; i < boxes.length; i++) {

			boxes[i] = true;
			count = QueenCombination(boxes, tq, qpsf + 1, ans + "q" + qpsf + "b" + i, i, count);
			boxes[i] = false;

		}
		return count;
	}

}
