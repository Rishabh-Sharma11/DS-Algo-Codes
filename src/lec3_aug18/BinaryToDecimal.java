package lec3_aug18;

import java.util.Scanner;

public class BinaryToDecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int res = 0;
		int multiplier = 1;
		while (n != 0) {
			res = res + multiplier * (n % 10);
			n /= 10;
			multiplier *= 2;

		}
		System.out.println(res);
		scn.close();

	}

}
