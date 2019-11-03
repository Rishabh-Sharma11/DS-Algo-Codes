package Assignments;

import java.util.Scanner;

public class patternInvertedHourGlass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int nst = 1;
		int nsp = 2 * n - 1;
		int row = 1;
		while (row <= 2*n+1) {
			int cst = 1;
			int val=n;
			while (cst <= nst) {
				System.out.print(val);
				cst++;
				val--;
				
			}
			int csp = 1;
			while (csp <= nsp) {
				System.out.print(" ");
				csp++;
			}
			cst = 1;
			if (row == n+1) {
				cst = 2;
				val++;
			}
			val++;
			while (cst <= nst) {
				System.out.print(val);
				cst++;
				val++;
				
			}
			System.out.println();
			if(row<=n) {
				nst++;
				nsp-=2;
			}else {
				nst--;
				nsp+=2;
			}
			row++;
		}

	}

}
