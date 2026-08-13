package com.practice.dsa.arrays;

import java.util.Arrays;

public class PrefixSum {
    public static void main(String[] args) {
        int[] arr={1,7,3,6,5,6};
        //System.out.println(Arrays.toString(buildPrefixSum(arr)));
        System.out.println(pivotIndex(arr));
    }
    static int[] buildPrefixSum(int[] arr){
        int previousSum=0;
        for(int i=0 ; i<arr.length;i++){
            int currentSum=previousSum+arr[i];
            arr[i]=currentSum;
            previousSum=currentSum;
        }
        return arr;
    }

    static int rangeSum(int[] prefix, int left, int right) {
        if (left == 0) {
            return prefix[right];
        }
        return prefix[right] - prefix[left - 1];
    }
    static int pivotIndex(int[] nums){
        int leftSum = 0;
        int totalSum=0;
        for(int num : nums){
            totalSum+=num;
        }
        for(int i=0; i<nums.length;i++){
            int rightSum = totalSum - leftSum - nums[i];
            if(leftSum == rightSum){
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
