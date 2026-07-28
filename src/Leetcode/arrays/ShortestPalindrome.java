package Leetcode.arrays;

public class ShortestPalindrome {
    class Solution {

        public String shortestPalindrome(String s) {

            String rev = new StringBuilder(s).reverse().toString();

            String combined = s + "#" + rev;

            int[] lps = buildLPS(combined);

            int longestPalindromePrefix = lps[combined.length() - 1];

            String remaining = s.substring(longestPalindromePrefix);

            return new StringBuilder(remaining)
                    .reverse()
                    .append(s)
                    .toString();
        }

        private int[] buildLPS(String str) {

            int[] lps = new int[str.length()];

            int len = 0;
            int i = 1;

            while (i < str.length()) {

                if (str.charAt(i) == str.charAt(len)) {

                    len++;
                    lps[i] = len;
                    i++;

                } else {

                    if (len != 0) {

                        len = lps[len - 1];

                    } else {

                        lps[i] = 0;
                        i++;
                    }
                }
            }

            return lps;
        }
    }
}
