package lec2_aug17;

import java.util.Scanner;

public class pattern32 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int nst = 1;
		int row = 1;
		int val = 1;
		while (row <= 2 * n - 1) {
			if (row <= n)
				val = row;
			else
				val = (2 * n - 1) - row + 1;

			int cst = 1;
			while (cst <= nst) {
				if (cst % 2 != 0) {
					System.out.print(val);
				} else {
					System.out.print("*");
				}
				cst++;
			}

			if (row <= n - 1) {
				nst += 2;
			} else {
				nst -= 2;
			}
			row++;
			System.out.println();
			scn.close();

		}

	}

}
