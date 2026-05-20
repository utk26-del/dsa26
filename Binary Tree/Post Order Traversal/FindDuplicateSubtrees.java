// https://leetcode.com/problems/find-duplicate-subtrees/description/

class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        helper(root, map, result);

        return result;

    }

    private String helper(TreeNode node, Map<String, Integer> map, List<TreeNode> list) {
        if (node == null)
            return "#";

        // Build postorder serialization: left, right, current
        String s = helper(node.left, map, list) + "," + helper(node.right, map, list) + "," + node.val;

        map.put(s, map.getOrDefault(s, 0) + 1);

        // Add to result only on the second occurrence
        if (map.getOrDefault(s, 0) == 2) {
            list.add(node);
        }

        return s;

    }
}