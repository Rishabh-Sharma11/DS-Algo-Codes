package lec14_sept29Backtracking;

public class CoinChangePermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2, 3, 5, 6 };
		System.out.println(CoinChangePermutations(arr, 10, "", 0));
	}

	public static int CoinChangePermutations(int[] denom, int amount, String ans, int count) {
		if (amount == 0) {
			count++;
			System.out.println(count + ". " + ans);
			return count;
		}
		if (amount < 0) {
			return count;
		}
		for (int i = 0; i < denom.length; i++) {

			count = CoinChangePermutations(denom, amount - denom[i], ans + denom[i], count);

		}
		return count;
	}

}
