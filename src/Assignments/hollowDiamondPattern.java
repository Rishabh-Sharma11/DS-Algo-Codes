package Assignments;

import java.util.Scanner;

public class hollowDiamondPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int nst=n/2+1;
		int nsp=-1;
		int row = 1;
		while (row <= n) {
			int cst=1;
			while(cst<=nst) {
				System.out.print("*");
				cst++;
			}
			int csp=1;
			while(csp<=nsp) {
				System.out.print(" ");
				csp++;
			}
			cst=1;
			if(row==1||row==n)
				cst=2;
			while(cst<=nst) {
				System.out.print("*");
				cst++;
			}
			System.out.println();
			if(row<=n/2) {
				nsp+=2;
				nst--;
			}else {
				nsp-=2;
				nst++;
			}
			row++;
		}


	}

}
