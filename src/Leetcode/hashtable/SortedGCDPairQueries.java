package Leetcode.hashtable;
import java.util.*;
public class SortedGCDPairQueries {


    class Solution {
        public int[] gcdValues(int[] nums, long[] queries) {
            int max = 0;
            for (int x : nums) max = Math.max(max, x);

            int[] freq = new int[max + 1];
            for (int x : nums) freq[x]++;

            long[] pairs = new long[max + 1];

            for (int g = max; g >= 1; g--) {
                long cnt = 0;
                for (int multiple = g; multiple <= max; multiple += g) {
                    cnt += freq[multiple];
                }

                pairs[g] = cnt * (cnt - 1) / 2;

                for (int multiple = g * 2; multiple <= max; multiple += g) {
                    pairs[g] -= pairs[multiple];
                }
            }

            long[] prefix = new long[max + 1];
            for (int g = 1; g <= max; g++) {
                prefix[g] = prefix[g - 1] + pairs[g];
            }

            int[] ans = new int[queries.length];

            for (int i = 0; i < queries.length; i++) {
                long target = queries[i] + 1;

                int left = 1;
                int right = max;

                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (prefix[mid] >= target) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }

                ans[i] = left;
            }

            return ans;
        }
    }
}
