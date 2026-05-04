// https://leetcode.com/problems/single-number-ii/description/

class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;

        for(int i=0; i<nums.length; i++){
            ones = (ones ^ nums[i]) & (~twos);
            twos = (twos ^ nums[i]) & (~ones);
        }

        // After all elements, ones holds bits that appeared once
        return ones;
    }
}
/*
    1. Number will be in ones if it is not in twos
    2. Number will be in twos if it is present in ones
*/