package Assignments;

import java.util.Scanner;

public class LCM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n1 = scn.nextInt();
		int n2 = scn.nextInt();
		int mult1 = 2;
		int mult2 = 2;
		int lcm, p1 = n1, p2 = n2;
		if (n1 == n2) {
			lcm = n1;
			System.out.println(lcm);
		} else {
			while (p1 != p2) {

				if (p1 < p2) {
					p1 =n1* mult1;
					mult1++;
				} else {
					p2 =n2*mult2;
					mult2++;
				}

			}
			lcm = p1;
			System.out.println(lcm);
		}

	}

}
