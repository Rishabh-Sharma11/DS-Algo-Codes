package Assignments;

import java.util.Scanner;

public class wavePrintRowWise {

	static Scanner scn=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][]arr=takeInput();
		wavePrintRow(arr);

	}
	public static int[][]takeInput(){
		int r=scn.nextInt();
		int c=scn.nextInt();
		int[][]arr=new int[r][c];
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				arr[i][j]=scn.nextInt();
			}
		}
		return arr;
	}
	public static void wavePrintRow(int[][]arr) {
		for(int r=0;r<arr.length;r++) {
			if(r%2==0) {
				for(int c=0;c<arr[0].length;c++) {
					System.out.print(arr[r][c]+", ");
				}
			}else {
				for(int c=arr[0].length-1;c>=0;c--) {
					System.out.print(arr[r][c]+", ");
				}
			}
		}
		System.out.println("END");
	}

}
