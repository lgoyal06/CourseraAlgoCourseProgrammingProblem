package com.lalit.coursera.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;

public class Sorting {
	private static Random random = new Random();

	private static int[] partition3(int[] a, int l, int r) {
		int x = a[l];
		int j = l;
		int s = 0;
		for (int i = l + 1; i <= r; i++) {
			if (a[i] <= x) {
				if (a[i] == x) {
					++s;
				}
				j++;
				int t = a[i];
				a[i] = a[j];
				a[j] = t;
			}
		}
		int t = a[l];
		a[l] = a[j];
		a[j] = t;

		int r1 = 0;
		if (s > 0) {
			for (int i = l; i < j; ++i) {
				if (a[i] == x) {
					// iterate till value prior to a[j] i.e. a[j-1],a[j-2] ==
					// a[j]
					while (j - r1 - 1 >= 0 && a[j - r1 - 1] == x) {
						++r1;
						--s;
					}
					// check if any other element exists in between then
					// swap it
					if (s > 0) {
						++r1;
						--s;
						a[i] = a[j - r1];
						a[j - r1] = x;
					}
					// Done and break
					if (s == 0) {
						break;
					}
				}
			}
		}

		int[] m = { j - r1, j };
		return m;

	}

	public static void randomizedQuickSort(int[] a, int l, int r) {
		if (l >= r) {
			return;
		}
		int k = random.nextInt(r - l + 1) + l;
		int t = a[l];
		a[l] = a[k];
		a[k] = t;
		int[] m = partition3(a, l, r);
		randomizedQuickSort(a, l, m[0] - 1);
		randomizedQuickSort(a, m[1] + 1, r);
	}

	public static void main(String[] args) {
		FastScanner scanner = new FastScanner(System.in);
		int n = scanner.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		randomizedQuickSort(a, 0, n - 1);
		for (int i = 0; i < n; i++) {
			System.out.print(a[i] + " ");
		}
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
