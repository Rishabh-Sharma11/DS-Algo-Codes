package lec2_aug17;

import java.util.Scanner;

public class pattern5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int nsp = 0;
		int nst = n;
		int row = 1;
		while (row <= n) {
			int csp = 1;
			while (csp <= nsp) {
				System.out.print(" ");
				csp++;
			}
			int cst = 1;
			while (cst <= nst) {
				System.out.print("*");
				cst++;
			}
			row++;
			nst--;
			nsp += 2;
			System.out.println();
			scn.close();

		}

	}

}
