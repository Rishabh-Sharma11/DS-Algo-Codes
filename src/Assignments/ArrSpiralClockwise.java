package Assignments;

import java.util.Scanner;

public class ArrSpiralClockwise {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = takeInput();
		SpiralClockDisplay(arr);

	}

	public static int[][] takeInput() {
		int row = scn.nextInt();
		int col = scn.nextInt();
		int[][] arr = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				arr[i][j] = scn.nextInt();
			}
		}
		return arr;
	}

	public static void SpiralClockDisplay(int[][] arr) {
		int minRow = 0, maxRow = arr.length - 1;
		int minCol = 0, maxCol = arr[0].length - 1;
		int count = 0, nel = arr.length * arr[0].length;
		while (count < nel) {
			for (int c = minCol; c <= maxCol && count < nel; c++) {
				System.out.print(arr[minRow][c] + " ");
				count++;
			}
			minRow++;
			for (int r = minRow; r <= maxRow && count < nel; r++) {
				System.out.print(arr[r][maxCol] + " ");
				count++;
			}
			maxCol--;
			for (int c = maxCol; c >= minCol && count < nel; c--) {
				System.out.print(arr[maxRow][c] + " ");
				count++;
			}
			maxRow--;
			for (int r = maxRow; r >= minRow && count < nel; r--) {
				System.out.print(arr[r][minCol] + " ");
				count++;
			}
			minCol++;
		}

	}

}
