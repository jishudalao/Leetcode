package leetcode1160;

public class CountCharacters {
	public static int countCharacters(String[] words, String chars) {
		int c[] = new int[26];
		for(char cc : chars.toCharArray()) {
			c[(int)(cc-'a')]++;
		}
		int res = 0;
		for(String word : words) {
			int w[] = new int[26];
			for(char ww : word.toCharArray()) {
				w[(int)(ww-'a')]++;
			}
			boolean flag = true;
			for(int i=0; i<26; i++) {
                if(w[i] > c[i]) {
                	flag = false;
                    break;
                }
            }
			if(flag) {
				res += word.length();
			}
			
		}
		return res;
    }
	public static void main(String[] args) {
		String words[] = {"cat","bt","hat","tree"};
		String chars = "atach";
		System.out.println(countCharacters(words, chars));
	}
}
