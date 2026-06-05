package Leetcode.dp;
import java.util.*;

public class TotalWavinessofNumbersinRangeII {



        static class Pair {
            long cnt;
            long sum;

            Pair(long cnt, long sum) {
                this.cnt = cnt;
                this.sum = sum;
            }


        private String s;
        private Pair[][][][][] memo;

        public long totalWaviness(long num1, long num2) {
            return solve(num2) - solve(num1 - 1);
        }

        private long solve(long x) {
            if (x <= 0) return 0;

            s = String.valueOf(x);

            memo = new Pair[s.length()][11][11][2][2];

            return dfs(0, 10, 10, 0, 1).sum;
        }

        private Pair dfs(int pos, int prev2, int prev1,
                         int started, int tight) {

            if (pos == s.length()) {
                return new Pair(1, 0);
            }

            if (tight == 0 &&
                    memo[pos][prev2][prev1][started][0] != null) {
                return memo[pos][prev2][prev1][started][0];
            }

            int limit = (tight == 1)
                    ? s.charAt(pos) - '0'
                    : 9;

            long totalCnt = 0;
            long totalSum = 0;

            for (int digit = 0; digit <= limit; digit++) {

                int nextTight =
                        (tight == 1 && digit == limit) ? 1 : 0;

                if (started == 0 && digit == 0) {

                    Pair child =
                            dfs(pos + 1, 10, 10,
                                    0, nextTight);

                    totalCnt += child.cnt;
                    totalSum += child.sum;

                } else {

                    int nPrev2 = prev2;
                    int nPrev1 = prev1;

                    long add = 0;

                    if (started == 1 && prev2 != 10) {

                        if ((prev1 > prev2 && prev1 > digit) ||
                                (prev1 < prev2 && prev1 < digit)) {
                            add = 1;
                        }
                    }

                    Pair child =
                            dfs(pos + 1,
                                    nPrev1,
                                    digit,
                                    1,
                                    nextTight);

                    totalCnt += child.cnt;

                    totalSum += child.sum
                            + add * child.cnt;
                }
            }

            Pair res = new Pair(totalCnt, totalSum);

            if (tight == 0) {
                memo[pos][prev2][prev1][started][0] = res;
            }

            return res;
        }
    }
}
