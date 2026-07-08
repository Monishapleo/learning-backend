package com.practice.dsa.arrays;

public class VariableSlidingWindow {
    /**
     * ==========================================================
     * Pattern : Variable Sliding Window
     * ==========================================================
     *
     * Description:
     * Window size changes dynamically based on
     * a condition.
     *
     * When to Use:
     * - Smallest Window
     * - Longest Window
     * - At Least
     * - At Most
     * - Target Sum
     *
     * Mental Model:
     *
     * sum < target
     *      ↓
     * Grow
     *
     * sum >= target
     *      ↓
     * Update Answer
     *      ↓
     * Shrink
     *
     * Common Problems:
     * - Minimum Size Subarray Sum
     * - Longest Substring Without Repeating Characters
     * - Fruit Into Baskets
     *
     * Time Complexity:
     * O(n)
     *
     * Space Complexity:
     * O(1)
     *
     * ==========================================================
     */

    static int minLengthArr(int[] arr, int target) {
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];

            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= arr[left];
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
