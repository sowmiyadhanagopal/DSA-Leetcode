package Leetcode.strings;

public class NumberofStringsThatAppearasSubstringsinWord {

        public int numOfStrings(String[] patterns, String word) {
            int n=patterns.length;
            int c=0;
            for(int i=0;i<n;i++)
            {
                if(word.contains(patterns[i]))
                {
                    c++;
                }
            }
            return c;
        }
    }

