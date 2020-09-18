package leetcode1552;

import java.util.Stack;

public class CQueue {
	Stack<Integer> stack1;
    Stack<Integer> stack2;
    int size;
    //��������͸��������ӵ�ˮһ��,ֻ������
    public CQueue() {
        stack1 = new  Stack<>();
        stack2 = new Stack<>();
        size = 0;
    }
    
    public void appendTail(int value) {
    	size++;
    	while(!stack1.isEmpty()) {
    		stack2.push(stack1.pop());
    	}
    	stack1.push(value);
    	while(!stack2.isEmpty()) {
    		stack1.push(stack2.pop());
    	}
    }
    //ɾ��������Ӧpop
    public int deleteHead() {
    	if (size == 0) {
            return -1;
        }
    	size--;
    	return stack1.pop();
    }
}
