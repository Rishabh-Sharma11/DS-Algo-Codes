package Assignments;

import java.util.Scanner;

public class basicCalculator {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char ch;
		ch = scn.next().charAt(0);
		while (ch != 'X' && ch != 'x') {

			if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '%') {
				int a = scn.nextInt();
				int b = scn.nextInt();
				switch (ch) {
				case '+':
					System.out.println(a + b);
					break;
				case '-':
					System.out.println(a - b);
					break;
				case '*':
					System.out.println(a * b);
					break;
				case '/':
					System.out.println(a / b);
					break;
				default:
					System.out.println(a % b);
				}
			} else {
				System.out.println("Invalid operation. Try again.");
			}
			ch = scn.next().charAt(0);
		}

	}

}
