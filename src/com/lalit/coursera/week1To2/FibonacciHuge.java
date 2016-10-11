package com.lalit.coursera.week1To2;

import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciHuge {

	static BigInteger[] arrayOfFibNumber;

	private static int getFibonacciHuge(BigInteger n, int m) {
		int r = n.mod(new BigInteger(String.valueOf(lengthOfPisanoPeriod(m)))).intValue();
		BigInteger a = BigInteger.ZERO;
		BigInteger b = BigInteger.ONE;
		BigInteger c;
		long i;
		if (r == 0) {
			return 0;
		}
		if (r == 1) {
			return 1;
		}
		for (i = 2; i <= r; i++) {
			c = a.add(b);
			a = b;
			b = c;
		}
		return b.mod(new BigInteger(String.valueOf(m))).intValue();
	}

	private static int lengthOfPisanoPeriod(int m) {
		int a = 0;
		int b = 1;
		int c = 0;
		int i;
		int count = 0;
		// TODO: Why 6* m Need to double check
		// Real logic behind it
		//Seems that PisanoPeriod always repeats after <=6m 
		for (i = 0; i <= 6 * m; i++) {
			if (a == 0 && b == 1 && count > 0) {
				break;
			}
			c = (a + b) % m;
			a = b % m;
			b = c % m;
			count = count + 1;
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BigInteger n = scanner.nextBigInteger();
		int m = scanner.nextInt();
		System.out.println(getFibonacciHuge(n, m));
	}
}
