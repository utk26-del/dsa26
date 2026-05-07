// https://leetcode.com/problems/path-sum-iii/description/

class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);

        int count = helper(root, targetSum, 0, map);
        return count;
    }

    private int helper(TreeNode node, int target, long currentSum, Map<Long, Integer> map) {
        if (node == null) {
            return 0;
        }

        currentSum = currentSum + node.val;

        int count = map.getOrDefault(currentSum - target, 0);

        map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);

        count = count + helper(node.left, target, currentSum, map);
        count = count + helper(node.right, target, currentSum, map);

        map.put(currentSum, map.get(currentSum) - 1);

        return count;
    }
}