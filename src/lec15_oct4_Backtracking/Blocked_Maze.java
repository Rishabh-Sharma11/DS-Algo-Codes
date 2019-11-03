package lec15_oct4_Backtracking;

public class Blocked_Maze {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = { { 0, 1, 0, 0 }, { 0, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 1, 0 } };
		boolean[][] visited = new boolean[4][4];
		blockedmaze(board, 0, 0, visited, "");
		//board is 4*4
	}

	public static void blockedmaze(int[][] board, int row, int col, boolean[][] visited, String ans) {
		if (row == 3 && col == 3) {
			System.out.println(ans);
			return;
		}
		if (row < 0 || col < 0 || row > board.length-1|| col > board[0].length-1 || visited[row][col] || board[row][col] == 1) {
			return;
		}

		visited[row][col] = true;
		// B
		blockedmaze(board, row + 1, col, visited, ans + "B");
		// T
		blockedmaze(board, row - 1, col, visited, ans + "T");
		// L
		blockedmaze(board, row, col - 1, visited, ans + "L");
		// R
		blockedmaze(board, row, col + 1, visited, ans + "R");
		visited[row][col] = false;
	}

}
