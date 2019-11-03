package lec12_sept21;

public class RecursionPrintCoinToss {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printCoinToss(3,"");

	}
	public static void printCoinToss(int n,String ans) {
		if(n==0) {
			System.out.println(ans);
			return;
		}
		printCoinToss(n-1,ans+'H');
		printCoinToss(n-1,ans+'T');
	}

}
