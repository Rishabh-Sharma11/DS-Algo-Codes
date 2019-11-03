package Assignments;

import java.util.Scanner;

public class StrinsDiffInAsciiCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		String str=scn.next();
		String opstr=DiffAscii(str);
		System.out.println(opstr);

	}
	public static String DiffAscii(String str) {
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<str.length()-1;i++) {
			int diff=str.charAt(i+1)-str.charAt(i);
			sb.append(str.charAt(i));
			sb.append(diff);
		}
		sb.append(str.charAt(str.length()-1));
		return sb.toString();
		
	}

}
