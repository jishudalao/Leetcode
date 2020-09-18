package leetcode1585;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
	public static void main(String[] args) {
		
	}
	public int majorityElement(int[] nums) {
		int len = nums.length/2;
		Map<Integer,Integer> map = new HashMap<>();
		for(int num:nums) {
			map.put(num, map.getOrDefault(num, 0)+1);
			if(map.get(num)>len) {
				return num;
			}
		}
		return -1;
    }
}
