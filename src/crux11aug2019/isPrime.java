package crux11aug2019;

import java.util.Scanner;

public class isPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int n = scn.nextInt();
		int i = 2, f = 0;
		while (i <= n / 2) {
			if (n % i == 0) {
				f = 1;
				break;
			}
			i++;
		}
		if (f == 0) {
			System.out.println("Prime");
		} else {
			System.out.println("Not Prime");
		}

	}

}
