package Leetcode.strings;

public class SmallestPalindromicRearrangementI {

    class Solution {
        public String smallestPalindrome(String s) {
            int[] freq=new int[26];
            for(char ch:s.toCharArray())
            {
                freq[ch-'a']++;
            }
            StringBuilder left=new StringBuilder();
            for(int i=0;i<26;i++)
            {
                for(int j=0;j<freq[i]/2;j++)
                {
                    left.append((char)('a'+i));
                }
            }
            String middle = "";

            for (int i = 0; i < 26; i++) {
                if(freq[i] % 2 == 1)
                {
                    middle = String.valueOf((char)('a' + i));
                    break;
                }
            }
            String right = new StringBuilder(left).reverse().toString();
            return left.toString() + middle + right;

        }


    }
}
