package lec5_aug25;

public class NextGreaterNumberWithSameDigSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 2, 1, 8, 7, 6, 5 };
		for (int i = 5; i >= 0; i--) {
			int flag = 0;
			int j = i - 1;
			int temp1 = a[i];
			int n = a[i];
			for (; j >= 0; j--) {
				if (a[i] > a[j]) {
					flag = 1;
					int temp = a[j + 1];
					a[j + 1] = a[j];
					a[j] = temp;

				}

			}
			a[j+1] = temp1;

			if (flag == 1)
				break;
		}
		for (int i = 0; i <= 5; i++) {
			System.out.print(a[i]);
		}

	}

}
