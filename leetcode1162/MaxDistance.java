package leetcode1162;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaxDistance {
	public static int maxDistance(int[][] grid) {
		/*
		 int[] dx = {0, 0, 1, -1};
	        int[] dy = {1, -1, 0, 0};

	        Queue<int[]> queue = new ArrayDeque<>();
	        int m = grid.length, n = grid[0].length;
	        // �Ȱ����е�½�ض���ӡ�
	        for (int i = 0; i < m; i++) {
	            for (int j = 0; j < n; j++) {
	                if (grid[i][j] == 1) {
	                    queue.offer(new int[] {i, j});
	                }
	            }
	        }

	        // �Ӹ���½�ؿ�ʼ��һȦһȦ�ı����������������ĺ��������½����Զ�ĺ���
	        boolean hasOcean = false;
	        int[] point = null;
	        while (!queue.isEmpty()) {
	            point = queue.poll();
	            int x = point[0], y = point[1];
	            // ȡ�����е�Ԫ�أ��������ܵĺ�����ӡ�
	            for (int i = 0; i < 4; i++) {
	                int newX = x + dx[i];
	                int newY = y + dy[i];
	                if (newX < 0 || newX >= m || newY < 0 || newY >= n || grid[newX][newY] != 0) {
	                    continue;
	                }
	                grid[newX][newY] = grid[x][y] + 1; // ������ֱ���޸���ԭ���飬��˾Ͳ���Ҫ�������������־�Ƿ����
	                hasOcean = true;
	                queue.offer(new int[] {newX, newY});
	            }
	        }

	        // û��½�ػ���û�к��󣬷���-1��
	        if (point == null || !hasOcean) {
	            return -1;
	        }

	        // �������һ�α������ĺ���ľ��롣
	        return grid[point[0]][point[1]] - 1;*/
		
		int dx[] = {0,0,-1,1};
		int dy[] = {1,-1,0,0};
		Queue<int[]> queue = new ArrayDeque<>();
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				if(grid[i][j]==1) {
					queue.offer(new int[] {i,j});
				}
			}
		}
		boolean hasOcean = false;
		int[] point = null;
		while(!queue.isEmpty()) {
			point = queue.poll();
			int x = point[0], y = point[1];
			for(int i=0;i<4;i++) {
				int newX = x + dx[i];
				int newY = y + dy[i];
				if(newX<0||newX>grid.length||newY<0||newY>grid[0].length) {
					continue;
				}
				grid[newX][newY] = grid[x][y] + 1; 
				hasOcean = true;
				queue.offer(new int[] {newX,newY});
				
			}
		}
		
		// û��½�ػ���û�к��󣬷���-1��
        if (point == null || !hasOcean) {
            return -1;
        }

        // �������һ�α������ĺ���ľ��롣
        return grid[point[0]][point[1]] - 1;
		
    }
	public static void main(String[] args) {
		int obstacleGrid[][] = new int[3][4];
		for (int i = 0; i < obstacleGrid.length; i++) {
			for (int j = 0; j < obstacleGrid[0].length; j++) {
				obstacleGrid[i][j] = 0;
			}
		}
		obstacleGrid[0][0] = 1;
		obstacleGrid[0][3] = 1;
		System.out.println(maxDistance(obstacleGrid));
	
	}
}
