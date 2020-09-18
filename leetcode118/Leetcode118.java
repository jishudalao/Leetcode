package leetcode118;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Leetcode118 {
	public static List<List<Integer>> generate(int numRows) {
		
		List<Integer> cur = new ArrayList<>();
		List<List<Integer>> res = new ArrayList<>();
		if(numRows==0) {
			return res;
		}
		cur.add(1);
		res.add(new ArrayList<>(cur));
		if(numRows==1) {
			return res;
		}
		cur.clear();
		cur.add(1);
		cur.add(1);
		res.add(new ArrayList<>(cur));
		if(numRows==2) {
			return res;
		}
		int index = 0;
		for(int i=2;i<numRows;i++) {
			List<Integer> now = new ArrayList<>();
			now.add(1);
			while(index<i-1) {
				now.add(cur.get(index++)+cur.get(index));
			}
			now.add(1);
			index = 0;
			res.add(new ArrayList<>(now));
			cur = now;
		}
		return res;
    }
	public static void main(String[] args) {
		List<List<Integer>> res = generate(5);
		for(List<Integer> r : res) {
			for(int i : r) {
				System.out.print(i+",");
			}
			System.out.println();
		}
	}
}
