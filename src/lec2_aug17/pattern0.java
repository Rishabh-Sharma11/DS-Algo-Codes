package lec2_aug17;

import java.util.Scanner;

public class pattern0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int row=1;
		while(row<=n) {
			System.out.println("*");
			row++;
			System.out.println();
		}
	}

}
