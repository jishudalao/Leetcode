package leetcode1111;

import java.util.Stack;

public class MaxDepthAfterSplit {
	public int[] maxDepthAfterSplit(String seq) {
		/*
	    if (seq == null || seq.equals("")) return new int[0];
	    Stack<Character> stack = new Stack<>();
	    int[] res = new int[seq.length()];
	    //����
	    for (int i = 0; i < seq.length(); i++) {
	        char c = seq.charAt(i);
	        if (c == '(') {//��ջ,��¼���Ŷ��������,������0��ǣ�ż����1��ǡ�
	            res[i] = stack.size() % 2;
	            stack.push(c);
	        } else {//��ջ,��¼���Ŷ��������,������0��ǣ�ż����1��ǡ�
	            stack.pop();
	            res[i] = stack.size() % 2;
	        }
	    }
	    return res;*/
		if (seq == null || seq.equals("")) return new int[0];
	    int depth=0;
	    int[] res = new int[seq.length()];
	    //����
	    for (int i = 0; i < seq.length(); i++) {
	        char c = seq.charAt(i);
	        if (c == '(') {//��ջ,ջ���������
	            res[i] = depth++ % 2;
	        } else {//��ջ��ջ����ȼ���
	            res[i] = --depth % 2;
	        }
	    }
	    return res;
	}
}
