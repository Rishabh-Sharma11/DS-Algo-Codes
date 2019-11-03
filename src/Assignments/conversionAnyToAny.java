package Assignments;

import java.util.Scanner;

public class conversionAnyToAny {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int sb = scn.nextInt();
		int db = scn.nextInt();
		int sn = scn.nextInt();
		int mult=1;
		int dec=0;
		int dn=0;
		while(sn>0) {
			int rem=sn%10;
			dec+=rem*mult;
			sn/=10;
			mult*=sb;
		}
		mult=1;
		while(dec>0) {
			int rem=dec%db;
			dn+=rem*mult;
			dec/=db;
			mult*=10;
		}
		System.out.println(dn);

	}

}
