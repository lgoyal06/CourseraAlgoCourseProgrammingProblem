package week5;

import java.util.Scanner;

class EditDistance {
	public static int EditDistance(String s, String t) {

		return editDistanceMatrix(s.toCharArray(), t.toCharArray())[s.toCharArray().length][t.toCharArray().length];
	}

	private static int[][] editDistanceMatrix(char[] char_array_1, char[] char_array_2) {

		int[][] distance = new int[char_array_1.length + 1][char_array_2.length + 1];

		for (int i = 1; i <= char_array_1.length; ++i) {
			distance[i][0] = i;
		}
		for (int j = 1; j <= char_array_2.length; ++j) {
			distance[0][j] = j;
		}

		for (int j = 1; j <= char_array_2.length; ++j) {
			for (int i = 1; i <= char_array_1.length; ++i) {
				int insertion = distance[i][j - 1] + 1;
				int deletion = distance[i - 1][j] + 1;
				int match = distance[i - 1][j - 1];
				int misMatch = distance[i - 1][j - 1] + 1;

				if (char_array_1[i - 1] == char_array_2[j - 1]) {
					distance[i][j] = Math.min(Math.min(insertion, deletion), match);
				} else {
					distance[i][j] = Math.min(Math.min(insertion, deletion), misMatch);
				}
			}
		}

		return distance;

	}

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);

		String s = scan.next();
		String t = scan.next();

		System.out.println(EditDistance(s, t));
	}

}
