package lec6_31aug;

import java.util.Scanner;

public class rotateArray {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = takeInput();
		int[]arr= {10,20,30,40,50,60};
		rotate(arr);
		display(arr);

	}

	public static int[] takeInput() {
		System.out.println("Size: ");
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		return arr;
	}

	public static void display(int[] arr) {
		for (int val : arr) {
			System.out.print(val + " ");
		}
		System.out.println();
	}

	public static void rotate(int[] arr) {
		System.out.println("Number of rotation: ");
		int rot = scn.nextInt();
		int actRot = rot % arr.length;
		if(actRot<0) {
			actRot+=arr.length;
		}
		for (int i = 0; i < actRot; i++) {
			int temp=arr[arr.length-1];
			for (int j = arr.length - 1; j >0; j--) {
				
				arr[j] = arr[j-1];
				
			}
			arr[0]=temp;
		}
	}

}
