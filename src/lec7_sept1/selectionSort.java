package lec7_sept1;

public class selectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 88, 77, 11, 55 };
		selectionSort(arr);
		display(arr);

	}

	public static void display(int[] arr) {
		for (int val : arr) {
			System.out.print(val + " ");
		}
		System.out.println();
	}

	public static void selectionSort(int[] arr) {
		for (int count = 0; count < arr.length-1; count++) {
			int min = count;
			for (int j = count + 1; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			// swap
			int temp = arr[min];
			arr[min] = arr[count];
			arr[count] = temp;
		}
	}

}
