package lec2_aug17;

import java.util.Scanner;

public class pattern7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int nsp1=0;
		int nsp2=n-2;
		
		int row=1;
		while(row<=n) {
			int csp1=1;
			while(csp1<=nsp1) {
				System.out.print(" ");
				csp1++;
			}
			
			
			System.out.print("*");
			int csp2=1;
			while(csp2<=nsp2) {
				System.out.print(" ");
				csp2++;
			}
			
			System.out.print("*");
			row++;
			nsp1++;
			
			nsp2-=2;
			
			System.out.println();
			scn.close();
			
		}

	}

}
