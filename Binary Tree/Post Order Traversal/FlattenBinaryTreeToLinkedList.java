// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/

class Solution {
    TreeNode last = null;

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        // Process right subtree first, then left, then current node
        flatten(root.right);
        flatten(root.left);

        // Connect current node to the last processed node
        root.left = null;
        root.right = last;
        last = root;
    }
}