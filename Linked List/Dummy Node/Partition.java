// https://leetcode.com/problems/partition-list/description/

class Solution {
    public ListNode partition(ListNode head, int x) {
        // Two Dummy Nodes for having less and greater chains and their respective tails
        ListNode dummy = new ListNode(0);
        ListNode lesstail = dummy;
        ListNode dummy1 = new ListNode(0);
        ListNode greatertail = dummy1;
        ListNode cur = head;

        // Distribute nodes into the two chains
        while (cur != null) {
            if (cur.val < x) {
                lesstail.next = cur;
                lesstail = lesstail.next;
            } else {
                greatertail.next = cur;
                greatertail = greatertail.next;
            }

            cur = cur.next;
        }

        //Connect the less chain to greater chain
        lesstail.next = dummy1.next;
        // Terminate the greater chain to prevent cycle
        greatertail.next = null;

        return dummy.next;
    }
}