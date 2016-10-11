package com.lalit.coursera.week1To2;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author lalit goyal
 * 
 *         Hint : What To Do Instead of computing this sum in a loop, try to
 *         come up with a formula for this sum. For this, play with small values
 *         of ð?‘›. Then, use a solution for the previous problem.
 * 
 */
public class FibonacciSum_1 {
	private static void getFibonacciSum(int n) {

		BigDecimal bd1 = new BigDecimal((1 + Math.sqrt(5)) / 2);
		BigDecimal bd2 = new BigDecimal((1 - Math.sqrt(5)) / 2);
		BigDecimal bd4 = new BigDecimal(Math.sqrt(5));
		BigDecimal bd3;

		bd3 = ((bd1.pow(n + 2).subtract(bd2.pow(n + 2))).divide(bd4)).subtract(BigDecimal.ONE)
				.remainder(BigDecimal.TEN);
		System.out.println(bd3.toBigInteger());
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		getFibonacciSum(n);
		// System.out.println(c);
	}
}
