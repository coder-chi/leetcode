package item.s155;

import java.util.Stack;

/**
 * created by zhangzhiyuan in 2020/1/21
 */
public class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;


    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            Integer min = minStack.peek();
            if (x < min) {
                minStack.push(x);
            } else {
                minStack.push(min);
            }
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
