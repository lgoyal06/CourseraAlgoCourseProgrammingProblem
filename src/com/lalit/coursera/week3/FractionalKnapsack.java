package com.lalit.coursera.week3;

import java.util.Scanner;

public class FractionalKnapsack {
	private static double getOptimalValue(int capacity, int[] values, int[] weights) {
		// Find Value to weight ratio
		double[] valueToWeightRatio = new double[values.length];

		// O(n)
		for (int i = 0; i < values.length; ++i) {
			valueToWeightRatio[i] = (double) values[i] / weights[i];
		}
		// O(n^2)
		double max = 0;
		int maxIndex = 0;
		// O(n) * O(n)
		for (int i = 0; i < values.length; ++i) {
			max = valueToWeightRatio[i];
			maxIndex = i;
			// O(n)
			for (int j = i + 1; j < values.length; ++j) {
				if (valueToWeightRatio[j] > max) {
					max = valueToWeightRatio[j];
					maxIndex = j;
				}
			}
			// Swapping of elements
			// Constant time
			if (maxIndex != i) {
				valueToWeightRatio[maxIndex] = valueToWeightRatio[i];
				valueToWeightRatio[i] = max;

				int temp;
				temp = weights[maxIndex];
				weights[maxIndex] = weights[i];
				weights[i] = temp;

				temp = values[maxIndex];
				values[maxIndex] = values[i];
				values[i] = temp;
			}
		}
		double value = 0;
		int index = 0;
		while (capacity > 0 && weights.length > index) {
			if (capacity >= weights[index]) {
				capacity = capacity - weights[index];
				value = value + values[index];
			} else {
				value = value + (((double) capacity / weights[index]) * values[index]);
				capacity = 0;
			}
			++index;
		}
		return value;
	}

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int capacity = scanner.nextInt();
		int[] values = new int[n];
		int[] weights = new int[n];
		for (int i = 0; i < n; i++) {
			values[i] = scanner.nextInt();
			weights[i] = scanner.nextInt();
		}
		System.out.println(getOptimalValue(capacity, values, weights));
	}
}
