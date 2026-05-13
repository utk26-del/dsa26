// https://leetcode.com/problems/maximum-width-of-binary-tree/description/

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int result = 0;
        Queue<TreeNode> nodeq = new LinkedList<>();
        Queue<Long> indexq = new LinkedList<>();
        nodeq.offer(root);
        indexq.offer(0L);

        while (!nodeq.isEmpty()) {
            int n = nodeq.size();
            long s = indexq.peek();
            long e = s;

            for (int i = 0; i < n; i++) {
                TreeNode temp = nodeq.poll();
                long idx = indexq.poll();
                e = idx;

                // Normalize index to prevent overflow
                long normalizedIdx = idx - s;

                if (temp.left != null) {
                    nodeq.offer(temp.left);
                    indexq.offer(2 * normalizedIdx);
                }
                if (temp.right != null) {
                    nodeq.offer(temp.right);
                    indexq.offer(2 * normalizedIdx + 1);
                }
            }

            result = Math.max(result, (int) (e - s + 1));
        }

        return result;
    }
}