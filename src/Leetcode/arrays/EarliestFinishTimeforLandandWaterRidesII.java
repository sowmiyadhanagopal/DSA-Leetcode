package Leetcode.arrays;
import java.util.*;
public class EarliestFinishTimeforLandandWaterRidesII {



        public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                      int[] waterStartTime, int[] waterDuration) {

            long ans = Long.MAX_VALUE;

            ans = Math.min(ans,
                    solve(landStartTime, landDuration,
                            waterStartTime, waterDuration));

            ans = Math.min(ans,
                    solve(waterStartTime, waterDuration,
                            landStartTime, landDuration));

            return (int) ans;
        }

        private long solve(int[] firstStart, int[] firstDur,
                           int[] secondStart, int[] secondDur) {

            int m = secondStart.length;

            int[][] rides = new int[m][2];

            for (int i = 0; i < m; i++) {
                rides[i][0] = secondStart[i];
                rides[i][1] = secondDur[i];
            }

            Arrays.sort(rides, (a, b) -> Integer.compare(a[0], b[0]));

            int[] starts = new int[m];
            long[] prefixMinDur = new long[m];
            long[] suffixMinStartPlusDur = new long[m];

            starts[0] = rides[0][0];
            prefixMinDur[0] = rides[0][1];

            for (int i = 1; i < m; i++) {
                starts[i] = rides[i][0];
                prefixMinDur[i] = Math.min(prefixMinDur[i - 1], rides[i][1]);
            }

            suffixMinStartPlusDur[m - 1] =
                    (long) rides[m - 1][0] + rides[m - 1][1];

            for (int i = m - 2; i >= 0; i--) {
                long value = (long) rides[i][0] + rides[i][1];
                suffixMinStartPlusDur[i] =
                        Math.min(suffixMinStartPlusDur[i + 1], value);
            }

            long answer = Long.MAX_VALUE;

            for (int i = 0; i < firstStart.length; i++) {

                long t = (long) firstStart[i] + firstDur[i];

                int idx = upperBound(starts, (int) t);

                long best = Long.MAX_VALUE;

                if (idx > 0) {
                    best = Math.min(best,
                            t + prefixMinDur[idx - 1]);
                }

                if (idx < m) {
                    best = Math.min(best,
                            suffixMinStartPlusDur[idx]);
                }

                answer = Math.min(answer, best);
            }

            return answer;
        }

        private int upperBound(int[] arr, int target) {

            int left = 0;
            int right = arr.length;

            while (left < right) {

                int mid = left + (right - left) / 2;

                if (arr[mid] <= target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            return left;
        }
    }

