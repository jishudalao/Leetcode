package leetcode680;

public class Leetcode680 {
	public static boolean validPalindrome(String s) {
		char[] ch = s.toCharArray();
		int left = 0;
		int right = ch.length-1;
		while(left<=right) {
			if(ch[left]!=ch[right]) {
				return isPalindrome(s, left+1, right)||isPalindrome(s, left, right-1);
			}
			left++;
			right--;
		}
		return true;
    }
	public static boolean isPalindrome(String s, int i, int j) {
	    while (i < j) {
	        if (s.charAt(i++) != s.charAt(j--)) {
	            return false;
	        }
	    }
	    return true;
	}
	public static void main(String[] args) {
		String s = "cbbcc";
		System.out.println(validPalindrome(s));
	}
}
