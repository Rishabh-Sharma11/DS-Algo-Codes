package assignment_Backtracking;

//import java.util.Scanner;

public class Sudoku_Solver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner scn = new Scanner(System.in);
//		int n = scn.nextInt();
//		int[][] matrix = new int[n][n];
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				matrix[i][j] = scn.nextInt();
//			}
//		}

		int[][] matrix = { { 5, 3, 0, 0, 7, 0, 0, 0, 0 }, { 6, 0, 0, 1, 9, 5, 0, 0, 0 }, { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
				{ 8, 0, 0, 0, 6, 0, 0, 0, 3 }, { 4, 0, 0, 8, 0, 3, 0, 0, 1 }, { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
				{ 0, 6, 0, 0, 0, 0, 2, 8, 0 }, { 0, 0, 0, 4, 1, 9, 0, 0, 5 }, { 0, 0, 0, 0, 8, 0, 0, 7, 9 } };

		SudokuSolver(matrix, 0, 0);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static boolean isItSafeToPlaceTheNumber(int[][] matrix, int num, int row, int col) {
		// horizontal
		for (int c = 0; c < matrix[0].length; c++) {
			if (matrix[row][c] == num) {
				return false;
			}
		}
		// vertical
		for (int r = 0; r < matrix.length; r++) {
			if (matrix[r][col] == num) {
				return false;
			}
		}
		// 3x3 grid
		int ar = row % 3;
		int ac = col % 3;
		int vr = (row / 3) * 3;
		int vc = (col / 3) * 3;
		while (ar >= 0) {
			if (matrix[vr + ar][vc + ac] == num) {
				return false;
			}
			ac--;
			if (ac == -1) {
				ar--;
				ac = 2;
			}
		}
		return true;

	}

	public static boolean isValid(int[][] matrix, int row) {
		for (int i = row; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0)
					return false;
			}
		}
		return true;
	}

	public static void SudokuSolver(int[][] matrix, int cr, int cc) {
		if (cr == matrix.length) {
			return;
		}
		if (cc == matrix[0].length) {
			SudokuSolver(matrix, cr + 1, 0);
			return;
		}
		if (matrix[cr][cc] == 0) {
			for (int num = 1; num <= 9; num++) {
				if (isItSafeToPlaceTheNumber(matrix, num, cr, cc)) {

					matrix[cr][cc] = num;

					SudokuSolver(matrix, cr, cc + 1);

					if (!isValid(matrix, cr)) {
						matrix[cr][cc] = 0;
					}
				}

			}

		} else {

			SudokuSolver(matrix, cr, cc + 1);
		}

	}

}
