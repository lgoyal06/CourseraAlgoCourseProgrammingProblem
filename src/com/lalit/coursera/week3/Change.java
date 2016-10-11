package com.lalit.coursera.week3;

import java.util.Scanner;

public class Change {

	private static int getChange(int money) {
		int[] array_denomination = { 10, 5, 1 };
		int minNumberOfCoinToChange = 0;
		int array_index = 0;
		while (money > 0) {
			int currentDenomination = array_denomination[array_index];
			if (money >= currentDenomination) {
				int numberOfCoinsChangeForGivenDenomination = money / currentDenomination;
				minNumberOfCoinToChange = minNumberOfCoinToChange + (numberOfCoinsChangeForGivenDenomination);
				money = money - ((numberOfCoinsChangeForGivenDenomination) * currentDenomination);
			}
			++array_index;
		}
		return minNumberOfCoinToChange;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		System.out.println(getChange(m));

	}
}