package leetcode1599;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1599 {
	public static int search(int[] nums, int target) {
		Map<Integer,Integer> map = new HashMap<>();
		for(int num:nums) {
			map.put(num, map.getOrDefault(num, 0)+1);
		}
		return map.getOrDefault(target, 0);
    }
	public static void main(String[] args) {
		int nums[] = {2, 3, 1, 0, 2, 5, 3};
		System.out.println(search(nums,3));
	}
}
