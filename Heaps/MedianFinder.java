// https://leetcode.com/problems/find-median-from-data-stream/description/

class MedianFinder {

    // Max-heap for the lower half
    private PriorityQueue<Integer> maxHeap;
    // Min-heap for the upper half
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        maxHeap.offer(num);
        // Ensure every element in maxHeap <= every element in minHeap
        minHeap.offer(maxHeap.poll());
        // Balance sizes: maxHeap can have at most 1 more than minHeap
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}
