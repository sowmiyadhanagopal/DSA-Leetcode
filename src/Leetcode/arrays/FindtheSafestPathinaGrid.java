package Leetcode.arrays;
import java.util.*;
public class FindtheSafestPathinaGrid {
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        public int maximumSafenessFactor(List<List<Integer>> grid) {

            int n = grid.size();

            int[][] dist = new int[n][n];

            Queue<int[]> q = new LinkedList<>();

            // initialize distances
            for(int i=0;i<n;i++){
                Arrays.fill(dist[i],-1);
            }

            // Put all thieves into queue
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){

                    if(grid.get(i).get(j)==1){

                        q.offer(new int[]{i,j});

                        dist[i][j]=0;
                    }
                }
            }

            // Multi Source BFS
            while(!q.isEmpty()){

                int[] cur=q.poll();

                int r=cur[0];
                int c=cur[1];

                for(int[] d:dir){

                    int nr=r+d[0];
                    int nc=c+d[1];

                    if(nr<0||nc<0||nr>=n||nc>=n)
                        continue;

                    if(dist[nr][nc]!=-1)
                        continue;

                    dist[nr][nc]=dist[r][c]+1;

                    q.offer(new int[]{nr,nc});
                }
            }

            // Max Heap
            PriorityQueue<int[]> pq=new PriorityQueue<>(
                    (a,b)->b[2]-a[2]
            );

            boolean[][] vis=new boolean[n][n];

            pq.offer(new int[]{0,0,dist[0][0]});

            while(!pq.isEmpty()){

                int[] cur=pq.poll();

                int r=cur[0];
                int c=cur[1];
                int safe=cur[2];

                if(vis[r][c])
                    continue;

                vis[r][c]=true;

                if(r==n-1 && c==n-1)
                    return safe;

                for(int[] d:dir){

                    int nr=r+d[0];
                    int nc=c+d[1];

                    if(nr<0||nc<0||nr>=n||nc>=n)
                        continue;

                    if(vis[nr][nc])
                        continue;

                    int newSafe=Math.min(safe,dist[nr][nc]);

                    pq.offer(new int[]{nr,nc,newSafe});
                }
            }

            return 0;
        }
    }
