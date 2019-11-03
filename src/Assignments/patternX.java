package Assignments;

import java.util.Scanner;

public class patternX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int non = 2 * n - 1;

		int row = 1;
		while (row <= 2 * n - 1) {

			int con = 1;
			while (con <= non) {
				if (con == row || con == (2 * n - 1 - row + 1)) {
					if (row <= n)
						System.out.print(row);
					else
						System.out.print(2 * n - 1 - row + 1);

				}

				else
					System.out.print(" ");
				con++;

			}
			System.out.println();

			row++;
		}

	}

}
