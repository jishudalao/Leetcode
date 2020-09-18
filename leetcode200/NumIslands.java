package leetcode200;

import java.util.LinkedList;

public class NumIslands {
	//������ȱ���
	/*
	public int numIslands(char[][] grid) {
		if(grid.length==0||grid[0].length==0) {
			return 0;
		}
		int count = 0;
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				if(grid[i][j]=='1') {
					count++;
					dfs(grid,i,j);
				}
				
			}
		}
		return count;
	}
	private void dfs(char[][] grid, int i, int j) {
		if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]=='0') {
			return;
		}
		grid[i][j] = '0';
		dfs(grid,i+1,j);
		dfs(grid, i-1, j);
		dfs(grid, i, j+1);
		dfs(grid, i, j-1);
	}
	public static void main(String[] args) {
		
	}
	*/
	
	    private int rows;
	    private int cols;

	    public int numIslands(char[][] grid) {
	        //           x-1,y
	        //  x,y-1    x,y      x,y+1
	        //           x+1,y
	        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

	        rows = grid.length;
	        if (rows == 0) {
	            return 0;
	        }
	        cols = grid[0].length;
	        boolean[][] marked = new boolean[rows][cols];
	        int count = 0;
	        for (int i = 0; i < rows; i++) {
	            for (int j = 0; j < cols; j++) {
	                // ����ǵ����е�һ���㣬����û�б����ʹ�
	                // ������Ϊ (i,j) �ĵ㿪ʼ���й�����ȱ���
	                if (!marked[i][j] && grid[i][j] == '1') {
	                    count++;
	                    LinkedList<Integer> queue = new LinkedList<>();
	                    // С���ɣ�������ת��Ϊһ������
	                    // ���򣬵���һ������棬�� Python �У�����ʹ�� tuple ��
	                    queue.addLast(i * cols + j);
	                    // ע�⣺����Ҫ������Ѿ����ʹ�
	                    marked[i][j] = true;
	                    while (!queue.isEmpty()) {
	                        int cur = queue.removeFirst();
	                        int curX = cur / cols;
	                        int curY = cur % cols;
	                        // �õ� 4 �����������
	                        for (int k = 0; k < 4; k++) {
	                            int newX = curX + directions[k][0];
	                            int newY = curY + directions[k][1];
	                            // �����Խ�硢û�б����ʹ������һ�Ҫ��½�أ��Ҿͼ���������У�������е�ͬʱ��Ҫ�ǵñ���Ѿ����ʹ�
	                            if (inArea(newX, newY) && grid[newX][newY] == '1' && !marked[newX][newY]) {
	                                queue.addLast(newX * cols + newY);
	                                // ���ر�ע�⡿�ڷ�������Ժ�Ҫ���ϱ�ǳ��Ѿ����ʹ�������Ҳ��ʮ������ģ�����ֻҪ�����˶��У�����綼���������
	                                // �������ڳ����е�ʱ���ٱ��
	                                // ���ر�ע�⡿����ǳ����е�ʱ���ٱ�ǣ�����ɺܶ��ظ��Ľ�������У�����ظ��Ĳ�������仰�����û��д�Եط�����������س�ʱ��
	                                marked[newX][newY] = true;
	                            }
	                        }
	                    }
	                }
	            }

	        }
	        return count;
	    }

	    private boolean inArea(int x, int y) {
	        // ���ں���Щϸ�ڲ�Ҫ����
	        return x >= 0 && x < rows && y >= 0 && y < cols;
	    }

	    public static void main(String[] args) {
	    	NumIslands solution2 = new NumIslands();
	        char[][] grid1 = {
	                {'1', '1', '1', '1', '0'},
	                {'1', '1', '0', '1', '0'},
	                {'1', '1', '0', '0', '0'},
	                {'0', '0', '0', '0', '0'}};
	        int numIslands1 = solution2.numIslands(grid1);
	        System.out.println(numIslands1);

	        char[][] grid2 = {
	                {'1', '1', '0', '0', '0'},
	                {'1', '1', '0', '0', '0'},
	                {'0', '0', '1', '0', '0'},
	                {'0', '0', '0', '1', '1'}};
	        int numIslands2 = solution2.numIslands(grid2);
	        System.out.println(numIslands2);
	    }
	
}
