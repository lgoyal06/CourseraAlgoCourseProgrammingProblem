package com.lalit.coursera.week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DifferentSummands {
	private static List<Integer> optimalSummands(int n) {
		List<Integer> summands = new ArrayList<Integer>();
		// write your code here
		int count = 1;
		while (n > 0) {
			if (count < n && n - count > count) {
				summands.add(count);
				n = n - count;
			} else {
				summands.add(n);
				n = 0;
			}
			++count;
		}
		return summands;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		List<Integer> summands = optimalSummands(n);
		System.out.println(summands.size());
		for (Integer summand : summands) {
			System.out.print(summand + " ");
		}
	}
}
