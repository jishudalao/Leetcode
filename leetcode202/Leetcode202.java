package leetcode202;

import java.util.ArrayList;
import java.util.List;
public class Leetcode202 {
	public static boolean isHappy(int n) {
        int num = n;
        List<Integer> list = new ArrayList<>();
        while(true) {
        	
        	char[] c = String.valueOf(num).toCharArray();
        	int res = 0;
        	for(int i=0;i<c.length;i++) {
        		res += (c[i] - '0') * (c[i] - '0');
        	}
        	if(list.contains(res)) {
        		return false;
        	}else {
        		list.add(res);
        	}
        	if(res==1) {
        		return true;
        	}
        	
        	num = res;
        }
    }
	public static void main(String[] args) {
		System.out.println(isHappy(19));
	}
}
