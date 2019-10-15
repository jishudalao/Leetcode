package leetcode34;

import java.util.Arrays;

public class SearchRange {
	public static int[] searchRange(int[] nums, int target) {
		int res[] = new int[2];
		res[0] = -1;
		res[1] = -1;
		if (nums == null || nums.length == 0) {
			return res;
		}
		if (nums.length == 1 && target == nums[0]) {

			res[0] = 0;
			res[1] = 0;
			return res;
		}
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (target == nums[mid]) {

				int start = mid;
				int end = mid;
				while (start >= 0 && nums[start] == nums[mid]) {
					start--;
				}
				res[0] = start + 1;
				while (end <= nums.length - 1 && nums[end] == nums[mid]) {
					end++;
				}
				res[1] = end - 1;
				return res;
			}
			if (target < nums[mid]) {
				right = mid - 1;
			}
			if (target > nums[mid]) {
				left = mid + 1;
			}
		}
		return res;
	   }
	public static void main(String[] args) {
		int nums[] = {1};
		System.out.println(Arrays.toString(searchRange(nums, 1)));
	}
}
