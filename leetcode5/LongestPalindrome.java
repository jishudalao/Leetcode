package leetcode5;

public class LongestPalindrome {
	//暴力解题法
	/*
	public String longestPalindrome(String s) {
        int max = 0;
        String ans = "";
		for(int i=0;i<s.length();i++) {
        	for(int j=i+1;j<=s.length();j++) {
        		String test = s.substring(i,j);
        		if(isHuiwen(test)&&test.length()>max) {
        			ans = s.substring(i, j);
                    max = Math.max(max, ans.length());
        		}
        	}
        }
		return ans;
    }
	public boolean isHuiwen(String s) {
		int length = s.length();
		for(int i=0;i<length/2;i++) {
			if(s.charAt(i)!=s.charAt(length-i-1)) {
				return false;
			}
		}
		return true;
	}
	*/
	
	//动态规划，中心扩展法
	public String longestPalindrome(String s) {
		if (s == null || s.length() < 1) return "";
	    int start = 0, end = 0;
		for(int i=0;i<s.length();i++) {
			int len1 = expandAroundCenter(s, i, i);
			int len2 = expandAroundCenter(s, i, i+1);
			int len = Math.max(len1, len2);
			if(len>end-start) {
				start = i - (len-1)/2;
				end = i + len/2;
			}
		}
		return s.substring(start,end+1);//end+1才能截取到完整的字符串
	}
	private int expandAroundCenter(String s,int left,int right) {
		int L = left,R = right;
		while(L>=0 &&R<s.length()&&s.charAt(L)==s.charAt(R)) {
			L--;
			R++;
		}
		return R-L-1;
	}
	
	
}
