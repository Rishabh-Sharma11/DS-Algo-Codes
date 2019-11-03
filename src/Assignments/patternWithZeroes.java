package Assignments;

import java.util.Scanner;

public class patternWithZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int nst = 1;
		int row = 1;
		while (row <= n) {
			int val = row;
			int cst = 1;
			while (cst <= nst) {
				if (cst == 1 || cst == nst)
					System.out.print(val);
				else
					System.out.print(0);
				cst++;
			}
			System.out.println();
			nst++;
			row++;
		}

	}

}
