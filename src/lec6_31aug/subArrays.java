package lec6_31aug;

public class subArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 20, 30, 40 };
		subArray(arr);

	}

	public static void display(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void subArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {

			for (int j = i; j < arr.length; j++) {
				int[] subarray = new int[j - i + 1];
				int l = 0;
				for (int k = i; k <= j; k++) {
					subarray[l++] = arr[k];
				}
				display(subarray);
			}
		}
	}

}
