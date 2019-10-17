package leetcode32;

import java.util.Stack;

public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
        int maxLen = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i=0;i<s.length();i++) {
        	if(s.charAt(i)=='(') {
        		stack.push(i);
        	}else {
        		stack.pop();
        		if(stack.empty()) {
        			stack.push(i);
        		}else {
        			maxLen = Math.max(maxLen, i-stack.peek());
        		}
        	}
        	
        }
        return maxLen;
    }
}
