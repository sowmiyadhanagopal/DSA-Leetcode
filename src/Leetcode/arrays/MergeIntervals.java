package Leetcode.arrays;
import java.util.*;
public class MergeIntervals {

        public int[][] merge(int[][] intervals) {
            if(intervals==null||intervals.length==0)
            {
                return new int[0][0];
            }
            Arrays.sort(intervals,(a,b)->a[0]-b[0]);
            List<int[]>result=new ArrayList<>();
            int[] prev=intervals[0];
            for(int i=1;i<intervals.length;i++)
            {
                int[] cur=intervals[i];
                if(cur[0]<=prev[1])
                {
                    prev[1]=Math.max(cur[1],prev[1]);
                }
                else
                {
                    result.add(prev);
                    prev=cur;
                }
            }
            result.add(prev);
            return result.toArray(new int[result.size()][]);
        }
    }

