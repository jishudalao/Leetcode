package leetcode1596;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1596 {
	public char firstUniqChar(String s) {
		char[] chars = s.toCharArray();
		Map<Character,Integer> map = new HashMap<>();
		for(Character c:chars) {
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		for(Character c:chars) {
			if(map.get(c)==1) {
				return c;
			}
		}
		return ' ';
    }
}
