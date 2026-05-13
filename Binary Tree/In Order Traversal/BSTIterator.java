// https://leetcode.com/problems/binary-search-tree-iterator/description/

class BSTIterator {

    List<Integer> list;
    int index;

    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        inorder(root);
        index = 0;
    }

    public int next() {
        return list.get(index++);
    }

    public boolean hasNext() {
        return index < list.size();
    }

    private void inorder(TreeNode node) {
        if (node == null)
            return;

        inorder(node.left);

        list.add(node.val);

        inorder(node.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */