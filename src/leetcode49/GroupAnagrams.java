package leetcode49;

import java.util.*;

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs){
		if(strs.length==0) {
			return new ArrayList();
		}
		Map<String, List> ans = new HashMap<String, List>();
		for(String str:strs) {
			char[] chars = str.toCharArray();
			Arrays.sort(chars);
			String key = String.valueOf(chars);
			if(!ans.containsKey(key)) {
				ans.put(key, new ArrayList<String>());
			}
			ans.get(key).add(str);
		}
		return new ArrayList(ans.values());
	}
	public static void main(String[] args) {
		
	}
}
