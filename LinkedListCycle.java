//https://leetcode.com/problems/linked-list-cycle/

class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            //if slow and fast meet at some point then list has cycle
            if (slow == fast)
                return true;
        }

        return false;
    }
}