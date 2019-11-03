package lec2_aug17;

import java.util.Scanner;

public class pattern16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int nst=n;
		int nsp=n-1;
		int row=1;
		while(row<=2*n-1) {
			//work
			
			//space
			int csp=1;
			while(csp<=nsp) {
				System.out.print(" ");
				csp++;
			}
			
			//stars
			int cst=1;
			while(cst<=nst) {
				System.out.print("*");
				cst++;
			}
			//prep
			if(row<=n-1) {
				nst--;
				nsp--;
			}
			else {
				nst++;
				nsp++;
			}
			row++;
			System.out.println();
			scn.close();
		}

	}

}
