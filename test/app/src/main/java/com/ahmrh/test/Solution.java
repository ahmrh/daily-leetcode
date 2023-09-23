package com.ahmrh.test;

import java.util.ArrayList;
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

}
