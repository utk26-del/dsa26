// https://leetcode.com/problems/longest-valid-parentheses/description/

class Solution {
    public int longestValidParentheses(String s) {
        int result = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(-1); //Base boundary for 1st valid substring

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }

            else {
                stack.pop();
                if (stack.isEmpty()) {
                    //New boundary becomes unmatched ')'
                    stack.push(i);
                } else {
                    result = Math.max(result, i - stack.peek());
                }
            }
        }

        return result;

    }
}