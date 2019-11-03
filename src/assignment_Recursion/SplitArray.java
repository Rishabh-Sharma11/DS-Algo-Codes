package assignment_Recursion;

import java.util.Scanner;

public class SplitArray {

	static Scanner scn=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=scn.nextInt();
		int[]arr=new int[n];
		takeInput(arr);
		
		
	}
	public static void takeInput(int[]arr) {
		for(int i=0;i<arr.length;i++) {
			arr[i]=scn.nextInt();
		}
	}
	public static int countSplitArrays(int[]arr) {
		return 0;
	}
	public static void printSplitArrays(int[]arr) {
		
	}

}
