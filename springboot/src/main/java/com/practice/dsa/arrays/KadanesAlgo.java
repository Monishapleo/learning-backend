package com.practice.dsa.arrays;

public class KadanesAlgo {
    public static void main(String[] args) {

    }
    static int maxSubArray(int[] nums){
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for(int num : nums){
            currentSum += num;
            maxSum = Math.max(maxSum, currentSum);
            if(currentSum < 0){
                currentSum = 0;
            }
        }
        return maxSum;
    }
}
