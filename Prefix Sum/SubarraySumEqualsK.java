// https://leetcode.com/problems/subarray-sum-equals-k/description/

class Solution {
    public int subarraySum(int[] nums, int k) {
        int curr = 0;
        // Map from prefix sum value to how many times we've seen it
        Map<Integer, Integer> hm = new HashMap<>();
        int ans = 0;
        hm.put(0, 1); // Empty prefix (sum = 0) seen once
        for (int num : nums) {
            curr += num;
            int pre = curr - k;
            if (hm.containsKey(pre)) {
                // How many earlier prefix sums form a valid subarray ending here?
                ans += hm.get(pre);
            }
            hm.put(curr, hm.getOrDefault(curr, 0) + 1);

        }
        return ans;

    }
}