package lec2_aug17;

import java.util.Scanner;

public class pattern21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int nst = 1;
		int nsp = 2 * n - 3;
		int row = 1;
		while (row <= n) {
			// work

			// stars
			int cst = 1;
			while (cst <= nst) {
				System.out.print("*");
				cst++;
			}

			// space
			int csp = 1;
			while (csp <= nsp) {
				System.out.print(" ");
				csp++;
			}

			// stars
			cst = 1;
			if(row<n) {
				while (cst <= nst) {
					System.out.print("*");
					cst++;
				}
			
			}else {
				while(cst<nst) {
					System.out.print("*");
					cst++;
				}
			}
			//if row==n, cst=2;
			
			// prep

			
			nst++;
			nsp-=2;
			row++;
			System.out.println();
			scn.close();
		}

	}

}
