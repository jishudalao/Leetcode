package leetcode47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PermuteUnique {
		private List<List<Integer>> res = new ArrayList<>();
	    private boolean[] used;
	
		public List<List<Integer>> permuteUnique(int[] nums) {
			int len = nums.length;
			if(len==0) {
				return res;
			}
			Arrays.sort(nums);
			used = new boolean[len];
			backtrack(nums,0,new Stack<Integer>());
			return res;
		}
		
	
	private void backtrack(int[] nums, int depth, Stack<Integer> stack) {
			// TODO Auto-generated method stub
			if(depth==nums.length) {
				res.add(new ArrayList<>(stack));
				return;
			}
			
				for(int i=0;i<nums.length;i++) {
					if(!used[i]) {
						if(i>0&&nums[i]==nums[i-1]&&!used[i-1]) {
							continue;
						}
						stack.add(nums[i]);
						used[i]=true;
						backtrack(nums, depth+1, stack);
						stack.pop();
						used[i]=false;
					}
				}
			
		}


public static void main(String[] args) {
	boolean[] bool = new boolean[5];
	System.out.println(Arrays.toString(bool));
}
}
