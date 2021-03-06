package com.lalit.coursera.week1To2;

import java.util.Scanner;

public class LCM {
	private static long gcd(long a, long b) {
		if (a % b == 0) {
			return b;
		}
		return gcd(b, a % b);
	}

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		long a = scanner.nextLong();
		long b = scanner.nextLong();
		if (a > b)
			System.out.println((a * b) / gcd(a, b));
		else {
			System.out.println((a * b) / gcd(b, a));
		}
	}
}
