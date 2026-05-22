// https://leetcode.com/problems/continuous-subarray-sum/description/

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if (n <= 1) {
            return false;
        }
        // Map: remainder -> first index where this remainder was seen
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // Handle subarrays starting from index 0

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum = sum + nums[i];
            int rem = sum % k;

            if (map.containsKey(rem)) {
                // Same remainder seen before — check if subarray length >= 2
                if (i - map.get(rem) >= 2)
                    return true;
            } else {
                // Only store the first occurrence to maximize subarray length
                map.put(rem, i);
            }
        }

        return false;

    }
}