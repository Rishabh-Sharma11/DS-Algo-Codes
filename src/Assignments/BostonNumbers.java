package Assignments;

import java.util.ArrayList;
import java.util.Scanner;

public class BostonNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		System.out.println(isBoston(n));

	}
	public static int countDigit(int org) {
		int sumDigits=0;
		while(org>0) {
			sumDigits+=org%10;
			org/=10;
		}
		return sumDigits;
	}
	public static int isBoston(int n) {
		int sumPrimeFactors=0;
		int org=n;
		int i=2;
		while(org!=1) {
			if(org%i==0) {
				org/=i;
				sumPrimeFactors+=countDigit(i);
			}else {
				i++;
				if(org%i==0) {
					org/=i;
					sumPrimeFactors+=countDigit(i);
				}
			}
		}
		org=n;
		int sumDigits=countDigit(n);
		if(sumPrimeFactors==sumDigits) {
			return 1;
		}else {
			return 0;
		}
		
	}

}
