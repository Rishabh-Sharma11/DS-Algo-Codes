package assignment_Recursion;

import java.util.Scanner;

public class MaximumIntegerWithKSwaps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int k=scn.nextInt();
//		int max=MaxInt(n,k,0);
		
		
//		System.out.println(max);

	}
	public static int[] intToArray(int n) {
		int k=digit(n);
		int[]arr=new int[k];
		int i=k-1;
		while(n>0) {
			arr[i]=n%10;
			n/=10;
			i--;
		}
		return arr;
	}
//	public static int MaxInt(int n,int k,int cos) {
//		
////		int sp=maxdigit(n%10);
////		int ans=Math.max(sp, n/10);
////		
//		if(n/10==0||cos==k) {
//			return n;
//		}
//		
//		
//		k++;
//		int sp=MaxInt(n/10,k,cos+1);
//		int ca=n%10;
////		int maxdigpos=maxdigit(sp);
////		while(maxdigpos>0) {
////			
////		}
//		
//		
//		return 0;
//		
//	}
	public static int digit(int num) {
		int dig=0;
		while(num>0) {
			dig++;
			num/=10;
		}
		return dig;
	}
	public static int maxdigit(int num) {
	int org=num;	
	int maxdigit=Integer.MIN_VALUE;
		int pos=0;
		while(num>0) {
			if(num%10>maxdigit) {
				maxdigit=num%10;
				pos++;
			}
			num/=10;
		}
		pos=digit(org)-pos;
		return pos;
	}
	
//	public static int[] func(int[]arr,int vidx,int k,int cos) {
//		
//		int[]p2=
//		
//	}

}
