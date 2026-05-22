// https://leetcode.com/problems/evaluate-reverse-polish-notation/description/

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String token: tokens){
            if(token.equals("+")){
                int sum = stack.pop() + stack.pop();
                stack.push(sum);
            }
            else if(token.equals("-")){
                int second = stack.pop();
                int first = stack.pop();
                int diff = first - second;
                stack.push(diff);
            }
            else if(token.equals("*")){
                int prod = stack.pop() * stack.pop();
                stack.push(prod);
            }
            else if(token.equals("/")){
                int second = stack.pop();
                int first = stack.pop();
                int div = first / second;
                stack.push(div);
            }
            else{
                stack.push(Integer.valueOf(token));
            }
        }

        return stack.peek();
    }
}