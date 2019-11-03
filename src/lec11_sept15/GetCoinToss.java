package lec11_sept15;

import java.util.ArrayList;
import java.util.Scanner;

public class GetCoinToss {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n= scn.nextInt();
		ArrayList<String> res = getcointoss(n);
		System.out.println(res);

	}
	public static ArrayList<String> getcointoss(int n){
		
		if(n==0) {
			ArrayList<String> br=new ArrayList<>();
			br.add("");
			return br;
		}
		
		ArrayList<String> rr=getcointoss(n-1);
		ArrayList<String> mr=new ArrayList<>();
		for(String val:rr) {
			mr.add('H'+val);
			mr.add('T'+val);
		}
		return mr;
		
	}

}
