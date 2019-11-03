package lec11_sept15;

import java.util.ArrayList;
import java.util.Scanner;

public class MazePath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int row = scn.nextInt();
		int col = scn.nextInt();
		ArrayList<String> res = getMazePath(row, col, 0, 0);
		System.out.println(res);

	}

	public static ArrayList<String> getMazePath(int row, int col, int cr, int cv) {
		if (cr == row - 1 && cv == col - 1) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		} else if (cr > row - 1 || cv > col - 1) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();
		ArrayList<String> rrH = getMazePath(row, col, cr + 1, cv);
		for (String val : rrH) {
			mr.add('H' + val);
		}
		ArrayList<String> rrV = getMazePath(row, col, cr, cv + 1);
		for (String val : rrV) {
			mr.add('V' + val);
		}
		return mr;

	}

}
