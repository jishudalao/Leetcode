package leetcode90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SubsetsWithDup {
	private  static List<List<Integer>> res = new ArrayList<>();
	public static  List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		res.add(new ArrayList<>());
		if(nums.length<=0) {
			return res;
		}
		backtrack(nums, 0,  new Stack<>());
		return res;
    }
	
	private  static void backtrack(int[] nums, int now, Stack<Integer> stack) {
		// TODO Auto-generated method stub
		if(stack.size()==nums.length) {
			
			return;
		}
		for(int i=now;i<nums.length;i++) {
			stack.add(nums[i]);
			List<Integer> list = new ArrayList<>(stack);
			if(!res.contains(list)) {
				res.add(list);
			}
			backtrack(nums,i+1, stack);
			stack.pop();
		}
	}
	public static void main(String[] args) {
		int nums[] = {4,4,4,1,4};
		subsetsWithDup(nums);
		for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
	}
}
