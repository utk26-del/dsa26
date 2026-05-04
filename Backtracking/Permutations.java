// https://leetcode.com/problems/permutations/description/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, new ArrayList<>(), result);
        return result;
    }

    private void helper(int[] nums, List<Integer> curr, List<List<Integer>> result) {
        if (curr.size() == nums.length)
            result.add(new ArrayList(curr));

        for (int num : nums) {
            if (curr.contains(num))
                continue;

            curr.add(num);
            helper(nums, curr, result);
            curr.remove(curr.size() - 1);
        }
    }
}