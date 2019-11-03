package lec12_sept21;

import java.util.Scanner;

public class RecursionPrintSubSequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		String str=scn.next();
		printSS(str,"");

	}
	public static void printSS(String ques,String ans) {
		if(ques.length()==0){
			System.out.println(ans);
			return;
		}
		char ch=ques.charAt(0);
		String roq=ques.substring(1);
		
		printSS(roq,ans);	//no
		printSS(roq,ans+ch);	//yes
	}

}
