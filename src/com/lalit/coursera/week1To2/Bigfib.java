package com.lalit.coursera.week1To2;

import java.math.BigDecimal;
import java.math.BigInteger;

class Bigfib {
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		BigInteger x = new BigInteger("1");
		BigInteger y = new BigInteger("0");
		BigInteger t;
		for (int k = 1; k <= n; k++) {
			x = x.add(y);
			y = x.subtract(y);
		}
		BigDecimal xd = new BigDecimal(x,
				25); /*
						 * converts BigInteger x to a BigDecimal with 25 decimal
						 * digits
						 */
		BigDecimal yd = new BigDecimal(y, 25);
		BigDecimal ratio = (xd.divide(yd,
				1)); /*
						 * the second argument of divide controls how the result
						 * is rounded to 25 digits
						 */
		System.out.println("\nFib(" + ++n + ")/Fib(" + --n + ") = " + ratio + "\n");
		System.out.println("p = " + (1 + Math.sqrt((double) 5)) / 2 + "\n");
		/*
		 * Math is a class in java.lang which contains various standard
		 * numerical operations: sqrt, log, exponential, trig functions, etc.
		 */
		// recently added code to compute the number of digits in Fib(n)
		String s = y.toString(); // converts BigInteger to String of digits
		int len = s.length(); // length( ) returns the # of chars in String s
		System.out.println("Fib(" + n + ") = " + y + "\n");
		System.out.println("\nand has " + len + " digits\n");
	}
}