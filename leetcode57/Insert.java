package leetcode57;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class Insert {
	public static int[][] insert(int[][] intervals, int[] newInterval) {
		//先插入，再排序
		/*
		int n = intervals.length;
	    int[][] input=new int[n+1][2];
	    //将newInterval和Intervals都输入一个数组
	    for (int i = 0; i < n; i++) {
	        input[i][0]=intervals[i][0];
	        input[i][1]=intervals[i][1];
	    }
	    input[n][0]=newInterval[0];
	    input[n][1]=newInterval[1];
		int[][] res = merge(input);
        return res;*/
		//一次遍历
		
		int newStart = newInterval[0], newEnd = newInterval[1];
	    int idx = 0, n = intervals.length;
	    LinkedList<int[]> output = new LinkedList<int[]>();

	    // add all intervals starting before newInterval
	    while (idx < n && newStart > intervals[idx][0])
	      output.add(intervals[idx++]);

	    // add newInterval
	    int[] interval = new int[2];
	    // if there is no overlap, just add the interval
	    if (output.isEmpty() || output.getLast()[1] < newStart)
	      output.add(newInterval);
	    // if there is an overlap, merge with the last interval
	    else {
	      interval = output.removeLast();
	      interval[1] = Math.max(interval[1], newEnd);
	      output.add(interval);
	    }

	    // add next intervals, merge with newInterval if needed
	    while (idx < n) {
	      interval = intervals[idx++];
	      int start = interval[0], end = interval[1];
	      // if there is no overlap, just add an interval
	      if (output.getLast()[1] < start) output.add(interval);
	      // if there is an overlap, merge with the last interval
	      else {
	        interval = output.removeLast();
	        interval[1] = Math.max(interval[1], end);
	        output.add(interval);
	      }
	    }
	    return output.toArray(new int[output.size()][2]);

    }
	public static int[][] merge(int[][] intervals) {
		 Arrays.parallelSort(intervals, Comparator.comparingInt(x -> x[0]));

	        LinkedList<int[]> list = new LinkedList<>();
	        for (int i = 0; i < intervals.length; i++) {
	            if (list.size() == 0 || list.getLast()[1] < intervals[i][0]) {
	                list.add(intervals[i]);//集合为空，或不满足条件，向后新增
	            } else {//满足条件，集合最后元素的end=最大值
	                list.getLast()[1] = Math.max(list.getLast()[1], intervals[i][1]);
	            }
	        }
	        int[][] res = new int[list.size()][2];//生成结果数组
	        int index = 0;
	        while (!list.isEmpty()) {//遍历集合
	            res[index++] = list.removeFirst();//删除集合首元素
	        }
	        return res;
	    }
	public static void main(String[] args) {
		 int obstacleGrid[][] = new int[5][2];
			for (int i = 0; i < obstacleGrid.length; i++) {
				for (int j = 0; j < obstacleGrid[0].length; j++) {
					obstacleGrid[i][j] = 1;
				}
			}
			obstacleGrid[0][0] = 1;
			obstacleGrid[0][1] = 2;
			obstacleGrid[1][0] = 3;
			obstacleGrid[1][1] = 5;
			obstacleGrid[2][0] = 6;
			obstacleGrid[2][1] = 7;
			obstacleGrid[3][0] = 8;
			obstacleGrid[3][1] = 10;
			obstacleGrid[4][0] = 12;
			obstacleGrid[4][1] = 16;
			int[] newInterval = {4,8};
			insert(obstacleGrid,newInterval);
	}
}


