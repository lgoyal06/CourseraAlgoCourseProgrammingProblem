package week5;

/**
 * @author lalit goyal
 * 
 *         EDITING
 *
 *         DISTANCE
 * 
 *         O(m*n)
 * 
 *         m - length of word 1
 * 
 *         n - length of word 2
 */
public class EditDistanceProblemVia2DMatrix {

	private static int[][] editDistanceMatrix(char[] char_array_1, char[] char_array_2) {

		int[][] distance = new int[char_array_1.length + 1][char_array_2.length + 1];

		for (int i = 1; i <= char_array_1.length; ++i) {
			distance[i][0] = i;
		}
		for (int j = 1; j <= char_array_2.length; ++j) {
			distance[0][j] = j;
		}

		for (int j = 1; j <=char_array_2.length; ++j) {
			for (int i = 1; i <=char_array_1.length; ++i) {
				int insertion = distance[i][j - 1] + 1;
				int deletion = distance[i - 1][j] + 1;
				int match = distance[i - 1][j - 1];
				int misMatch = distance[i - 1][j - 1] + 1;

				if (char_array_1[i-1] == char_array_2[j-1]) {
					distance[i][j] = Math.min(Math.min(insertion, deletion), match);
				} else {
					distance[i][j] = Math.min(Math.min(insertion, deletion), misMatch);
				}
			}
		}

		return distance;

	}

	public static void main(String... s) {
		String str_1 = s[0];
		String str_2 = s[1];

		editDistanceMatrix(str_1.toCharArray(), str_2.toCharArray());
	}
}
