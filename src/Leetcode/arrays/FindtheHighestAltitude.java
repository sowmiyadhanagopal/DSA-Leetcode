package Leetcode.arrays;

public class FindtheHighestAltitude {
        public int largestAltitude(int[] gain) {

            int currentalt=0;
            int maxalt=0;
            for(int num:gain)
            {
                currentalt+=num;
                maxalt=Math.max(maxalt,currentalt);
            }
            return maxalt;

        }
    }

