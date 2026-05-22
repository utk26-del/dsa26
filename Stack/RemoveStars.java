// https://leetcode.com/problems/removing-stars-from-a-string/description/

class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch != '*')
                stack.push(ch);
            else if (ch == '*' && !stack.isEmpty())
                stack.pop();
        }
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}