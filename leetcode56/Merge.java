package leetcode56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Merge {
	 public static int[][] merge(int[][] intervals) {
		 Arrays.parallelSort(intervals, Comparator.comparingInt(x -> x[0]));

	        LinkedList<int[]> list = new LinkedList<>();
	        for (int i = 0; i < intervals.length; i++) {
	            if (list.size() == 0 || list.getLast()[1] < intervals[i][0]) {
	                list.add(intervals[i]);//����Ϊ�գ��������������������
	            } else {//�����������������Ԫ�ص�end=���ֵ
	                list.getLast()[1] = Math.max(list.getLast()[1], intervals[i][1]);
	            }
	        }
	        int[][] res = new int[list.size()][2];//���ɽ������
	        int index = 0;
	        while (!list.isEmpty()) {//��������
	            res[index++] = list.removeFirst();//ɾ��������Ԫ��
	        }
	        return res;
	    }
	 public static void main(String[] args) {
		 int obstacleGrid[][] = new int[6][2];
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
			obstacleGrid[5][0] = 4;
			obstacleGrid[5][1] = 8;
			//int[] newInterval = {4,8};
			merge(obstacleGrid);
	}
}
