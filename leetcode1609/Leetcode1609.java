package leetcode1609;

public class Leetcode1609 {
	public static String reverseLeftWords(String s, int n) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
				sb.append(s.charAt(i));
		}
		StringBuilder sb2 = new StringBuilder();
		for(int i=n;i<s.length();i++) {
			sb2.append(s.charAt(i));
	}
		sb2.append(sb);
		return sb2.toString();
    }
	public static void main(String[] args) {
		String s = "abcdefg";
		System.out.println(reverseLeftWords(s, 2));
	}
}
