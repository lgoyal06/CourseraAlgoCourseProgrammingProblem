package com.lalit.coursera.week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Random;
import java.util.StringTokenizer;

//Link  to refer - http://www.geeksforgeeks.org/closest-pair-of-points/ 
//pdf to  refer - http://www.cs.ucsb.edu/~suri/cs235/ClosestPair.pdf
//TODO by 12 Oct 2016
public class Closest {

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static double minimalDistance(int[] x, int y[]) {
		// Map x and y axis to point model
		Point[] points = new Point[x.length];
		for (int i = 0; i < x.length; ++i) {
			points[i] = new Point(x[i], y[i]);
		}

		// Sort Based upon x axis via QuickSort in O(nlogn)
		randomizedQuickSort(points, 0, x.length - 1, "x");
		// Find the Closest points in left and right array
		double min = closestUtil(points, 0, x.length - 1);
		return min;
	}

	private static double stripClosest(Point[] stripArray) {
		double min = Double.MAX_VALUE;
		randomizedQuickSort(stripArray, 0, stripArray.length - 1, "y");
		// Pick all points one by one and try the next points till the
		// difference
		// between y coordinates is smaller than d.
		// This is a proven fact that this loop runs at most 6 times
		for (int i = 0; i < stripArray.length; ++i)
			for (int j = i + 1; j < stripArray.length && (stripArray[j].y - stripArray[i].y) < min; ++j)
				if (dist(stripArray[i], stripArray[j]) < min)
					min = dist(stripArray[i], stripArray[j]);
		return min;
	}

	// A Brute Force method to return the smallest distance between two points
	// in P[] of size n
	static double bruteForce(Point p[], int startingElementIndex, int endElementIndex) {
		double min = Double.MAX_VALUE;
		for (int i = startingElementIndex; i < endElementIndex; ++i) {
			for (int j = i + 1; j <= endElementIndex; ++j) {
				if (dist(p[i], p[j]) < min)
					min = dist(p[i], p[j]);
			}
		}
		return min;
	}

	// A utility function to find the distance between two points
	static double dist(Point p1, Point p2) {
		return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
	}

	// A recursive function to find the smallest distance. The array P contains
	// all points sorted according to x coordinate
	static double closestUtil(Point p[], int left, int right) {
		// If there are 2 or 3 points, then use brute force
		if ((right - left) <= 3)
			return bruteForce(p, left, right);
		int mid = (left + right) / 2;
		double dl = closestUtil(p, left, mid);
		double dr = closestUtil(p, mid, right);
		double d = Math.min(dl, dr);

		Point strip[] = new Point[right - left];
		int j = 0;
		for (int i = 0; i < right - left; i++) {
			if (Math.abs(p[i].x - p[mid].x) < d) {
				strip[j] = p[i];
				j++;
			}
		}

		Point stripFinal[] = new Point[j];
		for (int i = 0; i < j; ++i) {
			stripFinal[i] = strip[i];
		}

		return min(d, stripClosest(stripFinal));
	}

	static double min(double x, double y) {
		return (x < y) ? x : y;
	}

	private static Random random = new Random();

	private static int[] partition3(Point[] points, int l, int r) {

		int x = points[l].x;
		int j = l;
		int s = 0;
		for (int i = l + 1; i <= r; i++) {
			if (points[i].x <= x) {
				if (points[i].x == x) {
					++s;
				}
				j++;

				int t = points[i].x;
				points[i].x = points[j].x;
				points[j].x = t;
				t = points[i].y;
				points[i].y = points[j].y;
				points[j].y = t;
			}
		}

		int t = points[l].x;
		points[l].x = points[j].x;
		points[j].x = t;
		t = points[l].y;
		points[l].y = points[j].y;
		points[j].y = t;

		int r1 = 0;
		if (s > 0) {
			for (int i = l; i < j; ++i) {
				if (points[i].x == x) {
					while (j - r1 - 1 >= 0 && points[j - r1 - 1].x == x) {
						++r1;
						--s;
					}
					if (s > 0) {
						++r1;
						--s;

						points[i].x = points[j - r1].x;
						points[j - r1].x = x;
						int t1 = points[i].y;
						points[i].y = points[j - r1].y;
						points[j - r1].y = t1;

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

	private static int[] partition3BasedOnYAxis(Point[] points, int l, int r) {

		int x = points[l].y;
		int j = l;
		int s = 0;
		for (int i = l + 1; i <= r; i++) {
			if (points[i].y <= x) {
				if (points[i].y == x) {
					++s;
				}
				j++;

				int t = points[i].y;
				points[i].y = points[j].y;
				points[j].y = t;
				t = points[i].x;
				points[i].x = points[j].x;
				points[j].x = t;
			}
		}

		int t = points[l].y;
		points[l].y = points[j].y;
		points[j].y = t;
		t = points[l].x;
		points[l].x = points[j].x;
		points[j].x = t;

		int r1 = 0;
		if (s > 0) {
			for (int i = l; i < j; ++i) {
				if (points[i].y == x) {
					while (j - r1 - 1 >= 0 && points[j - r1 - 1].y == x) {
						++r1;
						--s;
					}
					if (s > 0) {
						++r1;
						--s;

						points[i].y = points[j - r1].y;
						points[j - r1].y = x;
						int t1 = points[i].x;
						points[i].x = points[j - r1].x;
						points[j - r1].x = t1;

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

	private static void randomizedQuickSort(Point[] points, int l, int r, String sortingAxis) {
		if (l >= r) {
			return;
		}
		int k = random.nextInt(r - l + 1) + l;
		int t = points[l].x;
		points[l].x = points[k].x;
		points[k].x = t;

		t = points[l].y;
		points[l].y = points[k].y;
		points[k].y = t;

		int[] m;
		if (sortingAxis.equals("x")) {
			m = partition3(points, l, r);
		} else {
			m = partition3BasedOnYAxis(points, l, r);
		}
		randomizedQuickSort(points, l, m[0] - 1, sortingAxis);
		randomizedQuickSort(points, m[1] + 1, r, sortingAxis);
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