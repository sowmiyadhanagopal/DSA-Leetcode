package Leetcode.arrays;
import java.util.*;
public class PartitionArrayAccordingtoGivenPivot {

        public int[] pivotArray(int[] nums, int pivot) {
            int k=nums.length;
            List<Integer>less=new ArrayList<>();
            List<Integer>equal=new ArrayList<>();
            List<Integer>greater=new ArrayList<>();
            for(int n:nums)
            {
                if(pivot>n)
                {
                    less.add(n);
                }
                else if(pivot<n)
                {
                    greater.add(n);
                }
                else
                {
                    equal.add(n);
                }

            }
            int ans[]=new int[k];
            less.addAll(equal);
            less.addAll(greater);
            for(int i=0;i<less.size();i++)
            {
                ans[i]=less.get(i);
            }
            return ans;
        }
    }

