package lec3_aug18;

import java.util.Scanner;

public class DecimalToAnyBase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int db=scn.nextInt();
		int res = 0;
		int multiplier = 1;
		while (n != 0) {
			res = res + multiplier * (n % db);
			n /= db;
			multiplier *= 10;

		}
		System.out.println(res);
		scn.close();

	}

}
