package com.practice.dsa.arrays;

import java.util.HashMap;
import java.util.Map;

public class FrequencyCounting {
    static boolean isAnagram(String str,String str1){
        Map<Character,Integer> frequencyMap1 = new HashMap<>();
        Map<Character,Integer> frequencyMap2 = new HashMap<>();
        for(Character i : str.toCharArray()){
            frequencyMap1.put(i, frequencyMap1.getOrDefault(i, 0) + 1);
        }
        for(Character i : str1.toCharArray()){
            frequencyMap2.put(i, frequencyMap2.getOrDefault(i, 0) + 1);
        }
        return frequencyMap1 .equals(frequencyMap2);
    }
    static boolean isAnagramOPT(String s, String t) {

        if (s == null || t == null) {
            throw new IllegalArgumentException("String cannot be null");
        }

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> frequency = new HashMap<>();

        // Increase frequency
        for (char c : s.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }

        // Decrease frequency
        for (char c : t.toCharArray()) {

            if (!frequency.containsKey(c)) {
                return false;
            }

            frequency.put(c, frequency.get(c) - 1);

            if (frequency.get(c) == 0) {
                frequency.remove(c);
            }
        }

        return frequency.isEmpty();
    }
    static boolean isAnagramBEST(String s, String t) {

        if (s == null || t == null) {
            throw new IllegalArgumentException("String cannot be null");
        }

        if (s.length() != t.length()) {
            return false;
        }

        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        for (int count : freq) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
