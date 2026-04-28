class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Dummy node to handles edge case of removing the head
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy;
        ListNode fast = dummy;

        // Advance fast by n + 1 steps to create the gap and slow remains exactly before the one we want to remove
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both pointers until fast reaches the end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // slow is now the node before the target, skip the target
        slow.next = slow.next.next;

        return dummy.next;
    }
}
