// https://leetcode.com/problems/count-complete-tree-nodes/description/

class Solution {
    public int countNodes(TreeNode root) {
        return helper(root);
    }

    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return 1 + helper(node.left) + helper(node.right);
    }
}