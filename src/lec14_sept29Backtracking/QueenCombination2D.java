package lec14_sept29Backtracking;

public class QueenCombination2D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		queenCombinationBoxRespect2D(new boolean[2][3], 0, 0, 2, 0, "", 0);

	}

	public static int queenCombinationBoxRespect2D(boolean[][] boxes, int row, int col, int tq, int qpsf, String ans,
			int count) {
		if (qpsf == tq) {
			System.out.println(++count + ". " + ans);
			return count;
		}
		if (col == boxes[0].length) {
			return queenCombinationBoxRespect2D(boxes, row + 1, 0, tq, qpsf, ans, count);
		}
		if (row == boxes.length) {
			return count;
		}

		// Queen Placed
		boxes[row][col] = true;
		count = queenCombinationBoxRespect2D(boxes, row, col + 1, tq, qpsf + 1, ans + "{" + row + "," + col + "} ",
				count);
		boxes[row][col] = false;
		// not placed
		count = queenCombinationBoxRespect2D(boxes, row, col + 1, tq, qpsf, ans, count);
		return count;
	}

}
