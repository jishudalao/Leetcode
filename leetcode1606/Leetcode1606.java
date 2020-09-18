package leetcode1606;

public class Leetcode1606 {
	public int[] twoSum(int[] nums, int target) {
		//ºÜÃ÷ÏÔË«Ö¸Õë
		int left = 0;
		int right = nums.length-1;
		while(left<right) {
			int sum = nums[left] + nums[right];
			if(sum>target) {right--;}
			else if(sum<target) {left++;}
			else {
				return new int[] {nums[left],nums[right]};
				}
		}
		return new int[0];
    }
	public static void main(String[] args) {
		
	}
}
