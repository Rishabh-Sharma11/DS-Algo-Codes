package Assignments;

import java.util.Scanner;

public class largestSubarrayWith0and1 {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t = scn.nextInt();
		for (int i = 0; i < t; i++) {
			int n = scn.nextInt();
			int[] arr = new int[n];
			takeInput(arr);
			largestSubarr(arr);

		}

	}

	public static void takeInput(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
	}

	public static void largestSubarr(int[] arr) {
		int maxLen = Integer.MIN_VALUE;
		int low = 0, upp = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				int oneCnt = 0;
				int zeroCnt = 0;
				for (int k = i; k <= j; k++) {
					if (arr[k] == 1)
						oneCnt++;
					else
						zeroCnt++;
				}
				if ((oneCnt == zeroCnt) && (oneCnt + zeroCnt) > maxLen) {
					maxLen = oneCnt + zeroCnt;
					low = i;
					upp = j;
				}
			}
		}
		if (low == 0 && upp == 0) {
			System.out.println("None");
		} else {
			System.out.println(low + " " + upp);
		}
	}

}
