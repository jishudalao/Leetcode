package leetcodemianshi61;

import java.util.ArrayList;
import java.util.List;
public class FindContinuousSequence {
	public static int[][] findContinuousSequence(int target) {
		int left = 1;
        int right = 1;
        int sum = 0;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        while(left <= target/2){
            if(sum < target){
                sum += right;
                right++;
            }else if(sum > target){
                sum -= left;
                left++;
            }else{
            	int left2 = left;
                while(left2<right) {
                	list.add(left2++);
                	}
                res.add(new ArrayList<>(list));
                list = new ArrayList<>();
                //看好了，精华所在
                sum -=left;
                left++;
                }
            }
		int r[][] = new int[res.size()][];
		int index1 = 0;
		
		for(List<Integer> l : res) {
			int index2 = 0;
			r[index1] = new int[l.size()];
			for(Integer in : l) {
				r[index1][index2++] = in;
			}
			index1++;
			index2 = 0;
		}
		return r;
    }
	public static void main(String[] args) {
		System.out.println(findContinuousSequence(9));
	}
}
