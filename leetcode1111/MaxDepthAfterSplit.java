package leetcode1111;

import java.util.Stack;

public class MaxDepthAfterSplit {
	public int[] maxDepthAfterSplit(String seq) {
		/*
	    if (seq == null || seq.equals("")) return new int[0];
	    Stack<Character> stack = new Stack<>();
	    int[] res = new int[seq.length()];
	    //遍历
	    for (int i = 0; i < seq.length(); i++) {
	        char c = seq.charAt(i);
	        if (c == '(') {//入栈,记录括号对所在深度,奇数用0标记，偶数用1标记。
	            res[i] = stack.size() % 2;
	            stack.push(c);
	        } else {//出栈,记录括号对所在深度,奇数用0标记，偶数用1标记。
	            stack.pop();
	            res[i] = stack.size() % 2;
	        }
	    }
	    return res;*/
		if (seq == null || seq.equals("")) return new int[0];
	    int depth=0;
	    int[] res = new int[seq.length()];
	    //遍历
	    for (int i = 0; i < seq.length(); i++) {
	        char c = seq.charAt(i);
	        if (c == '(') {//入栈,栈内深度增加
	            res[i] = depth++ % 2;
	        } else {//出栈，栈内深度减少
	            res[i] = --depth % 2;
	        }
	    }
	    return res;
	}
}
