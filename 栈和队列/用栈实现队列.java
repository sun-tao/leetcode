class MyQueue {
    Stack<Integer> stack_in;
    Stack<Integer> stack_out;
    
    public MyQueue() {
        stack_in = new Stack<>();
        stack_out = new Stack<>();
    }
    
    public void push(int x) {
        // 向输入栈中存数据
        stack_in.push(x);
        return;
    }
    
    public int pop() {
        int result;
        if (!stack_out.empty()){
            result = stack_out.peek();
            stack_out.pop();
            return result;
        }
        while(!stack_in.empty()){
            int temp = stack_in.peek();
            stack_in.pop();
            stack_out.push(temp);
        }
        result = stack_out.peek();
        stack_out.pop();
        return result;
    }
    
    public int peek() {
        int temp = pop();
        stack_out.push(temp);
        return temp;
    }   
    
    public boolean empty() {
        if (stack_in.empty() && stack_out.empty()){
            return true;
        }
        return false;
    }
}