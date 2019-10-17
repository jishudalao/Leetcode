package leetcode38;

public class CountAndSay {
	public static String countAndSay(int n) {
		String str = "1";
		for(int i=1;i<n;i++) {
			StringBuilder builder = new StringBuilder();
			char temp = str.charAt(0);
			int count = 1;
			for(int j=1;j<str.length();j++) {
				char innertemp = str.charAt(j);
				if(innertemp==temp) {
					count++;
					
				}else {
					builder.append(count).append(temp);
					temp = innertemp;
					count = 1;
				}
			}
			builder.append(count).append(temp);
            str = builder.toString();
		}
		return str;
	}
	public static void main(String[] args) {
		for(int i=1;i<7;i++) {
			System.out.println(countAndSay(i));
		}
	}
}
