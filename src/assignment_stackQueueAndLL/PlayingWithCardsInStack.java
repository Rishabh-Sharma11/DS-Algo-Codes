package assignment_stackQueueAndLL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class PlayingWithCardsInStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int Q = scn.nextInt();
		Stack<Integer> a0 = new Stack<>();
		for(int i=0;i<n;i++) {
			a0.push(scn.nextInt());
		}
		int[] primes = new int[Q];
		int i = 0;
		int count = 0;
		while (count < Q) {
			if (isPrime(i)) {
				primes[count] = i;
				count++;
			}
			i++;
		}
		playingWithCards(primes, a0, Q);

	}

	private static void playingWithCards(int[] primes, Stack<Integer> a0, int Q) {
		ArrayList<Stack<Integer>> A = new ArrayList<>();
		ArrayList<Stack<Integer>> B = new ArrayList<>();
		B.add(new Stack<Integer>());
		A.add(a0);
		for (int i = 1; i <= Q; i++) {
			Stack<Integer> nB = new Stack<>();
			Stack<Integer> nA = new Stack<>();
			while (!A.get(i - 1).isEmpty()) {
				int te = A.get(i - 1).pop();
				if (te % primes[i - 1] == 0) {
					nB.push(te);
				} else {
					nA.push(te);
				}
			}
			A.add(nA);
			B.add(nB);
		}
		for (int i = 1; i < B.size(); i++) {
			while (!B.get(i).isEmpty()) {
				System.out.println(B.get(i).pop());
			}
		}
		while (!A.get(A.size() - 1).isEmpty()) {
			System.out.println(A.get(A.size() - 1).pop());
		}

	}

	public static boolean isPrime(int n) {
		if (n == 0 || n == 1) {
			return false;
		}
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

}
