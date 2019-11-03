package assignment_Recursion;

import java.util.Scanner;

public class NthTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int ans=nthTriangle(n,0);
		System.out.println(ans);
	}
	public static int nthTriangle(int n,int c) {
		if(c==n) {
			return c;
		}
		int i=nthTriangle(n,c+1);
		return c+i;
	}

}
