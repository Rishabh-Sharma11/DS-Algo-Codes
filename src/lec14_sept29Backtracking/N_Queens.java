package lec14_sept29Backtracking;

public class N_Queens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NQueen(new boolean[4][4], 0, 0, 4, 0, "", 0);

	}

	public static boolean isItPossibleToPlaceQueen(boolean[][] board, int row, int col) {
		// check vertical
		int r = row - 1;
		int c = col;
		while (r >= 0) {
			if (board[r][c]) {
				return false;
			}
			r--;
		}
		// check left horizontal
		r = row;
		c = col - 1;
		while (c >= 0) {
			if (board[r][c]) {
				return false;
			}
			c--;
		}
		// check left upper diagonal
		r = row - 1;
		c = col - 1;
		while (r >= 0 && c >= 0) {
			if (board[r][c]) {
				return false;
			}
			r--;
			c--;
		}
		// check right upper diagonal
		r = row - 1;
		c = col + 1;
		while (r >= 0 && c < board[0].length) {
			if (board[r][c]) {
				return false;
			}
			r--;
			c++;
		}

		return true;
	}

	public static int NQueen(boolean[][] boxes, int row, int col, int tq, int qpsf, String ans, int count) {
		if (qpsf == tq) {
			System.out.println(++count + ". " + ans);
			return count;
		}
		if (col == boxes[0].length) {
			return NQueen(boxes, row + 1, 0, tq, qpsf, ans, count);
		}
		if (row == boxes.length) {
			return count;
		}

		// Queen Placed
		if (isItPossibleToPlaceQueen(boxes, row, col)) {
			boxes[row][col] = true;
			count = NQueen(boxes, row, col + 1, tq, qpsf + 1, ans + "{" + row + "," + col + "} ", count);
			boxes[row][col] = false;
		}
		// not placed
		count = NQueen(boxes, row, col + 1, tq, qpsf, ans, count);
		return count;
	}

}
