package assignment_Recursion;

import java.util.Scanner;

public class Subset_Problem {				//USING RECURSIVE CALLS IN FOR LOOP

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int n=scn.nextInt();
//		int[]arr=new int[n];
//		takeInput(arr);
//		int target=scn.nextInt();
//		printSubset(arr,target,0,0,"");
//		System.out.println(countSubset(arr,target,0,0));
		printSubset(new int[] { 2, 3, 2, 4 }, 7, 0, 0, "");
		System.out.println(countSubset(new int[] { 2, 3, 2, 4 }, 7, 0, 0));

	}

	public static void takeInput(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
	}

	public static int countSubset(int[] arr, int target, int vidx, int sum) {
		if (sum == target) {
			return 1;
		}
		if (sum > target) {
			return 0;
		}
		if (vidx == arr.length) {
			return 0;
		}
		int x=0;
		for (int i = vidx; i < arr.length; i++) {
			
			if (vidx == 0) {
				x+=countSubset(arr, target, vidx + i + 1, sum + arr[i]);
			} else {
				x+=countSubset(arr, target, vidx + i, sum + arr[i]);
			}

		}
		return x;
	}

	public static void printSubset(int[] arr, int target, int vidx, int sum, String ans) {
		if (sum == target) {
			System.out.println(ans);
			return;
		}
		if (sum > target) {
			return;
		}
		if (vidx == arr.length) {
			return;
		}

		for (int i = vidx; i < arr.length; i++) {
			if (vidx == 0) {
				printSubset(arr, target, vidx + i + 1, sum + arr[i], ans + arr[i] + " ");
			} else {
				printSubset(arr, target, vidx + i, sum + arr[i], ans + arr[i] + " ");
			}
		}
	}

}
