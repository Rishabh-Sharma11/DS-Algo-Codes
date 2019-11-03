package crux11aug2019;

import java.util.Scanner;

public class fibonacciSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("For printing fibanacci series upto kth fibonacci, enter k: ");
		int n = scn.nextInt();
		int a = 0;
		int b = 1;
		int i = 3;
		if (n == 1 || n == 2) {
			if (n == 1) {
				System.out.println(a);
			} else {
				System.out.print(a + "," + b);
			}
		} else {
			System.out.print(a + "," + b);
			while (i <= n + 1) {
				int temp = a;
				a = b;
				b = temp + b;
				System.out.print("," + b);
				i++;
			}

		}
	}

}
