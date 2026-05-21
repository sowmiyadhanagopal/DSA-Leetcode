package Leetcode.strings;
import java.util.*;
public class FindtheLengthoftheLongestCommonPrefix {

        public int longestCommonPrefix(int[] arr1, int[] arr2) {

            HashSet<Integer> set = new HashSet<>();

            // Store all prefixes of arr1
            for (int num : arr1) {

                while (num > 0) {
                    set.add(num);
                    num /= 10;
                }
            }

            int ans = 0;

            // Check prefixes of arr2
            for (int num : arr2) {

                while (num > 0) {

                    if (set.contains(num)) {
                        ans = Math.max(ans,
                                String.valueOf(num).length());
                    }

                    num /= 10;
                }
            }

            return ans;
        }
    }

