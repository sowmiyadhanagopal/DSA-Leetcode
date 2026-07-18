package Leetcode.arrays;

public class FindGreatestCommonDivisorofArray {
    class Solution {
        public int findGCD(int[] nums) {
            int n=nums.length;
            int max=Integer.MIN_VALUE;
            int min=Integer.MAX_VALUE;
            for(int i=0;i<n;i++)
            {
                if(nums[i]>max)
                {
                    max=nums[i];
                }
                if(nums[i]<min)
                {
                    min=nums[i];
                }
            }
            int a=max;
            int b=min;
            while(b!=0)
            {
                int rem=b;
                b=a%b;
                a=rem;
            }
            return a;

        }
    }
}
