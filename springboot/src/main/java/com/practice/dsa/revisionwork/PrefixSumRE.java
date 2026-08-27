package com.practice.dsa.revisionwork;

import org.springframework.data.jpa.repository.query.JSqlParserUtils;

import java.util.Arrays;

public class PrefixSumRE {
    public static void main(String[] args) {
        int[] arr={1,2,3,4};
        int[] prefix={3, 8, 10, 17, 21};
       System.out.println(Arrays.toString(buildPrefixSumPrevention(arr)));
       // System.out.println(rangeSum(prefix, 1, 3));

    }
    static int[] buildPrefixSum(int[] arr){
        if(arr==null || arr.length==0){
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        int previousSum=0;
        for(int i =0 ; i< arr.length;i++){
            previousSum+=arr[i];
            arr[i]=previousSum;
        }
        return arr;
    }

    static int[] buildPrefixSumPrevention(int[] arr){
        if(arr==null || arr.length==0){
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        int[] prefix=new int[arr.length];
        prefix[0]=arr[0];
        int runningSum=prefix[0];
        for(int i =1 ; i< arr.length;i++){
            runningSum+=arr[i];
            prefix[i]=runningSum;
        }
        return prefix;
    }

    static int rangeSum(int[] prefix, int left, int right){
        if(prefix==null || prefix.length==0){
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        if(left<0 || right>=prefix.length){
            throw new IndexOutOfBoundsException(" Invalid index ");
        }
        if(left>right){
            throw new IllegalArgumentException("left value should be smaller than right value ");
        }
        if(left==0){
            return prefix[right];
        }
        return prefix[right]-prefix[left-1];
    }
}
