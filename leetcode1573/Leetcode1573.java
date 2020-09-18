package leetcode1573;

import java.util.Deque;
import java.util.LinkedList;
public class Leetcode1573 {
	//��������Ƕ��������������Բ���Ҫ�õ����ṹ
	//������ǰ����ѧ�˵���ջ
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