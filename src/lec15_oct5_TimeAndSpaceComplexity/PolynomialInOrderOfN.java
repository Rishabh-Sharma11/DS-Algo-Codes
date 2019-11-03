package lec15_oct5_TimeAndSpaceComplexity;

import java.util.Scanner;

public class PolynomialInOrderOfN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int x = scn.nextInt();

		int sum = 0;
		int prev = 1;
		while (n > 0) {
			prev = prev * x;
			sum = sum + n * prev;
			n--;

		}
		System.out.println(sum);

	}

}
