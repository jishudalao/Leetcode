package leetcode80;

public class RemoveDuplicates {
	public static int removeDuplicates(int[] nums) {
        if(nums.length<3) {
        	return nums.length;
        }
        int rs = 1;
        for(int i=2;i<nums.length;i++) {
        	if(nums[rs-1]!=nums[i]) {
        		nums[++rs] = nums[i];
        	}
        }
        return rs+1;
    }
	
	public static void main(String[] args) {
		int nums[] = {1,1,1,1,1,1,2,2,3};
		System.out.println(removeDuplicates(nums));
		
	}
}
