package Assignments;

import java.util.Scanner;

public class stringCompression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		String str=scn.next();
		String opstr=compressStr(str);
		System.out.println(opstr);

	}
	public static String compressStr(String str) {
		StringBuilder sb=new StringBuilder();
		int i=0;
		int count=1;
		while(i<str.length()-1) {
			if(str.charAt(i+1)==str.charAt(i)) {
				i++;
				count++;
			}else {
				if(count!=1) {
					sb.append(str.charAt(i));
					sb.append(count);
					count=1;
				}else {
					sb.append(str.charAt(i));
					count=1;
				}
				
				i++;
			}
		}
		if(str.charAt(str.length()-2)==str.charAt(str.length()-1)) {
			sb.append(str.charAt(str.length()-1));
			sb.append(count);
		}else {
			sb.append(str.charAt(str.length()-1));
		}
		return sb.toString();
	}

}
