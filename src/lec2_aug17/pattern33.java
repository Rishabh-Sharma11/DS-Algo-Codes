package lec2_aug17;

import java.util.Scanner;

public class pattern33 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int nsp = n - 1;
		int nst = 0;
		int row = 1;
		
		while (row <= n) {
			int val1=n-row+1;
			int val2=n-1;
			int csp = 1;
			while (csp <= nsp) {
				
				System.out.print(" ");
				csp++;
			}
			
			int cst1 = 1;
			while (cst1 <= nst) {
				System.out.print(val1);
				cst1++;
				val1++;
			}
			System.out.print(0);
			int cst2=1;
			while (cst2 <= nst) {
				System.out.print(val2);
				cst2++;
				val2--;
			}
			
			
			nst ++;
			nsp--;
			row++;
			System.out.println();
			scn.close();

		}

	}

}
