// https://leetcode.com/problems/reverse-nodes-in-k-group/

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode leftPrev = dummy;

        while (true) {
            // Check if k nodes present
            ListNode kNode = getKNode(leftPrev, k);
            if (kNode == null) {
                break;
            }

            // Reverse k nodes starting from leftPrev.next
            ListNode rightNext = kNode.next;
            ListNode cur = leftPrev.next;
            ListNode prev = rightNext; // will become the "next" for the last reversed node

            for (int i = 0; i < k; i++) {
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }

            ListNode groupHead = leftPrev.next;// old first node is now tail
            leftPrev.next = kNode; // KNode is new head for reversed group
            leftPrev = groupHead; // reassign leftPrev to tail of reversed group

        }

        return dummy.next;
    }

    private ListNode getKNode(ListNode head, int k) {
        while (head != null && k > 0) {
            head = head.next;
            k--;
        }

        return head;
    }
}
