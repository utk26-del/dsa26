// https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/

class Solution {
    int minDiff = Integer.MAX_VALUE;
    Integer prev = null;

    public int minDiffInBST(TreeNode root) {
        inorder(root);
        return minDiff;
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }

        inorder(node.left);

        if (prev != null) {
            minDiff = Math.min(minDiff, node.val - prev);
        }

        prev = node.val;
        inorder(node.right);
    }
}