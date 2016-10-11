package com.lalit.coursera.week1To2;

import java.util.Scanner;

public class FibonacciLastDigit {
	static long[] arrayOfFibNumber;

	private static long calc_fib(int n) {
		arrayOfFibNumber = new long[n + 1];
		if (n <= 1)
			return n;
		else {
			arrayOfFibNumber[0] = 0;
			arrayOfFibNumber[1] = 1;
			for (int i = 2; i <= n; ++i) {
				arrayOfFibNumber[i] = arrayOfFibNumber[i - 1] % 10 + arrayOfFibNumber[i - 2] % 10;
			}
		}
		return arrayOfFibNumber[n] % 10;
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		System.out.println(calc_fib(n));
	}
}
