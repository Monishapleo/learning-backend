package com.practice.dsa.revisionwork;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.*;

public class HashingRE {
    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 1, 2, 4, 5};
        System.out.println(firstUnique(arr));
    }
    static boolean containsDuplicate(int[] arr){
        if(arr==null||arr.length==0) {
            throw new IllegalArgumentException("Array cannot be null/empty");
        }
            Set<Integer> seen=new HashSet<>();
            for(int num:arr){
                if(!seen.add(num)){
                    return true;
                }
            }
        return false;
    }
    static int firstDuplicate(int[] arr){
        if(arr==null||arr.length==0) {
            throw new IllegalArgumentException("Array cannot be null/empty");
        }
        Set<Integer> seen=new HashSet<>();
        for(int num:arr){
            if(!seen.add(num)){
                return num;
            }
        }
        return -1;
    }
    static int firstUnique(int[] arr){
        if(arr==null||arr.length==0) {
            throw new IllegalArgumentException("Array cannot be null/empty");
        }
        Map<Integer,Integer> countMap=new LinkedHashMap<>();
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        for(Map.Entry<Integer,Integer> map:countMap.entrySet()){
            if(map.getValue()==1){
                return map.getKey();
            }
        }
        return -1;
    }
    static int firstUniqueOriginal(int[] arr){
        if(arr==null||arr.length==0) {
            throw new IllegalArgumentException("Array cannot be null/empty");
        }
        Map<Integer,Integer> countMap=new HashMap<>();
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        for(int num:arr){
            if(countMap.get(num)==1){
                return num;
            }
        }
        return -1;
    }
}
