package com.lalit.coursera.week1To2;

import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciSum {

	private static int getFibonacciSum(BigInteger n) {
		int r = n.mod(new BigInteger("60")).intValue();
		BigInteger a = BigInteger.ZERO;
		BigInteger b = BigInteger.ONE;
		BigInteger c;
		long i;
		if (r == 0) {
			return 9;
		}
		if (r == 1) {
			return 0;
		}
		for (i = 2; i <= r; i++) {
			c = a.add(b);
			a = b;
			b = c;
		}
		if (b.mod(new BigInteger("10")).intValue() == 0) {
			return 9;
		}
		return b.mod(new BigInteger("10")).intValue() - 1;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BigInteger n = scanner.nextBigInteger().add(new BigInteger("2"));
		System.out.println(getFibonacciSum(n));
	}

}