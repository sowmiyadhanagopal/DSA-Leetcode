package Leetcode.arrays;
import java.util.*;
public class Shift2DGrid {
    class Solution {
        public List<List<Integer>> shiftGrid(int[][] grid, int k) {
            int rows=grid.length;
            int cols=grid[0].length;
            int total=rows*cols;
            k=k%total;
            List<List<Integer>>ans=new ArrayList<>();
            for(int i=0;i<rows;i++)
            {
                List<Integer>row=new ArrayList<>();
                for(int j=0;j<cols;j++)
                {
                    row.add(0);
                }
                ans.add(row);
            }
            for(int i=0;i<rows;i++)
            {
                for(int j=0;j<cols;j++)
                {
                    int index=i*cols+j;
                    int newindex=(index+k)%total;
                    int newrow=newindex/cols;
                    int newcol=newindex%cols;
                    ans.get(newrow).set(newcol,grid[i][j]);
                }
            }
            return ans;
        }
    }
}
