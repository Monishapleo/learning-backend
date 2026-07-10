package com.practice.dsa.arrays;

import java.util.Arrays;

public class PrefixSum {
    public static void main(String[] args) {
        int[] arr={2,3,4,5};
        System.out.println(Arrays.toString(buildPrefixSum(arr)));
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
}
