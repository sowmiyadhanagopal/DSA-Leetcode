package Leetcode.arrays;

public class JumpGameIII {
        public boolean canReach(int[] arr, int start) {
            boolean[] visited = new boolean[arr.length];
            return dfs(arr, start, visited);
        }
        public boolean dfs(int[] arr, int i, boolean[] visited) {
            if (i < 0 || i >= arr.length) {
                return false;
            }
            if (visited[i]) {
                return false;
            }
            if (arr[i] == 0) {
                return true;
            }
            visited[i] = true;
            int left = i - arr[i];
            int right = i + arr[i];
            return dfs(arr, left, visited) ||
                    dfs(arr, right, visited);
        }
    }

