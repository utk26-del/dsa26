// https://leetcode.com/problems/diameter-of-binary-tree/description/

class Solution {
    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return maxDiameter;
    }

    private int helper(TreeNode node) {
        if (node == null)
            return 0;

        int left = helper(node.left);
        int right = helper(node.right);
        
        // Diameter through this node = left height + right height
        maxDiameter = Math.max(maxDiameter, left + right);

        return 1 + Math.max(left, right);
    }
}