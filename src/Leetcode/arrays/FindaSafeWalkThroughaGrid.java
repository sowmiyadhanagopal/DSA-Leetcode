package Leetcode.arrays;
import java.util.*;
public class FindaSafeWalkThroughaGrid {


        public boolean findSafeWalk(List<List<Integer>> grid, int health) {

            int m = grid.size();
            int n = grid.get(0).size();

            int[][] best = new int[m][n];

            for (int i = 0; i < m; i++) {
                Arrays.fill(best[i], -1);
            }

            int startHealth = health - grid.get(0).get(0);

            if (startHealth <= 0) {
                return false;
            }

            Queue<int[]> queue = new LinkedList<>();

            queue.offer(new int[]{0, 0, startHealth});

            best[0][0] = startHealth;

            int[][] directions = {
                    {1, 0},
                    {-1, 0},
                    {0, 1},
                    {0, -1}
            };

            while (!queue.isEmpty()) {

                int[] current = queue.poll();

                int row = current[0];
                int col = current[1];
                int currentHealth = current[2];

                if (row == m - 1 && col == n - 1) {
                    return true;
                }

                for (int[] dir : directions) {

                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n) {
                        continue;
                    }

                    int newHealth = currentHealth - grid.get(newRow).get(newCol);

                    if (newHealth <= 0) {
                        continue;
                    }

                    if (newHealth > best[newRow][newCol]) {

                        best[newRow][newCol] = newHealth;

                        queue.offer(new int[]{newRow, newCol, newHealth});
                    }
                }
            }

            return false;
        }
    }
