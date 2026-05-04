// https://leetcode.com/problems/combination-sum/description/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, target, new ArrayList<>(), result, 0);
        return result;
    }

    private void helper(int[] nums, int target, List<Integer> curr, List<List<Integer>> result, int idx) {
        // Add to result if target becomes 0
        if (target == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }
        // If target becomes less than 0 then No further combination possible
        if (target < 0)
            return;

        for (int i = idx; i < nums.length; i++) {
            curr.add(nums[i]);
            // Pass i (not i+1) because we can reuse the same element
            helper(nums, target - nums[i], curr, result, i);
            curr.remove(curr.size() - 1);

        }
    }
}