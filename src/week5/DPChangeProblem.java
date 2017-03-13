package week5;

public class DPChangeProblem {

	public static void main(String... s) {
		int[] coins = { 6, 1, 10 };
		System.out.println(DPCall(76, coins));
	}

	private static int DPCall(int money, int[] coins) {

		int minNumCoins[] = new int[money + 1];
		for (int i = 1; i < minNumCoins.length; ++i) {
			minNumCoins[i] = -1;
		}

		minNumCoins[0] = 0;

		for (int i = 1; i <= money; ++i) {
			for (int j = 0; j < coins.length; ++j) {
				if (i >= coins[j]) {
					int numCoins = minNumCoins[i - coins[j]] + 1;
					if (minNumCoins[i] == -1 || numCoins < minNumCoins[i]) {
						minNumCoins[i] = numCoins;
					}
				}
			}
		}
		return minNumCoins[money];
	}
}
