// Ref: https://leetcode.com/problems/coin-change/?envType=study-plan-v2&envId=top-interview-150

class Solution {

    // build 1 array amount 0 , 1, 2, 3, ...., expected amount
    // For loop each selected coin in coins:
    //    leastOfNumCoin[expectedAmount] = 1 (selected coin) +  leastOfNumCoin[remainingAmount] 
    //    remainingAmount = expectedAmount - selectedCoin

    public int coinChange(int[] coins, int amount) {

        int[] changes = new int[amount + 1];
        changes[0] = 0;

        for (int i = 1; i < changes.length; i++) {

            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i && changes[i - coins[j]] != -1) {
                    min = Math.min(min, changes[i - coins[j]]);
                }
            }

            changes[i] = (min == Integer.MAX_VALUE) ? -1 : min + 1;
        }

        return changes[amount];
    }
}