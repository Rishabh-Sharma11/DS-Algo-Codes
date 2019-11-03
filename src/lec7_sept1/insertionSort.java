package lec7_sept1;

public class insertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 11, 44, 5, 5, 9, 8 };
		insertionSort(arr);
		display(arr);

	}

	public static void display(int[] arr) {
		for (int val : arr) {
			System.out.print(val + " ");
		}
		System.out.println();
	}

	public static void insertionSort(int[] arr) {
		for (int count = 1; count <= arr.length - 1; count++) {
			int temp = arr[count];
			int j = count - 1;
			while (j >= 0 && arr[j] > temp) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = temp;

		}
	}

}
