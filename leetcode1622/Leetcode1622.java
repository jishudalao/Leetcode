package leetcode1622;

import java.util.Arrays;
import java.util.Stack;

public class Leetcode1622 {
	public static int[] constructArr(int[] a) {
		//可以用两个栈解决
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		int res[] = new int[a.length];
		int count1 = 1;
		int count2 = 1;
		int len = a.length;
		stack2.push(1);
		for(int i=len-1;i>0;i--) {
			count2 *= a[i];
			stack2.push(count2);
		}
		stack1.push(1);
		for(int i=0;i<res.length;i++) {
			res[i] = stack2.pop() * stack1.pop();
			count1 *= a[i];
			stack1.push(count1);
		}
		return res;
    }
	public static void main(String[] args) {
		int a[] = {1,2,3,4,5};
		System.out.println(Arrays.toString(constructArr(a)));
	}
}
