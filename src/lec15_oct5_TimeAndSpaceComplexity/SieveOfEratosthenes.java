package lec15_oct5_TimeAndSpaceComplexity;

import java.util.Arrays;

public class SieveOfEratosthenes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SOE(25);
	}

	public static void SOE(int n) {
		boolean[] primes = new boolean[n + 1];
		Arrays.fill(primes, true);
		primes[0]=false;
		primes[1]=false;
		for (int table = 2; table * table <= n; table++) {
			if (primes[table] == false) {
				continue;
			}
			for (int mult = 2; table * mult <= n; mult++) {
				primes[table * mult] = false;
			}
		}
		for (int i = 0; i < primes.length; i++) {
			if (primes[i] == true)
				System.out.println(i);
		}
	}

}
