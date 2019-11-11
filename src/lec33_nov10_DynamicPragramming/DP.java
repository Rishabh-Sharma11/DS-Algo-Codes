package lec33_nov10_DynamicPragramming;

public class DP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Fibonacci
//		int n=6;
//		System.out.println(fibonacciTopDown(n,new int[n+1]));
//		System.out.println(fibonacciBottomUp(n));

//		BoardPath
//		int n = 10;
//		System.out.println(boardPathTD(n, 0, new int[n]));
//		System.out.println(boardPathBU(n, 0));
//		System.out.println(boardPathBUSE(n, 0));

//		MazePath
		int er = 2, ec = 2;
//		System.out.println(mazePathTD(er, ec, 0, 0, new int[er + 1][ec + 1]));
//		System.out.println(mazePathBU(er, ec, 0, 0));
//		System.out.println(mazePathBUSE(er, ec, 0, 0));

		System.out.println(mazePathBUSEwithDiagonal(er, ec, 0, 0));

	}

	public static int fibonacci(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	public static int fibonacciTopDown(int n, int[] storage) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}

		if (storage[n] != 0) {
			return storage[n];
		}

		int fnm1 = fibonacciTopDown(n - 1, storage);
		int fnm2 = fibonacciTopDown(n - 2, storage);
		int fn = fnm1 + fnm2;
		storage[n] = fn;
		return fn;
	}

	public static int fibonacciBottomUp(int n) {
		int[] storage = new int[n + 1];
		storage[0] = 0;
		storage[1] = 1;

		for (int i = 2; i <= n; i++) {
			storage[i] = storage[i - 1] + storage[i - 2];
		}

		return storage[n];

	}

	public static int fibonacciBottomUpSpaceEfficient(int n) {
		int[] strg = new int[2];
		strg[0] = 0;
		strg[1] = 1;
		for (int i = 2; i <= n; i++) {
			int temp = strg[0];
			strg[0] = strg[1];
			strg[1] = temp + strg[0];
		}
		return strg[1];
	}

	public static int boardPath(int end, int curr, String ans) {
		if (curr == end) {
			System.out.println(ans);
			return 1;
		}
		if (curr > end) {
			return 0;
		}
		int c = 0;
		for (int dice = 1; dice <= 6; dice++) {
			c += boardPath(end, curr + dice, ans + dice);
		}
		return c;
	}

	public static int boardPathTD(int end, int curr, int[] strg) {
		if (curr == end) {
			return 1;
		}
		if (curr > end) {
			return 0;
		}

		if (strg[curr] != 0) {
			return strg[curr];
		}

		int c = 0;
		for (int dice = 1; dice <= 6; dice++) {
			c += boardPathTD(end, curr + dice, strg);
		}

		strg[curr] = c;
		return c;
	}

	public static int boardPathBU(int n, int curr) {
		int[] strg = new int[n + 6];
		strg[n] = 1;
		// base cases return 0 and default value is also 0, so no need to fill them

		for (int i = n - 1; i >= 0; i--) {
			strg[i] = strg[i + 1] + strg[i + 2] + strg[i + 3] + strg[i + 4] + strg[i + 5] + strg[i + 6];
		}
		return strg[0];
	}

	public static int boardPathBUSE(int n, int curr) {
		int[] strg = new int[6];
		strg[0] = 1;
		for (int i = n - 1; i >= 0; i--) {
			int sum = 0;
			int temp = strg[5];
			for (int j = 5; j > 0; j--) {
				strg[j] = strg[j - 1];
				sum += strg[j];
			}
			strg[0] = sum + temp;
		}
		return strg[0];
	}

	public static int mazePath(int er, int ec, int cr, int cc, String ans) {
		if (cr == er && cc == ec) {
			System.out.println(ans);
			return 1;
		}
		if (cr > er || cc > ec) {
			return 0;
		}
		int cH = mazePath(er, ec, cr, cc + 1, ans + 'H');
		int cV = mazePath(er, ec, cr + 1, cc, ans + 'V');
		return cH + cV;
	}

	public static int mazePathTD(int er, int ec, int cr, int cc, int[][] storage) {
		if (cr == er && cc == ec) {
			return 1;
		}
		if (cr > er || cc > ec) {
			return 0;
		}

		if (storage[cr][cc] != 0) {
			return storage[cr][cc];
		}
		int cH = mazePathTD(er, ec, cr, cc + 1, storage);
		int cV = mazePathTD(er, ec, cr + 1, cc, storage);

		storage[cr][cc] = cH + cV;
		return cH + cV;
	}

	public static int mazePathBU(int er, int ec, int cr, int cc) {
		int[][] storage = new int[er + 2][ec + 2];
		storage[er][ec] = 1;
		for (int i = er; i >= 0; i--) {
			for (int j = ec; j >= 0; j--) { // i=row,j=col
				if (i == er && j == ec) {
					continue;
				}
				storage[i][j] = storage[i + 1][j] + storage[i][j + 1];
			}
		}
		return storage[0][0];
	}

	public static int mazePathBUSE(int er, int ec, int cr, int cc) {
		int[] storage = new int[ec + 1];
		storage[ec] = 1;
		for (int r = er; r >= 0; r--) {
			for (int c = ec - 1; c >= 0; c--) {
				storage[c] += storage[c + 1];
			}
		}
		return storage[0];
	}

	public static int mazePathBUSEwithDiagonal(int er, int ec, int cr, int cc) {
		int[] storage = new int[ec + 1];
		storage[ec] = 1;
		int diag = 0;
		for (int r = er; r >= 0; r--) {
			for (int c = ec - 1; c >= 0; c--) {
				int temp = storage[c];
				storage[c] += storage[c + 1] + diag;
				diag = temp;
			}
			diag = 1;
		}
		return storage[0];

	}


}
