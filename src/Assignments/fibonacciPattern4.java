package Assignments;

import java.util.Scanner;

public class fibonacciPattern4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int first=0;
		int second=1;
		int sum;
		int nst=1;
		int row=1;
		while(row<=n) {
			int cst=1;
			while(cst<=nst) {
				System.out.print(first);
				sum=first+second;
				first=second;
				second=sum;
				
				cst++;
			}
			nst++;
			System.out.println();
			
			row++;
		}

	}

}
