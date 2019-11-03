package lec11_sept15;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int end = scn.nextInt();
		ArrayList<String> res = getBoardPath(0, end);
		System.out.println(res);

	}

	public static ArrayList<String> getBoardPath(int curr, int end) {
		if(curr==end) {
			ArrayList<String> br=new ArrayList<>();
			br.add("");
			return br;
		}
		if(curr>end) {
			ArrayList<String> br=new ArrayList<>();
			return br;
		}
		
		ArrayList<String> mr=new ArrayList<>();
		for (int dice = 1; dice <= 6; dice++) {
			ArrayList<String> rr = getBoardPath(curr + dice, end);
			for(String val:rr) {
				mr.add(dice+val);
			}
		}
		return mr;

	}

}
