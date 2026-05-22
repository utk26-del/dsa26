// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/

class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (stack.size() != 0 && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }
}