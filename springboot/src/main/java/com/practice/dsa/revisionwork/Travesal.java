package com.practice.dsa.revisionwork;

public class Travesal {
    public static void main(String[] args) {
        int[] arr = {1,3,8,4,6,7};
        int target=22;
        System.out.println("MAX : "+ findMax(arr));
        System.out.println("MIN : "+ findMin(arr));
        System.out.println("SUM : "+ findSum(arr));
        System.out.println("Linear Search : "+ linearSearch(arr,target));
        System.out.println("Second largest : "+ findSecondLargest(arr));

        //findSum(int[] arr);

        //linearSearch(int[] arr, int target);
    }

    static int findMax(int[] arr){
        if(arr==null||arr.length==0){
            throw new IllegalArgumentException("Array cannot be null");
        }
        int largest=arr[0];
        for(int i=1 ; i<arr.length; i++){
            if(arr[i]>largest){
                largest=arr[i];
            }
        }
        return largest;
    }

    static int findMin(int[] arr){
        if(arr==null||arr.length==0){
            throw new IllegalArgumentException("Array cannot be null");
        }
        int smallest=arr[0];
        for(int i=1 ; i<arr.length; i++){
            if(arr[i]<smallest){
                smallest=arr[i];
            }
        }
        return smallest;
    }
    static int findSum(int[] arr){
        if(arr==null||arr.length==0){
            throw new IllegalArgumentException("Array cannot be null");
        }
        int sum=0;
        for(int num : arr){
            sum+=num;
        }
        return sum;
    }

    static int linearSearch(int arr[], int target){
        if(arr==null||arr.length==0){
            throw new IllegalArgumentException("Array cannot be null empty");
        }
        for(int i=0; i<arr.length;i++){
            if(arr[i]==target){
                return i;
            }
        }
        return -1;
    }

    static int countOccurrences(int[] arr, int target){
        if(arr==null||arr.length==0){
            throw new IllegalArgumentException("Array cannot be null empty");
        }
        int count=0;
        for (int num : arr) {
            if (num == target) {
                count++;
            }
        }
        return count;
    }

    static int findSecondLargest(int[] arr){
        if(arr==null||arr.length<2){
            throw new IllegalArgumentException("Array cannot be null and atleast have 2 elements");
        }
        int largest=arr[0];
        Integer secondLargest=null;
        for(int num:arr){
            if(num>largest){
                secondLargest=largest;
                largest=num;
            }else if(num<largest &&(secondLargest==null || num > secondLargest)){
                secondLargest=num;
            }
        }
        if(secondLargest==null){
            throw new RuntimeException(" No second largest exist ");
        }
        return secondLargest;
    }
}
