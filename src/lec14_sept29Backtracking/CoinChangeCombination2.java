package lec14_sept29Backtracking;

public class CoinChangeCombination2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		coinChangeCombination(new int[] {2, 3, 5, 6},0,10,"");

	}
	public static void coinChangeCombination(int[]arr,int vidx,int amount,String ans) {
		if(amount==0) {
			System.out.println(ans);
			return;
		}
		if(vidx==arr.length||amount<0) {
			return;
		}
		
		//yes
		coinChangeCombination(arr, vidx, amount-arr[vidx], ans+arr[vidx]);
		//no
		coinChangeCombination(arr, vidx+1, amount, ans);
	}
}
