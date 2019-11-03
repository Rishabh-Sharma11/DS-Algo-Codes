package Assignments;

import java.util.Scanner;

public class patternHourGlass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int nst=n;
		int nsp=0;
		int row=1;
		while(row<=2*n+1) {
			int val;
			if(row<=n)
				val=n-row+1;
			else
				val=row-n-1;
			int csp=1;
			while(csp<=nsp) {
				System.out.print(" ");
				csp++;
			}			
			int cst=1;
			while(cst<=nst) {
				System.out.print(val);;
				cst++;
				val--;
			}
			System.out.print(0);;
			cst=1;
			val=1;
			while(cst<=nst) {
				System.out.print(val);;
				cst++;
				val++;
			}
			if(row<=n) {
				nsp++;
				nst--;
			}else {
				nsp--;
				nst++;
			}
			System.out.println();
			row++;
		}
		

	}

}
