// https://leetcode.com/problems/rotate-list/description/

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int n = 1;
        ListNode tail = head;

        //find length of list and its tail
        while (tail.next != null) {
            n++;
            tail = tail.next;
        }

        k = k % n; //effective rotation
        if (k == 0)
            return head;

        tail.next = head;

        ListNode newTail = head;

        // Walk to the new tail: (n - k - 1) steps from head
        for (int i = 0; i < n - k - 1; i++) {
            newTail = newTail.next;
        }

        //Assign newHead and break the circle
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}