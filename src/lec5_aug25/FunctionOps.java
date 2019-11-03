package lec5_aug25;

import java.util.Scanner;

public class FunctionOps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n1 = scn.nextInt();
		int n2 = scn.nextInt();
		printAllPrimes(n1, n2);

	}

	public static void printAllPrimes(int lo, int hi) {
		for (int i = lo; i <= hi; i++) {
			boolean res = isPrime(i);
			if (res) {
				System.out.println(i);
			}
		}
	}

	public static boolean isPrime(int n) {
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

}
