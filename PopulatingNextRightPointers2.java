// https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/description/

class Solution {
    public Node connect(Node root) {
        if (root == null)
            return root;

        Node current = root;

        while (current != null) {
            // Dummy node acts as the head of the next level's linked list
            Node dummy = new Node(0);
            Node tail = dummy;

            // Move across the current level using next pointers
            while (current != null) {
                if (current.left != null) {
                    tail.next = current.left;
                    tail = tail.next;
                }
                if (current.right != null) {
                    tail.next = current.right;
                    tail = tail.next;
                }

                current = current.next;
            }

            // Move down to the next level
            current = dummy.next;
        }

        return root;
    }
}