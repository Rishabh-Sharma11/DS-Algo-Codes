package lec33_nov10_DynamicPragramming;

public class SetBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
		int[] arr = new int[n + 1];
		func(arr,n);
		for (int val : arr) {
			System.out.print(val + " ");
		}

	}

	public static void func(int[] storage,int n) {
		
		storage[0]=0;
		storage[1]=1;
		for (int i = 2; i <=n; i++) {
			if(i%2==0) {
				storage[i]=storage[i/2];
			}else {
				storage[i]=storage[i/2]+1;
			}
		}
	}

}
