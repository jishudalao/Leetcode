package leetcode1594;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1594 {
	public static int lengthOfLongestSubstring(String s) {
		//这题属于是滑动窗口，发现一个重复的字符之后，你需要找这个字符上一次出现的位置，所以说要存储字符串出现的位置。
		Map<Character, Integer> map = new HashMap<>();
        int strLen = s.length(), start = 0, res = 0;
        for (int i = 0; i < strLen; ++i) {
            start = Math.max(start, map.getOrDefault(s.charAt(i), -1) + 1);
            map.put(s.charAt(i), i);
            res = Math.max(res, i - start + 1);
        }
        return res;
    }
	public static void main(String[] args) {
		String s = "abcabcbb";
		System.out.println(lengthOfLongestSubstring(s));
	}
}
