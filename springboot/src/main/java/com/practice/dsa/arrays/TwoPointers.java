package com.practice.dsa.arrays;

import java.util.Arrays;

public class TwoPointers {
    /**
     * ==========================================================
     * Pattern : Two Pointers
     * ==========================================================
     *
     * Description:
     * Two pointers move toward each other or
     * in the same direction to solve problems efficiently.
     *
     * Usually Requires:
     * Sorted Array
     *
     * When to Use:
     * - Pair Sum
     * - Sorted Arrays
     * - Reverse Array
     * - Palindrome
     * - Merge Arrays
     *
     * Mental Model:
     *
     * sum < target
     *      ↓
     * left++
     *
     * sum > target
     *      ↓
     * right--
     *
     * sum == target
     *      ↓
     * Answer Found
     *
     * Why Sorted?
     *
     * left++ increases (or keeps) the value.
     *
     * right-- decreases (or keeps) the value.
     *
     * Common Problems:
     * - Two Sum II
     * - Valid Palindrome
     * - Merge Sorted Arrays
     * - Container With Most Water
     *
     * Time Complexity:
     * O(n)
     *
     * Space Complexity:
     * O(1)
     *
     * ==========================================================
     */
    public static void main(String[] args) {
        int[] arr={-7,1,2,4,3,-8,-9};
        //System.out.println(Arrays.toString(twoSumSorted(arr, 8)));
    }
    static int[] twoSumSorted(int[] arr, int target) {

        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int start = 0;
        int end = arr.length - 1;

        while (start < end) {

            int sum = arr[start] + arr[end];

            if (sum == target) {
                return new int[]{start, end};
            }else if(sum<target){
                start++;
        }else{
                end--;
            }
    }
        return new int[]{-1,-1};
    }

    static boolean isPalindrome(String str){
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
    static String reverseString(String str){
        if(str==null || str.isEmpty()){
            throw new IllegalArgumentException("String cannot be null or empty");
        }
        char[] arr = str.toCharArray();
        int start=0;
        int end = arr.length-1;
        while(start<end){
            char temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }

        return new String(arr);
    }

    static int removeDuplicate(int[] arr){
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        int j=0;

        for(int i=0;i<arr.length;i++){
            if(arr[i]!=arr[j]){
                j++;
                arr[j]=arr[i];
            }
        }
        return j;
    }
    static int[] squareOfNonSortedArr(int[] arr){
        for(int i = 0; i<arr.length;i++){
            arr[i]=arr[i]*arr[i];
        }
        System.out.println("arr: "+Arrays.toString(arr));

        for(int i=1;i<arr.length;i++){
            for(int j=0;j<i;j++){
                if(arr[i]<arr[j]){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }

        }
        return arr;
    }
    static int[] sortedSquares(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        int[] result = new int[arr.length];
        int index = arr.length - 1;
        while (left <= right) {

            int leftSquare = arr[left] * arr[left];
            int rightSquare = arr[right] * arr[right];

            if (leftSquare > rightSquare) {
                result[index] = leftSquare;
                left++;
            } else {
                result[index] = rightSquare;
                right--;
            }

            index--;
        }

        return result;
    }
    static int maxArea(int[] arr){
        int start=0;
        int end=arr.length-1;
        int maxAreaSoFar=Integer.MIN_VALUE;
        while(start<end){
            int width=end-start;
            int height = Math.min(arr[start], arr[end]);
            int area = width * height;
            maxAreaSoFar = Math.max(maxAreaSoFar, area);
            if (arr[start] < arr[end]) {
                start++;
            } else {
                end--;
            }

        }
        return maxAreaSoFar;
    }
}
