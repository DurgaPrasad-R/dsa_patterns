class MinStack {
    Stack<Integer> stack;
    PriorityQueue<Integer> minStack;

    public MinStack() {
        minStack = new PriorityQueue<>();
        stack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        minStack.offer(val);
    }
    
    public void pop() {
        int val = stack.pop();
        minStack.remove(val);
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */