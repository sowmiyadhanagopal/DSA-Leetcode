package Leetcode.arrays;

public class CountSubarraysWithMajorityElementI {

        public int countMajoritySubarrays(int[] nums, int target) {
            int n = nums.length;
            int[] prefix = new int[n + 1];

            for (int i = 0; i < n; i++) {
                prefix[i + 1] = prefix[i];
                if (nums[i] == target) {
                    prefix[i + 1]++;
                }
            }

            int ans = 0;

            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    int count = prefix[j + 1] - prefix[i];
                    int length = j - i + 1;

                    if (count > length / 2) {
                        ans++;
                    }
                }
            }

            return ans;
        }
    }
