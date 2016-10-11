package com.lalit.coursera.week3;

import java.util.Scanner;

public class DotProduct {
	private static long maxDotProduct(int[] a, int[] b) {

		// 2*O(n^2) ~ O(n^2)
		a = sortArrayOrderByDesc(a);
		b = sortArrayOrderByDesc(b);

		long result = 0;
		for (int i = 0; i < a.length; i++) {
			long product = (long) a[i] * b[i];
			result += product;
		}
		return result;
	}

	private static int[] sortArrayOrderByDesc(int[] array) {
		int max = 0;
		int maxIndex = 0;
		// O(n) * O(n)
		for (int i = 0; i < array.length; ++i) {
			max = array[i];
			maxIndex = i;
			for (int j = i + 1; j < array.length; ++j) {
				if (array[j] > max) {
					max = array[j];
					maxIndex = j;
				}
			}
			if (maxIndex != i) {
				array[maxIndex] = array[i];
				array[i] = max;
			}
		}
		return array;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			b[i] = scanner.nextInt();
		}
		System.out.println(maxDotProduct(a, b));
	}
}
