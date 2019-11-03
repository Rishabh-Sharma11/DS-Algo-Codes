package lec5_aug25;

public class maxArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]arr= {1,3,5,76,89,32,45};
		int  max=maxArray(arr);
		System.out.println(max);
		
		
	}	
	public static int maxArray(int[]arr){
		int max=arr[0];
		for(int i=1;i<arr.length;i++) {
			if(arr[i]>max) {
				max=arr[i];
			}
		}
		return max;
	}
}
