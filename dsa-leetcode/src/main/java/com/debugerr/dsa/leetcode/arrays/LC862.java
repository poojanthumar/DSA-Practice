package com.debugerr.dsa.leetcode.arrays;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class LC862 {

    static class Solution {
        public int shortestSubarray(int[] nums, int k) {
            int n = nums.length;
            long[] prefix = new long[n + 1]; // prefix[0] = 0
            for (int i = 0; i < n; i++) {
                prefix[i + 1] = prefix[i] + nums[i];
            }

            int ans = n + 1;
            Deque<Integer> dq = new ArrayDeque<>();

            for (int j = 0; j <= n; j++) {
                // Check if we can shrink from front
                while (!dq.isEmpty() && prefix[j] - prefix[dq.peekFirst()] >= k) {
                    ans = Math.min(ans, j - dq.pollFirst());
                }

                // Maintain increasing order of prefix sums
                while (!dq.isEmpty() && prefix[j] <= prefix[dq.peekLast()]) {
                    dq.pollLast();
                }

                dq.addLast(j);
            }

            return ans <= n ? ans : -1;
        }
    }


}
