// https://leetcode.com/problems/binary-tree-level-order-traversal/description/

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (q.size() > 0) {
            int n = q.size();
            List<Integer> level = new ArrayList<>();
            // Process all node at current level
            for (int i = 0; i < n; i++) {
                TreeNode curr = q.poll();

                level.add(curr.val);

                // Add subtree nodes in queue for next level
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            result.add(level);
        }

        return result;
    }
}