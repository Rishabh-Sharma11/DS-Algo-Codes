package assignment_Backtracking;

//import java.util.Scanner;

public class N_Knight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner scn=new Scanner(System.in);
//		int n=scn.nextInt();
		int n=2;
		N_KNIGHT(new boolean[n][n], 0, 0,0, "");

	}

	public static boolean isItSafeToPlaceTheKnight(boolean[][] board, int row, int col) {
		int[] dC = { -2, -1, 1, 2, 2, 1, -1, -2 };
		int[] dR = { 1, 2, 2, 1, -1, -2, -2, -1 };
		for (int i = 0; i < 8; i++) {
			int nr = row + dR[i];
			int nc = col + dC[i];
			if (nr >= 0 && nc >= 0 && nr < board.length && nc < board[0].length) {
				if (board[nr][nc]) {
					return false;
				}
			}
		}
		return true;
	}

	public static void N_KNIGHT(boolean[][] board, int cr, int cc, int kpsf,String ans) {
		if(kpsf==board.length) {
			System.out.println(ans);
			return;
		}
		if (cr == board.length) {
			return;
		}
		if (cc == board[0].length) {
			N_KNIGHT(board, cr + 1, 0,kpsf, ans);
			return;
		}
		if (isItSafeToPlaceTheKnight(board, cr, cc)) {
			board[cr][cc] = true;
			N_KNIGHT(board, cr, cc + 1, kpsf+1,ans + "{" + cr + "-" + cc + "}");
			board[cr][cc] = false;
			N_KNIGHT(board, cr, cc + 1,kpsf, ans);
		} else {
			N_KNIGHT(board, cr, cc + 1, kpsf,ans);
		}
	}

}
