package com.ahmrh.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.stream.IntStream;

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

        for (int i = 1, cheapest = prices[0]; i < prices.length; i++) {
            if (prices[i] < cheapest)
                cheapest = prices[i];
            else {
                int profit = prices[i] - cheapest;

                if (profit > max) max = profit;
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

        while (curr.next != null) {
            if (!pointerArray.contains(curr))
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

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ')
                break;

            length++;
        }

        return length;
    }

    public int maxDepth(TreeNode node) {
        if (node == null) return 0;

        return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;

    }

    public long coloredCells(int n) {
        Double ans = Math.pow(n, 2) + Math.pow(n - 1, 2);
        return ans.longValue();
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> hashMap = new HashMap();

        for (char c : magazine.toCharArray()) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }

        for (char c : ransomNote.toCharArray()) {
            if (!hashMap.containsKey(c) || hashMap.get(c) < 1) return false;
            hashMap.put(c, hashMap.get(c) - 1);
        }

        return true;
    }

    public String simplifyPath(String path) {
        path.replaceAll("//", "/");
        String[] dirs = path.split("/");

        Stack<String> stack = new Stack();

        for (String dir : dirs) {
            switch (dir) {
                case "":
                case ".":
                    continue;
                case "..": {
                    if (!stack.isEmpty()) stack.pop();
                    break;
                }
                default:
                    stack.push(dir);
            }
        }

        if (stack.isEmpty()) return "/";

        StringBuilder sb = new StringBuilder();
        for (String str : stack) {
            sb.append("/" + str);
        }

        return sb.toString();

    }

    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> ranges = new ArrayList();

        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];

            while (i + 1 < nums.length && nums[i] + 1 != nums[i + 1])
                i++;

            if (start != nums[i])
                ranges.add(start + "->" + nums[i]);
            else
                ranges.add(String.valueOf(start));
        }

        return ranges;
    }


    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();

        char c = s.charAt(0);
        String s1 = String.valueOf(c);

        for (int i = 1; i < s.length(); i++) {
            char c1 = s.charAt(i);
            if (c == c1) {
                s1 += c1;
            } else {
                if (s1.length() > 2) {
                    sb.append(String.valueOf(c) + c);
                } else {
                    sb.append(s1);
                }
                c = s.charAt(i);
                s1 = String.valueOf(c);
            }
        }

        if (s1.length() > 2) {
            sb.append(String.valueOf(c) + c);
        } else {
            sb.append(s1);
        }
        return sb.toString();
    }


    public boolean validMountainArray(int[] arr) {
        boolean inc = false, dec = false;
        int index = 0;

        while (index < arr.length) {
            if (arr[index - 1] < arr[index])
                inc = true;
            else
                break;

            index++;
        }

        while (index < arr.length) {
            if (arr[index - 1] > arr[index])
                dec = true;
            else
                break;

            index++;
        }

        return inc == dec && index == arr.length;
    }

    public boolean isValidSerialization(String preorder) {
        if (preorder == null) return false;

        String[] values = preorder.split(",");
        Stack<String> stack = new Stack();

        for (String value : values) {
            while (value.equals("#") && !stack.isEmpty() && stack.peek().equals(value)) {
                stack.pop();
                if (stack.isEmpty()) return false;
                stack.pop();

            }
            stack.push(value);
        }

        System.out.println(stack);

        return stack.size() == 1 && stack.peek().equals("#");
    }

    public int minSubArrayLen(int target, int[] nums) {

        if (nums == null || nums.length == 0) return 0;

        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;
        while (j < nums.length) {
            sum += nums[j++];
            while (sum >= target) {
                min = Math.min(min, j - i); //(old j) - i + 1 = j - i
                sum -= nums[i++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public int sumOfMultiples(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0)
                sum += i;
        }

        return sum;
    }

    public boolean isAnagram(String s, String t) {
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<Integer> arrayList = new ArrayList();

        ListNode curr = head;
        while (curr != null) {
            arrayList.add(curr.val);
            curr = curr.next;
        }
        System.out.println(arrayList);

        arrayList.remove(arrayList.size() - n);

        ListNode newHead = new ListNode(arrayList.get(0));
        ListNode newCurr = newHead;

        for (int i = 1; i < arrayList.size(); i++) {
            newCurr.next = new ListNode(arrayList.get(i));
            newCurr = newCurr.next;
        }

        return newHead;

    }

    public int minMovesToSeat(int[] seats, int[] students) {

        Arrays.sort(seats);
        Arrays.sort(students);

        int sum = 0;
        for (int i = 0; i < seats.length; i++) {
            sum += Math.abs(seats[i] - students[i]);
        }

        return sum;

    }


    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int min = Integer.MAX_VALUE;

        for (int i = 1; i < arr.length; i++) {
            int a = Math.min(arr[i - 1], arr[i]);
            int b = Math.max(arr[i - 1], arr[i]);
            int diff = b - a;
            if (diff < min) min = diff;
        }

        Arrays.sort(arr);
        System.out.println(arr);

        ArrayList<List<Integer>> output = new ArrayList();


        for (int i = 1; i < arr.length; i++) {
            int a = arr[i - 1];
            int b = arr[i];
            int diff = b - a;

            if (diff == min) output.add(Arrays.asList(a, b));
        }


        return output;
    }


    public int climbStairs(int n) {
        if (n == 1) return 1;
        return climbStairs(n - 1) + climbStairs()

    }

//    private int goodStringCounter = 0;
//
//    private final HashMap<String, String> hashMap = new HashMap<>();
//
//    public int countGoodStrings(int low, int high, int zero, int one) {
//
//        hashMap.put("zero ", buildGoodString(zero, "0"));
//        hashMap.put("one ", buildGoodString(one, "1"));
//
//        StringBuilder keyBuilder = new StringBuilder();
//
//        goodStringRecursion(low, high, zero, one, keyBuilder);
//
//        return goodStringCounter;
//    }
//
//    private void goodStringRecursion(int low, int high, int zero, int one, StringBuilder keyBuilder) {
//        String key = keyBuilder.toString();
//
//        StringBuilder sb = new StringBuilder();
//
//        if(hashMap.containsKey(key)){
//            sb.append(hashMap.get(key));
//        } else {
//            String[] arr = key.split(" ");
//            for(String i: arr){
//                sb.append(i);
//            }
//        }
//
//        if(low <= sb.length() && sb.length() <= high){
//            goodStringCounter += 1;
//            keyBuilder.delete(keyBuilder.lastIndexOf(" "), keyBuilder.length());
//            return;
//        }
//
//        String key0 = key += "zero ";
//        String[] arr = key.split(" ");
//        for(String key)
//
//        goodStringRecursion(low, high, zero, one, key += "zero ");
//        goodStringRecursion(low, high, zero, one, key += "one ");
//
//    }
//
//
//    private String buildGoodString(int n, String s) {
//        return String.format("%0" + n + "d", 0).replace("0", s);
//    }


    public int countGoodStrings(int low, int high, int zero, int one) {
        final int kMod = 1_000_000_007;
        int ans = 0;
        // dp[i] := # of good strings with length i
        int[] dp = new int[high + 1];
        dp[0] = 1;

        for (int i = 1; i <= high; ++i) {
            if (i >= zero)
                dp[i] = (dp[i] + dp[i - zero]) % kMod;
            if (i >= one)
                dp[i] = (dp[i] + dp[i - one]) % kMod;
            if (i >= low)
                ans = (ans + dp[i]) % kMod;
        }

        return ans;


    }

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int size0 = grid.length;
        int size1 = grid[0].length;


        // break into 1d array
        int index = 0;

        int[] arr = new int[size0 * size1];
        for (int i = 0; i < size0; i++) {
            for (int j = 0; j < size1; j++) {
                arr[index] = grid[i][j];
                index += 1;
            }
        }


        int shift = k % (size0 * size1);

        int[] shifted = arr.clone();

        for (int i = 0; i < shifted.length; i++) {
            System.out.print(shifted[i]);

            if (i - shift < 0)
                shifted[i] = arr[shifted.length + (i - shift)];
            else
                shifted[i] = arr[i - shift];

            System.out.println(shifted[i]);
        }


        // build back into 2d array
        index = 0;

        List<List<Integer>> shiftedGrid = new ArrayList<>();
        for (int i = 0; i < size0; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < size1; j++) {
                list.add(shifted[index]);
                index += 1;
            }
            shiftedGrid.add(list);
        }

        return shiftedGrid;

    }


    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeavesRecursion(null, root, false);

    }

    private int sumOfLeftLeavesRecursion(TreeNode parent, TreeNode node, Boolean isLeft) {
        if (node == null) return 0;
        if (node.left == null && node.right == null && parent != null && isLeft)
            return node.val;

        int left = sumOfLeftLeavesRecursion(node, node.left, true);
        int right = sumOfLeftLeavesRecursion(node, node.right, false);

        return left + right;
    }

    public int[] getConcatenation(int[] nums) {
        int size = nums.length;

        int[] ans = new int[size * 2];

        for (int i = 0; i < size; i++) {
            int num = nums[i];

            ans[i] = num;
            ans[size + i] = num;
        }

        return ans;
    }

    public String defangIPaddr(String address) {
        System.out.println(address);
        return address.replaceAll(".", "[.]");
    }

    public int minPartitions(String n) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n.length(); i++) {
            int num = Character.getNumericValue(n.charAt(i));
            if (max < num) {
                max = num;
            }
        }

        return max;

    }


    public int finalValueAfterOperations(String[] operations) {

        int x = 0;
        for (String operation : operations) {
            switch (operation) {
                case "--X":
                    --x;
                case "X--":
                    x--;
                case "X++":
                    x++;
                case "++X":
                    ++x;
            }
        }

        return x;
    }

    public int[] findArray(int[] pref) {
        int[] output = new int[pref.length];

        for (int i = 0, res = 0; i < pref.length; i++) {
            output[i] = res ^ pref[i];
            System.out.print(res + "^" + pref[i]);

            res ^= pref[i];
            System.out.println(" = " + res);
        }

        return output;


    }

    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;

        for (char c : stones.toCharArray()) {
            if (jewels.indexOf(c) != -1)
                count++;
        }

        return count;

    }

    public int[] shuffle(int[] nums, int n) {
        int[] shuffledArray = new int[2 * n];
        for (int i = 0, j = 0, k = n; i < 2 * n; i++) {
            if (i % 2 == 0) {
                shuffledArray[i] = nums[j];
                j += 1;
            } else {
                shuffledArray[i] = nums[k];
                k += 1;
            }
        }

        return shuffledArray;

    }

    public String convert(String s, int numRows) {
        String[][] arr = new String[numRows][s.length() / numRows];

        int index = 0, row = 0, col = 0;
        boolean zig = true, zag = true;
        while (index < s.length()) {
            if (row == 0) {
                zig = true;
                zag = false;
            }
            if (row == numRows) {
                zig = false;
                zag = true;
            }

            if (zig) {
                arr[row][col] = String.valueOf(s.charAt(index));
                System.out.println(row + " " + col + " = " + index);
                row++;
                index++;
            }
            if (zag) {
                arr[row][col] = String.valueOf(s.charAt(index));
                System.out.println(row + " " + col + " = " + index);
                row--;
                col++;
                index++;

            }

        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != null)
                    sb.append(arr[i][j]);
            }
        }

        return sb.toString();

    }

    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;

        int maxArea = Integer.MIN_VALUE;
        while (start < end) {
            int base = end - start;
            int area = height[start] > height[end] ? height[end] * base : height[start] * base;
            if(maxArea < area) maxArea = area;

            if(height[start] < height[end]) start ++;
            else end --;
        }

        return maxArea;
    }

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }


    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int[] tempInterval = newInterval.clone();
        int n = intervals.length;

        int i = 0;
        while(i < n){
            int[] interval = intervals[i];

            if(tempInterval[1] < interval[0]){
                res.add(tempInterval);
                while(i < n){
                    res.add(intervals[i]);
                    i ++;
                }
                return res.toArray(new int[0][]);
            }
            else if(interval[1] < tempInterval[0]){
                res.add(interval);
            } else {
                tempInterval[0] = Math.min(tempInterval[0], interval[0]);
                tempInterval[1] = Math.max(tempInterval[1], interval[1]);
            }

            i++;
            
        }

        res.add(tempInterval);

        return res.toArray(new int[0][]);

    }


    public boolean searchMatrix(int[][] matrix, int target) {
        int length = matrix.length;

        for(int[] array: matrix){
            if(binarySearch(array, target)) return true;
        }


        return false;
    }

    public boolean binarySearch(int[] array, int target){
        int length = array.length;
        if(length == 1)
            return array[0] == target;

        int start = 0, end = length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(array[mid] < target){
                start = mid + 1;
            } else if(array[mid] > target){
                end = mid - 1;
            } else{
                return true;
            }

        }

        return false;
    }

    public int romanToInt(String s) {
        HashMap<Character, Integer> dict = new HashMap<Character, Integer>(){
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };

        int count = 0;

        for(int i = 0; i < s.length(); i ++){
            if(i < s.length() - 1 && dict.get(s.charAt(i)) < dict.get(s.charAt(i + 1)))
                count -= dict.get(s.charAt(i));
            else
                count += dict.get(s.charAt(i));
        }

        return count;

    }

    public boolean isHappy(int n) {
        if(isSingleDigit(n) ) {
            return n == 7 || n == 1;
        }

        int number = 0;
        int temp = n, digit = 0;

        while(temp != 0){
            digit = temp % 10;
            temp /= 10;
            number += Math.pow(digit, 2);
        }

        System.out.println(number);
        return isHappy(number);

    }


