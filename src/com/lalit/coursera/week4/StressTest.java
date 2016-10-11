package com.lalit.coursera.week4;

import java.util.Arrays;
import java.util.Random;

public class StressTest {

	private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
		int[] cnt = new int[points.length];
		for (int i = 0; i < points.length; i++) {
			for (int j = 0; j < starts.length; j++) {
				if (starts[j] <= points[i] && points[i] <= ends[j]) {
					cnt[i]++;
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		Random generator = new Random();
		boolean pass = true;
		while (pass) {
			int numberOfSegments = generator.nextInt(500);
			int numberOfPoints = generator.nextInt(500);

			int[] segmentStartPoint = new int[numberOfSegments];
			int[] segmentEndPoint = new int[numberOfSegments];
			int[] points = new int[numberOfPoints];

			for (int i = 0; i < numberOfPoints; i++) {
				points[i] = generator.nextInt(100000000);
			}

			for (int i = 0; i < numberOfSegments; i++) {
				segmentStartPoint[i] = generator.nextInt(100000000);
				segmentEndPoint[i] = segmentStartPoint[i] + generator.nextInt(100000000);
			}

			int cnt[] = PointsAndSegments.fastCountSegments(segmentStartPoint, segmentEndPoint, points); // Three

			int[] cnt1 = naiveCountSegments(segmentStartPoint, segmentEndPoint, points);

			if (Arrays.equals(cnt1, cnt)) {
				System.out.println();
				System.out.println(numberOfSegments + "  " + numberOfPoints);

				for (int i = 0; i < numberOfSegments; i++) {
					System.out.println(segmentStartPoint[i] + " " + segmentEndPoint[i]);
				}

				for (int i = 0; i < numberOfPoints; i++) {
					System.out.print(points[i] + "  ");
				}

				System.out.println("\n\n Correct Answer: \n\n");

				for (int i = 0; i < cnt1.length; ++i) {
					System.out.print(cnt1[i] + " ");
				}

				System.out.println("\n\n Your Answer: \n\n");

				for (int i = 0; i < cnt.length; ++i) {
					System.out.print(cnt[i] + " ");
				}

			} else {
				pass = false;
				System.out.println(numberOfSegments + "  " + numberOfPoints);

				for (int i = 0; i < numberOfSegments; i++) {
					System.out.println(segmentStartPoint[i] + " " + segmentEndPoint[i]);
				}

				for (int i = 0; i < numberOfPoints; i++) {
					System.out.print(points[i] + "  ");
				}

				System.out.println("\n\n Correct Answer: \n\n");

				for (int i = 0; i < cnt1.length; ++i) {
					System.out.print(cnt1[i] + " ");
				}

				System.out.println("\n\n Your Answer: \n\n");

				for (int i = 0; i < cnt.length; ++i) {
					System.out.print(cnt[i] + " ");
				}

			}
		}

	}
}
