package lec4_aug24;

import java.util.Scanner;

public class temp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Scanner scn=new Scanner(System.in);
		int minf=scn.nextInt();
		int maxf=scn.nextInt();
		int step=scn.nextInt();
		for(int i=minf;i<=maxf;i=i+step) {
			int c=(int)((5.0/9)*(i-32));
			System.out.println(i+"\t"+c);
		}

	}

}
