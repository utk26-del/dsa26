// https://leetcode.com/problems/generate-parentheses/description/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        helper(n, list, new StringBuilder(), 0, 0);
        return list;
    }

    private void helper(int n, List<String> list, StringBuilder sb, int left, int right) {
        // Base case: string is complete
        if (sb.length() == 2 * n) {
            list.add(sb.toString());
            return;
        }
        // Place '(' if we haven't used all n opening brackets
        if (left < n) {
            helper(n, list, sb.append('('), left + 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }
        // Place ')' only if it won't create an invalid prefix
        if (right < left) {
            helper(n, list, sb.append(')'), left, right + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}