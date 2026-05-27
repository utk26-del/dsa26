// https://leetcode.com/problems/distribute-candies/description/

class Solution {
    public int distributeCandies(int[] candyType) {
        int n = candyType.length;
        Set<Integer> set = new HashSet<>();

        for (int candy : candyType) {
            set.add(candy);
        }

        int types = set.size();

        if (types <= n / 2) {
            return types;
        }

        else {
            return n / 2;
        }
    }
}