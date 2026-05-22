//	https://leetcode.com/problems/subarray-sums-divisible-by-k/description/

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        // Map to count occurrences of each remainder
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // empty prefix has remainder 0

        for (int num : nums) {
            sum += num;
            // Normalize remainder to handle negative prefix sums
            int rem = ((sum % k) + k) % k;

            if (map.containsKey(rem)) {
                // Each previous prefix sum with the same remainder forms a valid subarray
                count += map.get(rem);
            }

            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        return count;
    }
}