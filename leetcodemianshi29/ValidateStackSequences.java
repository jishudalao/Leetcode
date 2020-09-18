package leetcodemianshi29;

import java.util.Stack;

public class ValidateStackSequences {
	//ÊéÉÏÀıÌâ
	public static boolean validateStackSequences(int[] pushed, int[] popped) {
		Stack<Integer> stack = new Stack<>();
		int index = 0;
		for(int i=0;i<pushed.length;i++) {
			stack.push(pushed[i]);
			while(!stack.isEmpty()&&(stack.peek()==popped[index])) {
				stack.pop();
				index++;
			}
		}
		return stack.isEmpty();
    }
	public static void main(String[] args) {
		int[] pushed = {1,2,3,4,5}; 
		int[] popped = {4,5,3,2,1};
		System.out.println(validateStackSequences(pushed, popped));
	}
}
