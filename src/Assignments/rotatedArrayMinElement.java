package Assignments;

import java.util.Scanner;

public class rotatedArrayMinElement {

	static Scanner scn=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=scn.nextInt();
		int[]arr=new int[n];
		takeInput(arr);
		int min=func(arr);
		System.out.println(min);

	}
	public static void takeInput(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
	}
	public static int func(int[]arr) {
		int min=arr[0];
		for(int i=1;i<arr.length;i++) {
			if(arr[i]<arr[i-1]) {
				min=arr[i];
				break;
			}
		}
		return min;
	}

}
