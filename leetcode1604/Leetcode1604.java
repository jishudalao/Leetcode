package leetcode1604;

import java.util.HashSet;
import java.util.Set;

public class Leetcode1604 {
	//我跟你讲这种题有了复杂度的要求，排序啥的就不要想了，但肯定要遍历两遍
	//但是我不会做所以我要用set哈哈哈哈哈哈哈
	public int[] singleNumbers(int[] nums) {
		Set<Integer> set = new HashSet<>();
        for (int num : nums) {
        	if (!set.add(num)) {
            	set.remove(num);
            }
        }
        int res[] = new int[2];
        int count = 0;
            for(Integer s : set) {
            	res[count] = s;
            	count++;
            }
            return res;
    }
	public static void main(String[] args) {
		
	}
}
