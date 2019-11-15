package lec33_nov10_DynamicPragramming;

public class NoOfUniqueBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(noOfBST(3));
		System.out.println(noOfBSTTD(3, new int[4]));

	}

	public static int noOfBST(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			int fp = noOfBST(i - 1);
			int sp = noOfBST(n - i);
			int total = fp * sp;
			sum += total;
		}
		return sum;
	}

	public static int noOfBSTTD(int n, int[] storage) {
		if (n == 0 || n == 1) {
			return 1;
		}
		if (storage[n] != 0) {
			return storage[n];
		}
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			int fp = noOfBSTTD(i - 1, storage);
			int sp = noOfBSTTD(n - i, storage);
			int total = fp * sp;
			sum += total;
		}
		storage[n] = sum;
		return sum;
	}

}
