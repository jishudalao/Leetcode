package leetcode999;

public class NumRookCaptures {
	public int numRookCaptures(char[][] board) {
		int heng = 0, shu = 0;
		int sum = 0;
		for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (board[i][j] == 'R') {
                	heng = i;
                	shu = j;
                    break;
                }
            }
        }
		for(int j = shu;j<8;j++) {
			if(board[heng][j]=='B') {
				break;
			}
			if (board[heng][j] == 'p') {
				sum++;
                break;
            }
		}
		
		for(int j = shu;j>=0;j--) {
			if(board[heng][j]=='B') {
				break;
			}
			if (board[heng][j] == 'p') {
				sum++;
                break;
            }
		}
		
		for(int j = heng;j<8;j++) {
			if(board[j][shu]=='B') {
				break;
			}
			if (board[j][shu] == 'p') {
				sum++;
                break;
            }
		}
		
		for(int j = heng;j>=0;j--) {
			if(board[j][shu]=='B') {
				break;
			}
			if (board[j][shu] == 'p') {
				sum++;
                break;
            }
		}
		return sum;
    }
	public static void main(String[] args) {
		
	}
}
