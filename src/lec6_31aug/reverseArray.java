package lec6_31aug;

import java.util.Scanner;

public class reverseArray {

	static Scanner scn=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]arr= takeInput();
		reverse(arr);
		display(arr);
	}
	public static int[] takeInput() {
		System.out.println("Size: ");
		int n=scn.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<arr.length;i++) {
			arr[i]=scn.nextInt();
		}
		return arr;
	}
	public static void reverse(int[]arr) {
		for(int i=0;i<(arr.length)/2;i++) {
			int temp=arr[i];
			arr[i]=arr[arr.length-i-1];
			arr[arr.length-i-1]=temp;
			
		}
	}
	public static void display(int[]arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}

}
