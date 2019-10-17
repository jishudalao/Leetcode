package string;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class Demo {
	@Test
	public static int lengthOfLongestSubstrings(String s) {
      
        int totalSum = 0;
        for(int j=0;j<s.length()-1;j++) {
        	int sum = 0;
        	char indexStr = s.charAt(j);
        	for(int i=j+1;i<s.length();i++) {
        		
    			if(s.charAt(i)==indexStr) {
    				
    				//System.out.println(totalSum);
    				break;
    			}
    			
    			sum+=1;
    		}
        	System.out.println(sum);
        	if(totalSum<sum) {
        		
        		totalSum = sum;
        	}
        }
        return totalSum;
    }
	public static int lengthOfLongestSubstring(String s) {
		int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;

	}
	


	public static void main(String[] args) {
		//System.out.println(lengthOfLongestSubstring("ab"));
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
	}
}
