package com.practice.dsa.arrays;

public class FixedSlidingWindow {
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
