package leetcode45;

public class JumpTwo {
	public static int jump(int[] nums) {
		if (nums.length == 1) {
			return 0;
		}
		int bp[] = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			if (i + nums[i] >= nums.length - 1) {
				return bp[i] + 1;
			}
			for (int j = nums[i]; j > 0; j--) {
				if (bp[i + j] == 0) {
					bp[i + j] = bp[i] + 1;
				} else {
					break;
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		// int nums[] = {3,2,1,0,4};
		int nums[] = { 2, 3, 1, 1, 2, 1, 5, 1, 12, 1, 1, 1, 1, 1 };
		System.out.println(jump(nums));
	}
}
