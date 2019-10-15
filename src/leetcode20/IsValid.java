package leetcode20;

import java.util.HashMap;
import java.util.Stack;

public class IsValid {
	private HashMap<Character, Character> mappings;
	public IsValid() {
	    this.mappings = new HashMap<Character, Character>();
	    this.mappings.put(')', '(');
	    this.mappings.put('}', '{');
	    this.mappings.put(']', '[');
	  }

	 public boolean isValid(String s) {
		 	Stack<Character> stack = new Stack<>();
		 	
	        for(int i=0;i<s.length();i++) {
	        	char index = s.charAt(i);
	        	if(this.mappings.containsKey(index)) {
	        		char charThis = stack.isEmpty()?'#':stack.pop();
	        		if(this.mappings.get(index)!=charThis) {
	        			return false;
	        		}
	        	}else {
	        		stack.push(index);
	        	}
	        }
		 return stack.isEmpty();
	    }
	 
	 
	 
	 public static void main(String[] args) {
		
	}
}
