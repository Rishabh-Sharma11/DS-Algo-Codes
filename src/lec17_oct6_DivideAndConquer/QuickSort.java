package lec17_oct6_DivideAndConquer;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]arr= {50,40,80,90,70,10,30,60,120};
		quickSort(arr,0,arr.length-1);
		for(int val:arr) {
			System.out.print(val+" ");
		}

	}
	public static void quickSort(int[]arr,int lo,int hi) {
		if(lo>=hi) {
			return;
		}
		int left=lo;
		int right=hi;
		int mid=(left+right)/2;
		int pivot=arr[mid];
		//partition
		while(left<=right) {
			while(arr[left]<pivot) {
				left++;
			}
			while(arr[right]>pivot) {
				right--;
			}
			//solve the problem
			if(left<=right) {
				int temp=arr[left];
				arr[left]=arr[right];
				arr[right]=temp;
				left++;
				right--;
			}
			
		}
		//partition completed
		quickSort(arr,lo,right);
		quickSort(arr,left,hi);
	}

}
