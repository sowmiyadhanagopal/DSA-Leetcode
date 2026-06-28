package Leetcode.arrays;
import java.util.*;
public class MaximumElementAfterDecreasingandRearranging {

        public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
            Arrays.sort(arr);
            int ans = 1;

            for (int i = 1; i < arr.length; i++) {
                if (arr[i] >= ans + 1) {
                    ans++;
                }
            }

            return ans;
        }
    }
