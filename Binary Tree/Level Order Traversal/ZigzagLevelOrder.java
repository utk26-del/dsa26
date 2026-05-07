// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> q = new ArrayDeque<>();
        boolean leftToRight = true;
        q.offerLast(root);

        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                TreeNode temp = q.pollFirst();

                // Add to end or insert at front based on direction
                if (leftToRight) {
                    list.addLast(temp.val);
                } else {
                    list.addFirst(temp.val);
                }

                // Enqueue children for the next level
                if (temp.left != null)
                        q.offerLast(temp.left);
                if (temp.right != null)
                        q.offerLast(temp.right);
            }
            result.add(list);
            leftToRight = !leftToRight;
        }

        return result;
    }
}