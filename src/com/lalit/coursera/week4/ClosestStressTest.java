package com.lalit.coursera.week4;

import java.util.Random;

public class ClosestStressTest {

	private static double naiveWay(int[] x, int[] y) {
		double min = -1;
		for (int i = 0; i < x.length; ++i) {
			for (int j = i + 1; j < x.length; ++j) {
				if (i == 0 && j == 1) {
					min = dist(x[i], x[j], y[i], y[j]);
				}
				if (dist(x[i], x[j], y[i], y[j]) < min) {
					min = dist(x[i], x[j], y[i], y[j]);
				}
			}
		}
		return min;
	}

	// A utility function to find the distance between two points
	static double dist(int x1, int x2, int y1, int y2) {
		return Math.sqrt(((x1 - x2) * (x1 - x2)) + ((y1 - y2) * (y1 - y2)));
	}

	public static void main(String... s) {

		Random generator = new Random();
		boolean run = true;
		while (run) {
			int arrayLength = generator.nextInt(100);
			int[] x = new int[arrayLength];
			int[] y = new int[arrayLength];

			for (int i = 0; i < arrayLength; ++i) {
				x[i] = generator.nextInt(100);
				y[i] = generator.nextInt(100);
			}
			double re1 = naiveWay(x, y);
			double re2 = Closest.minimalDistance(x, y);
			if (re1 != re2) {
				System.out.println(arrayLength);
				for (int i = 0; i < arrayLength; ++i) {
					System.out.println(x[i] + "\t" + y[i]);
				}
				System.out.println(re1);
				System.out.println(re2);
				System.out.println("Error");
				run = false;
			} else {
				System.out.println("OK");
			}
		}
	}
}
