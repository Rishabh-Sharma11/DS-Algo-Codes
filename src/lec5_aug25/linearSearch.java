package lec5_aug25;

import java.util.Scanner;

public class linearSearch {
	static Scanner scn=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]arr= {14,34,65,34,65,67,98,56, 87};
		int src=scn.nextInt();
		int ind=lsearch(arr,src);
		if(ind==-1)
			System.out.println("Item not found");
		else
			System.out.println("Item found at index "+ind);
	}
	public static int lsearch(int[]arr,int item) {
	
			for(int i=0;i<arr.length;i++) {
				if(arr[i]==item) {
					return i;
				}
			}
			return-1;
			
	}

}
