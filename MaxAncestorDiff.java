// https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/description/

class Solution {
    public int maxAncestorDiff(TreeNode root) {
        return helper(root, root.val, root.val);
    }

    private int helper(TreeNode node, int currMin, int currMax) {
        if (node == null) {
            return currMax - currMin;
        }

        currMin = Math.min(currMin, node.val);
        currMax = Math.max(currMax, node.val);

        int left = helper(node.left, currMin, currMax);
        int right = helper(node.right, currMin, currMax);

        return Math.max(left, right);
    }
}