package com.practice.dsa.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Hashing {
    /*
    Because we should only match the current element with elements we've already seen.
    If we insert first, the current element could match itself, producing incorrect results like {0,0}
     */
    static int[] twoSumOPT(int[] nums, int target){
        HashMap<Integer,Integer> sumMap=new HashMap<>();
        for(int i =0; i<nums.length;i++){
            int needed=target-nums[i];
            if(sumMap.containsKey(needed)){
                return new int[]{i,sumMap.get(needed)};
            }else{
                sumMap.put(nums[i],i);
            }
        }
        return new int[]{};
    }

    static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }

        Set<Integer> unique = new HashSet<>();

        for (int num : nums) {
            if (!unique.add(num)) {
                return true;
            }
        }

        return false;
    }

}
