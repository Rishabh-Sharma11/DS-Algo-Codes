package assignment_Backtracking;

import java.util.Scanner;

public class RatChasesItsCheese {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		char[][] matrix = new char[n][m];
		/*
		 * Input: 5 4 OXOO OOOX XOXO XOOX XXOO
		 */
		for (int i = 0; i < n; i++) {
			String str = scn.next();
			for (int j = 0; j < m; j++) {
				matrix[i][j] = str.charAt(j);
			}
		}
		int[][] res = new int[n][m];
		if (ratChasesItsCheese(matrix, 0, 0, res, new boolean[n][m])) {
			for (int i = 0; i < res.length; i++) {
				for (int j = 0; j < res[0].length; j++) {
					System.out.print(res[i][j] + " ");
				}
				System.out.println();
			}
		} else {
			System.out.println("NO PATH FOUND");
		}
		scn.close();

	}

	public static boolean ratChasesItsCheese(char[][] matrix, int cr, int cc, int[][] res, boolean[][] visited) {
		if (cr == matrix.length - 1 && cc == matrix[0].length - 1) {
			res[cr][cc]=1;
			return true;
		}
		if (cr < 0 || cc < 0 || cr == matrix.length || cc == matrix[0].length
				|| visited[cr][cc] || matrix[cr][cc] == 'X') {
			return false;
		}
		res[cr][cc] = 1;
		visited[cr][cc] = true;
		if (ratChasesItsCheese(matrix, cr - 1, cc, res, visited)) { // top
			return true;
		}
		if (ratChasesItsCheese(matrix, cr, cc + 1, res, visited)) { // right
			return true;
		}
		if (ratChasesItsCheese(matrix, cr + 1, cc, res, visited)) { // bottom
			return true;
		}
		if (ratChasesItsCheese(matrix, cr, cc - 1, res, visited)) { // left
			return true;
		}

		res[cr][cc] = 0;
		visited[cr][cc] = false;
		return false;

	}

}
