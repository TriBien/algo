// Ref: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int curr = prices[i];

            maxProfit = Math.max(maxProfit, curr - minPrice);
            minPrice = Math.min(minPrice, curr);
        }

        return maxProfit;
    }
}