// https://leetcode.com/problems/k-closest-points-to-origin/description/

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        //Max heap for farthest element on top
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));

        for (int i = 0; i < n; i++) {
            int x = points[i][0];
            int y = points[i][1];

            pq.add(new int[] { x, y });

            // Remove farthest element from heap as size is more than k
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Build the result
        int[][] result = new int[k][2];

        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }

        return result;

    }
}