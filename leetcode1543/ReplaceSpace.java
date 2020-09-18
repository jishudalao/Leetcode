package leetcode1543;

public class ReplaceSpace {
	public static String replaceSpace(String s) {
		StringBuilder sb = new StringBuilder();
		for(Character c : s.toCharArray()) {
			if(c.equals(' ')) {
				sb.append("%20");
			}else {
				sb.append(c);
			}
		}
		return sb.toString();
    }
	public static void main(String[] args) {
		String s = "We are happy.";
		System.out.println(replaceSpace(s));
	}
}
