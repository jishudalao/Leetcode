package leetcode71;

import java.util.Arrays;

public class SimplifyPath {
	public static String simplifyPath(String path) {
		if(path.equals("")) {
			return path;
		}
		if(path.equals("/.")) {
			return "/";
		}
        StringBuilder sb = new StringBuilder(path);
        StringBuilder res = new StringBuilder();
        //第一步：删除连续的/
        for(int i=path.length()-2;i>=0;i--) {
        	if(sb.charAt(i)=='/'&&sb.charAt(i+1)=='/') {
        		sb.deleteCharAt(i+1);
        	}
        }
        //第二步：删除/.
        for(int i=sb.length()-2;i>=1;i--) {
        	if(sb.charAt(i)=='.'&&sb.charAt(i-1)=='/'&&sb.charAt(i+1)=='/') {
        		sb.deleteCharAt(i);
        		sb.deleteCharAt(i-1);
        	}
        }
        //第三步：整合/..
        if(sb.toString().endsWith("/.")) {
        	sb.deleteCharAt(sb.length()-1);
        	sb.deleteCharAt(sb.length()-1);
        }
        else if(sb.charAt(sb.length()-1)=='/') {
        	sb.deleteCharAt(sb.length()-1);
        }
        String[] sp = sb.toString().split("/");
        for(int i=sp.length-1;i>=0;i--) {
        	if(sp[i].equals("..")) {
        		sp[i] = "";
        		int j = i-1;
        		while(j>0&&(sp[j].equals("..")||sp[j].equals(""))) {
        			j--;
        		}
        		sp[j] = "";
        	}
        }
        
        for(String s : sp) {
        	if(!s.equals("")) {
        		res.append("/");
        		res.append(s);
        	}
        }
        if(res.toString().equals("")) {
        	res.append("/");
        }
        return res.toString();
    }
	public static void main(String[] args) {
		String path = "/home/of/foo/../../bar/../../is/./here/.";
		System.out.println(simplifyPath(path));
	}
}
