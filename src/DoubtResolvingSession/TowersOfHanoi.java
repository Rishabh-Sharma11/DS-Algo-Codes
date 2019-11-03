package DoubtResolvingSession;

import java.util.Scanner;

public class TowersOfHanoi {
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in) ;

		System.out.println(towerOfHanoi(scn.nextInt(), "T1", "T2", "T3"));

	}

	public static int towerOfHanoi(int n, String src, String dst, String helper) {

		if (n == 0) {
			return 0;
		}

		int c1 = towerOfHanoi(n - 1, src, helper, dst);
		System.out.println("Move " + n + "th disc from " + src + " to " + dst);
		int c2 = towerOfHanoi(n - 1, helper, dst, src);

		return c1 + c2 + 1;
	}

}
