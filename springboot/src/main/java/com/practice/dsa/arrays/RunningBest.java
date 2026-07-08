package com.practice.dsa.arrays;

public class RunningBest {

    /**
     * ==========================================================
     * Pattern : Running Best
     * ==========================================================
     *
     * Description:
     * Maintain the best answer while traversing the array.
     *
     * When to Use:
     * - Maximum
     * - Minimum
     * - Highest
     * - Lowest
     * - Longest
     * - Best Profit
     *
     * Mental Model:
     *
     * Current Answer
     *       ↓
     * Compare
     *       ↓
     * Update Best
     *
     * Common Problems:
     * - Maximum Consecutive Ones
     * - Best Time to Buy and Sell Stock
     * - Maximum Element
     * - Minimum Element
     *
     * Time Complexity:
     * O(n)
     *
     * Space Complexity:
     * O(1)
     *
     * ==========================================================
     */

    static int bestTimeToBuyAndSellStock(int[] prices){
        int maxProfit=0;
        int minPrice=prices[0];
        for (int i = 1; i < prices.length; i++) {
            int current = prices[i];
            if(current<minPrice){
                minPrice=prices[i];
            }else{
                int currentProfit=current-minPrice;;
                if(maxProfit<currentProfit){
                    maxProfit=currentProfit;
                }
            }
        }
        return maxProfit;
    }
    static int findMaxConsecutiveOnes(int[] nums){
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        int maxCount=0;
        int currentCount=0;
        for (int num : nums) {
            if (num == 1) {
                currentCount++;
            } else {
                currentCount = 0;
            }

            maxCount = Math.max(maxCount, currentCount);
        }
        return maxCount;
    }
}
