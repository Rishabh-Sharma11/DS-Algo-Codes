package Assignments;

import java.util.Scanner;

public class patternTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int nsp = n - 1;
		int nst = 1;
		int row = 1;
		while (row <= n) {
			int val = row;
			int csp = 1;
			while (csp <= nsp) {
				System.out.print(" ");
				csp++;
			}
			int cst = 1;
			while (cst <= nst) {
				System.out.print(val);
				cst++;
				val++;
			}
			cst = 2;
			val-=2;
			while (cst <= nst) {
				System.out.print(val);
				cst++;
				val--;
			}
			System.out.println();
			nsp--;
			nst ++;

			row++;
		}

	}

}
