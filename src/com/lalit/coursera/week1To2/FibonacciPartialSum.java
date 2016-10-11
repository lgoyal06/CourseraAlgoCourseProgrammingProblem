package com.lalit.coursera.week1To2;

import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciPartialSum {
	private static long getFibonacciPartialSum(BigInteger from, BigInteger to) {

		int r = from.mod(new BigInteger("60")).intValue();
		int r1 = to.mod(new BigInteger("60")).intValue();

		BigInteger b1 = getFibonaciNumber(r);
		BigInteger b2 = getFibonaciNumber(r1);

		BigInteger partialSum = b2.subtract(b1);
		return partialSum.mod(new BigInteger("10")).intValue();

	}

	private static BigInteger getFibonaciNumber(int r) {
		BigInteger a = BigInteger.ZERO;
		BigInteger b = BigInteger.ONE;
		BigInteger c;
		long i;
		if (r == 0) {
			return BigInteger.ZERO;
		}
		if (r == 1) {
			return BigInteger.ONE;
		}
		for (i = 2; i <= r; i++) {
			c = a.add(b);
			a = b;
			b = c;
		}
		return b;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BigInteger n = scanner.nextBigInteger().add(new BigInteger("1"));
		BigInteger m = scanner.nextBigInteger().add(new BigInteger("2"));
		System.out.println(getFibonacciPartialSum(n, m));
	}
}
