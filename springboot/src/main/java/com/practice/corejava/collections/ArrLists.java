package com.practice.corejava.collections;

import java.util.*;

public class ArrLists {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        //int[] arr = {3,3};
        /*ArrayList<Integer> arrList = new ArrayList<>();
        arrList.add(-1);
        arrList.add(0);
        arrList.add(3);
        arrList.add(5);*/

//        System.out.println(Arrays.toString(twoSumOPT(arr, 7)));
//        System.out.println(Arrays.toString(twoSum(arr, 6)));
        //System.out.println(containsDuplicate(arr));

        //System.out.println(isSorted(arr));
       // reverse(arr);
        String s1 = "Java";
        String s2 = new String("Java").intern();

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        String s = null;

        System.out.println(s instanceof String);
    }

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
        System.out.println("Received : "+Arrays.toString(arr));

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



    static int[] twoSum(int[] nums, int target){
        for(int i=1;i<nums.length;i++){
            for(int j=0; j<i;j++){
                if(nums[j]+nums[i]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }








}
 