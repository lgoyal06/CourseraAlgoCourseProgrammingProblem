package com.lalit.coursera.week3;

import java.util.Scanner;

public class LargestNumber {
	private static String largestNumber(String[] a) {
		// O(n^2)

		String max = "";
		int maxIndex = 0;
		for (int i = 0; i < a.length; ++i) {
			max = a[i];
			maxIndex = i;
			for (int j = i + 1; j < a.length; ++j) {
				// Definition to find max
				String firstElementForComparison = max + a[j];
				String secondElementForComparison = a[j] + max;
				if (Integer.valueOf(secondElementForComparison) >= Integer.valueOf(firstElementForComparison)) {
					max = a[j];
					maxIndex = j;
				}
			}
			if (maxIndex != i) {
				a[maxIndex] = a[i];
				a[i] = max;
			}
		}
		// O(n)
		String result = "";
		for (int i = 0; i < a.length; i++) {
			result += a[i];
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		String[] a = new String[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.next();
		}
		System.out.println(largestNumber(a));
	}
}
