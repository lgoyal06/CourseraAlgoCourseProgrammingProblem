package com.lalit.coursera.week1To2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaxPairwiseProduct {
	static long getMaxPairwiseProduct(long[] numbers) {
		long n = numbers.length;
		long maxValue = 0;
		long maxVal_index = 0;
		long secondMaxValue = 0;

		for (int i = 0; i < n; ++i) {
			if (maxValue < numbers[i]) {
				maxValue = numbers[i];
				maxVal_index = i;
			}
		}
		for (int i = 0; i < n; ++i) {
			if (secondMaxValue < numbers[i] && i != maxVal_index) {
				secondMaxValue = numbers[i];
			}
		}
		return maxValue * secondMaxValue;
	}

	public static void main(String[] args) {
		FastScanner scanner = new FastScanner(System.in);
		int n = scanner.nextInt();
		long[] numbers = new long[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = Long.valueOf(scanner.next());
		}
		System.out.println(getMaxPairwiseProduct(numbers));
	}

	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		FastScanner(InputStream stream) {
			try {
				br = new BufferedReader(new InputStreamReader(stream));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}

}