package Assignments;

public class MaxSumPath {
	public static void main(String[] args) {

		int[] one = { 2, 3, 7, 10, 12, 15, 30, 34 };
		int[] two = { 1, 5, 7, 8, 10, 15, 16, 19 };

		int i = 0;
		int j = 0;

		int s1 = 0;
		int s2 = 0;

		int total = 0;

		while (i < one.length && j < two.length) {

			if (one[i] < two[j]) {
				s1 += one[i];
				i++;
			} else if (one[i] > two[j]) {
				s2 += two[j];
				j++;
			} else {

				total += Math.max(s1, s2) + one[i];

				i++;
				j++;

				s1 = 0;
				s2 = 0;

			}

		}

		if (i == one.length) {

			while (j < two.length) {
				s2 += two[j];
				j++;
			}
		}

		if (j == two.length) {

			while (i < one.length) {
				s1 += one[i];
				i++;
			}
		}

		total += Math.max(s1, s2);

		System.out.println(total);

	}

}
