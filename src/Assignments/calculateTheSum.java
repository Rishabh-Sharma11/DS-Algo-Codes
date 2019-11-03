package Assignments;

import java.util.Scanner;

public class calculateTheSum {

	static Scanner scn=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=scn.nextInt();
		int[]arr=new int[n];
		int sum=takeInput(arr);
		int Fsum=countSum(arr,sum);
		System.out.println(Fsum);

	}
	public static int takeInput(int[]arr){
		int sum=0;
		
		for(int i=0;i<arr.length;i++) {
			arr[i]=scn.nextInt();
			sum+=arr[i];
		}
		return sum;
	}
//  *This is Wrong one* actual code is below it
//	public static void display(int[] arr) {
//		for(int val:arr) {
//			System.out.print(val+" ");
//		}
//		System.out.println();
//	}
//	public static int countSum(int[]arr) {
//		int sum=0;
//		int q=scn.nextInt();
//		int[]x=new int[q];
//		for(int i=0;i<q;i++) {
//			x[i]=scn.nextInt();
//		}
//		int[]arr2=new int[arr.length];
//		for(int i=0;i<x.length;i++) {
//			for(int j=0;j<arr.length;j++) {
//				if(j<x[i]) {
//					arr2[j]=arr[j]+arr[arr.length-(x[i]-j)];
//				}else {
//					arr2[j]=arr[j]+arr[j-x[i]];
//				}
//				
//				
//			}
//			for(int k=0;k<arr.length;k++) {
//				arr[k]=arr2[k];
//			}
//			display(arr2);
//		}
//		for(int i=0;i<arr2.length;i++) {
//			sum+=arr2[i];
////			sum=sum+arr2[i]%((int)Math.pow(10,9)+7);
//			
//		}
//		
//		
//		return sum%((int)Math.pow(10, 9)+7);
////		return sum;
//	}
	
	public static int countSum(int[]arr,int arrSum) {
		int FinalSum;
		int q=scn.nextInt();
		int[]x=new int[q];
		for(int i=0;i<q;i++) {
			x[i]=scn.nextInt();
		}
		
		FinalSum=(int)Math.pow(2, x.length)*arrSum;
		return FinalSum;
	}

}
