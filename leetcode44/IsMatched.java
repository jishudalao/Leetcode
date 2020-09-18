package leetcode44;

public class IsMatched {
	public static boolean isMatch(String s, String p) {
		boolean[][] bp = new boolean[s.length()+1][p.length()+1];
		bp[0][0] = true;
		for(int i=1;i<p.length()+1;i++) {
			if(p.charAt(i-1)=='*') {
				bp[0][i] = bp[0][i-1];
			}
		}
		for(int i=1;i<s.length()+1;i++) {
			for(int j=1;j<p.length()+1;j++) {
				if(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='?') {
					bp[i][j] = bp[i-1][j-1];
				}
				else if(p.charAt(j-1)=='*') {
					bp[i][j] = bp[i][j-1]||bp[i-1][j];
				}
			}
		}
		return bp[s.length()][p.length()];
    }
	public static void main(String[] args) {
		String s = "adceb";
		String p = "*a*b";
		System.out.println(isMatch(s,p));
		}
}
