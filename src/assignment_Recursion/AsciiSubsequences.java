package assignment_Recursion;

import java.util.Scanner;

public class AsciiSubsequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		String str=scn.next();
		printAsciiSubsequences(str, "");
		System.out.println();
		System.out.println(countAsciiSubsequences(str));
		scn.close();

	}
	public static void printAsciiSubsequences(String ques,String ans) {
		if(ques.length()==0) {
			System.out.print(ans+" ");
			return;
		}
		
		char ch=ques.charAt(0);
		String roq=ques.substring(1);
		printAsciiSubsequences(roq, ans);
		printAsciiSubsequences(roq, ans+ch);
		printAsciiSubsequences(roq, ans+(int)ch);
	}
	public static int countAsciiSubsequences(String ques) {
		if(ques.length()==0) {
			return 1;
		}
		String roq=ques.substring(1);
		int x=countAsciiSubsequences(roq);
		int y=countAsciiSubsequences(roq);
		int z=countAsciiSubsequences(roq);
		return x+y+z;
	}

}
