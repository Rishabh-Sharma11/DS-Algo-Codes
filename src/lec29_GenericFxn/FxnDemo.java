package lec29_GenericFxn;

import java.util.ArrayList;
import java.util.Comparator;

public class FxnDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Car[] carr = new Car[5];
		carr[0] = new Car(10, 6, "Black");
		carr[1] = new Car(500, 8, "White");
		carr[2] = new Car(80, 2, "Red");
		carr[3] = new Car(90, 9, "Yellow");
		carr[4] = new Car(5, 1, "Grey");

		display(carr);
		System.out.println("--------------------------");
		bubbleSort(carr);
		display(carr);

		Car2[] carr2 = new Car2[5];
		carr2[0] = new Car2(10, 6, "Black");
		carr2[1] = new Car2(500, 8, "White");
		carr2[2] = new Car2(80, 2, "Red");
		carr2[3] = new Car2(90, 9, "Yellow");
		carr2[4] = new Car2(5, 1, "Grey");

		System.out.println("----------------");
		bubbleSortUsingComparator(carr2, new CarPriceComparator());
		display(carr2);

		LinkedListGeneric<ArrayList<Integer>> l = new LinkedListGeneric<>();
		l.addLast(new ArrayList<>());
		l.getLast().add(10);
		l.getLast().add(20);
		l.getLast().add(30);
		l.addLast(new ArrayList<>());
		l.getLast().add(40);
		l.getLast().add(40);
		l.display();

	}

	public static <T> void display(T[] arr) {
		for (T val : arr) {
			System.out.println(val);
		}
	}

	public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
		for (int i = 0; i <= arr.length - 2; i++) {
			for (int j = 0; j <= arr.length - i - 2; j++) {
				if (arr[j].compareTo(arr[j + 1]) > 0) { // when this is more and other is less, then only swapping will
														// take place
					T temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	public static <T> void bubbleSortUsingComparator(T[] arr, Comparator<T> comp) {
		for (int i = 0; i <= arr.length - 2; i++) {
			for (int j = 0; j <= arr.length - i - 2; j++) {
				if (comp.compare(arr[j], arr[j + 1]) > 0) { // when this is more and other is less, then only swapping
															// will take place
					T temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

}
