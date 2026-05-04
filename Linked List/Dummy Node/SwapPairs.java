// https://leetcode.com/problems/swap-nodes-in-pairs/description/

class Solution {
    public ListNode swapPairs(ListNode head) {
	// Dummy node simplifies head pointer management
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode cur = head;

        while(cur!=null && cur.next!=null){
            ListNode first = cur;
            ListNode second = cur.next;

	    // Rewire the three pointers for swapping them
            prev.next = second;
            first.next = second.next;
            second.next = first;

            prev = first;
            cur = cur.next;
        }

        return dummy.next;
    }
}