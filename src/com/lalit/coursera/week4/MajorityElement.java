package com.lalit.coursera.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MajorityElement {
	private static int getMajorityElement(int[] a, int left, int right) {
		int[] resultantArray = mergeSort(a, left, right);
		int elementRepetitionCounter = 0, currentElement = -1, arrayIndex = 0;
		while (elementRepetitionCounter < (resultantArray.length / 2 + 1) && arrayIndex <= resultantArray.length - 1) {
			if (currentElement == resultantArray[arrayIndex]) {
				++elementRepetitionCounter;
			} else {
				currentElement = resultantArray[arrayIndex];
				elementRepetitionCounter = 1;
			}
			++arrayIndex;
		}
		if (elementRepetitionCounter > resultantArray.length / 2)
			return 1;
		return 0;
	}

	private static int[] mergeSort(int[] unsortedList, int left, int right) {
		if (left == right - 1)
			return new int[] { unsortedList[left] };
		int midElementIndex = (left + right) % 2 == 0 ? (left + right) / 2 : (left + right) / 2 + 1;
		int[] firstHalf = mergeSort(unsortedList, left, midElementIndex);
		int[] secondHalf = mergeSort(unsortedList, midElementIndex, right);
		return merge(firstHalf, secondHalf);
	}

	private static int[] merge(int[] firstHalf, int[] secondHalf) {
		int[] mergedResultantArray = new int[firstHalf.length + secondHalf.length];
		int currentIndexFirstHalf = 0, currentIndexSecondHalf = 0, currenIndexResultantArray = 0;
		while (currentIndexFirstHalf <= firstHalf.length - 1 && currentIndexSecondHalf <= secondHalf.length - 1) {
			if (firstHalf[currentIndexFirstHalf] <= secondHalf[currentIndexSecondHalf]) {
				mergedResultantArray[currenIndexResultantArray] = firstHalf[currentIndexFirstHalf];
				++currentIndexFirstHalf;
			} else {
				mergedResultantArray[currenIndexResultantArray] = secondHalf[currentIndexSecondHalf];
				++currentIndexSecondHalf;
			}
			++currenIndexResultantArray;
		}
		if (currentIndexFirstHalf <= firstHalf.length - 1) {
			while (currentIndexFirstHalf < firstHalf.length) {
				mergedResultantArray[currenIndexResultantArray] = firstHalf[currentIndexFirstHalf];
				++currenIndexResultantArray;
				++currentIndexFirstHalf;
			}
		} else if (currentIndexSecondHalf <= secondHalf.length - 1) {
			while (currentIndexSecondHalf < secondHalf.length) {
				mergedResultantArray[currenIndexResultantArray] = secondHalf[currentIndexSecondHalf];
				++currenIndexResultantArray;
				++currentIndexSecondHalf;
			}
		}
		return mergedResultantArray;
	}

	public static void main(String[] args) {
		FastScanner scanner = new FastScanner(System.in);
		int n = scanner.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		System.out.println(getMajorityElement(a, 0, a.length));
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