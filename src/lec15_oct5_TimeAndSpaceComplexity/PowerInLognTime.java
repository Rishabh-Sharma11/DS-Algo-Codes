package lec15_oct5_TimeAndSpaceComplexity;

public class PowerInLognTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x=2;
		int n=10;
		System.out.println(power(x,n));

	}

	public static int power(int x, int n) {
		if(n==1) {
			return x;
		}
		int sp = power(2, n / 2);
		int res;
		if (n % 2 == 0) {
			res = sp * sp;
		}else {
			res=sp*sp*x;
		}
		return res;
	}

}
