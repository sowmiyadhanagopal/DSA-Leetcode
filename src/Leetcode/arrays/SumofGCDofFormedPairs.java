package Leetcode.arrays;
import java.util.*;
public class SumofGCDofFormedPairs {
    class Solution {
        public long gcdSum(int[] nums) {
            int max=nums[0];
            int n=nums.length;
            int prefixgcd[]=new int[n];
            for(int i=0;i<n;i++)
            {
                max=Math.max(max,nums[i]);
                prefixgcd[i]=gcd(nums[i],max);
            }
            Arrays.sort(prefixgcd);
            int left=0;
            int right=n-1;
            long ans=0;
            while(left<right)
            {
                ans+=gcd(prefixgcd[left],prefixgcd[right]);
                left++;
                right--;
            }
            return ans;
        }
        public int gcd(int a,int b)
        {

            while(b!=0)
            {
                int rem=a%b;
                a=b;
                b=rem;
            }
            return a;

        }
    }
}