//    SIEVE OF ERATOSTHENES algorithm
    public int countPrimes(int n) {
        boolean[] prime = new boolean[n];
        Arrays.fill(prime, true);

        for(int i = 2; i * i < n; i++){
            if(prime[i]){
                for(int j = i; j * i < n; j++){
                    prime[i * j] = false;
                }
            }
        }

        for(boolean i : prime){
            System.out.println(i);
        }

        int count = 0;
        for(int i = 2; i < prime.length; i++){
            if(prime[i]) count += 1;
        }

        return count;
    }

    private boolean isSingleDigit(int num){
        return num / 10 != 0;
    }


    public void rotate(int[] nums, int k) {
        int length = nums.length;

        if(length <= 1) return;

        int[] tempNums = nums.clone();

        int step = k % length;

        for(int i = length - 1; i >= 0; i--){
            if(i - step >= 0)
                nums[i] = tempNums[i - step];
            else
                nums[i] = tempNums[length + i - step];

        }

    }


    public boolean isIsomorphic(String s, String t) {

        HashMap<String, String> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            String s1 = String.valueOf(s.charAt(i));
            String t1 = String.valueOf(t.charAt(i));

            if(map.get(s1) == null){
                if(map.containsValue(t1))
                    return false;

                map.put(s1, t1);
            } else if(!map.get(s1).equals(t1))
                return false;

        }

        return true;
    }

    public TreeNode invertTree(TreeNode root) {

        invertTraversal(root);

        return root;
    }

    void invertTraversal(TreeNode node) {
        if(node == null) return;

        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        invertTraversal(node.left);
        invertTraversal(node.right);
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        Arrays.sort(nums);

        int[] unique = IntStream.of(nums).distinct().toArray();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 1, j = 0; (i <= nums.length) && j < unique.length; i++){
            System.out.println(i + " " + unique[j]);
            if(i != unique[j]){
                list.add(i);
            } else
                j++;
        }

        return list;
    }


    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return subRoot == null;

        return isSame(root, subRoot)
                || isSubtree(root.left, subRoot)
                || isSubtree(root.right, subRoot);

    }

    private boolean isSame(TreeNode t1, TreeNode t2) { // takes O(n)
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;

        if (t1.val != t2.val) return false;
        return isSame(t1.left, t2.left) && isSame(t1.right, t2.right);
    }

    public static void main(String[] args) {


    }

}
