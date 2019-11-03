package Assignments;

import java.util.Scanner;

public class pascalTrianglePattern3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int nst = 1;
		for(int row=0;row<n;row++) {
			int val=1;
			
			for(int col=0;col<=row;col++) {
				System.out.print(val);
				
				val=val*(row-col)/(col+1);
			}
			System.out.println();
		}

	}

}
