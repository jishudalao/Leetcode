package leetcodemianshi1595;

import java.util.Arrays;

public class Leetcodemianshi45 {
	//这题是一个排序问题，但TM是一个很操蛋的另类排序
	public String minNumber(int[] nums) {
		String[] s = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
        	s[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(s, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for(String r : s)
            res.append(r);
        return res.toString();
    }
}
