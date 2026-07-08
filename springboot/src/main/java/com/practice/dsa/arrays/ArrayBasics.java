package com.practice.dsa.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayBasics {

    static int findMax(int[] arr){
        int largest=Integer.MIN_VALUE;
        for(int num: arr){
            if(num>largest){
                largest=num;
            }
        }
        return largest;
    }

    static int findSecondLargest(int[] arr){
        if (arr == null || arr.length == 2) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        int largest=Integer.MIN_VALUE;
        int secondLargest=Integer.MIN_VALUE;
        for(int num : arr){
            if(num>largest){
                secondLargest = largest;
                largest = num;
            }else if(num>secondLargest && num!=largest){
                secondLargest=num;
            }
        }
        return secondLargest;
    }
    static int findMin(int[] arr){
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        int smallest=arr[0];
        for(int num : arr){
            if(num<smallest){
                smallest=num;
            }
        }
        return smallest;
    }
    static int findMinList(ArrayList<Integer> list){
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List cannot be null or empty");
        }
        int smallest=list.get(0);
        for(int num : list){
            if(num<smallest){
                smallest=num;
            }
        }
        return smallest;
    }

    static void reverse(int[] arr){
        if (arr == null || arr.length <2) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        System.out.println("Received : "+ Arrays.toString(arr));

        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
        System.out.println("Reversed : "+Arrays.toString(arr));
    }
    static boolean isSorted(int[] arr){
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be null / empty and need 2 or more element");
        }
        for(int i = 1 ; i<=arr.length-1;i++){
            System.out.println("Value of i "+arr[i]);
            System.out.println("Value of i-1 "+(arr[i-1]));
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    static  void moveZerosToEnd(int[] arr){
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }

        int j=0;
        for(int i=0; i < arr.length; i++ ){
            if(arr[i]!=0){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                j++;
            }
        }
        System.out.println("ARR : "+Arrays.toString(arr));
    }

    static int removeDuplicates(int[] arr){
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }

        int j=0;
        for(int i = 1; i<arr.length; i++){
            if(arr[i]!=arr[j]){
                j++;
                arr[j]=arr[i];
            }
        }
        return j+1;
    }

}
