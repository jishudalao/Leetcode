package leetcode1608;

public class Leetcode1608 {
	public String reverseWords(String s) {
		if(s.length()<=0) {
					return s;
				}
				String[] sb = s.split(" ");
				
				
				StringBuilder sp = new StringBuilder();
				for(int i=sb.length-1;i>=0;i--) {
					if(!sb[i].equals("")) {
						sp.append(sb[i]);
						sp.append(" ");
					}
				}
				if(sp.length()!=0) {
					sp.deleteCharAt(sp.length()-1);
				}
				return sp.toString();
		    }
}
