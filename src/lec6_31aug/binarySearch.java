package lec6_31aug;

import java.util.Scanner;

public class binarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int[] arr = { 5, 12, 34, 41, 56, 87, 89 };
		int src = scn.nextInt();
		int ind = bsearch(arr, src);
		if (ind == -1)
			System.out.println("Item not found");
		else
			System.out.println("Item found at index " + ind);

	}

	public static int bsearch(int[] arr, int item) {
		int low = 0;
		int hi = arr.length - 1;
		while (low <= hi) {
			int mid = (low + hi) / 2;
			if (item > arr[mid]) {
				low = mid + 1;
			} else if (item < arr[mid]) {
				hi = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

}
