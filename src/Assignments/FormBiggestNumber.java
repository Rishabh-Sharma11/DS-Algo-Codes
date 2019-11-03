package Assignments;

import java.util.Scanner;

public class FormBiggestNumber {

	static Scanner scn=new Scanner(System.in);
    public static void main(String args[]) {
        int t=scn.nextInt();
		for(int i=1;i<=t;i++) {
			int n=scn.nextInt();
			int[]arr=new int[n];
			takeInput(arr);
			
            formBiggestNumber(arr);
            for(int val : arr) {
                System.out.print(val);
            }
            System.out.println();
		}
    }
    public static void takeInput(int[]arr) {
		for(int i=0;i<arr.length;i++) {
			arr[i]=scn.nextInt();
		}
	}
    public static void formBiggestNumber(int[] arr) {

		for (int count = 0; count <= arr.length - 2; count++) {

			for (int j = 0; j <= arr.length - count - 2; j++) {

				if (compare(arr[j], arr[j + 1])) {

					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}

			}


		}
	}

	public static boolean compare(int n1, int n2) {

		String n1n2s = n1+ "" + n2 ;
		String n2n1s = n2+ "" + n1 ;

		int res = n1n2s.compareTo(n2n1s)  ;

		if(res > 0) {
			return false ; // dont swap
		}else {
			return true ; // swap
		}

	}

}