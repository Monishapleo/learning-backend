package com.practice.dsa.arrays;

public class FixedSlidingWindow {

    /**
     * ==========================================================
     * Pattern : Fixed Sliding Window
     * ==========================================================
     *
     * Description:
     * Window size remains constant.
     *
     * When to Use:
     * - Size k
     * - Fixed Window
     * - Maximum Sum
     * - Minimum Sum
     * - Average of Size k
     *
     * Mental Model:
     *
     * Build First Window
     *        ↓
     * Store Answer
     *        ↓
     * Slide
     *        ↓
     * Remove Left
     *        ↓
     * Add Right
     *        ↓
     * Update Answer
     *
     * Core Formula:
     *
     * windowSum = windowSum - arr[i-k] + arr[i];
     *
     * Time Complexity:
     * O(n)
     *
     * Space Complexity:
     * O(1)
     *
     * ==========================================================
     */

    static int maxSumSubArray(int[] arr, int k){
        if (arr == null || arr.length == 0 || k <= 0 || k > arr.length) {
            throw new IllegalArgumentException("Invalid input");
        }
        int windowSum=0;

        for (int i = 0; i < k; i++) {
            windowSum+=arr[i];
        }
        int maxSum=windowSum;
        for (int i = k; i < arr.length; i++){
            windowSum=windowSum-arr[i-k]+arr[i];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }
    static double minSumSubArrayAvg(int[] arr, int k){
        if (arr == null || arr.length == 0 || k <= 0 || k > arr.length) {
            throw new IllegalArgumentException("Invalid input");
        }
        int windowSum=0;
        for (int i = 0; i < k; i++) {
            windowSum+=arr[i];
        }
        int minSum=windowSum;
        for(int i=k; i<arr.length;i++){
            windowSum=windowSum-arr[i-k]+arr[i];
            minSum=Math.min(minSum,windowSum);
        }
        return (double)minSum/k;
    }
}
