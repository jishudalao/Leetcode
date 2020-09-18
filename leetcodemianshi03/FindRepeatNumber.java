package leetcodemianshi03;

import java.util.HashMap;
import java.util.Map;
public class FindRepeatNumber {
	/*public static int findRepeatNumber(int[] nums) {
		Map<Integer,Integer> map = new HashMap<>();
		for(int num:nums) {
			map.put(num, map.getOrDefault(num, -1)+1);
			if(map.get(num)!=0) {
				return num;
			}
		}
		return -1;
    }*/
	//不适用额外空间
	public static int findRepeatNumber(int[] nums) {
		for(int i=0;i<nums.length;i++) {
			while(i!=nums[i]) {
				if(nums[i]==nums[nums[i]]) {
					return nums[i];
				}
				int temp = nums[i];
				nums[i] = nums[temp];
				nums[temp] = temp;
			}
		}
		return -1;
    }
	public static void main(String[] args) {
		int nums[] = {2, 3, 1, 0, 2, 5, 3};
		System.out.println(findRepeatNumber(nums));
	}
}
