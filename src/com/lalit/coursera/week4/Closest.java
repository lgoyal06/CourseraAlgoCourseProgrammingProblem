package com.lalit.coursera.week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

//Link  to refer - http://www.geeksforgeeks.org/closest-pair-of-points/ 
//pdf to  refer - http://www.cs.ucsb.edu/~suri/cs235/ClosestPair.pdf
//TODO by 12 Oct 2016
public class Closest {

	static class Point implements Comparable<Point> {
		long x, y;

		public Point(long x, long y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			return o.y == y ? Long.signum(x - o.x) : Long.signum(y - o.y);
		}
	}

	static double minimalDistance(int[] x, int y[]) {
		double ans = Double.POSITIVE_INFINITY;
		String d = "";
		d.toCharArray().l
		// Code to sort the points on x axis and find the shorted d
		double minDistance = mergeSort(x, y, 0, x.length);
		// Find median of x axis and find the list of point which lies within
		// range

		return ans;
	}

	private static double mergeSort(int[] x, int[] y, int left, int right) {
		if (left == right + 1)
			return Math.sqrt(Math.pow((x[left] - x[right]), 2) + Math.pow((y[left] - y[right]), 2));
		if(left==right)
			return 
		int midElementIndex = (left + right) % 2 == 0 ? (left + right) / 2 : (left + right) / 2 + 1;
		double minDistanceLeft = mergeSort(x, y, left, midElementIndex);
		double minDistanceRight = mergeSort(x, y, midElementIndex, right);
		return merge(x, y, left, midElementIndex, right, minDistanceLeft, minDistanceRight);
	}

	private static long merge(int[] unsortedArray, int[] sortedArray, int startIndex, int middleIndex, int endIndex,
			double minDistanceLeft, double minDistanceRight) {
		int currentIndexFirstHalf = startIndex, currentIndexSecondHalf = middleIndex,
				currenIndexResultantSortedArray = startIndex;
		int maxIndexForFirstHalf = middleIndex - 1, maxIndexForSecondHalf = endIndex - 1;
		while (currentIndexFirstHalf <= maxIndexForFirstHalf && currentIndexSecondHalf <= maxIndexForSecondHalf) {
			int currentFirstHalfElement = unsortedArray[currentIndexFirstHalf];
			int currentSecondHalfElement = unsortedArray[currentIndexSecondHalf];
			if (currentFirstHalfElement <= currentSecondHalfElement) {
				sortedArray[currenIndexResultantSortedArray] = currentFirstHalfElement;
				++currentIndexFirstHalf;
			} else {
				numberOfInversions += (middleIndex - currentIndexFirstHalf);
				sortedArray[currenIndexResultantSortedArray] = currentSecondHalfElement;
				++currentIndexSecondHalf;
			}
			++currenIndexResultantSortedArray;
		}
		while (currentIndexFirstHalf <= maxIndexForFirstHalf) {
			sortedArray[currenIndexResultantSortedArray] = unsortedArray[currentIndexFirstHalf];
			++currenIndexResultantSortedArray;
			++currentIndexFirstHalf;
		}
		while (currentIndexSecondHalf <= maxIndexForSecondHalf) {
			sortedArray[currenIndexResultantSortedArray] = unsortedArray[currentIndexSecondHalf];
			++currenIndexResultantSortedArray;
			++currentIndexSecondHalf;
		}
		for (int i = 0; i < sortedArray.length; ++i) {
			unsortedArray[i] = sortedArray[i];
		}
		return numberOfInversions;
	}

	public static void main(String[] args) throws Exception {
		reader = new BufferedReader(new InputStreamReader(System.in));
		writer = new PrintWriter(System.out);
		int n = nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		for (int i = 0; i < n; i++) {
			x[i] = nextInt();
			y[i] = nextInt();
		}
		System.out.println(minimalDistance(x, y));
		writer.close();
	}

	static BufferedReader reader;
	static PrintWriter writer;
	static StringTokenizer tok = new StringTokenizer("");

	static String next() {
		while (!tok.hasMoreTokens()) {
			String w = null;
			try {
				w = reader.readLine();
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (w == null)
				return null;
			tok = new StringTokenizer(w);
		}
		return tok.nextToken();
	}

	static int nextInt() {
		return Integer.parseInt(next());
	}
}
