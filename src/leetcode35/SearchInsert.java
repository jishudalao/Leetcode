package leetcode35;

public class SearchInsert {
	public static void main(String[] args) {
		int num[] = {1,3,5,6};
		int target = 4;
		System.out.println(searchInsert(num, target));
	}

	public static int searchInsert(int[] nums, int target) {
		int left = 0;
		int right = nums.length-1;
		
		int mid = (left + right) / 2;
		while (left <= right) {
			mid = (left + right) / 2;
			if (target > nums[mid]) {
				left = mid+1;
				
			} else if (target < nums[mid]) {
				right = mid-1;
				
			} else if (target == nums[mid]) {
				
				return mid;
			}
		}
		return left;
	}
}
