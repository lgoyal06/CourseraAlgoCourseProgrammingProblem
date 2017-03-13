package week5;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lalit goyal TODO Find coins demonimation that cashier will return
 *         minNumberOfCoins need to be given in change
 */
public class MinNumberOfChangeProblemViaRecursion {

	private static int recursiveCall(int money, int[] coins) {
		int minNumberOfCoins = -1;
		if (money <= 0) {
			return 0;
		} else {
			for (int i = 0; i < coins.length; ++i) {
				if (money >= coins[i]) {
					int numCoins = recursiveCall(money - coins[i], coins);
					if (minNumberOfCoins == -1 || numCoins + 1 < minNumberOfCoins) {
						minNumberOfCoins = numCoins + 1;
					}
				}
			}
			return minNumberOfCoins;
		}
	}

	public static void main(String... s) {
		int[] coins = { 6, 1, 10 };
		System.out.println(recursiveCall(20, coins));
	}

}

class Stack {

	List<Integer> stack = new ArrayList<Integer>();
	int topIndex = 0;

	public boolean push(int value) {
		stack.add(topIndex, value);
		++topIndex;
		return true;
	}

	public boolean pop() {
		if (topIndex == 0) {
			return false;
		} else {
			--topIndex;
			stack.remove(topIndex);
			return true;
		}
	}
}