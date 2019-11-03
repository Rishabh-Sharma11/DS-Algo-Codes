package assignment_Recursion;

//import java.util.Scanner;

public class ChessBoardProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner scn=new Scanner(System.in);
//		int n=scn.nextInt();
		
		int n = 3;
		printPaths(n, 0, 0, "{0-0}");
		System.out.println(countPaths(n, 0, 0, 0));

	}

	static int count = 0;

	public static void printPaths(int n, int cr, int cc, String ans) {
		if (cr == n - 1 && cc == n - 1) {
			count++;
			System.out.println(count + ". " + ans);
			return;
		}
		if (cr >= n || cc >= n) {
			return;
		}

		// Knight
		printPaths(n, cr + 2, cc + 1, ans + "K{" + (cr + 2) + "-" + (cc + 1) + "}");
		printPaths(n, cr + 1, cc + 2, ans + "K{" + (cr + 1) + "-" + (cc + 2) + "}");
		// Rook
		if (cr == 0 || cr == n - 1||cc == 0 || cc == n - 1) {
			for (int i = cc+1; i <= n - 1; i++) {
				printPaths(n, cr, i, ans + "R{" + cr + "-" + (i) + "}");
			}
			for (int i = cr+1; i <= n - 1; i++) {
				printPaths(n, i, cc, ans + "R{" + i + "-" + (cc) + "}");
			}
		}

		// Bishop
		if (cr == cc || cr == n - cc - 1) {
		for (int i = cr+1, j = cc+1; i <= n - 1 && j <=n - 1; i++, j++) {
				printPaths(n, i, j, ans + "B{" + (i) + "-" + (j) + "}");
			}
		}
	}
	public static int countPaths(int n, int cr, int cc,int count) {
		if (cr == n - 1 && cc == n - 1) {
			count++;
			return count;
		}
		if (cr >= n || cc >= n) {
			return count;
		}

		// Knight
		count=countPaths(n, cr + 2, cc + 1, count);
		count=countPaths(n, cr + 1, cc + 2, count);
		// Rook
		if (cr == 0 || cr == n - 1||cc == 0 || cc == n - 1) {
			for (int i = cc+1; i <= n - 1; i++) {
				count=countPaths(n, cr, i,count);
			}
			for (int i = cr+1; i <= n - 1; i++) {
				count=countPaths(n, i, cc, count);
			}
		}

		// Bishop
		if (cr == cc || cr == n - cc - 1) {
		for (int i = cr+1, j = cc+1; i <= n - 1 && j <=n - 1; i++, j++) {
				count=countPaths(n, i, j,count);
			}
		}
		return count;
	}


}
