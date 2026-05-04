// https://leetcode.com/problems/container-with-most-water/description/

class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int l = 0;
        int r = n - 1;
        int maxwater = 0;
        while (l < r) {
            // Calculate Area = width * height of shorter line
            int ht = Math.min(height[l], height[r]);
            int w = r - l;

            int curWater = ht * w;
            maxwater = Math.max(curWater, maxwater);

            // Move the pointer at the shorter line as shorter line will be controlling line for container
            if (height[l] <= height[r])
                l++;
            else
                r--;
        }

        return maxwater;
    }
}