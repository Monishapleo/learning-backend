package com.practice.dsa.arrays;

import org.hibernate.validator.constraints.ru.INN;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrefixSum {
    public static void main(String[] args) {
        int[] arr={1,7,3,1,5,6};
        //System.out.println(Arrays.toString(buildPrefixSum(arr)));
        System.out.println(longestSubarrayWithSum(arr,23));
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
    static int longestSubarrayWithSum(int[] arr, int target){
        if(arr==null||arr.length==0){
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        int maxLength=0;
        int prefixSum=0;
        Map<Integer,Integer>prefixMap=new HashMap<>();
        prefixMap.put(0, -1);
        for(int i=0;i<arr.length;i++){
           prefixSum+=arr[i];
           int need=prefixSum-target;
           if(prefixMap.containsKey(need)){
               int currentLength=i-prefixMap.get(need);
               maxLength=Math.max(currentLength,maxLength);
           }else if (!prefixMap.containsKey(prefixSum)){
               prefixMap.put(prefixSum,i);
           }

       }
       return maxLength;
    }
}
