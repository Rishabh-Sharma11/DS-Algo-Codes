package lec3_aug18;

import java.util.Scanner;

public class Rotate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int rnum = scn.nextInt();
		int rot = 0;

		int org = n;
		int dig = 0;
		while (org > 0) {
			dig++;
			org /= 10;
		}
		org = n;

		int arnum = rnum % dig;

		int i = 1;

		if (arnum < 0) {
			arnum+=dig;
		}
		while (i <= arnum) {
			rot = (int) Math.pow(10, dig - 1) * (org % 10);
			org /= 10;
			rot += org;

			org = rot;

			i++;
		}

		System.out.println("Rotated number is " + rot);

	}

}
