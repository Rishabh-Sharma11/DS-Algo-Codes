package Assignments;

import java.util.Scanner;

public class patternDoubleSidedArrow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int nsp1 = n - 1;
		int nsp2 = -1;
		int non = 1;
		int row = 1;
		while (row <= n) {
			int val;
			if (row < (n / 2 + 1))
				val = row;
			else
				val = n - row + 1;
			int csp1 = 1;
			while (csp1 <= nsp1) {
				System.out.print(" ");
				csp1++;
			}
			int con = 1;
			while (con <= non) {
				System.out.print(val);
				con++;
				val--;
			}
			int csp2 = 1;
			while (csp2 <= nsp2) {
				System.out.print(" ");
				csp2++;
			}
			con = 1;

			val = 1;
			while (con <= non) {
				if (row == 1 || row == n) {
					con++;
					continue;
				}
				System.out.print(val);
				con++;
				val++;
			}
			if (row < (n / 2 + 1)) {
				nsp1 -= 2;
				nsp2 += 2;
				non++;
			} else {
				nsp1 += 2;
				nsp2 -= 2;
				non--;
			}

			row++;
			System.out.println();
		}

	}

}
