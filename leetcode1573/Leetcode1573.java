package leetcode1573;

import java.util.Deque;
import java.util.LinkedList;
public class Leetcode1573 {
	//看清楚了是二叉搜索树，所以不需要用到树结构
	//还好我前几天学了单调栈
	public boolean verifyPostorder(int[] postorder) {
		int pE = Integer.MAX_VALUE;
		Deque<Integer> stack = new LinkedList<>();
		for(int i=postorder.length-1;i>=0;i--) {
			if(pE<postorder[i]) {
				return false;
			}
			while(!stack.isEmpty()&&stack.peek()>postorder[i]) {
				pE = stack.pop();
			}
			stack.push(postorder[i]);
		}
		return true;
    } 
}