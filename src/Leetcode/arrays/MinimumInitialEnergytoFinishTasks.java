package Leetcode.arrays;
import java.util.*;
public class MinimumInitialEnergytoFinishTasks {

        public int minimumEffort(int[][] tasks) {
            Arrays.sort(tasks, (a, b) -> {
                return (b[1] - b[0]) - (a[1] - a[0]);
            });

            int ans = 0;
            int curr = 0;

            for (int[] task : tasks) {

                int actual = task[0];
                int minimum = task[1];
                if (curr < minimum) {

                    int extra = minimum - curr;

                    ans += extra;
                    curr += extra;
                }
                curr -= actual;
            }

            return ans;
        }
}

