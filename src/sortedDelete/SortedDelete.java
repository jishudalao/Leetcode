package sortedDelete;

public class SortedDelete {
	public static int removeArr(int[] nums) {
		int num = 1;
		int count = 0;
		while(count<nums.length) {
			while(count+1<nums.length&&nums[count]==nums[count+1]) {
				count++;
			}
			if(count+1<nums.length) {
				nums[num++] = nums[++count];
			}else {
				count++;
			}
			
		}
		return num;
	}
	public static void main(String[] args) {
		int[] nums = {0,0,1,1,1,2,2,3,3,4};
		System.out.println(removeArr(nums));
	}
}
