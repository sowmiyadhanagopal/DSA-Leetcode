package Leetcode.arrays;

public class MinimumElementAfterReplacementWithDigitSum {
        public int minElement(int[] nums) {
            int ans=Integer.MAX_VALUE;
            for(int num:nums)
            {
                int d=0;
                while(num>0)
                {
                    d+=num%10;
                    num/=10;
                }
                ans=Math.min(ans,d);
            }
            return ans;
        }
    }

