package lec33_nov10_DynamicPragramming;

public class Rod_Cutting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] price = { 0, 1, 5, 8, 9, 10, 17, 17, 20 };
		System.out.println(rodCut(price, price.length - 1));
		System.out.println(rodCutTD(price, price.length - 1, new int[price.length]));
		System.out.println(rodCutBU(price));

	}

	public static int rodCut(int[] price, int n) {
		int left = 1;
		int right = n - 1;
		int max = price[n];
		while (left <= right) {
			int fp = rodCut(price, left);
			int sp = rodCut(price, right);
			int total = fp + sp;
			if (total > max) {
				max = total;
			}
			left++;
			right--;
		}
		return max;

	}

	public static int rodCutTD(int[] price, int n, int[] storage) {

		if (storage[n] != 0) {
			return storage[n];
		}
		int left = 1;
		int right = n - 1;
		int max = price[n];
		while (left <= right) {
			int fp = rodCutTD(price, left, storage);
			int sp = rodCutTD(price, right, storage);
			int total = fp + sp;
			if (total > max) {
				max = total;
			}
			left++;
			right--;
		}

		storage[n] = max;
		return max;

	}

	public static int rodCutBU(int[] price) {
		int[]storage=new int[price.length];
		storage[0]=price[0];
		storage[1]=price[1];
		for(int n=2;n<storage.length;n++) {
			int left = 1;
			int right = n - 1;
			int max = price[n];
			while (left <= right) {
				int fp =storage[left];
				int sp = storage[right];
				int total = fp + sp;
				if (total > max) {
					max = total;
				}
				left++;
				right--;
			}

			storage[n] = max;
		}
		
		return storage[price.length-1];
	}

}
