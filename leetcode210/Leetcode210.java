package leetcode210;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode210 {
	public static int[] findOrder(int numCourses, int[][] prerequisites){
        int cur[] = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<prerequisites.length;i++) {
        	cur[prerequisites[i][0]]++;
        	if(map.containsKey(prerequisites[i][1])) {
        		map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        	}else {
        		List<Integer> list = new ArrayList<>();
        		list.add(prerequisites[i][0]);
        		map.put(prerequisites[i][1], list);
        	}
        }
        for(int i=0;i<numCourses;i++) {
        	if(cur[i]==0) {
        		queue.offer(i);
        	}
        }
        while(!queue.isEmpty()) {
        	int c = queue.poll();
        	res.add(c);
        	if(map.containsKey(c)&&map.get(c).size()!=0) {
        		for(int q : map.get(c)) {
            		cur[q]--;
            		if(cur[q]==0) {
            			queue.offer(q);
            		}
            	}	
        	}
        }
        return res.size() == numCourses ? res.stream().mapToInt(Integer::valueOf).toArray() : new int[0];
    }
	
	public static void main(String[] args) {
		int prerequisites[][] = new int[4][2];
		prerequisites[0][0] = 1;
		prerequisites[0][1] = 0;
		prerequisites[1][0] = 2;
		prerequisites[1][1] = 0;
		prerequisites[2][0] = 3;
		prerequisites[2][1] = 1;
		prerequisites[3][0] = 3;
		prerequisites[3][1] = 2;
		int numCourses = 4;
		System.out.println(findOrder(numCourses, prerequisites));
	}
}
