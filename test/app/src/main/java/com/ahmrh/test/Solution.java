package com.ahmrh.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public boolean increasingTriplet(int[] nums) {
        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;

        for(int num: nums){
            if(num <= x) {
                x = num;
            } else if(num <= y){
                y = num;
            } else {
                return true;
            }
        }

        return false;

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0) return;

        for(int num2 : nums2){
            nums1[m + n] = num2;
            n ++;
        }

        Arrays.sort(nums1);

    }

}
