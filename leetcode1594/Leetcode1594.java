package leetcode1594;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1594 {
	public static int lengthOfLongestSubstring(String s) {
		//���������ǻ������ڣ�����һ���ظ����ַ�֮������Ҫ������ַ���һ�γ��ֵ�λ�ã�����˵Ҫ�洢�ַ������ֵ�λ�á�
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
