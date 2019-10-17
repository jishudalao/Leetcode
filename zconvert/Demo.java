package zconvert;

import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo {
	public static String convert(String s, int numRows) {
        Map<Integer,List<Character>> map = new HashMap<>(); 
      
        for(int j=0;j<numRows;j++) {
        	
    		map.put(j, new ArrayList<Character>());
        }
        boolean flag = true;
        int count =0;
        while(count<=s.length()) {
        	if(flag==true) {
        		for(int j=0;j<numRows;j++)
            	{
        			if(count>s.length()-1) {
        				count = count+1;
                		break;
                	}
            		map.get(j).add(s.charAt(count++));
            	}
        		flag = !flag;
        	}
        	else {
        		for(int j=numRows-2;j>0;j--)
            	{	
        			if(count>s.length()-1) {
        				count = count+1;
            		break;
            	}
            		map.get(j).add(s.charAt(count++));
            		
            	}
        		flag = !flag;
        	}
        	
        	
        }
        
       StringBuilder sb= new StringBuilder();
        for(int i=0;i<numRows;i++) {
        	List<Character> list = map.get(i);
        	for(Character a :list) {
        		sb.append(a);
        	}
        	
        }
        return sb.toString();
    }
	public static void main(String[] args) {
		System.out.println(convert("LEETCODEISHIRING",4));
	}
}
