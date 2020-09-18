package leetcode39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CombinationSum {
	private List<List<Integer>> res = new ArrayList<>();
	private int len;
	private int[] candidates;
	public List<List<Integer>> combinationSum(int[] candidates,int target) {
		int len = candidates.length;
		if(len==0) {
			return res;
		}
		Arrays.sort(candidates);
		this.len = len;
        this.candidates = candidates;
		backtrace(target,0,new Stack<>());
		return res;
	}
	private void backtrace(int target, int start, Stack<Integer> stack) {
		// TODO Auto-generated method stub
		if(target==0) {
			res.add(new ArrayList<>(stack));
			return;
		}
		for(int i=start;i<len&&target-candidates[i]>=0;i++) {
			stack.add(candidates[i]);
			backtrace(target-candidates[i], i, stack);
			stack.pop();
		}
	}
	
	
}
