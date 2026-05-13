// https://leetcode.com/problems/maximum-units-on-a-truck/description/

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int n = boxTypes.length;
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

        int boxes = 0;
        int result = 0;
        int i = 0;

        while (boxes < truckSize && i < n) {
            int box = 0;
            if (boxes + boxTypes[i][0] <= truckSize) {
                box = boxTypes[i][0];
            } else {
                box = truckSize - boxes;
            }
            result = result + (box * boxTypes[i][1]);
            boxes = boxes + box;
            i++;
        }

        return result;
    }
}