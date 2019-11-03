package Assignments;

import java.util.Scanner;

public class HollowRhombusPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int nsp=n-1;
		int nst=n;
		for(int row=1;row<=n;row++) {
			for(int csp=0;csp<nsp;csp++) {
				System.out.println(" ");
			}
			for(int cst=0;cst<nst;cst++) {
				if(cst==1||cst==n||row==1||row==n)
					System.out.println("*");
				else
					System.out.println(" ");
			}
		}
	}

}
