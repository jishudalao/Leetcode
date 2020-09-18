package leetcode1613;

import java.util.Arrays;

public class Leetcode1613 {
	public static void main(String[] args) {
		
	}
	public boolean isStraight(int[] nums) {
		//ÅÅĞòÑ½£¬ÅÅĞòºÃ×ö
		Arrays.sort(nums);
		for(int i = 0; i < 4; i++){
            if(nums[i] != 0){
                if(nums[4] - nums[i] >= 5)
                    return false;
                if(nums[i] == nums[i+1])
                    return false;
            }
        }
        return true;
    }
}
