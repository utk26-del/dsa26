// https://leetcode.com/problems/k-diff-pairs-in-an-array/description/

class Solution {
    public int findPairs(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int l = 0;
        int r = 1;
        int count = 0;

        while (r < n) {
            int diff = nums[r] - nums[l];

            if (diff < k || l >= r) {
                r++;
            } else if (diff > k) {
                l++;
            } else {
                count++;
                l++;
                r++;

                while (r < n && nums[r] == nums[r - 1]) {
                    r++;
                }
            }
        }

        return count;
    }
}