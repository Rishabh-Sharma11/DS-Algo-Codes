package lec14_sept29Backtracking;

public class CoinChangeCombination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]arr= {2,3,5,6};
		CoinChangeCombinations(arr,10,"",0);

	}
	public static void CoinChangeCombinations(int[]denom, int amount,String ans,int lastDenomIdx) {
		if(amount==0) {
			System.out.println(ans);
			return;
		}
		if(amount<0) {
			return;
		}
		for(int i=lastDenomIdx;i<denom.length;i++) {
			CoinChangeCombinations(denom, amount-denom[i], ans+denom[i], i);
		}
	}

}
