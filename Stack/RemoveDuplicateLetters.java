// https://leetcode.com/problems/remove-duplicate-letters/description/

class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (stack.contains(c))
                continue;

            // Pop characters that are larger and will appear later
            while (stack.size() > 0 && stack.peek() > c && lastIndex[stack.peek() - 'a'] > i) {
                stack.pop();
            }

            stack.push(c);
        }

        StringBuilder sb = new StringBuilder();

        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }
}