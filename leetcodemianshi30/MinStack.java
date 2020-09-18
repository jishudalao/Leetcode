package leetcodemianshi30;

import java.util.Stack;
//这题想想其实是如何保存次小值的问题
public class MinStack {
	Stack<Integer> stack;
	int size;
	int min = Integer.MAX_VALUE;
	public MinStack() {
		stack = new Stack<>();
		size = 0;
    }
    
    public void push(int x) {
    	if(x <= min){
            stack.push(min);
            min = x;
        }
    	stack.push(x);
    	min = Math.min(min, x);
    	size++;
    }
    
    public void pop() {
    	if(stack.pop() == min){
            min = stack.pop();
        }
    	size--;
    }
    
    public int top() {
    	return stack.peek();
    }
    
    public int min() {
    	return min;
    }
}
