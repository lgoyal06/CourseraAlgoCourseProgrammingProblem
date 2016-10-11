package com.lalit.coursera.week4;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static boolean isBalanced(String expression) {
		char[] characters = expression.toCharArray();
		int counter = 0;
		Stack<Character> stack = new Stack<Character>();
		while (counter < characters.length) {
			if (characters[counter] == '[' || characters[counter] == ('{') || characters[counter] == ('(')) {
				stack.push(characters[counter]);
			} else {
				if (stack.isEmpty() || characters[counter] == '}' && !stack.pop().equals('{')
						|| characters[counter] == ']' && !stack.pop().equals('[')
						|| characters[counter] == ')' && !stack.pop().equals('(')) {
					return false;
				}
			}
			++counter;
		}
		if (stack.isEmpty() && counter == characters.length)
			return true;
		return false;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			String expression = in.next();
			boolean answer = isBalanced(expression);
			if (answer)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}
