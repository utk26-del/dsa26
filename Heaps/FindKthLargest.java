// https://leetcode.com/problems/kth-largest-element-in-an-array/description/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        // Taking minHeap to get result on top
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add only the k largest elements
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }

        for (int i = k; i < n; i++) {
            // If heap exceeds size k, remove the smallest
            if (nums[i] > pq.peek()) {
                pq.poll();
                pq.add(nums[i]);
            }
        }

        // The root is the kth largest element
        return pq.peek();
    }
}