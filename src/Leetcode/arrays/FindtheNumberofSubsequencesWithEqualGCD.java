package Leetcode.arrays;
import java.util.*;
public class FindtheNumberofSubsequencesWithEqualGCD {
    class Solution {
        private static final int MOD = 1_000_000_007;

        int[] nums;
        int n;
        Integer[][][] memo;

        public int subsequencePairCount(int[] nums) {
            this.nums = nums;
            this.n = nums.length;
            memo = new Integer[n + 1][201][201];
            return dfs(0, 0, 0);
        }

        private int dfs(int index, int g1, int g2) {
            if (index == n) {
                return (g1 != 0 && g1 == g2) ? 1 : 0;
            }

            if (memo[index][g1][g2] != null) {
                return memo[index][g1][g2];
            }

            long ans = 0;

            ans += dfs(index + 1, g1, g2);

            int ng1 = (g1 == 0) ? nums[index] : gcd(g1, nums[index]);
            ans += dfs(index + 1, ng1, g2);

            int ng2 = (g2 == 0) ? nums[index] : gcd(g2, nums[index]);
            ans += dfs(index + 1, g1, ng2);

            memo[index][g1][g2] = (int) (ans % MOD);
            return memo[index][g1][g2];
        }

        private int gcd(int a, int b) {
            while (b != 0) {
                int temp = a % b;
                a = b;
                b = temp;
            }
            return a;
        }
    }
}
