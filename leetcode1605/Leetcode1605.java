package leetcode1605;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1605 {
	public int singleNumber(int[] nums) {
		Map<Integer,Integer> map = new HashMap<>();
		for(int num:nums) {
			map.put(num, map.getOrDefault(num, 0)+1);
			if(map.get(num)==3) {
				map.remove(num);
			}
		}
		return map.keySet().iterator().next();
    }
	public static void main(String[] args) {
		
	}
}
