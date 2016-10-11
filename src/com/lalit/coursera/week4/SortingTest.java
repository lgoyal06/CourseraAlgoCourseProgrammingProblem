package com.lalit.coursera.week4;

import java.util.Arrays;
import java.util.Random;

public class SortingTest {
	public static void main(String[] args) {
		Random generator = new Random();
		boolean pass = true;
		while (pass) {
			int size = generator.nextInt(10);
			int[] a = new int[size];
			int[] b = new int[size];

			for (int i = 0; i < size; i++) {
				a[i] = generator.nextInt(100);
				b[i] = a[i];
			}
			Sorting.randomizedQuickSort(a, 0, a.length - 1); // Three Partition

			System.out.println("Initial array\n");// Implementation
			for (int i = 0; i < b.length; ++i) {
				System.out.print(b[i] + " ");
			}

			Arrays.sort(b);

			if (Arrays.equals(a, b)) {
				System.out.println("Correct Answer");
			} else {
				pass = false;
				System.out.println("\n\n Correct Answer: \n\n");

				for (int i = 0; i < b.length; ++i) {
					System.out.print(b[i] + " ");
				}

				System.out.println("\n\n Your Answer: \n\n");

				for (int i = 0; i < a.length; ++i) {
					System.out.print(a[i] + " ");
				}

			}
		}

	}
}