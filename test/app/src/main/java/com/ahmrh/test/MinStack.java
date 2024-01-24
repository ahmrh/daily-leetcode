

import java.util.Stack;

class MinStack {
    private class Node{
        int val, min;

        Node(int x, int min) {
            this.val = x;
            this.min = min;
        }
    }

    Stack<Node> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {


        if (stack.empty()) {
            stack.push(new Node(val, val));
        } else {
            int minValue = Math.min(stack.peek().min, val);
            stack.push(new Node(val, minValue));
        }
    }


    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().min;
    }
}


