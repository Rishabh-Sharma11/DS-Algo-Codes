package lec33_nov10_DynamicPragramming;

public class DP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Fibonacci
//		int n=6;
//		System.out.println(fibonacciTopDown(n,new int[n+1]));
//		System.out.println(fibonacciBottomUp(n));

//		BoardPath
		int n = 10;
//		System.out.println(boardPath(n,0,""));
		System.out.println(boardPathTD(n, 0, new int[n]));
		System.out.println(boardPathBU(n, 0));
		System.out.println(boardPathBUSE(n, 0));

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
	
	
	

}
