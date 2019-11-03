package lec3_aug18;

import java.util.Scanner;

public class subset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int org = n;

		int dig = 0;
		while (org != 0) {
			org /= 10;
			dig++;
		}

		int nob = (int) Math.pow(2, dig);
		for (int cob = 0; cob < nob; cob++) {
			org = n;
			int subset = 0;
			int multiplier = 1;
			int bin = 0;
			int cobb = cob;
			while (cobb != 0) {
				bin += multiplier * (cobb % 2);
				cobb /= 2;
				multiplier *= 10;
			}
			int dbin = bin;
			if (bin == 0) {
				System.out.print("void, ");
			} else {
				for (int j = 1; j <= dig; j++) {
					int val = org % 10;
					int bit = dbin % 10;
					if (bit == 1) {
						subset = subset * 10 + val;

					}

					org /= 10;
					dbin /= 10;
				}
				// System.out.print("("+subset+")"+", ");
				int dsubset = subset;
				System.out.print("{");
				while (dsubset != 0) {
					System.out.print(dsubset % 10);
					dsubset /= 10;
					if (dsubset != 0)
						System.out.print(",");
				}
				System.out.print("}");
				if (cob < nob - 1)
					System.out.print(", ");
			}

		}

	}

}
