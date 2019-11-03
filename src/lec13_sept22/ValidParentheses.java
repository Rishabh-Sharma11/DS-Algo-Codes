package lec13_sept22;

public class ValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printValidParantheses(3, "", 0, 0);
		// co= count of opening , cc=count of closing

	}

	public static void printValidParantheses(int n, String ans, int co, int cc) {
		// positive base case
		if (co == n && cc == n) {
			System.out.println(ans);
			return;
		}
		// negative base case
		if (co > n || cc > n || cc > co) {
			return;
		}
		printValidParantheses(n, ans + '(', co + 1, cc);
		printValidParantheses(n, ans + ')', co, cc + 1);
	}

}
