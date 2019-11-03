package crux11aug2019;

import java.util.Scanner;

public class sumOf_n_numbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int c = 1;
		int sum = 0;
		while (c <= n) {
			sum = sum + c; // sum+=c;
			c = c + 1;
		}
		System.out.println(sum);

	}

}
