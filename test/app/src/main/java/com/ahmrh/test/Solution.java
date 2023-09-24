package com.ahmrh.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public String reverseVowels(String s) {
        Stack<Character> stack = new Stack<Character>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(isVowel(c)){
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(isVowel(c)){
                sb.append(stack.pop());
            }
            else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    Boolean isVowel(char c){
        return "aiueoAIUEO".contains(String.valueOf(c));
    }

    public int pivotIndex(int[] nums) {

        for(int i = 0; i < nums.length; i ++){
            int left = sumOfArray(Arrays.copyOfRange(nums, 0, i));
            int right = sumOfArray(Arrays.copyOfRange(nums, i + 1, nums.length - 1));
            if(left == right) return i;
        }

        return -1;
    }

    int sumOfArray(int[] arr){
        return Arrays.stream(arr).sum();
    }
}
