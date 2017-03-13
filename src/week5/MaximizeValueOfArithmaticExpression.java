package week5;

import java.util.Scanner;

public class MaximizeValueOfArithmaticExpression {

	static int[][] max;
	static int[][] min;
	static int[] operant;
	static char[] opr;

	private static int[] minMaxValue(int i, int j) {
		int maximum = Integer.MIN_VALUE, minimum = Integer.MAX_VALUE;
		for (int k = i; k < j; ++k) {
			int a, b, c, d;
			switch (opr[k]) {
			case '*':
				a = (min[i][k] * max[k + 1][j]);
				b = (max[i][k] * max[k + 1][j]);
				c = (min[i][k] * min[k + 1][j]);
				d = (max[i][k] * min[k + 1][j]);
				break;
			case '+':
				a = (min[i][k] + max[k + 1][j]);
				b = (max[i][k] + max[k + 1][j]);
				c = (min[i][k] + min[k + 1][j]);
				d = (max[i][k] + min[k + 1][j]);
				break;
			case '-':
				a = (min[i][k] - max[k + 1][j]);
				b = (max[i][k] - max[k + 1][j]);
				c = (min[i][k] - min[k + 1][j]);
				d = (max[i][k] - min[k + 1][j]);
				break;
			default:
				a = (min[i][k] / max[k + 1][j]);
				b = (max[i][k] / max[k + 1][j]);
				c = (min[i][k] / min[k + 1][j]);
				d = (max[i][k] / min[k + 1][j]);
				break;
			}
			minimum = Math.min(d, Math.min(c, Math.min(b, Math.min(minimum, a))));
			maximum = Math.max(d, Math.max(c, Math.max(b, Math.max(maximum, a))));
		}
		return new int[] { minimum, maximum };

	}

	private static int findMaxValArithExp() {

		// When to find max and min from only one operant
		for (int i = 0; i < operant.length; ++i) {
			min[i][i] = operant[i];
			max[i][i] = operant[i];
		}

		for (int s = 1; s < operant.length; ++s) {
			for (int i = 0; i < operant.length - s; ++i) {
				int j = i + s;
				int[] result = minMaxValue(i, j);
				max[i][j] = result[1];
				min[i][j] = result[0];
			}
		}
		return max[0][operant.length - 1];

	}

	public static void main(String... s) {
		Scanner scan = new Scanner(System.in);
		String exp = scan.next();

		char[] expChar = exp.toCharArray();

		operant = new int[(expChar.length / 2) + 1];
		opr = new char[(expChar.length / 2)];
		min = new int[operant.length][operant.length];
		max = new int[operant.length][operant.length];
		int j = 0, k = 0;
		for (int i = 0; i < expChar.length; i = i + 1) {
			if (i % 2 == 0) {
				operant[k] = Integer.valueOf(String.valueOf(expChar[i]));
				++k;
			} else {
				opr[j] = expChar[i];
				++j;
			}
		}
		System.out.println(findMaxValArithExp());
	}
}
