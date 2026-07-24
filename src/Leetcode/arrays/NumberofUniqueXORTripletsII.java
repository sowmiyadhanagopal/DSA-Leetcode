package Leetcode.arrays;
import java.util.*;
public record NumberofUniqueXORTripletsII() {
    class Solution {
        public int uniqueXorTriplets(int[] nums) {
            int n=nums.length;
            if(n==1)
            {
                return 1;
            }
            Set<Integer>pairXor=new HashSet<>();
            for(int i=0;i<n;i++)
            {
                for(int j=i+1;j<n;j++)
                {
                    pairXor.add(nums[i]^nums[j]);
                }
            }
            BitSet tripleXor=new BitSet();
            for(int num:nums)
            {
                tripleXor.set(num);
            }
            for(int xor:pairXor)
            {
                for(int num:nums)
                {
                    tripleXor.set(xor^num);
                }
            }
            return tripleXor.cardinality();
        }
    }
}
