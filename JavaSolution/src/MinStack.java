import java.util.Stack;

public class MinStack {
    Stack<Integer> valueStack;
    Stack<Integer> minStack;
    public MinStack() {
        valueStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        valueStack.push(val);
        if (minStack.empty() || minStack.peek() >= val) {
            minStack.push(val);
        }
    }

    public void pop() {
        int deletedValue = valueStack.pop();
        if (minStack.peek() == deletedValue) {
            minStack.pop();
        }
    }

    public int top() {
        return valueStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.getMin(); // return -3
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
