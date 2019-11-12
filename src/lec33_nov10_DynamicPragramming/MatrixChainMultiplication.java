package lec33_nov10_DynamicPragramming;

import java.util.Arrays;

public class MatrixChainMultiplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 3, 4, 5 }; // answer=38
//		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 44 };

		System.out.println(MCM(arr, 0, arr.length - 1));
		int[][] storage = new int[arr.length][arr.length];
		for (int[] val : storage) {
			Arrays.fill(val, -1);
		}
		System.out.println(MCM_TopDown(arr, 0, arr.length - 1, storage));
		System.out.println(MCM_BottomUp(arr));

	}

	public static int MCM(int[] arr, int si, int ei) {
		if (ei - si == 1) {
			return 0;
		}

		int min = Integer.MAX_VALUE;
		for (int k = si + 1; k <= ei - 1; k++) {
			int fp = MCM(arr, si, k);
			int sp = MCM(arr, k, ei);
			int sw = arr[si] * arr[k] * arr[ei];

			int total = fp + sp + sw;
			if (total < min) {
				min = total;
			}
		}

		return min;
	}

	public static int MCM_TopDown(int[] arr, int si, int ei, int[][] storage) {
		if (ei - si == 1) {
			return 0;
		}

		if (storage[si][ei] != -1) {
			return storage[si][ei];
		}

		int min = Integer.MAX_VALUE;
		for (int k = si + 1; k <= ei - 1; k++) {
			int fp = MCM_TopDown(arr, si, k, storage);
			int sp = MCM_TopDown(arr, k, ei, storage);
			int sw = arr[si] * arr[k] * arr[ei];

			int total = fp + sp + sw;
			if (total < min) {
				min = total;
			}
		}
		storage[si][ei] = min;
		return min;
	}

	public static int MCM_BottomUp(int[] arr) {
		int n = arr.length;
		int[][] storage = new int[n][n];

		for (int slide = 2; slide <= n - 1; slide++) {
			for (int si = 0; si <= n - slide - 1; si++) {
				int ei = si + slide;

				int min = Integer.MAX_VALUE;
				for (int k = si + 1; k <= ei - 1; k++) {
					int fp = storage[si][k];
					int sp = storage[k][ei];
					int sw = arr[si] * arr[k] * arr[ei];

					int total = fp + sp + sw;
					if (total < min) {
						min = total;
					}
				}
				storage[si][ei] = min;

			}
		}

		return storage[0][n - 1];

	}

}
