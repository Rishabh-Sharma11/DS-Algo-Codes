package lec7_sept1;

import java.util.Scanner;

public class Array2DOps {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = takeInput();
		display(arr);

	}

	public static int[][] takeInput() {
		System.out.println("Rows?");
		int row = scn.nextInt();
		int[][] arr = new int[row][];
		for (int r = 0; r < arr.length; r++) {
			System.out.println("Columns?");
			int col = scn.nextInt();
			arr[r] = new int[col];
			for (int c = 0; c < arr[r].length; c++) {
				arr[r][c] = scn.nextInt();
			}
		}
		return arr;
	}

	public static void display(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
