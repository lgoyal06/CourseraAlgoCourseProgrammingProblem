package com.lalit.coursera.week4;

import java.util.Random;
import java.util.Scanner;

public class PointsAndSegments {

	private static Random random = new Random();

	private static int[] partition3(int[] a, int b[], int l, int r) {

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
				t = b[i];
				b[i] = b[j];
				b[j] = t;
			}
		}

		int t = a[l];
		a[l] = a[j];
		a[j] = t;
		t = b[l];
		b[l] = b[j];
		b[j] = t;

		int r1 = 0;
		if (s > 0) {
			for (int i = l; i < j; ++i) {
				if (a[i] == x) {
					while (j - r1 - 1 >= 0 && a[j - r1 - 1] == x) {
						++r1;
						--s;
					}
					if (s > 0) {
						++r1;
						--s;

						a[i] = a[j - r1];
						a[j - r1] = x;
						int t1 = b[i];
						b[i] = b[j - r1];
						b[j - r1] = t1;

					}
					if (s == 0) {
						break;
					}
				}
			}
		}
		int[] m = { j - r1, j };
		return m;
	}

	private static void randomizedQuickSort(int[] a, int b[], int l, int r) {
		if (l >= r) {
			return;
		}
		int k = random.nextInt(r - l + 1) + l;
		int t = a[l];
		a[l] = a[k];
		a[k] = t;

		t = b[l];
		b[l] = b[k];
		b[k] = t;

		int[] m = partition3(a, b, l, r);
		randomizedQuickSort(a, b, l, m[0] - 1);
		randomizedQuickSort(a, b, m[1] + 1, r);
	}

	private static int getUpperLimitOfMatchingSegmentForAPoint(int[] a, int[] b, int x) {
		int left = 0, right = a.length - 1;
		while (left <= right) {
			int mid = ((left + right) % 2 == 0 ? (left + right) / 2 : ((left + right) / 2) + 1);
			if (x >= a[mid]) {
				if (mid < a.length - 1 && (x >= a[mid + 1])) {
					left = mid + 1;
				} else {
					return mid;
				}
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}

	public static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
		int[] cnt = new int[points.length];
		// QuickSort - O(n*log(n))
		randomizedQuickSort(starts, ends, 0, starts.length - 1);
		// O(i*log(n))+O(i*lastIndexOfValue)
		for (int i = 0; i < points.length; ++i) {
			// Binary Search to have counts - log(n)
			int lastIndexOfValue = getUpperLimitOfMatchingSegmentForAPoint(starts, ends, points[i]);
			if (lastIndexOfValue == -1)
				cnt[i] = 0;
			else {
				int occurance = 0;
				// O(i*lastIndexOfValue)
				while (lastIndexOfValue >= 0) {
					if (points[i] <= ends[lastIndexOfValue])
						++occurance;
					--lastIndexOfValue;
				}
				cnt[i] = occurance;
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n, m;
		n = scanner.nextInt();
		m = scanner.nextInt();
		int[] starts = new int[n];
		int[] ends = new int[n];
		int[] points = new int[m];
		for (int i = 0; i < n; i++) {
			starts[i] = scanner.nextInt();
			ends[i] = scanner.nextInt();
		}
		for (int i = 0; i < m; i++) {
			points[i] = scanner.nextInt();
		}
		// use fastCountSegments
		int[] cnt = fastCountSegments(starts, ends, points);
		for (int x : cnt) {
			System.out.print(x + " ");
		}
	}
}