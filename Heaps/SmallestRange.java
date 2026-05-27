// https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/description/

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        // Min-heap: [value, listIndex, elementIndex]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int maxElement = Integer.MIN_VALUE;

        // Initialize heap with first element from each list
        for (int i = 0; i < k; i++) {
            int num = nums.get(i).get(0);
            pq.add(new int[] { num, i, 0 });
            maxElement = Math.max(maxElement, num);
        }

        int[] result = new int[2];
        result[0] = pq.peek()[0];
        result[1] = maxElement;

        while (true) {
            int min[] = pq.poll();
            int value = min[0];
            int listIdx = min[1];
            int eleIdx = min[2];

            //check if new range is better
            if (maxElement - value < result[1] - result[0]
                    || (maxElement - value == result[1] - result[0] && value < result[0])) {
                result[0] = value;
                result[1] = maxElement;
            }
            // If exceeds list size the break the loop
            if (eleIdx + 1 >= nums.get(listIdx).size()) {
                break;
            }

            // Push next element from the same list in min-heap and calculate maxElement
            int nextVal = nums.get(listIdx).get(eleIdx + 1);
            pq.add(new int[] { nextVal, listIdx, eleIdx + 1 });
            maxElement = Math.max(maxElement, nextVal);
        }

        return result;
    }
}