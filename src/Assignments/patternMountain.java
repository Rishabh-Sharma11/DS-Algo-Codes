package Assignments;

import java.util.Scanner;

public class patternMountain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int nst = 1;
		int nsp = 2 * n - 3;
		int row = 1;
		while (row <= n) {
			int cst = 1;
			int val = 1;
			while (cst <= nst) {
				System.out.print(val);
				cst++;
				val++;
			}
			int csp = 1;
			while (csp <= nsp) {
				System.out.print(" ");
				csp++;
			}
			cst = 1;
			if (row == n) {
				cst = 2;
				val--;
			}
			val--;
			while (cst <= nst) {
				System.out.print(val);
				cst++;
				val--;
			}
			System.out.println();
			nst++;
			nsp -= 2;
			row++;
		}

	}

}
