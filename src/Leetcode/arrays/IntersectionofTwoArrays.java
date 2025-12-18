package Leetcode.arrays;

public class IntersectionofTwoArrays {

        public int[] intersect(int[] nums1, int[] nums2) {


            int[] count = new int[1001];
            int[] temp = new int[Math.min(nums1.length, nums2.length)];
            int k = 0;

            for (int n : nums1) {
                count[n]++;
            }

            for (int n : nums2) {
                if (count[n] > 0) {
                    temp[k++] = n;
                    count[n]--;
                }
            }

            int[] result = new int[k];
            for (int i = 0; i < k; i++) {
                result[i] = temp[i];
            }

            return result;
        }

    }


