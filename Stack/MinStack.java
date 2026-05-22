// https://leetcode.com/problems/min-stack/description/

class MinStack {

    int[] stack;
    int[] minStack;
    int top;

    public MinStack() {
        stack = new int[30000];
        minStack = new int[30000];
        top = -1;
    }

    public void push(int val) {
        top++;
        stack[top] = val;
        if (top > 0) {
            minStack[top] = Math.min(val, minStack[top - 1]);
        }
        else{
            minStack[top] = val;
        }
    }

    public void pop() {
        top--;
    }

    public int top() {
        return stack[top];
    }

    public int getMin() {

        return minStack[top];
    }
}