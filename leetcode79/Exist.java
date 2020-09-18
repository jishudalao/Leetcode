package leetcode79;

public class Exist {
	private boolean marked[][];
	private int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};
	private int m;
	private int n;
	private String word;
	private char[][] board;
	public boolean exist(char[][] board, String word) {
		m = board.length;
		if(m==0) {
			return false;
		}
		n = board[0].length;
		marked = new boolean[m][n];
		this.word = word;
		this.board = board;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(dfs(i,j,0)) {
					return true;
				}
			}
		}
		return false;
    }
	private boolean dfs(int i, int j, int k) {
		// TODO Auto-generated method stub
		if (k == word.length() - 1) {
            return board[i][j] == word.charAt(k);
        }
		if(word.charAt(k)==board[i][j]) {
			marked[i][j] = true;;
			for(int l=0;l<4;l++) {
				int newX = i + direction[l][0];
	            int newY = j + direction[l][1];
				if(inArea(newX,newY)&&!marked[newX][newY]) {
					if(dfs(newX, newY, k+1)) {
						return true;
					}
				}
			}
			marked[i][j] = false;
		}
		
		return false;
	}
	private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
	public static void main(String[] args) {
		
	}
}
