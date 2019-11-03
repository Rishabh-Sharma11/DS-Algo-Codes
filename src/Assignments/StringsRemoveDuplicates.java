package Assignments;

import java.util.Scanner;

public class StringsRemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		String str=scn.next();
		String opstr=removeDup(str);
		System.out.println(opstr);
	}
	public static String removeDup(String str) {
		StringBuilder sb=new StringBuilder();
		int i=0;
		
//	<-- This code is not working well for inputs like "aabccbaa" -->
//		while(i<str.length()-1) {
//			if(str.charAt(i+1)==str.charAt(i)) {
//				i++;
//			}else {
//				sb.append(str.charAt(i));
//				i++;
//			}
//		}
//		if(str.charAt(str.length()-2)!=str.charAt(str.length()-1)) {
//			sb.append(str.charAt(str.length()-1));
//		}
		
		
//	<-- This input is correct --> 
		char prev = str.charAt(0);
		sb.append(prev);
		while (i < str.length()) {
			char curr = str.charAt(i);
			if (prev == curr) {
			} else {
				sb.append(curr);
			}
			i++;
			prev = curr;
		}
		
		
		return sb.toString();
	}

}
