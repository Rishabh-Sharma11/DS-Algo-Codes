package lec9_sept8;

public class RecursionPower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(power(2,5));

	}
	public static int power(int x,int n) {
		if(n==1) {
			return x;
		}
		int sp=power(x,n-1);
		int ans=sp*x;
		return ans;
	}

}
