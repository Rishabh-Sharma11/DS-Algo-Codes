package lec31_nov3_HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class HashMapOps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner scn = new Scanner(System.in);
//		String str = scn.next(); // abacdaaa
//		System.out.println(maxFreqChar(str));

		int[] one = { 5, 20, 10, 10, 20, 20 };
		int[] two = { 5, 40, 10, 10, 10 };
		Intersection(one, two);
		
		int[]arr= {2,12,9,16,10,5,3,20,25,11,1,8,6};
		longestSequence(arr);

	}

	public static char maxFreqChar(String str) {
		HashMap<Character, Integer> map = new HashMap<>(str.length());
		char maxfreqChar = str.charAt(0);
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (!map.containsKey(ch)) {
				map.put(ch, 1);
			} else {
				int val = map.get(ch);
				map.put(ch, val + 1);
				if (map.get(maxfreqChar) < val + 1) {
					maxfreqChar = ch;
				}
			}

//			int of=map.getOrDefault(ch, 0);
//			map.put(ch,of+1);

		}
		return maxfreqChar;
	}

	public static void Intersection(int[] one, int[] two) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < one.length; i++) {
			if (map.containsKey(one[i])) {
				int freq = map.get(one[i]);
				map.put(one[i], freq + 1);
			} else {
				map.put(one[i], 1);
			}
		}
		for (int j = 0; j < two.length; j++) {
			if (map.containsKey(two[j]) && map.get(two[j]) >= 1) {
				int freq = map.get(two[j]);
				map.put(two[j], freq - 1);
				System.out.print(two[j] + " ");
			}
		}
		System.out.println();
	}

	public static void longestSequence(int[] arr) { // Longest consecutive sequence
		HashMap<Integer, Boolean> map = new HashMap<>();
		
		for(int i=0;i<arr.length;i++) {
			
			if(map.containsKey(arr[i]-1)) {
				map.put(arr[i], false);
			}else {
				map.put(arr[i],true);
			}
			
			if(map.containsKey(arr[i]+1)) {
				map.put(arr[i]+1,false);
			}
		}
		int maxLength = 0;
		int starting=0;
		for (int key : map.keySet()) {

			if (map.get(key)) {

				int count = 0;
				while (map.containsKey(key + count)) {
					count++;
				}

				if (count > maxLength) {
					maxLength = count;
					starting = key;
				}

			}

		}

		
		for(int i=0;i<maxLength;i++) {
			System.out.print(i+starting+" ");
		}
	}

}
