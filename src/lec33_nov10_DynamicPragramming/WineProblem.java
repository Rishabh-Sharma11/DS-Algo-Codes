package lec33_nov10_DynamicPragramming;

public class WineProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] price = { 2, 3, 5, 1, 4 };
		System.out.println(wineProblem(price, 0, price.length - 1, 1));
		System.out.println(WineProblemTopDown(price, 0, price.length - 1, new int[price.length][price.length]));

		System.out.println(WineProblemBottomUp(price));

	}

	public static int wineProblem(int[] price, int si, int ei, int yr) {
		if (si == ei) {
			return price[si] * yr;
		}

		int start = wineProblem(price, si + 1, ei, yr + 1) + price[si] * yr;
		int end = wineProblem(price, si, ei - 1, yr + 1) + price[ei] * yr;

		return Math.max(start, end);
	}

	public static int WineProblemTopDown(int[] price, int si, int ei, int[][] storage) {

		int yr = price.length - ei + si;
		if (si == ei) {
			return price[si] * yr;
		}

		if (storage[si][ei] != 0) {
			return storage[si][ei];
		}

		int start = WineProblemTopDown(price, si + 1, ei, storage) + price[si] * yr;
		int end = WineProblemTopDown(price, si, ei - 1, storage) + price[ei] * yr;

		int ans = Math.max(start, end);
		storage[si][ei] = ans;

		return ans;
	}

	public static int WineProblemBottomUp(int[] price) {
		int n = price.length;
		int[][] storage = new int[n][n];

//		for (int r = 0; r < n; r++) {
//			for (int c = 0; c < n; c++) {
//				if (r == c) {
//					storage[r][c] = price[r] * price.length;
//				}
//			}
//		}
//
//		for (int slide = 1; slide <= n - 1; slide++) {
//			for (int si = 0; si <= n - slide - 1; si++) {
//				int ei = si + slide;
//				int yr = n - ei + si;
//
//				int start = storage[si + 1][ei] + price[si] * yr;
//				int end = storage[si][ei - 1] + price[ei] * yr;
//
//				int ans = Math.max(start, end);
//				storage[si][ei] = ans;
//
//			}
//		}
//		return storage[0][n - 1];

		for (int slide = 0; slide <= n - 1; slide++) {
			for (int si = 0; si <= n - slide - 1; si++) {
				int ei = si + slide;
				int yr = n - ei + si;

				if (si == ei) {
					storage[si][ei] = price[si] * yr;
					continue;
				}

				int start = storage[si + 1][ei] + price[si] * yr;
				int end = storage[si][ei - 1] + price[ei] * yr;

				int ans = Math.max(start, end);
				storage[si][ei] = ans;

			}
		}
		return storage[0][n - 1];

	}

}
