package lec6_31aug;

public class sortInPlaceConstantSpace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2, 0, 2, 1, 1, 0 }; // output={0,0,1,1,2,2}
		passConstSpace(arr);
		display(arr);

	}

	public static void display(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void passConstSpace(int[] arr) {
		

	}

}
