// https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/description/

class Solution {
    public Node flatten(Node head) {

        Node cur = head;

        while (cur != null) {

            if (cur.child != null) {
                Node next = cur.next; //save the current's next node
                // Find the tail of the child chain
                Node tail = cur.child;
                while (tail.next != null) {
                    tail = tail.next;
                }

                // Connect current child to current next
                cur.next = cur.child;
                cur.child.prev = cur;

                tail.next = next;
                if (next != null) {
                    next.prev = tail;
                }

                cur.child = null; // clear child pointer
            }

            cur = cur.next;
        }

        return head;
    }
}