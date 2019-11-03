package Assignments;

import java.util.Scanner;

public class StringsOddEvenChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		String str=scn.next();
		String opstr=oddEvenChar(str);
		System.out.println(opstr);

	}
	public static String oddEvenChar(String str) {
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<str.length();i++) {
			if((i+1)%2==0) {
				sb.append((char)(str.charAt(i)-1));
			}else {
				sb.append((char)(str.charAt(i)+1));
			}
		}
		return sb.toString();
	}

}
