package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class twosun {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(sol.twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(sol.twoSum(new int[]{3, 3}, 6)));
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int left = target - nums[i];
            if (set.contains(left)) {
                int j = 0;
                for (j = 0; j < nums.length; j++) {
                    if (nums[j] == left)
                        break;
                }
                return new int[]{i < j ? i : j, i < j ? j : i};
            } else {
                set.add(nums[i]);
            }
        }
        return new int[]{0, 0};
    }
}
