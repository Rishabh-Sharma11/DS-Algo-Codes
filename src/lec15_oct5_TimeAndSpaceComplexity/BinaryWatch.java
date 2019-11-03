package lec15_oct5_TimeAndSpaceComplexity;

import java.util.ArrayList;

public class BinaryWatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
//		System.out.println(binaryToDecimal(new int[] {0,0,1,1},0,3,'m'));
		System.out.println(binaryWatch(n, 0, -1, new int[10]));
	}

	public static ArrayList<String> binaryWatch(int n, int opsf, int lastLedUsed, int[] led) {

		if (opsf == n) {
			ArrayList<String> br = new ArrayList<>();
			String time = time(led);
			if (!time.equals("")) {
				br.add(time);
			}
			return br;
		}

		ArrayList<String> rr = new ArrayList<>();
		ArrayList<String> mr = new ArrayList<>();
		for (int i = lastLedUsed + 1; i < 10; i++) {
			if (led[i] == 0) {
				led[i] = 1;
				rr = binaryWatch(n, opsf + 1, i, led);

				for (String val : rr) {
					mr.add(val);
				}
				led[i] = 0;

			}
		}
		return mr;

	}

	public static String binaryToDecimal(int[] arr, int si, int ei, char ch) {
		int multiplier = 1;
		int res = 0;
		for (int i = ei; i >= si; i--) {
			res = res + multiplier * arr[i];
			multiplier *= 2;
		}
		String str = res + "";
		if (ch == 'h') {
			if (res >= 12) {
				str = "no";
			}
		}
		if (ch == 'm') {
			if (str.length() == 1) {
				str = "0" + str;
			}
			if (res >= 60) {
				str = "no";
			}
		}
		return str;
	}

	public static String time(int[] led) {
		String hrs = binaryToDecimal(led, 0, 3, 'h');
		String min = binaryToDecimal(led, 4, 9, 'm');
		String time;
		if (hrs.equals("no") || min.equals("no")) {
			time = "";
		} else {
			time = hrs + ":" + min;
		}
		return time;
	}

}
