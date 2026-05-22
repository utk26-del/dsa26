// https://leetcode.com/problems/contiguous-array/description/

class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;

        if (n <= 1) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0;
        int len = 0;

        for (int i = 0; i < n; i++) {
            // Treat 0 as -1: equal 0s and 1s means sum = 0
            if (nums[i] == 0) {
                sum = sum - 1;
            } else {
                sum = sum + nums[i];
            }

            if (map.containsKey(sum)) {
                len = Math.max(len, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        return len;
    }
}