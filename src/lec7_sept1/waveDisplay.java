package lec7_sept1;

public class waveDisplay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 } };
		wavedisplay(arr);

	}

	public static void wavedisplay(int[][] arr) {
		for (int i = 0; i < arr[0].length; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < arr.length; j++) {

					System.out.print(arr[j][i] + " ");

				}
			} else {
				for (int j = arr.length - 1; j >= 0; j--) {
					System.out.print(arr[j][i] + " ");

				}

			}
		}
	}

}
