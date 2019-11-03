package Assignments;

import java.util.Scanner;

public class alex {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = scn.nextInt();
		int[] arr = new int[n];
		takeInput1D(arr);
		int q = scn.nextInt();
		int cq = 1;
		while (cq <= q) {
			int amount = scn.nextInt();
			int num = scn.nextInt();
			int count = 0;
			for (int i = 0; i <= arr.length - 1; i++) {
				if (amount % arr[i] == 0 && arr[i] <= amount) {
					count++;
				}
			}
			if (count == num) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
			cq++;
		}
	}

	public static void takeInput1D(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
	}

	public static void takeInput2D(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = scn.nextInt();
			}
		}
	}

//	public static boolean check(int[] arr, int[] arr2) {
//		int count = 0;
//		for (int j = 0; j < arr.length; j++) {
//			if (/* arr2[0] >= arr[j] && */ arr2[0] % arr[j] == 0)
//				count++;
//		}
//		if (count == arr2[1])
//			return true;
//		else
//			return false;
//	}

}
