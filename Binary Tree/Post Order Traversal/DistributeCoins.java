// https://leetcode.com/problems/distribute-coins-in-binary-tree/description/

class Solution {
    int moves = 0;

    public int distributeCoins(TreeNode root) {
        moves = 0;
        helper(root);

        return moves;
    }

    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = helper(node.left);
        int right = helper(node.right);

        // Moves on left and right edges
        moves = moves + Math.abs(left) + Math.abs(right);
        // This node's excess: its coins minus the 1 it needs, plus children's excess
        return (node.val - 1 + left + right);
    }
}