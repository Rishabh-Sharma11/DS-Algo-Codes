package assignment_Recursion;

import java.util.Scanner;

public class Subsequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		String str=scn.next();
		printSS(str,"");
		System.out.println();
		System.out.println(countSS(str));
		scn.close();

	}
	public static void printSS(String str,String ans) {
		if(str.length()==0) {
			System.out.print(ans+" ");
			return;
		}
		char ch=str.charAt(0);
		String roq=str.substring(1);
		printSS(roq,ans);
		printSS(roq,ans+ch);
	}
	public static int countSS(String str) {
		if(str.length()==0) {
			return 1;
		}
		String roq=str.substring(1);
		int x=countSS(roq);
		int y=countSS(roq);
		return x+y;
	}

}
