package crux11aug2019;

import java.util.Scanner;

public class gdcHCF {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter two numbers: ");
		int a = scn.nextInt();
		int b = scn.nextInt();
		int gdc=1;
		int aOriginal = a;
		int bOriginal = b;
		int min;
		if (a < b) {
			min = a;
		} else {
			min = b;
		}
		int count = 1;
		while (count <= min) {
			if (a % count == 0 && b % count == 0) {
				gdc = count;
			}

			count++;
		}
		System.out.println("GDC is " + gdc);

	}

}
