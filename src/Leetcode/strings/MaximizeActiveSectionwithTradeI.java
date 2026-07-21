package Leetcode.strings;
import java.util.*;
public class MaximizeActiveSectionwithTradeI {
    class Solution {
        public int maxActiveSectionsAfterTrade(String s) {

            int ones = 0;
            for (char ch : s.toCharArray()) {
                if (ch == '1') {
                    ones++;
                }
            }
            String t = "1" + s + "1";
            ArrayList<Character> type = new ArrayList<>();
            ArrayList<Integer> len = new ArrayList<>();

            int i = 0;

            while (i < t.length()) {

                char ch = t.charAt(i);
                int j = i;

                while (j < t.length() && t.charAt(j) == ch) {
                    j++;
                }

                type.add(ch);
                len.add(j - i);

                i = j;
            }


            int maxGain = 0;

            for (int k = 1; k < type.size() - 1; k++) {

                if (type.get(k) == '1'
                        && type.get(k - 1) == '0'
                        && type.get(k + 1) == '0') {

                    int gain = len.get(k - 1) + len.get(k + 1);

                    maxGain = Math.max(maxGain, gain);
                }
            }


            return ones + maxGain;
        }
    }
}
