package week5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author lalit goyal
 * 
 *         Time complexity - o(N*O)
 * 
 *         N - number
 * 
 *         O - possible operations
 */
public class PrimitiveCalculator {

	private static List<Integer> optimal_sequence(int number) {

		int minNumOperations[] = new int[number + 1];

		List<List<Integer>> sequenceList = new ArrayList<List<Integer>>();

		List<Integer> sequence_0 = new ArrayList<Integer>();
		sequence_0.add(1);
		sequenceList.add(sequence_0);

		List<Integer> sequence_1 = new ArrayList<Integer>();
		sequence_1.add(1);
		sequenceList.add(sequence_1);

		for (int i = 2; i < minNumOperations.length; ++i) {
			minNumOperations[i] = -1;
		}

		int[] operations = { 3, 2 };

		for (int i = 2; i <= number; ++i) {
			List<Integer> sequence = new ArrayList<Integer>();
			for (int j = 0; j < operations.length; ++j) {
				if (((i % operations[j]) == 0)) {
					int numOperations = minNumOperations[i / operations[j]] + 1;
					if (minNumOperations[i] == -1 || numOperations < minNumOperations[i]) {
						sequence.clear();
						sequence.addAll(sequenceList.get((i / operations[j])));
						minNumOperations[i] = numOperations;
					}
				}
			}
			int numCoins = minNumOperations[i - 1] + 1;
			if (minNumOperations[i] == -1 || numCoins < minNumOperations[i]) {
				minNumOperations[i] = numCoins;
				sequence.clear();
				sequence.addAll(sequenceList.get((i - 1)));
			}
			sequence.add(i);
			sequenceList.add(sequence);
		}

		return sequenceList.get(number);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		List<Integer> sequence = optimal_sequence(n);
		System.out.println(sequence.size() - 1);
		for (Integer x : sequence) {
			System.out.print(x + " ");
		}
	}
}
