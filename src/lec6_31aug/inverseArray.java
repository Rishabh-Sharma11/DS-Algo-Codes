package lec6_31aug;

public class inverseArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 3, 4, 0, 2, 1 };
		int[] arr2 = inverse(arr);
		display(arr2);

	}

	public static int[] inverse(int[] arr) {
		int[] arr2 = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			arr2[arr[i]] = i;
		}
		return arr2;
	}

	public static void display(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
