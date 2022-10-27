package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class validparentheses {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isValid("{}}}{}"));
    }

    static class Solution {
        public boolean isValid(String s) {
            Map<Character, Character> symbolMap = new HashMap<Character, Character>() {{
                put('[', ']');
                put('(', ')');
                put('{', '}');
            }};
            Set<Character> openSymbol = symbolMap.keySet();

            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                Character nowSymbol = s.charAt(i);
                if (openSymbol.contains(nowSymbol)) {
                    stack.push(nowSymbol);
                } else {
                    if (stack.empty()) return false;
                    Character closeSymbol = stack.pop();
                    if (symbolMap.get(closeSymbol) != nowSymbol) return false;
                }
            }
            return stack.isEmpty();
        }
    }
}
