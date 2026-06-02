package Leetcode.arrays;

public class EarliestFinishTimeforLandandWaterRidesI {

        public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
            int ans=Integer.MAX_VALUE;
            for(int i=0;i<landStartTime.length;i++)
            {
                for(int j=0;j<waterStartTime.length;j++)
                {
                    int landFinish=landStartTime[i]+landDuration[i];
                    int waterFinish=Math.max(landFinish,waterStartTime[j])+waterDuration[j];
                    ans=Math.min(ans,waterFinish);
                    int firstWaterFinish = waterStartTime[j] + waterDuration[j];
                    int finalLandFinish = Math.max(firstWaterFinish, landStartTime[i])+landDuration[i];
                    ans = Math.min(ans, finalLandFinish);
                }
            }
            return ans;
        }
    }

