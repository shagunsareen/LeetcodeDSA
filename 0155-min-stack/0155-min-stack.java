class MinStack {

    // ******** Approach 1 - One Stack ******** //
    /*private Stack<int[]> stack; 

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(new int[]{val, val}); //curr ele is the new minimum
            return;
        }

        int currMin = stack.peek()[1];
        int newMin = Math.min(currMin, val);

        stack.push(new int[]{val, newMin});
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];
    }*/

    // ******** Approach 2 - Two stacks ******** //
    /*private Stack<Integer> stack; 
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);

        if(minStack.isEmpty() || val <= minStack.peek()){
            minStack.push(val); //update minstack is this is the smallest value 
        }
    }
    
    public void pop() {
        //if top of stack is top of minstack pop that as well
        if(stack.peek().equals(minStack.peek())){
            minStack.pop();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }*/

    //Approach 3 - Optimised space solution 
    private Stack<Integer> stack; 
    private Stack<int[]> minStack; //number and freq of the number 

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);

        if(minStack.isEmpty() || val < minStack.peek()[0]){
            minStack.push(new int[]{val, 1}); //update minstack is this is the smallest value 
        }else if(val == minStack.peek()[0]){
            minStack.peek()[1]++;
        }
    }
    
    public void pop() {
        //if top of stack is top of minstack pop that as well
        if(stack.peek().equals(minStack.peek()[0])){
            minStack.peek()[1]--;
        }

        if(minStack.peek()[1] == 0){
            minStack.pop();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek()[0];
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