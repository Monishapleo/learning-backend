package com.practice.dsa.revisionwork;

import java.util.Arrays;

public class TwoPointerRE {
    public static void main(String[] args) {
        int[] arr={0,0,1,1,2,2,3,3,4,5};
       // removeElement(arr,2);
        System.out.println(isPalindrome("madams"));
    }
    static int[] twoSum(int arr[] , int target){
        if(arr==null||arr.length==0){
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        int start=0;
        int end=arr.length-1;
        while(start<end){
            int sum=arr[start]+arr[end];
            if(sum==target){
                return new int[]{start,end};
            }else if (sum < target) {
                start++;
            } else {
                end--;
            }
        }
        return new int[]{-1,-1};
    }
    static int removeDuplicates(int[] arr){
        if(arr==null||arr.length==0){
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        int write=1;
        for(int read=1;read<arr.length;read++){
            if(arr[write-1]!=arr[read]){
                arr[write]=arr[read];
                write++;
            }
        }
        return write;
    }

    static void moveZeroes(int[] arr){
        if(arr==null||arr.length==0){
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        int j=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                j++;
            }

        }
    }
    static void removeElement(int[] arr,int target){
        if(arr==null||arr.length==0){
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        int write =0;
        for(int read=0;read<arr.length;read++){
            if(arr[read]!=target){
                arr[write]=arr[read];
                write++;
            }

        }
        System.out.println(Arrays.toString(arr));
    }
    static int removeElementReturnLength(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }

        int write = 0;

        for (int read = 0; read < arr.length; read++) {
            if (arr[read] != target) {
                arr[write] = arr[read];
                write++;
            }
        }

        return write;
    }
    static void reverseArray(int[] arr){
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        int left=0;
        int right=arr.length-1;
        while(left<right){
            int temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
    }
    static boolean isPalindrome(String s){
        if(s==null||s.isBlank()){
            throw new IllegalArgumentException("String cannot be null or empty");
        }
        int left=0;
        int right=s.length()-1;
        while (left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    static boolean isValidPalindrome(String str){
        if(str==null || str.isEmpty()){
            throw new IllegalArgumentException("String cannot be null or empty");
        }
        int start = 0;
        int end = str.length()-1;

        while(start<end){
            if(!Character.isLetterOrDigit(str.charAt(start))){
                start++;
                continue;
            }
            if(!Character.isLetterOrDigit(str.charAt(end))){
                end--;
                continue;
            }
            char left = Character.toLowerCase(str.charAt(start));
            char right = Character.toLowerCase(str.charAt(end));
            if(left!=right){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
