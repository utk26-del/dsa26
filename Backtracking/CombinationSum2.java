// https://leetcode.com/problems/combination-sum-ii/description/

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        //Sort the array to group all duplicate elements together
        Arrays.sort(candidates);
        helper(candidates, target, new ArrayList<>(), result, 0);
        return result;
    }

    private void helper(int[] nums, int target, List<Integer> curr, List<List<Integer>> result, int idx) {
        if (target < 0)
            return;
        if (target == 0) {
            List<Integer> list = new ArrayList<>(curr);
            result.add(list);
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            curr.add(nums[i]);
            helper(nums, target - nums[i], curr, result, i + 1);
            curr.remove(curr.size() - 1);
            // Skip duplicates at the same decision level
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
    }
}