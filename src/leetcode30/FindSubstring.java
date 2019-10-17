package leetcode30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindSubstring {
	/*
	//˫hashmap�����ƽ�
	public static List<Integer> findSubstring(String s, String[] words) {
	    List<Integer> res = new ArrayList<Integer>();
	    int wordNum = words.length;
	    if (wordNum == 0) {
	        return res;
	    }
	    int wordLen = words[0].length();
	    //HashMap1 �����е���
	    HashMap<String, Integer> allWords = new HashMap<String, Integer>();
	    for (String w : words) {
	        int value = allWords.getOrDefault(w, 0);
	        allWords.put(w, value + 1);
	    }
	    //���������Ӵ�
	    for (int i = 0; i < s.length() - wordNum * wordLen + 1; i+=wordLen) {
	        //HashMap2 �浱ǰɨ����ַ������еĵ���
	        HashMap<String, Integer> hasWords = new HashMap<String, Integer>();
	        int num = 0;
	        //�жϸ��Ӵ��Ƿ����
	        while (num < wordNum) {
	            String word = s.substring(i + num * wordLen, i + (num + 1) * wordLen);
	            //�жϸõ����� HashMap1 ��
	            if (allWords.containsKey(word)) {
	                int value = hasWords.getOrDefault(word, 0);
	                hasWords.put(word, value + 1);
	                //�жϵ�ǰ���ʵ� value �� HashMap1 �иõ��ʵ� value
	                if (hasWords.get(word) > allWords.get(word)) {
	                    break;
	                }
	            } else {
	                break;
	            }
	            num++;
	        }
	        //�ж��ǲ������еĵ��ʶ���������
	        if (num == wordNum) {
	            res.add(i);
	        }
	    }
	    return res;
	}
*/
	public static  List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return res;
        HashMap<String, Integer> map = new HashMap<>();
        int one_word = words[0].length();
        int word_num = words.length;
        int all_len = one_word * word_num;
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < one_word; i++) {
            int left = i, right = i, count = 0;
            HashMap<String, Integer> tmp_map = new HashMap<>();
            while (right + one_word <= s.length()) {
                String w = s.substring(right, right + one_word);
                right += one_word;
                if (!map.containsKey(w)) {
                    count = 0;
                    left = right;
                    tmp_map.clear();
                } else {
                    tmp_map.put(w, tmp_map.getOrDefault(w, 0) + 1);
                    count++;
                    while (tmp_map.getOrDefault(w, 0) > map.getOrDefault(w, 0)) {
                        String t_w = s.substring(left, left + one_word);
                        count--;
                        tmp_map.put(t_w, tmp_map.getOrDefault(t_w, 0) - 1);
                        left += one_word;
                    }
                    if (count == word_num) res.add(left);
                }
            }
        }
        return res;
    }

	
	public static void main(String[] args) {
		String s = "barfoothefoofoobarman";
		String[] words = {"foo","bar"};
		System.out.println(findSubstring(s, words));
	}
}
