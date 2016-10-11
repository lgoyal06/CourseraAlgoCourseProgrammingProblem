package com.lalit.coursera.week3;

import java.util.Scanner;

public class CoveringSegments {

	private static int[] optimalPoints(Segment[] segments) {
		// write your code here

		// O(n^2) - optimize it to O(nlogn)
		int min = 0, minIndex = 0;
		for (int i = 0; i < segments.length; ++i) {
			min = segments[i].end;
			minIndex = i;
			for (int j = i + 1; j < segments.length; ++j) {
				if (segments[j].end < min) {
					min = segments[j].end;
					minIndex = j;
				}
			}
			if (minIndex != i) {
				segments[minIndex].end = segments[i].end;
				segments[i].end = min;

				int temp;
				temp = segments[minIndex].start;
				segments[minIndex].start = segments[i].start;
				segments[i].start = temp;
			}
		}

		// O(n)
		int index = 0;
		int counter = 0;
		String optimalPointsStr = "";
		while (counter < segments.length) {
			int currentPoint = segments[counter].end;
			while (counter < segments.length - 1 && currentPoint >= segments[counter + 1].start
					&& currentPoint <= segments[counter + 1].end) {
				++counter;
			}
			++counter;
			optimalPointsStr = optimalPointsStr + currentPoint + " ";
			++index;
		}
		int[] optimalPoints = new int[index];
		String[] optimalPointsStrArray = optimalPointsStr.split(" ");

		// O(index)
		for (int i = 0; i < index; ++i) {
			optimalPoints[i] = Integer.valueOf(optimalPointsStrArray[i]);
		}
		return optimalPoints;
	}

	private static class Segment {
		int start, end;

		Segment(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		Segment[] segments = new Segment[n];
		for (int i = 0; i < n; i++) {
			int start, end;
			start = scanner.nextInt();
			end = scanner.nextInt();
			segments[i] = new Segment(start, end);
		}
		int[] points = optimalPoints(segments);
		int totalOptimalPoints = 0;
		String pointsPrint = "";
		for (int point : points) {
			totalOptimalPoints = totalOptimalPoints + 1;
			pointsPrint = pointsPrint + point + " ";
		}
		System.out.println(totalOptimalPoints);
		System.out.println(pointsPrint);
	}
}
