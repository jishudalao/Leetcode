package leetcode22;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
	public static void main(String[] args) {
		for(String str :generateParenthesis(3) ) {
			System.out.println(str);
		}
		
	}
	public static List<String> generateParenthesis(int n) {
    List<String> list = new ArrayList<>();
    backtrack(list, "", 0, 0, n);
    return list;
	}
	public static void backtrack(List<String> ans,String str,int left,int right,int max) {
		if(str.length()==max*2) {
			ans.add(str);
			return;
		}
		if(left<max) {
			backtrack(ans, str+"(", left+1, right, max);
		}
		if(right<left) {
			backtrack(ans, str+")", left, right+1, max);
		}
	}
}
