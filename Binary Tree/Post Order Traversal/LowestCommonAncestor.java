// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: reached null, or found one of the target nodes
        if (root == null || root == p || root == q) {
            return root;
        }

        // Recursively search both subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both subtrees found a target, current node is the LCA
        if (left != null && right != null) {
            return root;
        }

        // Otherwise, return whichever subtree found something
        return left != null ? left : right;
    }
}