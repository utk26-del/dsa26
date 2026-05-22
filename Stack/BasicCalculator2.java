// https://leetcode.com/problems/basic-calculator-ii/description/

class Solution {
    public int calculate(String s) {
        char op = '+';
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        int i = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch))
                num = num * 10 + (ch - '0');

            if (!Character.isDigit(ch) && ch != ' ' || i == s.length() - 1) {
                switch (op) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                op = ch;
                num = 0;
            }
            i++;
        }

        int res = 0;
        while (!stack.isEmpty())
            res = res + stack.pop();

        return res;
    }
}