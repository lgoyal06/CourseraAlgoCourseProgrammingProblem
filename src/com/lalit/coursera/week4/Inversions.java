package com.lalit.coursera.week4;

import java.util.Scanner;

public class Inversions {

	private static long getNumberOfInversions(int[] a, int[] b, int left, int right) {
		long numberOfInversions = 0;
		if (right <= left + 1) {
			return numberOfInversions;
		}
		int midElementIndex = (left + right) % 2 == 0 ? (left + right) / 2 : (left + right) / 2 + 1;
		numberOfInversions += getNumberOfInversions(a, b, left, midElementIndex);
		numberOfInversions += getNumberOfInversions(a, b, midElementIndex, right);
		return merge(a, b, left, midElementIndex, right, numberOfInversions);
	}

	private static long merge(int[] unsortedArray, int[] sortedArray, int startIndex, int middleIndex, int endIndex,
			long numberOfInversions) {
		int currentIndexFirstHalf = startIndex, currentIndexSecondHalf = middleIndex,
				currenIndexResultantSortedArray = startIndex;
		int maxIndexForFirstHalf = middleIndex - 1, maxIndexForSecondHalf = endIndex - 1;
		while (currentIndexFirstHalf <= maxIndexForFirstHalf
				&& currentIndexSecondHalf <= maxIndexForSecondHalf) {
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

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			int x = scanner.nextInt();
			a[i] = x;
			b[i] = x;
		}
		System.out.println(getNumberOfInversions(a, b, 0, a.length));

	}
}