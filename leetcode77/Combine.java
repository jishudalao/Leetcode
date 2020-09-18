package leetcode77;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Combine {
	private  List<List<Integer>> res = new ArrayList<>();
	public  List<List<Integer>> combine(int n, int k) {
		if(n<=0||k<=0||n<k) {
			return res;
		}
		backtrack(n, k, 1,  new Stack<>());
		return res;
    }
	
	private  void backtrack(int n, int k, int now, Stack<Integer> stack) {
		// TODO Auto-generated method stub
		if(stack.size()==k) {
			res.add(new ArrayList<>(stack));
			return;
		}
		for(int i=now;i<=n - (k - stack.size()) + 1;i++) {
			stack.add(i);
			backtrack(n, k, i+1, stack);
			stack.pop();
		}
	}

	public static void main(String[] args) {
	}
}
