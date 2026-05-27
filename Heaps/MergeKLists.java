// https://leetcode.com/problems/merge-k-sorted-lists/description/

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Push the head of each non-empty list
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while (!pq.isEmpty()) {
            // Pop the smallest node
            ListNode smallest = pq.poll();
            current.next = smallest;
            current = current.next;

            // Push the next node from the same list
            if (smallest.next != null) {
                pq.add(smallest.next);
            }
        }

        return dummy.next;

    }
}