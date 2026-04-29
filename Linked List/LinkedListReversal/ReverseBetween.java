// https://leetcode.com/problems/reverse-linked-list-ii/description/

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;

        // Move prev to the node just before position left
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        ListNode curr = prev.next; // First node in the reversal range

        // Reverse by moving each next node to the front of the reversed section
        for (int i = 0; i < right - left; i++) {
            ListNode nextNode = curr.next;
            curr.next = nextNode.next;
            nextNode.next = prev.next;
            prev.next = nextNode;
        }

        return dummy.next;
    }

}