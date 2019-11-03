package assignment_Backtracking;

import java.util.ArrayList;

public class LeetCodeRestoreIPAddresses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ipAddress("25525511135","");

	}

//	public static ArrayList<String> restoreIpAddresses(String str,int dotCount){
//		
//	}
	public static void ipAddress(String str, String ans) {
		if (str.length() == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = 1; i < 3&&i<=str.length(); i++) {
			String res1 = str.substring(0, i) + ".";
			String p1 = str.substring(i);
			if (Integer.parseInt(res1.substring(0, res1.length() - 1)) < 256 && p1.charAt(0) != 0) {
				ipAddress(p1, ans+res1);
			}
		}
	}

}
