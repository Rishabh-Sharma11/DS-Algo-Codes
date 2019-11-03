package lec6_31aug;

public class bubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 60, 50, 70, 30, 20, 40 };
		bubbleSort(arr);
		display(arr);

	}

	public static void display(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void bubbleSort(int[] arr) {
		for (int i = 0; i <= arr.length - 2; i++) {
			for (int j = 0; j <= arr.length - i - 2; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

}
