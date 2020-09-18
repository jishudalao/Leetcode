package leetcode1248;

import java.util.ArrayList;
import java.util.List;
public class NumberOfSubarrays {
	public static int numberOfSubarrays(int[] nums, int k) {
		List<Integer> ji = new ArrayList<>();
		ji.add(-1);
		for(int i=0;i<nums.length;i++) {
			if(nums[i]%2!=0) {
				ji.add(i);
			}
		}
		ji.add(nums.length);
		if(ji.size()-2<k) {
			return 0;
		}
		int count = 0;
		for(int i=1;i<=(ji.size()-2)-k+1;i++) {
			int left = ji.get(i) - ji.get(i-1);
			int right = ji.get(i+k) - ji.get(i+k-1);
			count += left * right;
		}
		return count;
    }
	public static void main(String[] args) {
		int[] nums = {1};
		//int[] nums = {1,1,2,1,1};
		System.out.println(numberOfSubarrays(nums, 1));
	}
}
