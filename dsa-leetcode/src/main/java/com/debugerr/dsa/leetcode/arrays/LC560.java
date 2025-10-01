package com.debugerr.dsa.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0,1);
        int ans= 0;
        mp.put(nums[0],1);
        if(nums[0] == 0) mp.put(0,2);
        if(nums[0] == k) ans++;
        for(int i = 1 ; i < nums.length; i++)
        {
            nums[i] += nums[i-1] ;
            if(mp.containsKey(nums[i] - k )) ans += mp.get(nums[i] - k);
            if(mp.containsKey(nums[i] )) mp.put(nums[i] , mp.get(nums[i]) + 1);
            else mp.put(nums[i] , 1);
        }
        return ans;

    }
}
public class LC560 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,1,2,1};
        System.out.println(new Solution().subarraySum(nums, 3));
    }

}
