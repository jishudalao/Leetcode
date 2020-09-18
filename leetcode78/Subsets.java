package leetcode78;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Subsets {
	private  static List<List<Integer>> res = new ArrayList<>();
	public static  List<List<Integer>> subsets(int[] nums) {
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
			res.add(new ArrayList<>(stack));
			backtrack(nums,i+1, stack);
			stack.pop();
		}
	}
	public static void main(String[] args) {
		int nums[] = {1,2,3,4};
		subsets(nums);
		for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
	}
}
