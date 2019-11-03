package lec2_aug17;

import java.util.Scanner;

public class pattern13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int nst=1;
		int row=1;
		while(row<=2*n-1) {
			//work
			int cst=1;
			while(cst<=nst) {
				System.out.print("*");
				cst++;
			}
			//prep
			if(row<=n-1)
				nst++;
			else
				nst--;
			row++;
			System.out.println();
		}

	}

}
