package lec33_nov10_DynamicPragramming;

public class BoundaryPaths {
	public static void main(String[] args) {
		System.out.println(func(2, 2, 2, 0, 0, 0));
//		System.out.println(funcTD(2, 2, 2, 0, 0, 0, new int[3][3][3])); // store -1

		System.out.println(funcBU(1, 1, 2, 0, 0));

	}

	public static int func(int m, int n, int N, int i, int j, int moves) {
		if (i < 0 || j < 0 || i == m || j == n) {
			return 1;
		}
		int sum = 0;
		if (moves < N) {
			int left = func(m, n, N, i, j - 1, moves + 1);
			int right = func(m, n, N, i, j + 1, moves + 1);
			int top = func(m, n, N, i + 1, j, moves + 1);
			int bottom = func(m, n, N, i - 1, j, moves + 1);
			sum = left + right + top + bottom;
		}

		return sum;

	}

	public static int funcTD(int m, int n, int N, int i, int j, int moves, int[][][] storage) {
		if (i < 0 || j < 0 || i == m || j == n) {
			return 1;
		}

		if (storage[moves][i][j] != -1) {
			return storage[moves][i][j];
		}
		int sum = 0;
		if (moves < N) {
			int left = func(m, n, N, i, j - 1, moves + 1);
			int right = func(m, n, N, i, j + 1, moves + 1);
			int top = func(m, n, N, i + 1, j, moves + 1);
			int bottom = func(m, n, N, i - 1, j, moves + 1);
			sum = left + right + top + bottom;
		}
		storage[moves][i][j] = sum;

		return sum;

	}

	public static int funcBU(int m, int n, int N, int i, int j) {
		int[][][] storage = new int[N + 1][m + 1][n + 1];
		for (int mvs = 1; mvs < storage.length; mvs++) {
			for (int r = 0; r <= m; r++) {
				for (int c = 0; c <= n; c++) {
					int left = c - 1 < 0 ? 1 : storage[mvs - 1][r][c - 1];
					int right = (c + 1 > n) ? 1 : storage[mvs - 1][r][c + 1];
					int top = r - 1 < 0 ? 1 : storage[mvs - 1][r - 1][c];
					int bottom = r + 1 > m ? 1 : storage[mvs - 1][r + 1][c];

					storage[mvs][r][c] = left + right + top + bottom;
				}
			}
		}
		return storage[N][i][j];
	}

}
