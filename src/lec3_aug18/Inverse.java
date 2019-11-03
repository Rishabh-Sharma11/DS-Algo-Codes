package lec3_aug18;

import java.util.Scanner;

public class Inverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int dig = 0;
		int org = n;
		int inv = 0;
		while (org > 0) {
			dig++;
			org /= 10;
		}
		org = n;
		for (int pos = 1; pos <= dig; pos++) {
			inv = inv + (int) Math.pow(10, org % 10 - 1) * pos;
			org /= 10;
		}
		System.out.println(inv);

	}

}
