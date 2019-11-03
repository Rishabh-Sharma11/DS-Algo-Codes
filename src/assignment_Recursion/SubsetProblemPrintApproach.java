package assignment_Recursion;

import java.util.Scanner;

public class SubsetProblemPrintApproach {
	
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
		printSubset(arr, target, vidx+1, sum+arr[vidx], ans+arr[vidx]+" ");
		printSubset(arr, target, vidx+1, sum, ans);
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
		
		int x1=countSubset(arr, target, vidx+1, sum+arr[vidx]);
		int x2=countSubset(arr, target, vidx+1, sum);
		
		return x1+x2;
	}
	

}
