package com.practice.dsa.revisionwork;

public class SlidingwindowRE {
    public static void main(String[] args) {

    }
    static int maxSumSubarray(int[] arr, int k){
        if(arr==null|| arr.length==0){
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        if(k<0 || k>arr.length){
            throw new IllegalArgumentException("K must be > than 0 and < than the array length");
        }
        int windowSum=0;
        for(int i=0; i<k;i++){
            windowSum=windowSum+arr[i];
        }
        int maxSum=windowSum;
        for(int i=k;i<arr.length;i++){
            windowSum=windowSum-arr[i-k]+arr[i];
            maxSum=Math.max(maxSum,windowSum);
        }
        return maxSum;
    }

    static int minSubarrayLength(int[] arr, int target){
        if(arr==null|| arr.length==0){
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        if(target<=0){
            throw new IllegalArgumentException("Invalid number");
        }
        int left = 0;
        int windowSum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < arr.length; right++) {

            windowSum += arr[right];

            while (windowSum >= target) {
                int currentLength = right - left + 1;
                minLength=Math.min(minLength,currentLength);
                windowSum-=arr[left];
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }


}
