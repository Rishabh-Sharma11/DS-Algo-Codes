package lec10_sept14_recursion;

import java.util.Scanner;

public class Recursion1 {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = { 100, 50, 60, 20, 5 };
		int[] arr2 = { 10, 20, 50, 20, 20, 60 };
//		int n=scn.nextInt();
//		int[]arr=new int[n];
		System.out.println(Max(arr1, 0));
		System.out.println(firstIndex(arr2, 0, 20));
		System.out.println(lastIndex(arr2, 0, 20));
		int[] res = allIndex(arr2, 0, 20, 0);
		for (int val : res) {
			System.out.println(val);
		}

	}

	public static int Max(int[] arr, int vidx) {
		// base case
		if (vidx == arr.length - 1) {
			return arr[vidx];
		}

		// smaller problem
		int sp = Max(arr, vidx + 1);

		// self work
		return Math.max(sp, arr[vidx]);

	}

	public static int firstIndex(int[] arr, int vidx, int item) {
//		// base case
//		if (vidx == arr.length - 1) {
//			if (arr[vidx] == item) {
//				return vidx;
//			} else {
//				return -1;
//			}
//		}
//		// smaller problem
//		int sp = firstIndex(arr, vidx + 1, item);
//		// self work
//		if (arr[vidx] == item) {
//			return vidx;
//		}
//		return sp;

		if (vidx == arr.length) { // base case
			return -1;
		}
		if (arr[vidx] == item) { // self work
			return vidx;
		} else { // smaller problem
			return firstIndex(arr, vidx + 1, item); // 1->4? this funcframe returns the value returned by recursion
		}

	}

	public static int lastIndex(int[] arr, int vidx, int item) {
		if (vidx == arr.length) {
			return -1;
		}
		int rr = lastIndex(arr, vidx + 1, item); // recursion result
		if (arr[vidx] == item && rr == -1) {
			return vidx;
		}
//		if (arr[vidx] == item) {
//			return Math.max(vidx,rr);   this is also correct
//		}
		return rr;

	}

	public static int[] allIndex(int[] arr, int vidx, int item, int count) {

		if (vidx == arr.length) {
			int[] br = new int[count];
			return br;
		}

		int[] rr;

		if (arr[vidx] == item) {
			rr = allIndex(arr, vidx + 1, item, count + 1);
			rr[count] = vidx;
		} else {
			rr = allIndex(arr, vidx + 1, item, count);
		}
		return rr;

	}

}
