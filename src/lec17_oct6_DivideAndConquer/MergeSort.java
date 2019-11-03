package lec17_oct6_DivideAndConquer;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 70, 80, 20, 30, 90, 10 };
		int[] res = mergeSort(arr, 0, arr.length - 1);
		for (int val : res) {
			System.out.print(val + " ");
		}
	}

	public static int[] mergeTwoSortedArrays(int[] one, int[] two) {
		int[] ans = new int[one.length + two.length];
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < one.length && j < two.length) {
			if (one[i] < two[j]) {
				ans[k] = one[i];
				i++;
				k++;
			} else {
				ans[k] = two[j];
				k++;
				j++;
			}
		}
		while (i < one.length) {
			ans[k] = one[i];
			i++;
			k++;
		}
		while (j < two.length) {
			ans[k] = two[j];
			k++;
			j++;
		}

		return ans;

	}

	public static int[] mergeSort(int[] arr, int lo, int hi) {
		if (lo == hi) {
			int[] br = new int[1];
			br[0] = arr[lo];
			return br;
		}

		int mid = (lo + hi) / 2;
		int[] fh = mergeSort(arr, lo, mid);
		int[] sh = mergeSort(arr, mid + 1, hi);
		int[] merged = mergeTwoSortedArrays(fh, sh);
		return merged;
	}

}
