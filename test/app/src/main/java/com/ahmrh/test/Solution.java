package com.ahmrh.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Solution {
    public String reverseVowels(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isVowel(c)) {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isVowel(c)) {
                sb.append(stack.pop());
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    Boolean isVowel(char c) {
        return "aiueoAIUEO".contains(String.valueOf(c));
    }

    public int pivotIndex(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int left = sumOfArray(Arrays.copyOfRange(nums, 0, i));
            int right = sumOfArray(Arrays.copyOfRange(nums, i + 1, nums.length - 1));
            if (left == right) return i;
        }

        return -1;
    }

    int sumOfArray(int[] arr) {
        return Arrays.stream(arr).sum();
    }

    public boolean increasingTriplet(int[] nums) {
        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= x) {
                x = num;
            } else if (num <= y) {
                y = num;
            } else {
                return true;
            }
        }

        return false;

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;

        for (int num2 : nums2) {
            nums1[m + n] = num2;
            n++;
        }

        Arrays.sort(nums1);

    }

    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int mid = nums.length / 2;
        return nums[mid];
    }
    public int maxProfit(int[] prices) {

        int max = 0;

        for(int i = 1, cheapest = prices[0]; i < prices.length; i++){
            if(prices[i] < cheapest)
                cheapest = prices[i];
            else{
                int profit = prices[i] - cheapest;

                if(profit > max) max = profit;
            }
        }

        return max;

    }

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        String str = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        sb.append(str);

        return sb.toString().equals(sb.reverse().toString());

    }

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ArrayList<ListNode> pointerArray = new ArrayList<ListNode>();

        ListNode curr = head;

        while(curr.next != null){
            if(!pointerArray.contains(curr))
                pointerArray.add(curr);
            else
                return true;

            curr = curr.next;
        }

        return false;

    }

    public int lengthOfLastWord(String s) {
        s = s.trim();

        int length = 0;

        for(int i = s.length() - 1; i >= 0; i --){
            if(s.charAt(i) == ' ')
                break;

            length ++;
        }

        return length;
    }

    public int maxDepth(TreeNode node) {
        if(node == null) return 0;

        return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;

    }

    public long coloredCells(int n) {
        Double ans = Math.pow(n, 2) + Math.pow(n - 1, 2);
        return ans.longValue();
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> hashMap = new HashMap();

        for(char c: magazine.toCharArray()){
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }

        for(char c: ransomNote.toCharArray()){
            if(!hashMap.containsKey(c) || hashMap.get(c) < 1) return false;
            hashMap.put(c, hashMap.get(c) - 1);
        }

        return true;
    }

    public String simplifyPath(String path) {
        path.replaceAll("//", "/");
        String[] dirs = path.split("/");

        Stack<String> stack = new Stack();

        for(String dir: dirs) {
            switch(dir){
                case "":
                case ".":
                    continue;
                case "..": {
                    if(!stack.isEmpty()) stack.pop();
                    break;
                }
                default: stack.push(dir);
            }
        }

        if(stack.isEmpty()) return "/";

        StringBuilder sb = new StringBuilder();
        for(String str: stack){
            sb.append("/" + str);
        }

        return sb.toString();

    }

    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> ranges = new ArrayList();

        for(int i = 0; i < nums.length; i++){
            int start = nums[i];

            while(i + 1 < nums.length && nums[i] + 1 != nums[i + 1])
                i ++;

            if(start != nums[i])
                ranges.add("" + start + "->" + nums[i]);
            else
                ranges.add(String.valueOf(start));
        }

        return ranges;
    }


    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();

        char c = s.charAt(0);
        String s1 = "" + c;

        for(int i = 1; i < s.length(); i++){
            char c1 = s.charAt(i);
            if(c == c1){
                s1 += c1;
            } else{
                if(s1.length() > 2){
                    sb.append("" + c + c);
                } else{
                    sb.append(s1);
                }
                c = s.charAt(i);
                s1 = "" + c;
            }
        }

        if(s1.length() > 2){
            sb.append("" + c + c);
        } else{
            sb.append(s1);
        }
        return sb.toString();
    }


    public boolean validMountainArray(int[] arr) {
        boolean inc = false, dec = false;
        int index = 0;

        while(index < arr.length){
            if(arr[index - 1] < arr[index])
                inc = true;
            else
                break;

            index ++;
        }

        while(index < arr.length){
            if(arr[index - 1] > arr[index])
                dec = true;
            else
                break;

            index ++;
        }

        return inc == dec && index == arr.length;
    }

    public static void main(String[] args) {


    }
}
