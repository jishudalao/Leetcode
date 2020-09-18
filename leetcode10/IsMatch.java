package leetcode10;

public class IsMatch {
	/*public static boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        boolean bp[][] = new boolean[sLen+1][pLen+1];
        bp[0][0] = true;
        for(int j=2;j<=pLen;j++) {
        	bp[0][j] = bp[0][j-2] && p.charAt(j-1)=='*';
        }
        for(int i=1;i<=sLen;i++) {
        	for(int j=1;j<=pLen;j++) {
        		int m =i-1, n = j-1; 
        		
        		if(p.charAt(n)=='*') {
        			
        			if(p.charAt(n-1)=='.'||p.charAt(n-1)==s.charAt(m)) {
        				bp[i][j] = bp[i-1][j];
        			}else {
        				bp[i][j] = bp[i][j-2];
        			}
        		
        			
        		}else if(p.charAt(n)==s.charAt(m)||p.charAt(n)=='.'){
        			bp[i][j] = bp[i-1][j-1];
        		}
        		
        		
        	}
        }
        return bp[sLen][pLen];
    }
	*/
	
	public static boolean isMatch(String s, String p) {
		int sLen = s.length();
		int pLen = p.length();
		boolean dp[][] = new boolean[sLen+1][pLen+1];
		dp[0][0] = true;
		for(int i=2;i<=pLen;i++) {
			dp[0][i] = dp[0][i-2] && p.charAt(i-1)=='*';
		}
		for(int i=1;i<=s.length();i++) {
			for(int j=1;j<=p.length();j++) {
				int m= i-1, n = j-1;
				if(p.charAt(n)=='*') {
					
					if(s.charAt(m)==p.charAt(n-1)||p.charAt(n-1)=='.') {
						dp[i][j] = dp[i-1][j];
					}else {
						dp[i][j] = dp[i][j-2];
					}
					
					
					
				} else if (s.charAt(m)==p.charAt(n)||p.charAt(n)=='.') {
					dp[i][j] = dp[i-1][j-1];
				}
			}
		}
		return dp[sLen][pLen];
	}
	
	
	public static void main(String[] args) {
	String s = "aaaaab";
	String p = "c*a*b";
	System.out.println(isMatch(s,p));
	
	}
}
