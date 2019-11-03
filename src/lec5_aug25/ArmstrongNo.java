package lec5_aug25;

import java.util.Scanner;

public class ArmstrongNo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n1 = scn.nextInt();
		int n2 = scn.nextInt();
		printAllArmstrong(n1, n2);

	}

	public static void printAllArmstrong(int lo, int hi) {
		for (int i = lo; i <= hi; i++) {
			boolean res = isArmstrong(i);
			if (res) {
				System.out.println(i);
			}
		}
	}

	public static boolean isArmstrong(int n) {
		int dig = NoOfDigits(n);
		int org = n;
		int val = 0;
		while (org > 0) {
			val = val + (int) Math.pow(org % 10, dig);
			org /= 10;
		}
		if (val == n)
			return true;
		else
			return false;
	}

	public static int NoOfDigits(int n) {
		int dig = 0;
		while (n > 0) {
			dig++;
			n /= 10;
		}
		return dig;
	}

}
