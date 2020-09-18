package leetcode1550;

public class Exist {
	//这题可以用深度优先搜索或者广度优先搜索
	
	public boolean exist(char[][] board, String word) {
		boolean[][] marked = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++) {
        	for(int j=0;j<board[0].length;j++) {
        		if(backtrack(board,0,word,i,j,marked)) {
        			return true;
        		}
        	}
        }
        return false;
    }
	private boolean backtrack(char[][] board, int k, String word, int i, int j,boolean[][] marked) {
		// TODO Auto-generated method stub
		if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word.charAt(k)||marked[i][j]==true) return false;
        if(k == word.length() - 1) { 
        	return true;
        }
        marked[i][j]=true;
        boolean res = backtrack(board,k + 1, word, i + 1, j, marked) || backtrack(board, k + 1, word, i - 1, j,marked) || 
        		backtrack(board, k + 1,word, i, j + 1, marked) || backtrack(board,k + 1, word, i , j - 1, marked);
        marked[i][j]=false;
        return res;
        
	}
	public static void main(String[] args) {
		
	}
}
