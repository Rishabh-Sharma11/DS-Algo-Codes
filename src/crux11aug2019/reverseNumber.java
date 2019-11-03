package crux11aug2019;

import java.util.Scanner;

public class reverseNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the number: ");
		int n = scn.nextInt();
		int rev = 0;

		while (n > 0) {
			rev = rev * 10 + n % 10;
			n /= 10;
		}
		System.out.println("Reverse of the given number is " + rev);

	}

}
