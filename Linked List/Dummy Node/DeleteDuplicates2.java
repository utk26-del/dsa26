//https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;

        ListNode current = head;
        while (current != null) {
            // Check if current starts a duplicate run
            if (current.next != null && current.val == current.next.val) {
                // Skip all duplicate nodes with this value
                while (current.next != null && current.val == current.next.val) {
                    current = current.next;
                }
                // Point prev to the node after the duplicate run to skip first duplicate Node
                prev.next = current.next;
            } else {
                // Current is unique, advance prev
                prev = prev.next;
            }
            current = current.next;
        }

        return dummy.next;
    }
}