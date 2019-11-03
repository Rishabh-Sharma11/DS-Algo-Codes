package lec6_31aug;

public class subSets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]arr= {10,20,30};
		subset(arr);

	}
	public static void subset(int[]arr) {
		int limit=(int)Math.pow(2,arr.length);
		for(int i=0;i<limit;i++) {
			int temp=i;
			for(int digit=0;digit<arr.length;digit++) {
				int rem=temp%2;
				if(rem%2==1)
					System.out.print(arr[digit]+" ");
				temp/=2;
			}
			System.out.println();
		}
	}
	

}
