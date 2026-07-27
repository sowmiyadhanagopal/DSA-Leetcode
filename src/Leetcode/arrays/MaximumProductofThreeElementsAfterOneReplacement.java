package Leetcode.arrays;
import java.util.*;
public class MaximumProductofThreeElementsAfterOneReplacement {


    class Solution {
        public long maxProduct(int[] nums) {
            Arrays.sort(nums);

            int n = nums.length;
            long x = 100000L;

            long case1 = 1L * nums[0] * nums[1] * x;
            long case2 = 1L * nums[n - 2] * nums[n - 1] * x;
            long case3 = 1L * nums[0] * nums[n - 1] * (-x);

            return Math.max(case1, Math.max(case2, case3));
        }
    }
}
