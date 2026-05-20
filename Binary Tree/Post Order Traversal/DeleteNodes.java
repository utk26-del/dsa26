// https://leetcode.com/problems/delete-nodes-and-return-forest/description/

class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> deleteList = Arrays.stream(to_delete).boxed().collect(Collectors.toSet());
        List<TreeNode> result = new ArrayList<>();
        TreeNode node = helper(root, result, deleteList);
        
        //Handling if root itself needs to be deleted
        if (node != null) {
            result.add(node);
        }
        return result;
    }

    private TreeNode helper(TreeNode node, List<TreeNode> list, Set<Integer> deleteList) {
        if (node == null) {
            return node;
        }

        TreeNode left = helper(node.left, list, deleteList);
        TreeNode right = helper(node.right, list, deleteList);

        node.left = left;
        node.right = right;

        if (deleteList.contains(node.val)) {
            if (node.left != null) {
                list.add(node.left);
            }
            if (node.right != null) {
                list.add(node.right);
            }
            return null;
        }

        return node;
    }
}