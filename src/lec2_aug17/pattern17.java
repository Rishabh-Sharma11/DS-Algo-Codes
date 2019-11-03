package lec2_aug17;

import java.util.Scanner;

public class pattern17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int row=1;
		int nst=n/2;
		int nsp=1;
		while(row<=n) {
			//work
			
			//star
			int cst=1;
			while(cst<=nst) {
				System.out.println("*");
				cst++;
			}
			//space
			int csp=1;
			while(csp<=nsp) {
				System.out.println(" ");
				csp++;
			}
			
			
			
		}

	}

}
