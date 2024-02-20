import java.util.HashMap;

/**
 * Given an integer array coins representing coins of different denominations
 * and an integer amount representing a total amount of money,
 * Return the fewest number of coins needed to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * Assume that you have an infinite number of each kind of coin.

 * Example1:
 *      Input: coins = [1,2,5], amount = 11
 *      Output: 3
 *      Explanation: 11 = 5 + 5 + 1

 * Example2:
 *      Input: coins = [2], amount = 3
 *      Output: -1

 * Example3:
 *      Input: coins = [1], amount = 0
 *      Output: 0
 */
public class CoinChange {

    public int coinChange(int[] arr, int sum) {
        return coinChange(arr, sum, new HashMap<>());
    }

    /**
     * Helper method to compute the least change needed to make an amount.
     * @param arr the coins array
     * @param sum the total amount of money to be made
     * @param memo a hashmap to store partial solutions to speed up
     *             recursive calls that has been solved before
     */
    private static int coinChange(int[] arr, int sum, HashMap<Integer, Integer> memo) {
        if (sum == 0) {
            return 0;
        }
        if (sum < 0) {
            return -1;
        }

        if (memo.containsKey(sum))
            return memo.get(sum);

        int least = coinChange(arr, sum - arr[0], memo);
        for (int i = 1; i < arr.length; i++) {
            int current = coinChange(arr, sum - arr[i], memo);
            if ((current < least && current >= 0) || least == -1) {
                least = current;
            }
        }

        if (least == -1) {
            memo.put(sum, -1);
            return -1;
        }

        memo.put(sum, least + 1);
        return least + 1;
    }

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        int[] arr = {2,5,10,1};
        int sum = 27;
        int result = cc.coinChange(arr, sum);
        System.out.println(result);
    }
}
