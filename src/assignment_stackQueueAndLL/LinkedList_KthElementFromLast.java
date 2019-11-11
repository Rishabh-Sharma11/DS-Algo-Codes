package assignment_stackQueueAndLL;

import java.util.LinkedList;
import java.util.Scanner;

public class LinkedList_KthElementFromLast {
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		LinkedList<Integer> ll=new LinkedList<>();
		while(true) {
			int item=scn.nextInt();
			if(item==-1) {
				break;
			}
			ll.addLast(item);
		}
		int k=scn.nextInt();
		LinkedList<Integer> helper=new LinkedList<>();
		for(int i=1;i<k;i++) {
			int rm=ll.removeLast();
			helper.addFirst(rm);
		}
		int result=ll.removeLast();
		System.out.println(result);
	}

}
