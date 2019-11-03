package lec12_sept21;

import java.util.ArrayList;
import java.util.Scanner;

public class MazePathMultipleMoves {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int row = scn.nextInt();
		int col = scn.nextInt();
		ArrayList<String> res = getMazePathMultipleMoves(row, col, 0, 0);
		System.out.println(res.size());

	}

	public static ArrayList<String> getMazePathMultipleMoves(int er, int ec, int cr, int cc) {
		if (cr == er && cc == ec) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		} else if (cr > er || cc > ec) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}
		ArrayList<String> mr = new ArrayList<>();
		for (int move = 1; move <= er - cr; move++) {
			ArrayList<String> rrH = getMazePathMultipleMoves(er, ec, cr + move, cc);
			for (String val : rrH) {
				mr.add("V" + move + val);
			}
		}
		for (int move = 1; move <= ec - cc; move++) {
			ArrayList<String> rrV = getMazePathMultipleMoves(er, ec, cr, cc + move);
			for (String val : rrV) {
				mr.add("H" + move + val);
			}
		}
		for (int move = 1; move <= ec - cc && move <= er - cr; move++) {
			ArrayList<String> rrD = getMazePathMultipleMoves(er, ec, cr + move, cc + move);
			for (String val : rrD) {
				mr.add("D" + move + val);
			}
		}
		return mr;

	}

}
