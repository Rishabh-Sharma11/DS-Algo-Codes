package lec15_oct4_Backtracking;

public class ConstructWordsFromSeqAdjCellOfGrid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String word = "SEE";
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		int flag = 0;
		boolean res = false;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				res = searchWord(board, word, 0, new boolean[board.length][board[0].length], i, j);
				if (res) {
					flag = 1;
					break;
				}
			}
			if (flag == 1) {
				break;
			}
		}
		System.out.println(res);

	}

	public static boolean searchWord(char[][] board, String word, int vidx, boolean[][] visited, int row, int col) {
		if (vidx == word.length()) {
			return true;
		}
		if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || visited[row][col]) {
			return false;
		}
		if (board[row][col] != word.charAt(vidx)) {
			return false;
		}

		visited[row][col] = true;
		// T
		boolean t = searchWord(board, word, vidx + 1, visited, row - 1, col);
		// L
		boolean l = searchWord(board, word, vidx + 1, visited, row, col - 1);
		// R
		boolean r = searchWord(board, word, vidx + 1, visited, row, col + 1);
		// B
		boolean b = searchWord(board, word, vidx + 1, visited, row + 1, col);
		visited[row][col] = false;

		return t || l || r || b;
	}

}
